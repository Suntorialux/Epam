import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import by.gsu.epamlab.ClassDate;
import by.gsu.epamlab.ClassMoney;



public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String FILE_IN="src/in.txt";
		final String FILE_OUT="src/out.txt";
		
		Scanner scanner = null;
		FileWriter writer = null;
		    
		try {
			scanner=new Scanner(new FileReader(FILE_IN));
			writer = new FileWriter(FILE_OUT);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				line=ClassDate.replaceDate(line);
				line=ClassMoney.replaceMoney(line);  
				writer.write(line.concat("\n"));
			}
		
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (scanner!=null) {
				scanner.close();
			}
			try {
				if (writer!=null) {
				writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
