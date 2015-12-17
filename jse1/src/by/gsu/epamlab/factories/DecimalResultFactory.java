package by.gsu.epamlab.factories;

import java.io.IOException;
import java.sql.Date;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.beans.DecimalResult;
import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.xml.ResultImplXml;

public class DecimalResultFactory extends ResultFactory {
	
	@Override
	public Result getResultFromFactory(String login, String test, Date date, int mark) {
		// TODO Auto-generated method stub
		return new DecimalResult(login, test, date, mark);
	}

	@Override
	public IResultDAO getResultDaoFromFactory(ResultFactory resultFactory, String fileName) throws IOException {
		// TODO Auto-generated method stub
		return new ResultImplXml(fileName);
	}
	
	@Override
	protected double setMean(double mean) {
		// TODO Auto-generated method stub
		return mean/10;
	}
		
}
