package by.gsu.epamlab.model.impl;

import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.ifaces.IUserDAO;

public class HardcodedUserImpl implements IUserDAO {
	public User getUser(String login, String password) throws DaoException {
		final String ADMIN_LOGIN = "sys", ADMIN_PASSWORD = "111";
		final String USER_LOGIN = "boss", USER_PASSWORD = "000";
		Role role;
		if (ADMIN_LOGIN.equals(login) && ADMIN_PASSWORD.equals(password)) {
			role = Role.ADMIN;
		} else {
			if (USER_LOGIN.equals(login) && USER_PASSWORD.equals(password)) {
				role = Role.USER;
			} else {
				role = Role.VISITOR;
			}
		}
		return new User(login, role);
	}
}
