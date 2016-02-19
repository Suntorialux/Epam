/**
 * 
 */
package by.gsu.epamlab.model.ifaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.beans.Place;
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

	Map<String, Place> getHall(String filePath) throws UserException;

	Set<Booking> getShemaHall(Map<String, Place> hall, int idPlay);
}
