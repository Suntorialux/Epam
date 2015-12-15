package by.gsu.epamlab;

import java.sql.Date;

import by.gsu.epamlab.xml.DecimalResult;
import by.gsu.epamlab.xml.ResultImplXml;

public class DecimalResultFactory extends ResultFactory {

	
	
	
	@Override
	public Result getResultFromFactory(String login, String test, Date date, int mark) {
		// TODO Auto-generated method stub
		return new DecimalResult(login, test, date, mark);
	}

	@Override
	public IResultDAO getResultDaoFromFactory(ResultFactory resultFactory, String fileName) {
		// TODO Auto-generated method stub
		return new ResultImplXml(fileName);
	}
	
	
	
	
	
}
