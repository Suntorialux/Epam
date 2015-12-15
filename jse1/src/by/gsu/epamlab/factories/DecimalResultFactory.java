package by.gsu.epamlab.factories;

import java.sql.Date;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.results.DecimalResult;
import by.gsu.epamlab.results.Result;
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
	
	@Override
	protected double setMean(double mean) {
		// TODO Auto-generated method stub
		return mean/10;
	}
		
}
