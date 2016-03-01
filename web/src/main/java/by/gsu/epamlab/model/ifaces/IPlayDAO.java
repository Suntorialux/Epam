/**
 * 
 */
package by.gsu.epamlab.model.ifaces;

import java.util.List;
import java.util.Map;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.PlayException;

/**
 * @author Yahorau Andrei
 *
 */
public interface IPlayDAO {

	List<Play> getPlaysFromXML(String filePath) throws PlayException;
	
	void addPlaysDB(List<Play> playlist) throws PlayException ;
	
	Map<Integer, Play> getPlaysFromDB() throws PlayException  ;

}
