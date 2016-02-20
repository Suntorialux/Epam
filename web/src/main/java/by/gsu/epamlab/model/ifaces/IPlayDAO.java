/**
 * 
 */
package by.gsu.epamlab.model.ifaces;

import java.util.List;
import java.util.Map;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.UserException;

/**
 * @author Yahorau Andrei
 *
 */
public interface IPlayDAO {

	List<Play> getPlaysFromXML(String filePath) throws UserException;
	
	void addPlaysDB(List<Play> playlist) throws UserException;
	
	Map<Integer, Play> getPlaysFromDB() throws UserException;

}
