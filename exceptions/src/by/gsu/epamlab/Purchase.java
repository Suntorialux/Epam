package by.gsu.epamlab;

public class Purchase {
	
	private String commodityName;
	private int price;
	private int numberUnits;

	public Purchase() {
		this(null,0,0);
	}

	public Purchase(String commodityName, int price, int numberUnits) {
		if (price<=0) throw new IllegalArgumentException();
		if (commodityName.equals("")) throw new IllegalArgumentException();
		this.commodityName = commodityName;
		this.price = price;
		this.numberUnits = numberUnits;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberUnits() {
		return numberUnits;
	}

	public void setNumberUnits(int numberUnits) {
		this.numberUnits = numberUnits;
	}

	public int getCost () {
		return price*numberUnits;
	}

	protected String fieldsToString () {
		return commodityName+";"+price+";"+numberUnits;
	}

	@Override
	public String toString() {
		return fieldsToString()+";"+getCost();
	}
	
	
	
	
}
