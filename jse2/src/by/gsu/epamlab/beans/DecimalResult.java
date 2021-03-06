package by.gsu.epamlab.beans;

import java.sql.Date;

public class DecimalResult extends Result {
	
	private final static String SEPARATOR_POINT = ".";
	private final static int FACTOR = 10;
	
	public DecimalResult(String login, String test, Date date, int mark) {
		super(login, test, date, mark);
		// TODO Auto-generated constructor stub
	}

	public DecimalResult(String login, String test, Date date, String stringMark) {
		super(login, test, date, stringMark);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setMark(String stringMark) {
		// TODO Auto-generated method stub
		int mark = (int)(Double.parseDouble(stringMark)*FACTOR);
		setMark(mark);
	}

	@Override
	public String getStringMark() {
		// TODO Auto-generated method stub
		String stringMark = (getMark()/FACTOR)+SEPARATOR_POINT+(getMark()%FACTOR);
		return stringMark;
	}
}
