package by.gsu.epamlab.model.factories;

import by.gsu.epamlab.ifaces.IUserDAO;
import by.gsu.epamlab.model.impl.CsvUserImpl;
import by.gsu.epamlab.model.impl.HardcodedUserImpl;

public class UserFactory {
	public static String classesRealPath;
	public static IUserDAO getClassFromFactory() {
		return new CsvUserImpl();
//		return new HardcodedUserImpl();
	}

}
