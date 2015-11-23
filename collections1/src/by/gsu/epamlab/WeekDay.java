package by.gsu.epamlab;


public enum WeekDay {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	

	public static WeekDay getWeekDay(int ordinalNumber) {
		
		WeekDay day=null;
		
		for (WeekDay weekDay : WeekDay.values()) {
			if (weekDay.ordinal()==ordinalNumber)
				day=weekDay;
		}
		
		if (day==null) 
			throw new IllegalArgumentException();
		return day;
	}

	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
