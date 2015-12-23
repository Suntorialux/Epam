package by.gsu.epamlab;

import by.gsu.epamlab.beans.Result;

public class BuferReader implements IResultDAO {

	private Bufer bufer;
	private IResultDAO reader;

	
	public BuferReader(Bufer bufer, IResultDAO reader) {
		this.bufer = bufer;
		this.reader = reader;
	}

	@Override
	public synchronized Result nextResult() {
		// TODO Auto-generated method stub
		return bufer.getResult();
	}

	@Override
	public synchronized boolean hasResult() {
		// TODO Auto-generated method stub
		boolean isResult = false;
		if(reader.hasResult()) {
			isResult = true;
		}
		return isResult;
	}

	@Override
	public void closeReader() {
		// TODO Auto-generated method stub
		
	}
}
