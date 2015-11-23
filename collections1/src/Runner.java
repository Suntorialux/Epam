import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchaseFactory;
import by.gsu.epamlab.WeekDay;
import exceptions.CsvLineException;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Purchase, WeekDay> purchaseMap = new HashMap<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader("src/in.csv"));
			while(sc.hasNext()) {
				try {
					Purchase purchase = PurchaseFactory.getPurchaseFromFactory(sc);
					WeekDay weekDay= WeekDay.valueOf(sc.nextLine());
					purchaseMap.put(purchase, weekDay);
								
					
				} catch (CsvLineException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}
				
			
			}
			
			for(Map.Entry<Purchase, WeekDay> map : purchaseMap.entrySet()) {
				System.out.println(map.getKey()+"   "+map.getValue());
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(Constants.ERROR_FILE_FOUND);
		} finally {
			if (sc!=null) {
				sc.close();
			}
		}
		
		
		
	}

}
