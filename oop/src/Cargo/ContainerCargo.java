package Cargo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import Material.Solid;
import Model.Trip;

public class ContainerCargo implements Trip {
	
	private static final String NAME="Container";
	private Solid solid;
	private ContainerKind containerKind;
	public static final int ID = 2;
	/**
	 * 
	 */
	public ContainerCargo() {
		this(null,null);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param solid
	 * @param containerKind
	 */
	public ContainerCargo(Solid solid, ContainerKind containerKind) {
		this.solid = solid;
		this.containerKind = containerKind;
	}
	public Solid getSolid() {
		return solid;
	}
	public void setSolid(Solid solid) {
		this.solid = solid;
	}
	public ContainerKind getContainerKind() {
		return containerKind;
	}
	public void setContainerKind(ContainerKind containerKind) {
		this.containerKind = containerKind;
	}
	
	public double getWeight() {
		double cargoWeight=solid.getDensity()*containerKind.getVolume();
		double weight=cargoWeight+containerKind.getWeight();
		return new BigDecimal(weight).setScale(3, RoundingMode.UP).doubleValue();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return NAME+";"+solid+";"+getWeight();
	}
	
	
	

	

}
