package by.gsu.epamlab;

import java.util.Scanner; 
import exceptions.CsvLineException;
import exceptions.NonpositiveArgumentException;




public class PurchaseFactory {
		        
	 public static Purchase getPurchaseFromFactory(Scanner sc) throws CsvLineException {
		 	String csvLine = sc.nextLine();
			String [] inputData = csvLine.split(Constants.DELIMETR);
	 		int kind = inputData.length;
	 		if ((kind< Constants.GENERAL_PURCHASE)||(kind>Constants.PRICE_DISCOUNT_PURCHASE)) {
				throw new CsvLineException(Constants.ERROR_WRONG_NUMBER, csvLine);
	 		}
	 		String name = inputData[Constants.INDEX_NAME];
	 		try {
	 			int price=Integer.parseInt(inputData[Constants.INDEX_PRICE]);
	 			int number=Integer.parseInt(inputData[Constants.INDEX_NUMBER]);
	 			switch(kind) {
					case Constants.GENERAL_PURCHASE : 
						return new Purchase(name,price,number);
					case Constants.PRICE_DISCOUNT_PURCHASE :
						int discount=Integer.parseInt(inputData[Constants.INDEX_DISCOUNT]);
						return new PriceDiscountPurchase(name,price,number,discount); 
					default :
						throw new CsvLineException(Constants.ERROR_WRONG_NUMBER,csvLine); 
				}
			} catch (NumberFormatException e) {
				throw new CsvLineException(Constants.ERROR_FORMAT_NUMBER,csvLine);
			} catch (NonpositiveArgumentException e) {
				throw new CsvLineException(csvLine,e);
			} catch (IllegalArgumentException e) {
				throw new CsvLineException(e.getMessage(),csvLine);
			}
	 }
	
}
