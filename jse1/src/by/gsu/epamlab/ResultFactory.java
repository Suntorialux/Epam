package by.gsu.epamlab;

import java.sql.Date;

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

	
	
	
}
