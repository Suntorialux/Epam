package by.gsu.epamlab;

public class PriceDiscountPurchase extends Purchase{
	 private int priceDiscount;

	    public PriceDiscountPurchase() {
	    	super();
	        this.priceDiscount = 0;
	    }

	    public PriceDiscountPurchase(String commodityName, int price, int numberUnits, int priceDiscount) {
	        super(commodityName, price, numberUnits);
	        if(priceDiscount>price) throw new IllegalArgumentException();
	        if(commodityName.equals("")) throw new IllegalArgumentException();
	        this.priceDiscount = priceDiscount;
	    }
	    
	    public int getPriceDiscount() {
	        return priceDiscount;
	    }

	    public void setPriceDiscount(int priceDiscount) {
	        this.priceDiscount = priceDiscount;
	    }

	    @Override
	    public int getCost() {
	        int cost=(getPrice()-priceDiscount)*getNumberUnits();
	        return cost;
	    }

		@Override
		protected String fieldsToString() {
			// TODO Auto-generated method stub
			return super.fieldsToString()+";"+priceDiscount;
		}

}
