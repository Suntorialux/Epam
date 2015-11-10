package Comparator;

import java.lang.reflect.Field;
import java.util.Comparator;

import Model.Trip;

public class TripCompare<T> implements Comparator<Trip> {

	@Override
	public int compare(Trip trip1, Trip trip2) {
		// TODO Auto-generated method stub
		Class<? extends Trip> t1 = trip1.getClass();
		Class<? extends Trip> t2 = trip2.getClass();
		int id1=0,id2=0;
		
		Field field1 = null; Field field2 = null;
		try {
			field1 = t1.getField("ID");
			field2 = t2.getField("ID");
			id1=field1.getInt(trip1);
			id2=field2.getInt(trip2);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id1-id2;
		}
}
