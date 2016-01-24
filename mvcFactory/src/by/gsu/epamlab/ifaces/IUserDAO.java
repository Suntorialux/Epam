package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.impl.DaoException;

public interface IUserDAO {
	public User getUser(String name, String password) throws DaoException;
}
