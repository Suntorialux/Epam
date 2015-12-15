import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.gsu.epamlab.ConnectDB;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultFactory;
import by.gsu.epamlab.ResultsLoader;

public class RunnerLogic {

	public static void logic(ResultFactory resultFactory, String fileName) {
		
		IResultDAO reader = resultFactory.getResultDaoFromFactory(resultFactory, fileName);
		ResultsLoader.loadResults(reader);
		
		
		Connection connection = ConnectDB.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT logins.name , tests.name, results.dat, results.mark from logins, tests, results "+
			                     "WHERE logins.idLogin = results.loginId AND tests.idTest = results.testId");
			while(resultSet.next()) {
				String login = resultSet.getString(1);
				String test = resultSet.getString(2);
				Date date = resultSet.getDate(3);
				int mark = resultSet.getInt(4);
				Result result = resultFactory.getResultFromFactory(login, test, date, mark); 
				System.out.println(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
