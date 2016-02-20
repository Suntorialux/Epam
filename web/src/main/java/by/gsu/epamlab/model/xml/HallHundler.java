/**
 * 
 */
package by.gsu.epamlab.model.xml;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


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
	private int numRows;
	private int numPlaces;
	private Map<String, int[]> hall;
	
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
	public Map<String, int[]> getHall() {
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
			this.numRows = Integer.parseInt(attributes.getValue("rows"));
			this.numPlaces= Integer.parseInt(attributes.getValue("places"));
			int [] paramSector = new int[] {numRows, numPlaces, price};
			hall.put(nameSector, paramSector);
		}	
	}
}
