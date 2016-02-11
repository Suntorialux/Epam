/**
 * 
 */
package by.gsu.epamlab.model.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.gsu.epamlab.model.beans.Play;

/**
 * @author Yahorau Andrei
 *
 */
public class PlayHundler extends DefaultHandler {

	private static enum PlayEnum {
		PLAYS, PLAY, DESCRIPTION, DATES, DATE;
	}

	private List<Play> plays;
	private Play play = null;
	private PlayEnum playEnum;
	private String title;
	private String description;
	int id;

	/**
	 * @param plays
	 */
	public PlayHundler() {
		super();
		this.plays = new ArrayList<Play>();
		this.id = 0;
	}

	/**
	 * @return the plays
	 */
	public List<Play> getPlays() {
		return plays;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		playEnum = PlayEnum.valueOf(localName.toUpperCase());
		if (playEnum == PlayEnum.PLAY) {
			title = attributes.getValue("title").trim();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if (playEnum == PlayEnum.DESCRIPTION) {
			String description = new String(ch, start, length).trim();
			if (!description.isEmpty()) {
				this.description = description;
			}
		}
		if (playEnum == PlayEnum.DATE) {
			String date = new String(ch, start, length).trim();
			if (!date.isEmpty()) {
				play = new Play();
				id++;
				play.setId(id);
				play.setDate(date);
				play.setTitle(title);
				play.setDescription(description);
				plays.add(play);
			}
		}
	}
}
