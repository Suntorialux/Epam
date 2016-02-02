/**
 * 
 */
package by.gsu.epamlab.model.factories;

import by.gsu.epamlab.model.ifaces.IUserDAO;
import by.gsu.epamlab.model.impl.DBUserImpl;
import by.gsu.epamlab.model.impl.MemoryUserImpl;

/**
 * @author Yahorau Andrei
 *
 */
public class UserFactory {
	
	public static IUserDAO getClassFromFactory() {
		//return new MemoryUserImpl();
		return new DBUserImpl();
	}
}
