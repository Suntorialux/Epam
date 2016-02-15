/**
 * 
 */
package by.gsu.epamlab.model.beans;

import java.text.SimpleDateFormat;

/**
 * @author Yahorau Andrei
 *
 */
public class Constants {
	
	public final static SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");
	public final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd.mm.yyyy");
	
	

	public static final String LOGIN_OR_PASSWORD_ABSENT_ERROR = "Login or password absent error";
	public static final String LOGIN_EMPTY_ERROR = "Login is empty error";

	public static final String DEVELOPER = "Developed by Andrei Yahorau";
	public static final String MAIL_DEVELOPER = "suntorialux@gmail.com";
	public static final String KEY_LOGIN = "login";
	public static final String KEY_PASSWORD = "password";
	public static final String USER = "user";
	public static final String ROLE = "role";
	public static final String EMPTY = "";
	public static final String ERROR = "error";
	public static final String NOT_EMPTY = " is not empty";
	
	
	public static final String PLAY_LIST_XML = "playlist.xml";
	public static final String FOLDER_VIEWS = "/WEB-INF/views";
	public static final String PAGE_LOGIN = "/login.jsp";
	public static final String PAGE_INDEX = "/index.jsp";
	public static final String PAGE_MAIN = "/main.jsp";
	public static final String PAGE_REGISTRATION = "/registration.jsp";

}
