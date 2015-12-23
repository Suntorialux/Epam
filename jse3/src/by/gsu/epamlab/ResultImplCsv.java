package by.gsu.epamlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.factories.ResultFactory;

public class ResultImplCsv implements IResultDAO {
	
	private static final String START_NAME_FILE = "src/";
	private static final String END_NAME_FILE = ".csv";
	private static final String SEPARATOR = ";";
	private static final int LOGIN_IND = 0;
	private static final int TEST_IND = 1;
	private static final int DATE_IND = 2;
	private static final int MARK_IND = 3;
	
	
	private Scanner sc;
	private ResultFactory resultFactory;
		
		
	public ResultImplCsv(String nameFile, ResultFactory resultFactory) throws IOException  {

		try {
			this.sc = new Scanner(new File(START_NAME_FILE+nameFile+END_NAME_FILE));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new IOException();
		}
		this.resultFactory = resultFactory;
	}
	
	
	@Override
	public synchronized Result nextResult() {
			String [] data = sc.nextLine().split(SEPARATOR);
			String login = data[LOGIN_IND].trim();
			String test = data[TEST_IND].trim();
			Date date = Date.valueOf(data[DATE_IND]);
			String stringMark = data[MARK_IND];
			Result result = this.resultFactory.setResultFromFactory(login, test, date, stringMark); 
			return result;
	}

	@Override
	public synchronized boolean hasResult() {
		boolean isResult = false;
		if(sc!=null) {
			isResult = sc.hasNext();
		}
		return isResult;
	}


	@Override
	public synchronized void closeReader() {
		if (sc!=null) 
			sc.close();		
	}


}
