package by.gsu.epamlab.xml;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ResultsSAXBuilder {
	private List<DecimalResult> results;
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

	public List<DecimalResult> getResults() {
		return results;
	}

	public void buildListResults (String fileName) {
	
		try {
			reader.parse(fileName);
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
