package by.gsu.epamlab.beans;

import java.sql.Date;

public class HalfResult extends Result {
	
	private final static int FACTOR = 2;
	
	public HalfResult(String login, String test, Date date, int mark) {
		super(login, test, date, mark);
		// TODO Auto-generated constructor stub
	}
	
	public HalfResult(String login, String test, Date date, String StringMark) {
		super(login, test, date, StringMark);
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
		String stringMark=String.valueOf(getMark()/FACTOR);
		if(getMark()%FACTOR!=0) {
			stringMark +=".5";
		}
		return stringMark;
	}
}
