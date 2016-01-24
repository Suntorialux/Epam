package by.gsu.epamlab.model.impl;

import java.io.FileReader;
import java.util.Scanner;

import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.factories.UserFactory;
import by.gsu.epamlab.controllers.Constants;
import by.gsu.epamlab.ifaces.IUserDAO;

public class CsvUserImpl implements IUserDAO  {
	public User getUser(String login, String password) throws DaoException {
		String filename = UserFactory.classesRealPath + Constants.INPUT_FILENAME;
		final String CSV_SPLITTER = ";";
		final int LOGIN_NUM = 0, PASSWORD_NUM = 1, ROLE_NUM = 2;
		User user = null;
		Scanner sc = null;
		try {
			Role role = Role.VISITOR;
			sc = new Scanner(new FileReader(filename));
			String[] str = null;
			while (sc.hasNext ()) {
				str = sc.next().split(CSV_SPLITTER);
				if (str[LOGIN_NUM].equals(login) && str[PASSWORD_NUM].equals(password)) {
					role = Role.valueOf(str[ROLE_NUM]);
					break;
				}
			}
			user = new User(login, role);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(Constants.ERROR_SOURCE, e);
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
		return user;
	}
}
