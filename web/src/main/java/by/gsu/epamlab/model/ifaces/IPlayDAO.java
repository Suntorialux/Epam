/**
 * 
 */
package by.gsu.epamlab.model.ifaces;

import java.util.List;

import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.UserException;

/**
 * @author Yahorau Andrei
 *
 */
public interface IPlayDAO {
	
	List<Play> getPlays(String filePath) throws UserException;

}
