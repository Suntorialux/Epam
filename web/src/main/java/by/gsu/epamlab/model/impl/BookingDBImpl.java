/**
 * 
 */
package by.gsu.epamlab.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.NamingException;

import by.gsu.epamlab.model.DB.AbstractManagerDB;
import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.BookingException;
import by.gsu.epamlab.model.ifaces.IBookingDAO;

/**
 * @author Andrei Yahorau
 *
 */
public class BookingDBImpl extends AbstractManagerDB implements IBookingDAO {

	private final static Object LOCK = new Object();
	private final static String SELECT_USER_ID = "SELECT idUser FROM users WHERE login = (?)";

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
			psAddBooking = connection.prepareStatement(
					"Insert into orders (id_user, id_play, sector, row, place, price, status) values (?,?,?,?,?,?,?)");
			psSelect = connection.prepareStatement(SELECT_USER_ID);
			psSelectOrder = connection.prepareStatement(
					"Select idOrder from orders where id_play = (?) && sector = (?) && row = (?) && place = (?)");
			String userLogin = user.getLogin();
			int idUser = getId(userLogin, psSelect);
			int idPlay = Integer.parseInt(params.get(0));
			String sector = params.get(1);
			int row = Integer.parseInt(params.get(2));
			int place = Integer.parseInt(params.get(3));
			int price = Integer.parseInt(params.get(4));
			String status = "book";
			psSelectOrder.setInt(1, idPlay);
			psSelectOrder.setString(2, sector);
			psSelectOrder.setInt(3, row);
			psSelectOrder.setInt(4, place);
			psAddBooking.setInt(1, idUser);
			psAddBooking.setInt(2, idPlay);
			psAddBooking.setString(3, sector);
			psAddBooking.setInt(4, row);
			psAddBooking.setInt(5, place);
			psAddBooking.setInt(6, price);
			psAddBooking.setString(7, status);
			synchronized (LOCK) {
				resultSet = psSelectOrder.executeQuery();
				if (!resultSet.first()) {
					psAddBooking.executeUpdate();
				} else {
					throw new BookingException("This play is brone. Try again.");
				}
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatement(psAddBooking, psSelect, psSelectOrder);
			closeConnection(connection);
		}

	}

	@Override
	public Set<Booking> getBookingsDB() throws BookingException {
		Connection connection = null;
		PreparedStatement psSelectBooking = null;
		ResultSet resultSet = null;
		try {
			Set<Booking> bookings = new HashSet<>();
			connection = getConnection();
			psSelectBooking = connection.prepareStatement("Select * from orders");
			resultSet = psSelectBooking.executeQuery();
			while (resultSet.next()) {
				int idPlay = resultSet.getInt(3);
				String sector = resultSet.getString(4);
				int row = resultSet.getInt(5);
				int numberPlace = resultSet.getInt(6);
				int price = resultSet.getInt(7);
				String status = resultSet.getString(8);
				Place place = new Place(sector, row, numberPlace, price);
				Booking booking = new Booking(place, idPlay, status);
				bookings.add(booking);
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
