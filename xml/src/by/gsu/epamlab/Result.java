package by.gsu.epamlab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
	
	private final static String SEPARATOR_POINT = "\\.";
	private final static SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");
	private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd.mm.yyyy");
	
	private String login;
	private String test;
	private Date date;
	private int mark;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(String login, String test, Date date, String mark) {
		this.login = login;
		this.test = test;
		this.date = date;
		setMark(mark);
	}
	
	

	public Result(String login, String test, String date, String mark) {
		this.login = login;
		this.test = test;
		setDate(date);
		setMark(mark);
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

	public void setDate(String date) {
		try {
			this.date = INPUT_DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException();
		}
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
	
	public String getStringMark() {
		String stringMark = (mark/Constants.TEN)+Constants.POINT+(mark%Constants.TEN);
		return stringMark;
	}
	
	public void setMark (String mark) {
		String [] data = mark.split(SEPARATOR_POINT);
		this.mark=Integer.parseInt(data[Constants.INDEX_ZERO])*Constants.TEN+Integer.parseInt(data[Constants.INDEX_ONE]);
	}

	@Override
	public String toString() {
		return login + Constants.DELIMETER + test + Constants.DELIMETER + getStringDate() + Constants.DELIMETER + getStringMark();
	}
	
	
}
