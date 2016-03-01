/**
 * 
 */
package by.gsu.epamlab.model.constants;

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
	public static final String BOOKING_ERROR = "This place is brone. Try again.";
	public static final String SEPARATOR = "_";
	public static final String DEVELOPER = "Developed by Andrei Yahorau";
	public static final String MAIL_DEVELOPER = "suntorialux@gmail.com";
	public static final String KEY_LOGIN = "login";
	public static final String KEY_PASSWORD = "password";
	public static final String USER = "user";
	public static final String ROLE = "role";
	public static final String EMPTY = "";
	public static final String ERROR = "error";
	public static final String NOT_EMPTY = " is not empty";
	public static final String ID_PLAY = "idPlay";
	public static final String PLAYLIST = "playlist";
	public static final String HALL = "hall";
	public static final String PLAY = "play";
	public static final String BOOKING_HALL = "bookingHall";
	public static final String PLACE = "place";
	public static final String BOOKING = "booking";
	public static final String BOOKINGS = "bookings";
	public static final String LOGINS = "logins";
	public static final String ALL = "all";
	public static final String STATUS = "status";
	public static final String CHANGE_STATUS = "change on isBought";
	public static final String DELETE = "delete";
	public static final String OPERATION = "operation";
	public static final String ID_BOOKING = "idBooking";
	public static final String PRINT = "print";
	public static final String DELIMITR = ";";
	public static final String NEW_LINE = "\n";
	public static final String IS_BOOKED = "isBooked";
	public static final String FREE = "free";
	public static final String BRONE = "brone";
	
	public static final String RESOURSE_PATH = "WEB-INF/classes/";
	public static final String THEATER_HALL_XML = "theaterHall.xml";
	public static final String PLAY_LIST_XML = "playlist.xml";
	public static final String FOLDER_VIEWS = "/WEB-INF/views";
	public static final String PAGE_LOGIN = "/login.jsp";
	public static final String PAGE_INDEX = "/index.jsp";
	public static final String PAGE_MAIN = "/main.jsp";
	public static final String PAGE_REGISTRATION = "/registration.jsp";
	public static final String PAGE_BOOKING = "/booking.jsp";
	public static final String PAGE_BOOKING_INFO = "/bookingInfo.jsp";
	public static final String PAGE_COURIER = "/courier.jsp";
	public static final String PAGE_MY_BOOKINGS = "/myBookings.jsp";
	public static final String PAGE_ORDER = "/order.jsp";
	public static final String PAGE_INFO_ORDER = "/orderInfo.jsp";
	public static final String MAIN = "/main";

}
