package by.gsu.epamlab.factories;

import java.sql.Date;
import java.util.Locale;

import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultImplCsv;
import by.gsu.epamlab.results.Result;

public class ResultFactory {
	
	public Result getResultFromFactory(String login, String test, Date date, int mark){
		return new Result(login, test, date, mark);
	}

	public Result setResultFromFactory(String login, String test, Date date, String stringMark) {
		int mark = Integer.parseInt(stringMark);
		return new Result(login, test, date, mark);
	}
	
	public IResultDAO getResultDaoFromFactory(ResultFactory resultFactory, String fileName) {
		return new ResultImplCsv(fileName, resultFactory);
	}
	
	protected double setMean(double mean) {
		return mean;
	}

	public String getAVG (double mean) {
		String avg = String.format(Locale.ENGLISH, "%.2f", setMean(mean));
		return avg;
	}
	
	
	
}
