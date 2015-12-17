package by.gsu.epamlab.beans;

import java.text.SimpleDateFormat;

import java.sql.Date;

public class Result {
	
	private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	private final static String DELIMETER = ";";
	
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
	
	public Result(String login, String test, Date date, String stringMark) {
		this.login = login;
		this.test = test;
		this.date = date;
		setMark(stringMark);
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

	public String getStringDate () {
		return OUTPUT_DATE_FORMAT.format(date);
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public void setMark (String stringMark) {
		this.mark=Integer.parseInt(stringMark);
	}
		
	public String getStringMark() {
		String stringMark = Integer.toString(mark);
		return stringMark;
	}
		
	@Override
	public String toString() {
		return login + DELIMETER + test + DELIMETER + getStringDate() + DELIMETER + getStringMark();
	}
}
