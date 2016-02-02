/**
 * 
 */
package by.gsu.epamlab.model.beans;

/**
 * @author Yahorau Andrei
 *
 */
public class ConstantsSQL {

	public static final String DB_RESOURCE = "jdbc/WebDB";
	public static final String DB_CONTEXT = "java:/comp/env";

	public final static String SQL_GET_LOGIN_AND_PASSWORD = "Select login, role, password FROM users WHERE login=? && password=?";
	public final static String SQL_GET_LOGIN = "Select login FROM users WHERE login=? ";
	public final static String SQL_ADD_USER = "Insert into users (login, password, role) values (?,?,?)";

	public final static int LOGIN_INDEX = 1;
	public final static int PASSWORD_INDEX = 2;
	public final static int ROLE_INDEX = 3;
}
