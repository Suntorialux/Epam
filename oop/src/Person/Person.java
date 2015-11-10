package Person;

import Model.Trip;

public class Person implements Trip{
	
	private String name;
	private double weight;
	public final static int ID = 1;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+";"+weight;
	}
	
	

}
