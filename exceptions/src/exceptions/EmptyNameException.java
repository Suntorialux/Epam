package exceptions;

@SuppressWarnings("serial")
public class EmptyNameException extends IllegalArgumentException{
	
	private String message;

	public EmptyNameException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}
	
}

