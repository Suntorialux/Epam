package by.gsu.epamlab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Comparators.PurchaseComparatorBuilder;
import exceptions.CsvLineException;


public class PurchasesList {
	
	private List<Purchase> purchases;

	public PurchasesList() {
		this.purchases=new ArrayList<Purchase>();
	}

	public PurchasesList(String fileName) {
		purchases = new ArrayList<Purchase>();
		Scanner sc = null;
		try {
			sc=new Scanner(new FileReader(fileName));
			while (sc.hasNext()) {
				try {
					Purchase purchase = PurchaseFactory.getPurchaseFromFactory(sc);
					purchases.add(purchase);
				} catch (CsvLineException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}
			} 
		} catch (FileNotFoundException e) {
				System.err.println(Constants.ERROR_FILE_FOUND);
		} finally {
				if (sc != null) {
					sc.close();
				}
			}
	}
	 public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public void insertPurchase(int index,Purchase purchase) {
	    if(purchase==null) {
	    	throw new NullPointerException(Constants.ERROR_NULL_PURCHASE);
	    }
	    if(isIndexCorrect(index)) {
	    	purchases.add(index, purchase);
	    } else {
	    	purchases.add(purchase);
	    }	    
	 }
	
	public boolean isIndexCorrect(int index) {
		boolean isCorrect = index >= 0 && index < purchases.size()-Constants.INDEX_FIRST;
		return isCorrect;
	}
	 
	 public void deletePurchase(int index) throws IndexOutOfBoundsException {
		 if(!isIndexCorrect(index)) {
			 throw new IndexOutOfBoundsException(Constants.ERROR_NOT_INDEX+index);
		 } 
		 purchases.remove(index); 
	 }
	 
	 public int getTotalCost() {
		 if (purchases==null) {
			 throw new NullPointerException(Constants.ERROR_NULL_PURCHASE);
		 }
		 int totalCost=0;
		 for(Purchase purchase:purchases) {
			 totalCost+=purchase.getCost();
		 }
		 return totalCost;
	 }
	 
	public void sort() {
		
		Collections.sort(getPurchases(), PurchaseComparatorBuilder.getPurchaseComparator());
	}
	 
	public void found(Purchase purchase) {
		if (purchases==null) {
		 throw new NullPointerException(Constants.ERROR_NULL_PURCHASE);
		}
		int index=Collections.binarySearch(getPurchases(), purchase, PurchaseComparatorBuilder.getPurchaseComparator());
		StringBuilder result = new StringBuilder();
		result.append(Constants.ELEMENT).append(Constants.NEW_LINE).append(purchase.fieldsToString())
		 		.append(Constants.NEW_LINE).append(index>=0?Constants.FOUND_POSITION+index:Constants.NOT_FOUND_POSITION);
		System.out.println(result.toString());
	}
	
	public String printTable () {
		StringBuilder table=new StringBuilder();
		table.append(String.format(Constants.PRINT_FORMAT_TITLE, Constants.COLUMN_NAME.split(Constants.DELIMETR)));
		for(Purchase purchase : getPurchases())
        {
     	 	String nameClass=purchase.getClass().getSimpleName();
     	 	switch(nameClass) {
     	 		case Constants.NAME_CLASS_PURCHASE: {
     	 			table.append(String.format(Constants.PRINT_FORMAT_PURCHASE, purchase.toString().split(Constants.DELIMETR)));
     	 			break;
     	 		}
     	 		case Constants.NAME_CLASS_PRICE_DISCOUNT_PURCHASE: {
     	 			table.append(String.format(Constants.PRINT_FORMAT_TITLE, purchase.toString().split(Constants.DELIMETR)));
     	 			break;
     	 		}
     	 	}
     	}

        table.append(String.format(Constants.PRINT_FORMAT_TOTAL, Constants.TOTAL_COST, getTotalCost()));
			
		return table.toString();
	}
	
 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 StringBuilder result=new StringBuilder();
	        for(Purchase purchase:getPurchases())
	        {
	            result.append(purchase.toString()).append(Constants.NEW_LINE);
	        }
	        return result.toString();
	}
}
