package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase {
	
	private String commodityName;
	private int price;
	private int numberUnits;

	public Purchase() {
		this(null,0,0);
	}

	public Purchase(String commodityName, int price, int numberUnits) {
		this.commodityName = commodityName;
		this.price = price;
		this.numberUnits = numberUnits;
	}

	public Purchase(Scanner scanner) {
		this.commodityName=scanner.next();
		this.price=scanner.nextInt();
		this.numberUnits=scanner.nextInt();
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Purchase))
			return false;
		Purchase other = (Purchase) obj;
		if (commodityName == null) {
			if (other.commodityName != null)
				return false;
		} else if (!commodityName.equals(other.commodityName))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
}
