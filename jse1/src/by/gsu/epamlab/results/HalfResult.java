package by.gsu.epamlab.results;

import java.sql.Date;

public class HalfResult extends Result {
	
	private final static String SEPARATOR_POINT = ".";
	
	public HalfResult(String login, String test, Date date, int mark) {
		super(login, test, date, mark);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getStringMark() {
		// TODO Auto-generated method stub 
		String stringMark=String.valueOf(getMark()/2);
		if(getMark()%2!=0) {
			stringMark +=SEPARATOR_POINT+getMark()*5%10;
		}
		return stringMark;
	}
}
