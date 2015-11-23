package Comparators;

import java.util.Comparator;

import by.gsu.epamlab.Purchase;

public class PurchaseComparatorV1 implements Comparator<Purchase> {

	@Override
	public int compare(Purchase purchase1, Purchase purchase2) {

        if (purchase1.getName().compareTo(purchase2.getName()) != 0)
        {
            return purchase1.getName().compareTo(purchase2.getName());
        }
        else
        {
            if(purchase2.getClass()==purchase1.getClass())
            {
                return purchase1.getCost() - purchase2.getCost();
            }
            else
            {
                return purchase2.getClass().getSimpleName().compareTo(purchase1.getClass().getSimpleName());
            }

        }
	}
}
