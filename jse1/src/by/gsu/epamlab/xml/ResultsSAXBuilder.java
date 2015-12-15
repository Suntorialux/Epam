package by.gsu.epamlab.xml;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.gsu.epamlab.Result;

public class ResultsSAXBuilder {
	
	private static final String BEGIN_NAME_FILE = "src/";
	private static final String END_NAME_FILE = ".xml";
	
	private List<Result> results;
	private ResultHandler handler;
	private XMLReader reader;
	
	public ResultsSAXBuilder() {
		
		handler=new ResultHandler();
		try {
			reader= XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
				
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		} 
	}

	public List<Result> getResults() {
		return results;
	}

	public void buildListResults (String fileName) {
	
		try {
			reader.parse(BEGIN_NAME_FILE+fileName+END_NAME_FILE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		
		results=handler.getResults();
	}
}
