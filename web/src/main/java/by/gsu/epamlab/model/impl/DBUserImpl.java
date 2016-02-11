/**
 * 
 */
package by.gsu.epamlab.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import by.gsu.epamlab.model.DB.AbstractManagerDB;
import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.beans.ConstantsSQL;
import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.UserException;
import by.gsu.epamlab.model.ifaces.IUserDAO;

/**
 * @author Andrei Yahorau
 *
 */
public class DBUserImpl extends AbstractManagerDB implements IUserDAO {

	private final static Object lock = new Object();

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.gsu.epamlab.model.ifaces.IUserDAO#getUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User getUser(String login, String password) throws UserException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_GET_LOGIN_AND_PASSWORD);
			preparedStatement.setString(ConstantsSQL.LOGIN_INDEX, login);
			preparedStatement.setString(ConstantsSQL.PASSWORD_INDEX, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Role role = Role.valueOf(resultSet.getString(Constants.ROLE).toUpperCase());
				return new User(login, role);
			} else {
				throw new UserException(Constants.LOGIN_OR_PASSWORD_ABSENT_ERROR);
			}

		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException(e.getMessage());
		} finally {
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.gsu.epamlab.model.ifaces.IUserDAO#addAndGetUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User addAndGetUser(String login, String password) throws UserException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = getConnection();

			preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_GET_LOGIN);
			preparedStatement.setString(ConstantsSQL.LOGIN_INDEX, login);
			ps = connection.prepareStatement(ConstantsSQL.SQL_ADD_USER);
			ps.setString(ConstantsSQL.LOGIN_INDEX, login);
			ps.setString(ConstantsSQL.PASSWORD_INDEX, password);
			ps.setString(ConstantsSQL.ROLE_INDEX, Role.USER.toString().toUpperCase());
			synchronized (lock) {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					ps.executeUpdate();
					user = new User(login, Role.USER);
				}
			}
			if (user != null) {
				return user;
			} else {
				throw new UserException(Constants.KEY_LOGIN + " " + login + Constants.NOT_EMPTY);
			}

		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException(e.getMessage());
		} finally {
			closeResultSet(resultSet);
			closeStatement(preparedStatement, ps);
			closeConnection(connection);
		}

	}

}
