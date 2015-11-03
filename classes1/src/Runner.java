import by.gsu.epamlab.BusinessTrip;

/**
 * 
 */

/**
 * @author Andrei Yahorau
 *
 */
class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args)  { 
		// TODO Auto-generated method stub
		
		
		/* 1. Create an array of 5 objects (the element with index 2 should be empty;
		 * the last element of the array should be created by default constructor;
		 * other elements are valid and should be created by general-purpose constructor). 
		 */

		BusinessTrip[] businessTrips = { 
				new BusinessTrip("Ivan Ivanov", 60000, 5),
				new BusinessTrip("Anton Shumsky", 50000, 6),
				null,
				new BusinessTrip("Petr Petrov", 55000, 4),
				new BusinessTrip(),
		};
		
		
		// 2. Print the array content to the console, using show() method.
		
		for(BusinessTrip businessTrip : businessTrips) {
			if (businessTrip == null) 
				System.out.println("null");
			else 
				businessTrip.show(); 
		}
		
		// 3.Change the employee`s transportaion expenses for the last object of the array.
		
		businessTrips[businessTrips.length-1].setTransportationExpenses(20000);
	
		// 4. Print the total duration of two initial business trips by the single operator.
		
		System.out.println("Duration="+(businessTrips[0].getNumberOfDay()+businessTrips[1].getNumberOfDay()));
		
		// 5. Print the array content to the console (one element per line), using toString( ) method implicitly.

		for(BusinessTrip businessTrip : businessTrips) {
			System.out.println(businessTrip);
		}

	}

}
