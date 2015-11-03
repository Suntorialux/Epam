import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * 
 */

/**
 * @author ������
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String INPUT_CSV = "src/in.csv";
		final String SEPARATOR = ";";
		final String PLUS = " + ";
		final String MINUS = " - ";
		final String BEGIN_RESULTS = "result(";
		final String BEGIN_ERROR="error-lines = ";
		
		
		
		
		Scanner sc= null;
		StringBuilder resultString = new StringBuilder();
		double resultNumber = 0;
		int errorNumber = 0;
		
		
				
		try {
			sc=new Scanner(new FileReader(INPUT_CSV));
			
			while(sc.hasNext()) {
				String inputString = sc.nextLine();
				String [] elements =  inputString.split(SEPARATOR);
				try {
					int index = Integer.parseInt(elements[0]);
					double number = Double.parseDouble(elements[index]);
					resultString.append(number>0?PLUS:MINUS).append(Math.abs(number));
					resultNumber+=number;	
				} catch (IndexOutOfBoundsException|NumberFormatException e2) {
					errorNumber++;
				}
			}
			if (resultString.charAt(1)=='-') 
				resultString.replace(0, 3, "-");
			else resultString.delete(0, 3);
			
			resultString.insert(0,BEGIN_RESULTS).append(") = ").append(resultNumber);
			
			System.out.println(resultString);
			System.out.println(BEGIN_ERROR+errorNumber);
				
		} catch (FileNotFoundException e) {
			System.err.println("Input file is not found");
		} finally {
			if(sc!=null)
				sc.close();
		}
		///commit

				
		

	}

}
