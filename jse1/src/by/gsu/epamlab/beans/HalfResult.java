package by.gsu.epamlab.beans;

import java.sql.Date;

public class HalfResult extends Result {
	
	private final static String SEPARATOR_POINT = ".";
	private final static int TWO = 2;
	
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
		int mark = (int)(Double.parseDouble(stringMark)*TWO);
		super.setMark(mark); 
	}

	@Override
	public String getStringMark() {
		// TODO Auto-generated method stub 
		String stringMark=String.valueOf(getMark()/TWO);
		if(getMark()%TWO!=0) {
			stringMark +=SEPARATOR_POINT+getMark()*5%10;
		}
		return stringMark;
	}
}
