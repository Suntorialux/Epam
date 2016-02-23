/**
 * 
 */
package by.gsu.epamlab.model.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.exceptions.HallException;
import by.gsu.epamlab.model.ifaces.IHallDAO;
import by.gsu.epamlab.model.xml.HallHundler;

/**
 * @author Andrei Yahorau
 *
 */
public class ReaderHallIml implements IHallDAO {

	@Override
	public Map<String, int[]> getHall(String filePath) throws HallException {
		HallHundler hallHundler = new HallHundler();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(hallHundler);
			reader.parse(filePath);
			return hallHundler.getHall();
		} catch (SAXException | IOException e) {
			throw new HallException(e.getMessage());
		}
	}
	
	@Override
	public Map<String, Booking[][]> getBookingHall (Map<String, int[]> hall, Map<Integer, Booking> bookings) {
		Map<String, Booking[][]> bookingHall = new HashMap<>();
		for(Map.Entry<String, int[]> sector : hall.entrySet()) {
			Booking [] [] books = new Booking [sector.getValue()[0]] [sector.getValue()[1]];
			for (int row = 0; row<sector.getValue()[0]; row++) {
				for (int place = 0; place <sector.getValue()[1]; place++) {
					Booking booking = new Booking(sector.getKey(), row+1, place+1, sector.getValue()[2], "free");
					if(bookings.containsValue(booking)) {
						booking.setStatus("brone");
					}
					books[row][place] = booking;
				}
			}
			bookingHall.put(sector.getKey(), books);
		}
		
		return bookingHall;	
	}
	
	

	
	
}
