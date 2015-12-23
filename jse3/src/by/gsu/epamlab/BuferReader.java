package by.gsu.epamlab;

import by.gsu.epamlab.beans.Result;

public class BuferReader implements IResultDAO {

	private Bufer bufer;

	
	public BuferReader(Bufer bufer) {
		this.bufer = bufer;
	}

	@Override
	public Result nextResult() {
		// TODO Auto-generated method stub
		
		return bufer.getResult();
	}

	@Override
	public boolean hasResult() {
		// TODO Auto-generated method stub
		return bufer.hasResult();
	}

	@Override
	public void closeReader() {
		// TODO Auto-generated method stub
		
	}
}
