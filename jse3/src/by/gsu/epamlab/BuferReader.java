package by.gsu.epamlab;

import by.gsu.epamlab.beans.Result;

public class BuferReader implements IResultDAO {

	private Bufer bufer;
	private IResultDAO reader;
	
	
	public BuferReader(IResultDAO reader, Bufer bufer) {
		this.bufer = bufer;
		this.reader = reader;
	}

	@Override
	public Result nextResult() {
		// TODO Auto-generated method stub
		
		return bufer.getResult();
	}

	@Override
	public boolean hasResult() {
		// TODO Auto-generated method stub
		boolean isResult = false;
		if(reader.hasResult()||bufer.hasResult()) {
			isResult = true;
		}
		return isResult;
	}

	@Override
	public void closeReader() {
		// TODO Auto-generated method stub
		
	}
}
