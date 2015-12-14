package by.gsu.epamlab;

import java.sql.Date;

import by.gsu.epamlab.xml.DecimalResult;

public class DecimalResultFactory extends ResultFactory {
	
	public Result getResultFromFactory(String login, String test, Date date, int mark){
		return new DecimalResult(login, test, date, mark);
	}
}
