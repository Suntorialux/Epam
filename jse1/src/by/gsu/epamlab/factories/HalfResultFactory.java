package by.gsu.epamlab.factories;

import java.sql.Date;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultImplCsv;
import by.gsu.epamlab.results.HalfResult;
import by.gsu.epamlab.results.Result;

public class HalfResultFactory extends ResultFactory {

		
	@Override
	public Result setResultFromFactory(String login, String test, Date date, String stringMark) {
		// TODO Auto-generated method stub
		int mark = (int)(Double.parseDouble(stringMark)*2);
		return new HalfResult(login, test, date, mark);
	}

	@Override
	public Result getResultFromFactory(String login, String test, Date date, int mark) {
		// TODO Auto-generated method stub
		return new HalfResult(login, test, date, mark);
	}

	@Override
	public IResultDAO getResultDaoFromFactory(ResultFactory resultFactory, String fileName) {
		// TODO Auto-generated method stub
		return new ResultImplCsv(fileName, resultFactory);
	}
	
	

	@Override
	protected double setMean(double mean) {
		// TODO Auto-generated method stub
		return mean/2;
	}

}
