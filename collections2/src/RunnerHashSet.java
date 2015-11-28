import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import Comparators.Comparators.ComparatorForNum;
import beans.Constants;
import beans.NumLen;

public class RunnerHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		List<NumLen> list = new ArrayList<>();
		Set<NumLen> setNumLen = new HashSet<NumLen>();
			
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new FileReader(Constants.FILE_NAME));

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String [] data = line.split(Constants.REG_EXP);
				double x1 = Double.parseDouble(data[Constants.INDEX_ONE]);
				double y1 = Double.parseDouble(data[Constants.INDEX_TWO]);
				double x2 = Double.parseDouble(data[Constants.INDEX_THREE]);
				double y2 = Double.parseDouble(data[Constants.INDEX_FOUR]);
				int len = (int)Math.round(Math.sqrt ((x1 - x2)*(x1 - x2)+(y1 - y2)*(y1 - y2))); 
				NumLen numLen = new NumLen(len);
				setNumLen.add(numLen);
			} 
			
			list.addAll(setNumLen);
			
			Collections.sort(list, new ComparatorForNum());
			
			printList(list);
	
		
			
			
			
			
			
			
			
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(Constants.ERROR_FILE_FOUND);
		} finally {
			if(scanner!=null) {
				scanner.close();
			}
		}
		
		
				
		
		
	}

	private static void printList(List<NumLen> list) {
		for (NumLen numLen: list) {
			System.out.println(numLen);
			
		}
		
		
	}

}
