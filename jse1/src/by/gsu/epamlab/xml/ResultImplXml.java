package by.gsu.epamlab.xml;

import java.util.Iterator;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.Result;

public class ResultImplXml implements IResultDAO {

	private Iterator<DecimalResult> iterator;
	
			
	public ResultImplXml(String nameFile) {
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
		
		return iterator.hasNext();
	}

	@Override
	public void closeReader() {
		// TODO Auto-generated method stub
		
	}

	

}
