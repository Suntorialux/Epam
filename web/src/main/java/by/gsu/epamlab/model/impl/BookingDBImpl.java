/**
 * 
 */
package by.gsu.epamlab.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import by.gsu.epamlab.model.DB.AbstractManagerDB;
import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.constants.Constants;
import by.gsu.epamlab.model.constants.ConstantsSQL;
import by.gsu.epamlab.model.exceptions.BookingException;
import by.gsu.epamlab.model.ifaces.IBookingDAO;

/**
 * @author Andrei Yahorau
 *
 */
public class BookingDBImpl extends AbstractManagerDB implements IBookingDAO {

	private final static Object LOCK = new Object();
	
	private final int ID_PLAY_INDEX = 1;
	private final int SECTOR_INDEX = 2;
	private final int ROW_INDEX = 3;
	private final int PLACE_INDEX = 4;
	private final int INDEX_ID_USER = 1;
	private final int INDEX_ID_PLAY = 2;
	private final int INDEX_SECTOR = 3;
	private final int INDEX_ROW = 4;
	private final int INDEX_PLACE = 5;
	private final int INDEX_PRICE = 6;
	private final int INDEX_STATUS = 7;
	
	@Override
	public void addBookingDB(List<String> params, User user) throws BookingException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement psAddBooking = null;
		PreparedStatement psSelect = null;
		PreparedStatement psSelectOrder = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			psAddBooking = connection.prepareStatement(ConstantsSQL.SQL_INSERT_BOOKING);
			psSelect = connection.prepareStatement(ConstantsSQL.SQL_SELECT_USER_ID);
			psSelectOrder = connection.prepareStatement(ConstantsSQL.SQL_SELECT_ID_BOOKING);
			String userLogin = user.getLogin();
			int idUser = getId(userLogin, psSelect);
			int idPlay = Integer.parseInt(params.get(0));
			String sector = params.get(1);
			int row = Integer.parseInt(params.get(2));
			int place = Integer.parseInt(params.get(3));
			int price = Integer.parseInt(params.get(4));
			String status = Constants.IS_BOOKED;
			psSelectOrder.setInt(ID_PLAY_INDEX, idPlay);
			psSelectOrder.setString(SECTOR_INDEX, sector);
			psSelectOrder.setInt(ROW_INDEX, row);
			psSelectOrder.setInt(PLACE_INDEX, place);
			psAddBooking.setInt(INDEX_ID_USER, idUser);
			psAddBooking.setInt(INDEX_ID_PLAY, idPlay);
			psAddBooking.setString(INDEX_SECTOR, sector);
			psAddBooking.setInt(INDEX_ROW, row);
			psAddBooking.setInt(INDEX_PLACE, place);
			psAddBooking.setInt(INDEX_PRICE, price);
			psAddBooking.setString(INDEX_STATUS, status);
			synchronized (LOCK) {
				resultSet = psSelectOrder.executeQuery();
				if (!resultSet.first()) {
					psAddBooking.executeUpdate();
				} else {
					throw new BookingException(Constants.BOOKING_ERROR);
				}
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BookingException(e.getMessage());
		} finally {
			closeStatement(psAddBooking, psSelect, psSelectOrder);
			closeConnection(connection);
		}

	}

	@Override
	public Map<Integer, Booking> getBookingsDB() throws BookingException {
		Connection connection = null;
		PreparedStatement psSelectBooking = null;
		ResultSet resultSet = null;
		try {
			Map<Integer, Booking> bookings = new HashMap<>();
			connection = getConnection();
			psSelectBooking = connection.prepareStatement(ConstantsSQL.SQL_SELECT_BOOKINGS);
			resultSet = psSelectBooking.executeQuery();
			while (resultSet.next()) {
				int idBooking = resultSet.getInt(1);
				String loginUser = resultSet.getString(2);
				int idPlay = resultSet.getInt(3);
				String sector = resultSet.getString(4);
				int row = resultSet.getInt(5);
				int place = resultSet.getInt(6);
				int price = resultSet.getInt(7);
				String status = resultSet.getString(8);
				Booking booking = new Booking(loginUser, idPlay, sector, row, place, price, status); 
				bookings.put(idBooking, booking);
			}
			return bookings;
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BookingException(e.getMessage());
		} finally {
			closeResultSet(resultSet);
			closeStatement(psSelectBooking);
			closeConnection(connection);
		}
	}
	
	@Override
	public Map<Integer, Booking> getBookingsDB(int idPlay) throws BookingException {
		Map<Integer, Booking> bookingsByIdPlay = new HashMap<>();
		Map<Integer, Booking> bookings = getBookingsDB();
		for(Map.Entry<Integer, Booking> entry : bookings.entrySet()) {
			if(entry.getValue().getIdPlay()==idPlay) {
				bookingsByIdPlay.put(entry.getKey(), entry.getValue());
			}
		}
		return bookingsByIdPlay;
	}
	
	
	@Override
	public Map<Integer, Booking> getBookingsDB(String userLogin) throws BookingException {
		Map<Integer, Booking> bookingsByIdPlay = new HashMap<>();
		Map<Integer, Booking> bookings = getBookingsDB();
		for(Map.Entry<Integer, Booking> entry : bookings.entrySet()) {
			if(entry.getValue().getNameUser().equals(userLogin)) {
				bookingsByIdPlay.put(entry.getKey(), entry.getValue());
			}
		}
		return bookingsByIdPlay;
	}
	

	@Override
	public Map<Integer, Booking> getBookingsByStatus(String status) throws BookingException {
		Map<Integer, Booking> bookingsByStatus = new HashMap<>();
		Map<Integer, Booking> bookings = getBookingsDB();
		for(Map.Entry<Integer, Booking> entry : bookings.entrySet()) {
			if(entry.getValue().getStatus().equals(status)) {
				bookingsByStatus.put(entry.getKey(), entry.getValue());
			}
		}
		return bookingsByStatus;
	}
	@Override
	public Set<String> getUserLoginFromBooking() throws BookingException {
		Map<Integer, Booking> bookings = getBookingsDB();
		Set<String> userLogins = new HashSet<>();
		for(Map.Entry<Integer, Booking> entry : bookings.entrySet()) {
			String login = entry.getValue().getNameUser();
			userLogins.add(login);
		}
		return userLogins;
	}
	
	@Override
	public void changeStatusBooking(Integer idBooking) throws BookingException {

		Connection connection = null;
		PreparedStatement psUpdateStatus = null;
		try {
			connection = getConnection();
			psUpdateStatus = connection.prepareStatement(ConstantsSQL.SQL_CHANGE_STATUS);
			psUpdateStatus.setInt(1, idBooking);
			psUpdateStatus.executeUpdate();	
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			throw new BookingException(e.getMessage());
		} finally {
			closeStatement(psUpdateStatus);
			closeConnection(connection);
		}
	}
	

	@Override
	public void deleteBooking(Integer idBooking) throws BookingException {
		
		Connection connection = null;
		PreparedStatement psUpdateStatus = null;
		try {
			connection = getConnection();
			psUpdateStatus = connection.prepareStatement("delete from orders WHERE  idOrder = (?)");
			psUpdateStatus.setInt(1, idBooking);
			psUpdateStatus.executeUpdate();	
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			throw new BookingException(e.getMessage());
		} finally {
			closeStatement(psUpdateStatus);
			closeConnection(connection);
		}
	}
	
	

	private static int getId(String name, PreparedStatement psSelect) throws SQLException {
		int id;
		ResultSet resultSet = null;
		psSelect.setString(1, name);
		resultSet = psSelect.executeQuery();
		if (resultSet.first()) {
			id = resultSet.getInt(1);
			return id;
		} else {
			throw new SQLException("Creating user failed, no rows affected.");
		}

	}

}
