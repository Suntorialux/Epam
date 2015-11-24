package by.gsu.epamlab;

import exceptions.NonpositiveArgumentException;

public class PriceDiscountPurchase extends Purchase{
	
		private int priceDiscount;

	    public PriceDiscountPurchase() {
	    	super();
	        this.priceDiscount = 0;
	    }

	    public PriceDiscountPurchase(String commodityName, int price, int numberUnits, int priceDiscount) throws NonpositiveArgumentException {
	        super(commodityName, price, numberUnits);
	        setPriceDiscount(priceDiscount);
	    }
	    
	    public int getPriceDiscount() {
	        return priceDiscount;
	    }

	    public void setPriceDiscount(int priceDiscount) throws IllegalArgumentException {
	    	if(priceDiscount>super.getCost()) {
	    		throw new IllegalArgumentException(Constants.ERROR_WRONG_DISCOUNT);
	    	}
	    	this.priceDiscount = priceDiscount;
	    }

	    @Override
	    public int getCost() {
	        int cost=(getPrice()-priceDiscount)*getNumberUnits();
	        return cost;
	    }

		@Override
		public String fieldsToString() {
			// TODO Auto-generated method stub
			return super.fieldsToString()+Constants.DELIMETR+priceDiscount;
		}

}
