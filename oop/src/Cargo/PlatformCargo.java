package Cargo;

import Model.Trip;

public class PlatformCargo implements Trip {

		private static final String NAME = "Platforma";
		private final String NAME_LOAD;
		private double weight;
		public static final int ID = 3;
		
		public PlatformCargo() {
			// TODO Auto-generated constructor stub
			this(null,0);
		}

		/**
		 * @param nameLoad
		 * @param weight
		 */
		public PlatformCargo(String nameLoad, double weight) {
			this.NAME_LOAD = nameLoad;
			this.weight = weight;
		}

		public String getNAME_LOAD() {
			return NAME_LOAD;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return NAME+";"+NAME_LOAD+";"+weight;
		}
		
		
		
		
		
		
				
	
	
	
	
	
	
}
