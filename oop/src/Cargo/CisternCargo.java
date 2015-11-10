package Cargo;
import java.math.BigDecimal;
import java.math.RoundingMode;

import Material.Liquid;
import Model.Trip;

public class CisternCargo implements Trip {

    private final static String NAME="Cistern";
    private Liquid liquid;
    private CisternKind cisternKind;
    public static final int ID = 4;
    
	/**
	 * 
	 */
	public CisternCargo() {
		this(null,null);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param liquid
	 * @param cisternKind
	 */
	public CisternCargo(Liquid liquid, CisternKind cisternKind) {
		super();
		this.liquid = liquid;
		this.cisternKind = cisternKind;
	}
	public Liquid getLiquid() {
		return liquid;
	}
	public void setLiquid(Liquid liquid) {
		this.liquid = liquid;
	}
	public CisternKind getCisternKind() {
		return cisternKind;
	}
	public void setCisternKind(CisternKind cisternKind) {
		this.cisternKind = cisternKind;
	}
	
	public double getWeight() {
		double weight = cisternKind.getVolume()*liquid.getDensity();
		return new BigDecimal(weight).setScale(3, RoundingMode.UP).doubleValue();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return NAME+";"+liquid+";"+getWeight();
	}
	
	
}
