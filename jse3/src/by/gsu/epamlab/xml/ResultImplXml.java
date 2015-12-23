package by.gsu.epamlab.xml;

import java.io.IOException;
import java.util.Iterator;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.factories.ResultFactory;

public class ResultImplXml implements IResultDAO {
	
	private static final String BEGIN_NAME_FILE = "src/";
	private static final String END_NAME_FILE = ".xml";
	
	private Iterator<Result> iterator;
	
			
	public ResultImplXml(String nameFile, ResultFactory resultFactory) {
		
		try {
			ResultHandler handler = new ResultHandler(resultFactory);
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
			reader.parse(BEGIN_NAME_FILE+nameFile+END_NAME_FILE);
			iterator=handler.getResults().iterator();
		} catch (IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		iterator = null;
	}
}
