/**
 * 
 */
package by.gsu.epamlab.model.exceptions;

/**
 * @author Yahorau Andrei
 *
 */
public class BookingException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BookingException() {
		super();

	}

	/**
	 * @param message
	 */
	public BookingException(String message) {
		super(message);

	}

}
