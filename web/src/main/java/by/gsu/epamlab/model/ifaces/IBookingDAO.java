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
	Set<Booking> getBookingsDB () throws BookingException;

}
