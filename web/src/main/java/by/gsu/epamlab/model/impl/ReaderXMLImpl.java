/**
 * 
 */
package by.gsu.epamlab.model.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.UserException;
import by.gsu.epamlab.model.ifaces.IPlayDAO;
import by.gsu.epamlab.model.xml.PlayHundler;

/**
 * @author Andrei Yahorau
 *
 */
public class ReaderXMLImpl implements IPlayDAO {

	@Override
	public List<Play> getPlays(String filePath) throws UserException {
		PlayHundler playHundler = new PlayHundler();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(playHundler);
			reader.parse(filePath);

		} catch (SAXException | IOException e) {
			throw new UserException(e.getMessage());
		}

		return playHundler.getPlays();
	}

}
