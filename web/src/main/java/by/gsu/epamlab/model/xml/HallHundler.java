/**
 * 
 */
package by.gsu.epamlab.model.xml;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.gsu.epamlab.model.beans.Place;


/**
 * @author Andrei Yahorau
 *
 */
public class HallHundler extends DefaultHandler {
	
	private enum HallEnum {
		THEATER, HALL, SECTOR;
	}
	
	private HallEnum hallEnum;
	private String nameSector;
	private int price;
	private int rows;
	private int places;
	private Map<String, Place> hall;
	
	/**
	 * 
	 * @param hall
	 */
	public HallHundler() {
		this.hall = new HashMap<>();
	}
	
	/**
	 * @return the hall
	 */
	public Map<String, Place> getHall() {
		return hall;
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		hallEnum = HallEnum.valueOf(localName.toUpperCase());
		if (hallEnum==HallEnum.SECTOR) {
			this.nameSector=attributes.getValue("name").trim();
			this.price = Integer.parseInt(attributes.getValue("price"));
			this.rows = Integer.parseInt(attributes.getValue("rows"));
			this.places= Integer.parseInt(attributes.getValue("places"));
			Place place = new Place(nameSector, rows, places, price);
			hall.put(nameSector, place);
		}	
	}
}
