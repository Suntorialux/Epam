package exceptions;

import by.gsu.epamlab.Constants;

@SuppressWarnings("serial")
public class CsvLineException extends Exception{

	private String csvLine;


	public CsvLineException(String csvLine, Exception exception) {
		super(exception);
		this.csvLine = csvLine;
	}
	
	public CsvLineException(String cause, String csvLine) {
		super(cause);
		this.csvLine = csvLine;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return csvLine+Constants.ERROR_EXCEPTION_DELIMETER + getMessage();
	}

	
	
	

	
}
