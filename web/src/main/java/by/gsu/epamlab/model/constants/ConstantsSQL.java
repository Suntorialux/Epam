/**
 * 
 */
package by.gsu.epamlab.model.constants;

/**
 * @author Yahorau Andrei
 *
 */
public class ConstantsSQL {

	public static final String DB_RESOURCE = "jdbc/WebDB";
	public static final String DB_CONTEXT = "java:/comp/env";

	public final static String SQL_GET_LOGIN_AND_PASSWORD = "Select login, role, password FROM users WHERE login like binary ? && password like binary ?";
	public final static String SQL_GET_LOGIN = "Select login FROM users WHERE login=? ";
	public final static String SQL_ADD_USER = "Insert into users (login, password, role) values (?,?,?)";
	public final static String SQL_ADD_PLAYS = "INSERT INTO plays (title, datePlay, description) VALUES (?,?,?)";
	public final static String SQL_SELECT_PLAY = "SELECT title, datePlay FROM plays WHERE title = ? && datePlay = ?" ;
	public final static String SQL_SELECT_PLAYS = "Select * from plays" ;
	public final static String SQL_SELECT_USER_ID = "SELECT idUser FROM users WHERE login = (?)";
	public final static String SQL_INSERT_BOOKING = "Insert into orders (id_user, id_play, sector, row, place, price, status) values (?,?,?,?,?,?,?)";
	public final static String SQL_SELECT_ID_BOOKING = "Select idOrder from orders where id_play = (?) && sector = (?) && row = (?) && place = (?)";
	public final static String SQL_CHANGE_STATUS = "update orders set status = 'isBought' where  idOrder = (?)";
	public final static String SQL_SELECT_BOOKINGS = "Select orders.idOrder, users.login, orders.id_play, orders.sector, orders.row, orders.place, orders.price, orders.status from users, orders where users.idUser = orders.id_user";
	

	
	public final static int LOGIN_INDEX = 1;
	public final static int PASSWORD_INDEX = 2;
	public final static int ROLE_INDEX = 3;
	public final static int TITLE_INDEX = 1;
	public final static int DATE_INDEX = 2;
	public final static int DESCRIPTION_INDEX = 3;
}
