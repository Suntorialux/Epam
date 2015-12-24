package by.gsu.epamlab.xml;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.factories.ResultFactory;

public class ResultHandler extends DefaultHandler{
	
	private static final String NAME = "name";
	private static final String DATE = "date";
	private static final String MARK = "mark";
	
	private static enum ResultEnum { 
		RESULTS,STUDENT,LOGIN,TESTS,TEST;
	}
	
	private List<Result> results;
	private ResultFactory resultFactory;
	private Result result; 
	private String login;
    private ResultEnum resultEnum;

	
	public List<Result> getResults() {
		return results;
	}
	
	public ResultHandler(ResultFactory resultFactory ) {
		// TODO Auto-generated constructor stub
		this.results = new ArrayList<Result>();
		this.resultFactory = resultFactory;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		// TODO Auto-generated method stub
		resultEnum = ResultEnum.valueOf(localName.toUpperCase());
		if(resultEnum==ResultEnum.TEST) {
			String nameTest = attrs.getValue(NAME).trim();
			String dateString = attrs.getValue(DATE).trim();
			Date date = Date.valueOf(dateString);
			String markString = attrs.getValue(MARK).trim();
			result = resultFactory.setResultFromFactory(login, nameTest, date, markString);
			results.add(result);	
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if(resultEnum==ResultEnum.LOGIN) {
			String s = new String(ch, start, length).trim();
			if(!s.isEmpty()) {
				login=s;
			}
		}
	}
}
