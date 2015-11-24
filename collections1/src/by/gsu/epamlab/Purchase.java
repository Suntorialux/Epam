package by.gsu.epamlab;

import exceptions.NonpositiveArgumentException;

public class Purchase {
	
	private String name;
	private int price;
	private int numberUnits;

	public Purchase() {
	}
	
	public Purchase(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
		if(name==null) {
			throw new IllegalArgumentException(Constants.ERROR_NULL_NAME);
		}
		if(name.isEmpty()) {
			throw new IllegalArgumentException(Constants.ERROR_EMPTY_NAME);
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

	protected String fieldsToString () {
		return name+Constants.DELIMETR+price+Constants.DELIMETR+numberUnits;
	}

	@Override
	public String toString() {
		return fieldsToString()+Constants.DELIMETR+getCost();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	

	
	
}
