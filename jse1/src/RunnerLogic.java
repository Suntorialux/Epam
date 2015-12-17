import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import by.gsu.epamlab.ConnectDB;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.factories.ResultFactory;

public class RunnerLogic {

	public static void logic(ResultFactory resultFactory, String fileName) {
		
		final String GET_AVG_MARK = "SELECT logins.name, ROUND(avg(results.mark),2)  AS mean " +
                "FROM results INNER JOIN logins ON logins.idLogin = results.loginId " +
                "GROUP BY name ORDER BY mean DESC";
	
        final  String GET_FIELD_FROM_TABLE_ON_MONTH ="SELECT logins.name , tests.name, results.dat, results.mark" +
                " FROM tests right JOIN" +
                " (logins right JOIN results ON logins.idLogin = results.loginId) ON tests.idTest = results.testId" +
                " WHERE Month(results.dat)=? AND YEAR(results.dat)=?" +
                " ORDER BY results.dat";

        final String GET_FIELD_FROM_TABLE = "SELECT logins.name , tests.name, results.dat, results.mark from logins, tests, results "+
                "WHERE logins.idLogin = results.loginId AND tests.idTest = results.testId";
        
        final int LOGIN_IND = 1;
        final int TEST_IND = 2;
        final int DATE_IND = 3;
        final int MARK_IND = 4;
        final String MONTH = "MM";
        final String YEAR = "yyyy";
        
		
		
		IResultDAO reader;
		try {
			reader = resultFactory.getResultDaoFromFactory(resultFactory, fileName);
			ResultsLoader.loadResults(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("file is not found and the base has not been updated");
		}
		
		
		List<Result> results = new LinkedList<Result>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectDB.getConnection();
			ps=connection.prepareStatement(GET_FIELD_FROM_TABLE);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				String login = resultSet.getString(LOGIN_IND);
				String test = resultSet.getString(TEST_IND);
				Date date = resultSet.getDate(DATE_IND);
				int mark = resultSet.getInt(MARK_IND);
				Result result = resultFactory.getResultFromFactory(login, test, date, mark); 
				System.out.println(result);
			}
			resultSet.close();
			ps.close();
			System.out.println();
				
//3. Print the mean value of marks (2 digits after decimal point) on every student in descending order by the mean value. 
				
			ps = connection.prepareStatement(GET_AVG_MARK);
			resultSet = ps.executeQuery();
			System.out.println();
			while (resultSet.next()) {
				String login = resultSet.getString(LOGIN_IND);
				double mean = resultSet.getDouble(2);
				System.out.println(login+" = "+ resultFactory.getAVG(mean));
			}
			resultSet.close();
			System.out.println();
				
//4. Create a LinkedList implementation of tests results for the current month sorting by the date ascending and print it.
				
			ps=connection.prepareStatement(GET_FIELD_FROM_TABLE_ON_MONTH);
		    java.util.Date now = new java.util.Date();
		    SimpleDateFormat month = new SimpleDateFormat(MONTH);
		    SimpleDateFormat year = new SimpleDateFormat(YEAR);
		    int intMonth=Integer.parseInt(month.format(now));
		    int intYear = Integer.parseInt(year.format(now));
		    ps.setInt(1, intMonth);
		    ps.setInt(2, intYear);
		    resultSet=ps.executeQuery();
		    while (resultSet.next())  {
		        String login=resultSet.getString(LOGIN_IND);
		        String test=resultSet.getString(TEST_IND);
		        Date date=resultSet.getDate(DATE_IND);
		        int mark=resultSet.getInt(MARK_IND);
		        Result result = resultFactory.getResultFromFactory(login, test, date, mark);
		        results.add(result);
		    }
		    for(Result result : results) {
		    	System.out.println(result);
		    }
		    System.out.println();
			    
   //5. Print tests results in the latest day of the current month (without SQL request), when tests have been passed.
			    
		    if(!results.isEmpty()) {
			    	
		    	ListIterator<Result> it = results.listIterator(results.size());
		       	Date lastDate = it.previous().getDate();
		                 	
		    	for(it = results.listIterator(results.size()) ;it.hasPrevious();) {
		    		Result result = it.previous();
		    		if (result.getDate().equals(lastDate)) {
		    			System.out.println(result);
		    		}
		    	} 
		    } 			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} finally {
			ConnectDB.closeResultSet(resultSet);
			ConnectDB.closePreparedStatement(ps);
			ConnectDB.closeConnection(connection);
		}
	}
}
