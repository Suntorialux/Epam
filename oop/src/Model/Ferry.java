package Model;

public class Ferry  {
	
	private static final double CARRYING=5000;
	private Trip [] trips;
	
	
	public Ferry() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ferry(Trip[] trips) {
		super();
		this.trips = trips;
	}


	public Trip[] getTrips() {
		return trips;
	}

	public void setTrips(Trip[] trips) {
		this.trips = trips;
	}

	public static double getCarrying() {
		return CARRYING;
	}
	
	public boolean isCarry()
    {
        double weight=0;
        for(Trip trip: trips)
        {
           weight+=trip.getWeight();
        }
        if(weight<=CARRYING)  {
          	return true;
        }
       	return false;
    }


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder result=new StringBuilder();
        for(Trip trip:trips)
        {
            result.append(trip).append("\n");
        }
        return  result.toString();
	}
	
	

}
