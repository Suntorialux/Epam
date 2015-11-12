package by.gsu.epamlab;

public class PurchaseFactory {
	
	 static final String SEPARATOR = ";"; 
	 static final int GENERAL_PURCHASE = 3;
	 static final int PRICE_DISCOUNT_PURCHASE = 4; 
	        
	 public static Purchase getPurchaseFromFactory(String line) {
			String [] inputData = line.split(SEPARATOR);
	 		int kind = inputData.length;
	 		switch(kind) {
		 		case GENERAL_PURCHASE : 
		 			return new Purchase(inputData[0],Integer.parseInt(inputData[1]),Integer.parseInt(inputData[2]));
		 		case PRICE_DISCOUNT_PURCHASE :
		 			return new PriceDiscountPurchase(inputData[0], Integer.parseInt(inputData[1]),
		 											Integer.parseInt(inputData[2]), Integer.parseInt(inputData[3])); 
		 		default :
		 			throw new IllegalArgumentException();
	 		}
		 		
	 }
	
}
