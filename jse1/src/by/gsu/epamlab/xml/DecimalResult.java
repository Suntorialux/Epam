package by.gsu.epamlab.xml;

import java.sql.Date;

import by.gsu.epamlab.Result;

public class DecimalResult extends Result{
	
	private final static String SEPARATOR_POINT = ".";
	
	public DecimalResult(String login, String test, Date date, int mark) {
		super(login, test, date, mark);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getStringMark() {
		// TODO Auto-generated method stub
		String stringMark = (getMark()/10)+SEPARATOR_POINT+(getMark()%10);
		return stringMark;
	}

}
