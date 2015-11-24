package by.gsu.epamlab;

import java.util.ArrayList;
import java.util.List;

public class PurchaseList {
	 private List<Purchase> purchases;

	    public PurchaseList(Purchase purchase)
	    {
	        this.purchases = new ArrayList<>();
	        this.purchases.add(purchase);
	    }

	    public List<Purchase> getPurchases()
	    {
	        return purchases;
	    }

	    public void setPurchases(List<Purchase> purchases)
	    {
	        this.purchases = purchases;
	    }

	    public void addPurchase(Purchase purchase)
	    {
	        purchases.add(purchase);
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
	    
	    
	    @Override
	    public String toString()
	    {
	        StringBuilder stringBuilder=new StringBuilder();
	        for(Purchase purchase:purchases)
	        {
	            stringBuilder.append(purchase)
	                    .append(Constants.NEW_LINE);
	        }


	        return stringBuilder.toString();
	    }
}
