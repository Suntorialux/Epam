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
import by.gsu.epamlab.model.constants.Constants;
import by.gsu.epamlab.model.exceptions.HallException;
import by.gsu.epamlab.model.ifaces.IHallDAO;
import by.gsu.epamlab.model.xml.HallHundler;

/**
 * @author Andrei Yahorau
 *
 */
public class ReaderHallIml implements IHallDAO {

	private final int ROWS_INDEX = 0;
	private final int PLACES_INDEX = 1;
	private final int PRICE_INDEX = 2;
	
	
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
	public Map<String, Booking[][]> getBookingHall(Map<String, int[]> hall, Map<Integer, Booking> bookings) {
		Map<String, Booking[][]> bookingHall = new HashMap<>();
		for (Map.Entry<String, int[]> sector : hall.entrySet()) {
			Booking[][] books = new Booking[sector.getValue()[ROWS_INDEX]][sector.getValue()[PLACES_INDEX]];
			for (int row = 0; row < sector.getValue()[ROWS_INDEX]; row++) {
				for (int place = 0; place < sector.getValue()[PLACES_INDEX]; place++) {
					Booking booking = new Booking(sector.getKey(), row + 1, place + 1, sector.getValue()[PRICE_INDEX],
							Constants.FREE);
					if (bookings.containsValue(booking)) {
						booking.setStatus(Constants.BRONE);
					}
					books[row][place] = booking;
				}
			}
			bookingHall.put(sector.getKey(), books);
		}

		return bookingHall;
	}

}
