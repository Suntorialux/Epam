package by.gsu.epamlab;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class Result {
	
	//private final static SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");
	private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
	private String login;
	private String test;
	private Date date;
	private int mark;

	public Result(String login, String test, Date date, int mark) {
		this.login = login;
		this.test = test;
		this.date = date;
		this.mark=mark;
	}
	
	public Result(String login, String test, Date date) {
		// TODO Auto-generated constructor stub
		this.login = login;
		this.test = test;
		this.date = date;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	
/*	
	public void setDate(String date) {
		try {
			this.date = new Date(INPUT_DATE_FORMAT.parse(date).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException();
		}
	}
	 */
	public String getStringDate () {
		return OUTPUT_DATE_FORMAT.format(date);
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
		
	public String getStringMark() {
		String stringMark = Integer.toString(mark);
		return stringMark;
	}
/*	
	public void setMark (String mark) {
			this.mark=Integer.parseInt(mark);
	}  */
	
	@Override
	public String toString() {
		return login + ";" + test + ";" + getStringDate() + ";" + getStringMark();
	}
}
