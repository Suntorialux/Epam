package by.gsu.epamlab;

import java.util.Locale;
import java.util.Scanner;


public class PercentDiscountPurchase extends Purchase {

    private final static int BARRIER_DISCOUNT=15;
    private double percentDiscount;

    public PercentDiscountPurchase() {
    	super();
    	this.percentDiscount = 0;
    }

    public PercentDiscountPurchase(String commodityName, int price, int numberUnits, double percentDiscount) {
        super(commodityName, price, numberUnits);
        this.percentDiscount = percentDiscount;
    }

    public PercentDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.percentDiscount = scanner.useLocale(Locale.US).nextDouble();
    }

    public int getBARRIER_DISCOUNT() {
        return BARRIER_DISCOUNT;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public int getCost() {
    	int number=getNumberUnits();
    	int cost=super.getCost();
    	if(number>BARRIER_DISCOUNT)
           cost*=(100-percentDiscount)/100;
        return cost;
    }
    
    @Override
	protected String fieldsToString() {
		// TODO Auto-generated method stub
		return super.fieldsToString()+";"+percentDiscount;
	}
}
