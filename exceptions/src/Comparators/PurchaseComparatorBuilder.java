package Comparators;

import java.util.Comparator;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Purchase;

public class PurchaseComparatorBuilder {
	
	 private static Comparator<Purchase> purchaseComparator;
	 
	 private PurchaseComparatorBuilder() {
		super();
		// TODO Auto-generated constructor stub
	 }
	 
	 public static Comparator<Purchase> getPurchaseComparator() {
		return purchaseComparator;
	}
	
	public static void  buildPurchaseComparator (String comparatorName)
	    {	
			if(purchaseComparator != null) {
				return;
			}
				        
	        if(!"".equals(comparatorName))
	        {
	            Class<?> comparatorClass;
	            String fullNameComparator = Constants.INITIAL_NAME_COMPARATOR + comparatorName; 
	            try {
	                comparatorClass = Class.forName(fullNameComparator);
	                Object obj=comparatorClass.newInstance();
	                if(comparatorName.equals(Constants.NAME_COMPARATOR_V1))
	                {
	                    purchaseComparator =(PurchaseComparatorV1)obj;
	                }
	                else
	                {
	                    purchaseComparator =(PurchaseComparatorV2)obj;
	                }

	            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e)
	            {
	                e.printStackTrace();
	            }
	        }
	    }
}
