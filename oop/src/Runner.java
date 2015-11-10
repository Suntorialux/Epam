

import java.util.Arrays;

import Cargo.CisternCargo;
import Cargo.CisternKind;
import Cargo.ContainerCargo;
import Cargo.ContainerKind;
import Cargo.PlatformCargo;
import Comparator.TripCompare;
import Material.Liquid;
import Material.Solid;
import Model.Ferry;
import Model.Trip;
import Person.Person;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String CAR="Car";
		final String BUS = "Bus";
		final double WEIGHT_CAR=50;
		final double WEIGHT_BUS=100;
		final String NAME_MIKE = "Mike";
		final String NAME_GREG = "Greg";
		final String NAME_MINI = "MINI";
		final double WEIGHT_MIKE = 0.085;
		final double WEIGHT_GREG = 0.1;
		final double WEIGHT_MINI = 0.09;
		final String FERRY_IS_CARRY="Ferry to stay afloat is";
	
		
		PlatformCargo car = new PlatformCargo(CAR, WEIGHT_CAR);
		PlatformCargo bus = new PlatformCargo(BUS, WEIGHT_BUS);
		ContainerCargo dvd = new ContainerCargo(Solid.DVD_PLEERS, ContainerKind.FOOT_40_STANDART);
		ContainerCargo diaper = new ContainerCargo(Solid.DIAPERS, ContainerKind.FOOT_20_STANDART);
		CisternCargo diesel = new CisternCargo(Liquid.DIESEL, CisternKind.MODEL_15_811);
		CisternCargo gasoline = new CisternCargo(Liquid.GASOLINE, CisternKind.MODEL_15_150);
		Person Mike = new Person(NAME_MIKE,WEIGHT_MIKE);
		Person Greg = new Person(NAME_GREG,WEIGHT_GREG);
		Person Mini = new Person(NAME_MINI,WEIGHT_MINI);
		
		Trip [] trips = { car,bus,dvd,diaper,diesel,gasoline,Greg,Mike,Mini};
		
		printTrip(trips);
		
		Ferry ferry = new Ferry(trips);
				
		System.out.println("------------------------------");
		Arrays.sort(trips, new TripCompare<Trip>());
		printTrip(trips);
			
		System.out.println(FERRY_IS_CARRY+" "+ferry.isCarry());
	}
	
	public static void printTrip(Trip [] trips) {
		for(Trip trip : trips) {
			System.out.println(trip); 
		}
	}
}
