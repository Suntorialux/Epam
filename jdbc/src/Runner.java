import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.NumLen;

public class Runner {
	public static void main(String[] args) {
		String driverName = "org.gjt.mm.mysql.Driver";
		String dbUrl = "jdbc:mysql://localhost/segments"; 
		String user = "use";
		String password = "111";
		List<NumLen> lenNums = new ArrayList<>();

		
		
		try {
			
			Class.forName(driverName);
			
			try(Connection cn = DriverManager.getConnection(dbUrl, user, password)) {
				
				String querry = "SELECT ROUND(ABS(X1 - X2)+0.001) AS len, COUNT(ROUND(ABS(X1 - X2)+0.001))"
						+ " AS num FROM coordinates GROUP BY ROUND(ABS(X1-X2)+0.001) ORDER BY len ";
				try(Statement st = cn.createStatement()) {
									
					try(ResultSet rs = st.executeQuery(querry)) {
						while (rs.next()) {
							lenNums.add(new NumLen(rs.getInt(1),rs.getInt(2)));			
						}
						st.executeUpdate("DELETE FROM frequencies");
					}
				}
				
				for(NumLen numLen :lenNums) {
					System.out.println(numLen);
				}
				System.out.println();
				
				
				
				String sql = "INSERT INTO frequencies(Len, Num) VALUES(?, ?)";
				try(PreparedStatement preparedStatement = cn.prepareStatement(sql)) {
					
					for(NumLen numLen : lenNums) {
						preparedStatement.setInt(1, numLen.getLen());
						preparedStatement.setInt(2, numLen.getNum());
						preparedStatement.executeUpdate();
					}
				}
				
				try(Statement statement = cn.createStatement()) {
					String querry2 = "SELECT * FROM frequencies WHERE len>num";
					try (ResultSet resultSet = statement.executeQuery(querry2))  {
						while(resultSet.next()) {
							System.out.println(resultSet.getString("len")+";"+resultSet.getString("num"));
						}
					} 
				}
				
			
				
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
