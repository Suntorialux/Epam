/**
 * 
 */
package by.gsu.epamlab.model.factories;

import by.gsu.epamlab.model.ifaces.IBookingDAO;
import by.gsu.epamlab.model.impl.BookingDBImpl;

/**
 * @author Andrei Yahorau
 *
 */
public class BookingFactory {
		
	public static IBookingDAO getClassFromFactory () {
		
		return new BookingDBImpl();
		
	}
}
