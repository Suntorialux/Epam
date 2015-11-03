import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Create the object representing the steel wire having the volume 0.03 cubic meter.

			final Material steel = new Material("steel",7850);
			Subject wire = new Subject("wire",steel,0.03);
					
		//	2. Print the object content to the console, using toString( ) method.
						
			System.out.println(wire);
			
		//	3. Change the wire material on the copper (density = 8500.0) and print its mass.

			final Material copper = new Material("copper", 8500);
			wire.setMaterial(copper);
			System.out.println(wire);
			System.out.println("The wire mass is "+ wire.getMass() +" kg.");
			
	}		

}
