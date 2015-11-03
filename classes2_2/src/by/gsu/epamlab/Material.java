package by.gsu.epamlab;

public enum Material {
	
	STEEL(7850.0), COPPER(8500.0);

	private final double density;
	
	private Material(double density) {
		this.density = density;
	}

	public double getDensity() {
		return density;
	}
	
	public String getName() {
		return this.name().toLowerCase();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() +";"+density; 
	}
	
	
	
	
	
	

}
