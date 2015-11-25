package by.gsu.epamlab;

import java.util.Map;
import by.gsu.epamlab.WeekDay;

public interface EntryChecker {
	boolean check(Map.Entry<Purchase, WeekDay>  entry);
}
