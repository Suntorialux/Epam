/**
 * 
 */
package by.gsu.epamlab.model.exceptions;

/**
 * @author Yahorau Andrei
 *
 */
public class ValidationException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ValidationException() {
		super();

	}

	/**
	 * @param message
	 */
	public ValidationException(String message) {
		super(message);

	}

}
