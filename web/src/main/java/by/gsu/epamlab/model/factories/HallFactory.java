/**
 * 
 */
package by.gsu.epamlab.model.factories;

import by.gsu.epamlab.model.ifaces.IHallDAO;
import by.gsu.epamlab.model.impl.ReaderHallIml;

/**
 * @author Andrei Yahorau
 *
 */
public class HallFactory {
	
	public static IHallDAO getClassFromFactory() {
		return new ReaderHallIml();
	}
}
