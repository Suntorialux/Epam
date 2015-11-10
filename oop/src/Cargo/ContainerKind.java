package Cargo;

public enum ContainerKind {
	FOOT_20_STANDART(2.335,5.935,2.383,2.08), FOOT_40_STANDART(2.352,12.032,2.385,3.8);
	
	private final double width;
	private final double lenght;
	private final double height;
	private final double weight;
		
	/**
	 * @param width
	 * @param lenght
	 * @param height
	 * @param weight
	 */
	private ContainerKind(double width, double lenght, double height, double weight) {
		this.width = width;
		this.lenght = lenght;
		this.height = height;
		this.weight = weight;
	}

	public double getWidth() {
		return width;
	}

	public double getLenght() {
		return lenght;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}
	
	public double getVolume() {
		double volume = width*height*lenght;
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
