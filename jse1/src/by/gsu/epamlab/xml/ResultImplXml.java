package by.gsu.epamlab.xml;

import java.util.Iterator;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultFactory;

public class ResultImplXml implements IResultDAO {

	private Iterator<Result> iterator;
	private ResultFactory resultFactory;
	
			
	public ResultImplXml(ResultFactory resultFactory, String nameFile) {
		ResultsSAXBuilder saxBuilder = new ResultsSAXBuilder();
		saxBuilder.buildListResults(nameFile);
		this.iterator=saxBuilder.getResults().iterator();
		this.resultFactory = resultFactory;
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
		
		return iterator.hasNext();
	}

	@Override
	public void closeReader() {
		// TODO Auto-generated method stub
		
	}

	

}
