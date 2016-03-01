/**
 * 
 */
package by.gsu.epamlab.model.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.gsu.epamlab.model.DB.AbstractManagerDB;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.constants.ConstantsSQL;
import by.gsu.epamlab.model.exceptions.PlayException;
import by.gsu.epamlab.model.ifaces.IPlayDAO;
import by.gsu.epamlab.model.xml.PlayHundler;

/**
 * @author Andrei Yahorau
 *
 */
public class ReaderPlayImpl extends AbstractManagerDB implements IPlayDAO {

	
	private final int ID_INDEX = 1;
	private final int TITLE_INDEX = 2;
	private final int DATE_INDEX = 3;
	private final int DESCRIPTION_INDEX = 4;
	
	
	@Override
	public List<Play> getPlaysFromXML(String filePath) throws PlayException {
		PlayHundler playHundler = new PlayHundler();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(playHundler);
			reader.parse(filePath);
			return playHundler.getPlays();
		} catch (SAXException | IOException e) {
			throw new PlayException(e.getMessage());
		}
	}



	@Override
	public void addPlaysDB(List<Play> playlist) throws PlayException {

		Iterator<Play> iterator = playlist.iterator();
		Connection connection = null;
		PreparedStatement psInsertPlay = null;
		PreparedStatement psSelectPlay = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			psInsertPlay = connection
					.prepareStatement(ConstantsSQL.SQL_ADD_PLAYS);
			psSelectPlay = connection.prepareStatement(ConstantsSQL.SQL_SELECT_PLAY);
			while (iterator.hasNext()) {
				Play play = iterator.next();
				String title = play.getTitle();
				Date date = play.getDate();
				String description = play.getDescription();
				psSelectPlay.setString(ConstantsSQL.TITLE_INDEX, title);
				psSelectPlay.setDate(ConstantsSQL.DATE_INDEX, date);
				resultSet = psSelectPlay.executeQuery();
				if (!resultSet.first()) {
					psInsertPlay.setString(ConstantsSQL.TITLE_INDEX, title);
					psInsertPlay.setDate(ConstantsSQL.DATE_INDEX, date);
					psInsertPlay.setString(ConstantsSQL.DESCRIPTION_INDEX, description);
					psInsertPlay.executeUpdate();
				}
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new PlayException(e.getMessage());
		} finally {
			closeResultSet(resultSet);
			closeStatement(psSelectPlay, psInsertPlay);
			closeConnection(connection);
		}
	}

	@Override
	public Map<Integer, Play> getPlaysFromDB() throws PlayException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Map<Integer, Play> playlist = new HashMap<>();
			connection = getConnection();
			preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_SELECT_PLAYS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(ID_INDEX);
				String title = resultSet.getString(TITLE_INDEX);
				Date date = resultSet.getDate(DATE_INDEX);
				String description = resultSet.getString(DESCRIPTION_INDEX);
				Play play = new Play(id, title, description, date);
				playlist.put(id, play);
			}
			return playlist;
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new PlayException(e.getMessage());
		} finally {
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
	}
}
