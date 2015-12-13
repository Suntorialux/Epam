package by.gsu.epamlab.xml;

import by.gsu.epamlab.Result;

public class DecimalResult extends Result{
	
	private final static String SEPARATOR_POINT = ".";
	

	@Override
	public String getStringMark() {
		// TODO Auto-generated method stub
		String stringMark = (getMark()/10)+SEPARATOR_POINT+(getMark()%10);
		return stringMark;
	}

}
