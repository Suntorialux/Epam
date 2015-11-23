package by.gsu.epamlab;

import exceptions.NonpositiveArgumentException;

public class Purchase {
	
	private String name;
	private int price;
	private int numberUnits;

	public Purchase() {
		this(null,0,0);
	}

	public Purchase(String name, int price, int numberUnits) throws NonpositiveArgumentException, IllegalArgumentException {
		setName(name);
		setPrice(price);
		setNumberUnits(numberUnits);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		if("".equals(name)) {
			throw new IllegalArgumentException(Constants.ERROR_EMPTY_NAME);
		}
		if(name==null) {
			throw new IllegalArgumentException(Constants.ERROR_NULL_NAME);
		}
		this.name=name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) throws NonpositiveArgumentException {
		if (price<=0) {
			throw new NonpositiveArgumentException(price,Constants.NAME_FIELD_PRICE);
		}
		this.price = price;
	}

	public int getNumberUnits() {
		return numberUnits;
	}

	public void setNumberUnits(int numberUnits) throws NonpositiveArgumentException {
		if (numberUnits<=0) {
			throw new NonpositiveArgumentException(numberUnits,Constants.NAME_FIELD_NUMBER);
		}
		this.numberUnits = numberUnits;
	}

	public int getCost () {
		return price*numberUnits;
	}

	public String fieldsToString () {
		return name+";"+price+";"+numberUnits;
	}

	@Override
	public String toString() {
		return fieldsToString()+";"+getCost();
	}
}
