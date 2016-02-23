/**
 * 
 */
package by.gsu.epamlab.model.ifaces;

import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.UserException;

/**
 * @author Yahorau Andrei
 *
 */
public interface IUserDAO {

	User getUser(String login, String password) throws UserException;

	User addAndGetUser(String login, String password) throws UserException;
	
}
