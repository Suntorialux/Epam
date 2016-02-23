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
import by.gsu.epamlab.model.exceptions.UserException;
import by.gsu.epamlab.model.ifaces.IPlayDAO;
import by.gsu.epamlab.model.xml.PlayHundler;

/**
 * @author Andrei Yahorau
 *
 */
public class ReaderPlayImpl extends AbstractManagerDB implements IPlayDAO {

	@Override
	public List<Play> getPlaysFromXML(String filePath) throws UserException {
		PlayHundler playHundler = new PlayHundler();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(playHundler);
			reader.parse(filePath);
			return playHundler.getPlays();
		} catch (SAXException | IOException e) {
			throw new UserException(e.getMessage());
		}
	}



	@Override
	public void addPlaysDB(List<Play> playlist) throws UserException {

		Iterator<Play> iterator = playlist.iterator();
		Connection connection = null;
		PreparedStatement psInsertPlay = null;
		PreparedStatement psSelectPlay = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			psInsertPlay = connection
					.prepareStatement("INSERT INTO plays (title, datePlay, description) VALUES (?,?,?)");
			psSelectPlay = connection.prepareStatement("SELECT title, datePlay FROM plays WHERE title = ? && datePlay = ?");
			while (iterator.hasNext()) {
				Play play = iterator.next();
				String title = play.getTitle();
				Date date = play.getDate();
				psSelectPlay.setString(1, title);
				psSelectPlay.setDate(2, date);
				resultSet = psSelectPlay.executeQuery();
				if (!resultSet.first()) {
					psInsertPlay.setString(1, title);
					psInsertPlay.setDate(2, date);
					psInsertPlay.setString(3, play.getDescription());
					psInsertPlay.executeUpdate();
				}
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException(e.getMessage());
		} finally {
			closeResultSet(resultSet);
			closeStatement(psSelectPlay, psInsertPlay);
			closeConnection(connection);
		}
	}

	@Override
	public Map<Integer, Play> getPlaysFromDB() throws UserException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Map<Integer, Play> playlist = new HashMap<>();
			connection = getConnection();
			preparedStatement = connection.prepareStatement("Select * from plays");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				Date date = resultSet.getDate(3);
				String description = resultSet.getString(4);
				Play play = new Play(id, title, description, date);
				playlist.put(id, play);
			}
			return playlist;
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException(e.getMessage());
		} finally {
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
	}
}
