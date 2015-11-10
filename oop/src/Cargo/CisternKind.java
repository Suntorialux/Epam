package Cargo;

public enum CisternKind {
	MODEL_15_150(1.5,10.818,27.5), MODEL_15_811(1.5,20.226,48.8); 
	
	private final double radius;
	private final double lenght;
	private final double weight;
	/**
	 * @param radius
	 * @param lenght
	 * @param weight
	 */
	private CisternKind(double radius, double lenght, double weight) {
		this.radius = radius;
		this.lenght = lenght;
		this.weight = weight;
	}
	public double getRadius() {
		return radius;
	}
	public double getLenght() {
		return lenght;
	}
	public double getWeight() {
		return weight;
	}
	
	public double getVolume() {
		double volume = Math.PI*radius*radius*lenght;
		return volume;
	}
	
	public String getName() {
		return this.name().toLowerCase();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
}
