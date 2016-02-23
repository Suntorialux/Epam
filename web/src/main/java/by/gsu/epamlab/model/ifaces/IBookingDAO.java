/**
 * 
 */
package by.gsu.epamlab.model.ifaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.BookingException;

/**
 * @author Andrei Yahorau
 *
 */
public interface IBookingDAO {
	
	void addBookingDB(List<String> params, User user) throws BookingException;	
	Map<Integer, Booking> getBookingsDB () throws BookingException;
	Map<Integer, Booking> getBookingsDB(int idPlay) throws BookingException;
	Set<String> getUserLoginFromBooking() throws BookingException;
	Map<Integer, Booking> getBookingsDB(String userLogin) throws BookingException;
	void changeStatusBooking(Integer idBooking) throws BookingException;
	void deleteBooking(Integer idBooking) throws BookingException;
	Map<Integer, Booking> getBookingsByStatus(String status) throws BookingException;

}
