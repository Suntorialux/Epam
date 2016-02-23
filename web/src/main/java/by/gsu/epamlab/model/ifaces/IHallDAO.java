/**
 * 
 */
package by.gsu.epamlab.model.ifaces;

import java.util.Map;
import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.exceptions.HallException;

/**
 * @author Andrei Yahorau
 *
 */
public interface IHallDAO {

	Map<String, int[]> getHall(String filePath) throws HallException;

	Map<String, Booking[][]> getBookingHall(Map<String, int[]> hall, Map<Integer, Booking> bookings);
}
