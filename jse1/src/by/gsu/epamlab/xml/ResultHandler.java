package by.gsu.epamlab.xml;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ResultHandler extends DefaultHandler{
	
	private static final String NAME = "name";
	private static final String DATE = "date";
	private static final String MARK = "mark";
	
	private static enum ResultEnum { 
		RESULTS,STUDENT,LOGIN,TESTS,TEST;
	}
	
	private List<DecimalResult> results;
	private DecimalResult result=null; 
	private String login;
    private ResultEnum resultEnum;

	
	public List<DecimalResult> getResults() {
		return results;
	}
	
	public ResultHandler() {
		// TODO Auto-generated constructor stub
		this.results = new ArrayList<DecimalResult>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		// TODO Auto-generated method stub
		resultEnum = ResultEnum.valueOf(localName.toUpperCase());
		if(resultEnum==ResultEnum.TEST) {
			result = new DecimalResult();
			result.setLogin(login);
			String nameTest = attrs.getValue(NAME).trim();
			result.setTest(nameTest);
			String dateString = attrs.getValue(DATE).trim();
			result.setDate(Date.valueOf(dateString));
			String markString = attrs.getValue(MARK).trim();
			int mark = (int)(Double.parseDouble(markString)*10);
			result.setMark(mark);
			results.add(result);			
		}
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
