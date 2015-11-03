package by.gsu.epamlab;

public class Subject {
	
	private String name;
	private Material material;
	private double volume;
	
	public Subject() {
		name = null;
		material = null;
		volume = 0;
		// TODO Auto-generated constructor stub
	}
	
	public Subject(String name, Material material, double volume) {
		super();
		this.name = name;
		this.material = material;
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public double getMass () {
		return material.getDensity()*volume;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + ";" + material.toString() + ";" + volume + ";" + getMass();
	}
	

}
