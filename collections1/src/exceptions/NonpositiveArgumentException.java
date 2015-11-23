package exceptions;

import by.gsu.epamlab.Constants;

@SuppressWarnings("serial")
public class NonpositiveArgumentException extends IllegalArgumentException {
	 
	private int nonpositiveValue;
	private final String fieldName;
	
	public NonpositiveArgumentException(String fieldName) {
		super();
		this.fieldName = fieldName;
	}

	public NonpositiveArgumentException(int nonpositiveValue, String fieldName) {
		super();
		this.nonpositiveValue = nonpositiveValue;
		this.fieldName = fieldName;
	}
		
	public int getNonpositiveValue() {
		return nonpositiveValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Constants.ERROR_NON_POSITIVE+getFieldName();
	}
	
	

	
}
