/**
 * 
 */
package by.gsu.epamlab;

/**
 * @author Andrei Yahorau
 *
 */
public class Material {
	
	private final String name;
	private final double density;
	
	public Material() {
		this(null,0.0);
		
	}

	public Material(String name, double density) {
		super();
		this.name = name;
		this.density = density;
	}

	public String getName() {
		return name;
	}

	public double getDensity() {
		return density;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + ";" + density;
	}
	
	

}
