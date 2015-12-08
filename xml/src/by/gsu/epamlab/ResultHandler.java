package by.gsu.epamlab;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ResultHandler extends DefaultHandler{

	private static enum ResultEnum { 
		RESULTS,STUDENT,LOGIN,TESTS,TEST;
	}
	
	private List<Result> results;
	private Result result=null; 
	private String login;
    private ResultEnum resultEnum;

	
	public List<Result> getResults() {
		return results;
	}
	
	public ResultHandler() {
		// TODO Auto-generated constructor stub
		this.results = new ArrayList<Result>();
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		// TODO Auto-generated method stub
		resultEnum = ResultEnum.valueOf(localName.toUpperCase());
		if(resultEnum==ResultEnum.TEST) {
			result=new Result();
			result.setLogin(login);
			String nameTest = attrs.getValue(Constants.NAME);
			result.setTest(nameTest);
			String dateString = attrs.getValue(Constants.DATE);
			result.setDate(dateString);
			String mark = attrs.getValue(Constants.MARK);
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

	

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
}
