package by.gsu.epamlab.xml;

import java.io.IOException;
import java.util.Iterator;

import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.beans.Result;

public class ResultImplXml implements IResultDAO {

	private Iterator<Result> iterator;
	
			
	public ResultImplXml(String nameFile) throws IOException {
		ResultsSAXBuilder saxBuilder = new ResultsSAXBuilder();
		saxBuilder.buildListResults(nameFile);
		this.iterator=saxBuilder.getResults().iterator();
	}

	@Override
	public Result nextResult() {
		// TODO Auto-generated method stub
		Result result = iterator.next();
		return result;
	}

	@Override
	public boolean hasResult() {
		// TODO Auto-generated method stub
		boolean isResult = false;
		if(iterator!=null) {
			isResult = iterator.hasNext();
		}
		return isResult;
	}

	@Override
	public void closeReader() {
		// TODO Auto-generated method stub
	
	}
}
