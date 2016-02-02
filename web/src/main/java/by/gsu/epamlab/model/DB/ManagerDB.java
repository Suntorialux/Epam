/**
 * 
 */
package by.gsu.epamlab.model.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import by.gsu.epamlab.model.beans.ConstantsSQL;

/**
 * @author Yahorau Andrei
 *
 */
public class ManagerDB {

	public static Connection getConnection() throws NamingException, SQLException {
		Connection connection;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup(ConstantsSQL.DB_CONTEXT);
		DataSource datasource = (DataSource) envContext.lookup(ConstantsSQL.DB_RESOURCE);
		connection = datasource.getConnection();
		return connection;

	}

	public static void closeResultSet(ResultSet... resultSets) {
		for (ResultSet rs : resultSets) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					printSQLException(ex);
				}
			}
		}
	}

	public static void closeStatement(Statement... statement) {
		for (Statement st : statement) {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException ex) {
					printSQLException(ex);
				}
			}
		}
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				printSQLException(ex);
			}
		}
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
