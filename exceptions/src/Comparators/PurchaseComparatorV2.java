package Comparators;

import java.util.Comparator;

import by.gsu.epamlab.PriceDiscountPurchase;
import by.gsu.epamlab.Purchase;

public class PurchaseComparatorV2 implements Comparator<Purchase> {

	private boolean isClassPurchase (Purchase purchase) {
		boolean index = !(purchase instanceof PriceDiscountPurchase);
		return index;
	}
		
	@Override
	public int compare(Purchase purchase1, Purchase purchase2) {
		// TODO Auto-generated method stub
        if (!purchase1.getName().equals(purchase2.getName()) )  {
            return purchase1.getName().compareTo(purchase2.getName());
        }
        else  if(isClassPurchase(purchase2)&&isClassPurchase(purchase1))  {
                return purchase1.getCost() - purchase2.getCost();
            }
            else  {
               if(isClassPurchase(purchase2)) {
                   return 1;
               }
                else {
                   return -1;
            }
        }
    }
}


	


