package by.gsu.epamlab.factories;

import java.sql.Date;
import by.gsu.epamlab.beans.HalfResult;
import by.gsu.epamlab.beans.Result;

public class HalfResultFactory extends ResultFactory {

		
	@Override
	public Result setResultFromFactory(String login, String test, Date date, String stringMark) {
		// TODO Auto-generated method stub
		return new HalfResult(login, test, date, stringMark);
	}

	@Override
	public Result getResultFromFactory(String login, String test, Date date, int mark) {
		// TODO Auto-generated method stub
		return new HalfResult(login, test, date, mark);
	}
	
	@Override
	protected double setMean(double mean) {
		// TODO Auto-generated method stub
		return mean/2;
	}

}
