package by.gsu.epamlab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
	
	private final static String INPUT_DATE = "yyyy-mm-dd";
	private final static String OUITPUT_DATE = "dd.mm.yyyy";
	private final static String SEPARATOR_POINT = "\\.";
	
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
		SimpleDateFormat dateInput =new SimpleDateFormat(INPUT_DATE);
		try {
			this.date = dateInput.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public String getStringMark() {
		String stringMark = mark/Constants.TEN+Constants.POINT+mark%Constants.TEN;
		return stringMark;
	}
	
	public void setMark (String mark) {
		String [] data = mark.split(SEPARATOR_POINT);
		this.mark=Integer.parseInt(data[Constants.INDEX_ZERO])*Constants.TEN+Integer.parseInt(data[Constants.INDEX_ONE]);
	}

	@Override
	public String toString() {
		SimpleDateFormat dateOutput =new SimpleDateFormat(OUITPUT_DATE);
		return login + Constants.DELIMETER + test + Constants.DELIMETER + dateOutput.format(date) + Constants.DELIMETER + getStringMark();
	}
	
	
}
