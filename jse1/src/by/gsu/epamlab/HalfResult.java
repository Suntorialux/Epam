package by.gsu.epamlab;

import java.sql.Date;

public class HalfResult extends Result {
	
	private final static String SEPARATOR_POINT = ".5";

	public HalfResult(String login, String test, Date date, int mark) {
		super(login, test, date, mark);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getStringMark() {
		// TODO Auto-generated method stub
		String stringMark;
		if(getMark()%2!=0) {
			stringMark = (getMark()/2)+SEPARATOR_POINT;	
		} else {
			stringMark = String.valueOf(getMark()/2);
		}
		return stringMark;
	}
}
