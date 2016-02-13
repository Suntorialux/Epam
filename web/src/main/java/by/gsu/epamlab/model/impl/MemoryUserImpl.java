/**
 * 
 */
package by.gsu.epamlab.model.impl;

import java.util.HashMap;
import java.util.Map;

import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.UserException;
import by.gsu.epamlab.model.ifaces.IUserDAO;

/**
 * @author Yahorau Andrei
 *
 */
public class MemoryUserImpl implements IUserDAO {

	private static final Object lock = new Object();
	
	private static Map<User, String> users;

	static {

		users = new HashMap<User, String>();
		users.put(new User("sysadmin", Role.ADMIN), "111");
		users.put(new User("clever", Role.USER), "111");
		users.put(new User("ternal", Role.USER), "111");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.gsu.epamlab.model.ifaces.IUserDAO#getUser(java.lang.String,
	 * java.lang.String)
	 */
	public User getUser(String login, String password) throws UserException {
		// TODO Auto-generated method stub

		for (Map.Entry<User, String> user : users.entrySet()) {
			if (user.getKey().getLogin().equals(login) && user.getValue().equals(password)) {
				return user.getKey();

			}
		}

		throw new UserException(Constants.LOGIN_OR_PASSWORD_ABSENT_ERROR);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.gsu.epamlab.model.ifaces.IUserDAO#addAndGetUser(java.lang.String,
	 * java.lang.String)
	 */
	public User addAndGetUser(String login, String password) throws UserException {
		// TODO Auto-generated method stub

		synchronized (lock) {
			User user = new User(login, Role.USER);
			if (!users.containsKey(user)) {
				users.put(user, password);
				return user;
			} else {
				throw new UserException(Constants.KEY_LOGIN + " " + login + Constants.NOT_EMPTY);
			}
		}
	}
}
