package Material;

public enum Solid {
	DVD_PLEERS(0.03),DIAPERS(0.04),TV(0.08);
	
	private final double density;

	/**
	 * @param density
	 */
	private Solid(double density) {
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
		return getName()+";"+density;
	}
}