package Material;

public enum Liquid {
	DIESEL(0.85),GASOLINE(0.75),KEROSENE(0.8);
	
	private final double density;

	/**
	 * @param density
	 */
	private Liquid(double density) {
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
		return getName();
	}
	
	
	
	

}
