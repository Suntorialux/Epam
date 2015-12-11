package by.gsu.epamlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ResultImplCsv implements IResultDAO{

	private Scanner sc;
	
	
	public ResultImplCsv(String nameFile) {

			try {
				this.sc = new Scanner(new File("src/"+nameFile+".csv"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found");
			}
			
	}
	
	
	@Override
	public Result nextResult() {
		String [] data = sc.nextLine().split(";");
		String login = data[0];
		String name = data[1];
		String date = data[2];
		String mark = data[3];
		Result result = new Result(login, name, date, mark);
		return result;
	}

	@Override
	public boolean hasResult() {
		if (this.sc.hasNext()) {
			return true;
		}
		return false;
	}


	@Override
	public void closeReader() {
		if (sc!=null) 
			sc.close();		
	}
}
