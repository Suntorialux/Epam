import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.xml.ResultImplXml;

public class RunnerDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IResultDAO resultDAO = new ResultImplXml("src/results.xml");
		ResultsLoader.loadResults(resultDAO);
		
		
		
		
		
	/*	
		Connection connection = ConnectDB.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT logins.name , tests.name, results.dat, results.mark from logins, tests, results "+
			                     "WHERE logins.idLogin = results.loginId AND tests.idTest = results.testId");
			while(resultSet.next()) {
				String login = resultSet.getString(1);
				String name = resultSet.getString(2);
				Date date = resultSet.getDate(3);
				int mark = resultSet.getInt(4);
				Result result = new DecimalResult(login, name, date, mark);
				System.out.println(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	*/	
	} 

}
