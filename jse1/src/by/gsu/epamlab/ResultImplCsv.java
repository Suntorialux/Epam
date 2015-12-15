package by.gsu.epamlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Scanner;

public class ResultImplCsv implements IResultDAO{
	
	private Scanner sc;
	private ResultFactory resultFactory;
	
	public ResultImplCsv(ResultFactory resultFactory, String nameFile) {

		try {
			this.sc = new Scanner(new File("src/"+nameFile+".csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
		this.resultFactory = resultFactory;
	}
	
	
	@Override
	public Result nextResult() {
		String [] data = this.sc.nextLine().split(";");
		String login = data[0].trim();
		String test = data[1].trim();
		Date date = Date.valueOf(data[2]);
		String stringMark = data[3];
		Result result = resultFactory.getResultFromFactory(login, test, date, stringMark); 
		return result;
	}

	@Override
	public boolean hasResult() {
		return sc.hasNext();
	}


	@Override
	public void closeReader() {
		if (sc!=null) 
			sc.close();		
	}
}
