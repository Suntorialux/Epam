package by.gsu.epamlab;

import java.util.Map.Entry;

public class Constants {
	
	public static final String DELIMETR=";";
	public static final String ERROR_FILE_FOUND=" File not found  ";
	public static final String ERROR_EXCEPTION_DELIMETER="\t-> ";
	public static final String ERROR_NULL_NAME=" null name ";
	public static final String ERROR_EMPTY_NAME=" empty name ";
	public static final String ERROR_NON_POSITIVE=" non positive ";
	public static final String ERROR_WRONG_DISCOUNT = " wrong discount ";
	public static final String ERROR_WRONG_NUMBER = " wrong number of arguments ";
	public static final String ERROR_FORMAT_NUMBER = " error format of arguments ";
	public static final String ERROR_NOT_INDEX = "No purchase among purchases with index ";
	public static final String ERROR_NULL_PURCHASE = " Purchases is null ";
	
	public static final String NAME_FIELD_PRICE=" price ";
	public static final String NAME_FIELD_NUMBER=" number units ";
	public static final String PRICE_DISCOUNT = " price discount ";
	public static final int INDEX_NAME = 0;
	public static final int INDEX_PRICE=1;
	public static final int INDEX_NUMBER=2;
	public static final int INDEX_DISCOUNT=3;
	public static final int GENERAL_PURCHASE = 3;
	public static final int PRICE_DISCOUNT_PURCHASE = 4; 
	
	
	public final static String TOTAL_COST="Total cost ";
	
	
	public final static String NAME_COMPARATOR_V1 = "PurchaseComparatorV1";
	public final static String INITIAL_NAME_COMPARATOR = "Comparators.";
	public final static String FILE_NAME ="src/in.csv";
	public final static String ELEMENT = "element";
	public final static String FOUND_POSITION = "is found at position ";
	public final static String NOT_FOUND_POSITION = "is not found";
	public final static String NEW_LINE = "\n";
	public final static int INDEX_FIRST_ELEMENT=0;
	public final static int INDEX_FIRST=1;
	public final static int INDEX_SECOND=2;

	
	public final static Purchase BREAD_1550 = new Purchase("bread", 1550); 
	public final static Purchase BREAD_1700 = new Purchase("bread", 1700);
	public final static String WITH_PRICE = " with price ";
	public final static String LAST_WEEKDAY = "Last weekday for ";
	public final static String FIRST_WEEKDAY = "First weekday for ";
	public final static String PURCHASE_IS = "Purchase is ";
	public final static String MEAT = "meat";
	public final static String SPACE=" ";
	public final static String EQUALLY=" = ";
	
	public final static EntryChecker CHECK_MEAT = new EntryChecker() {
		
		@Override
		public boolean check(Entry<Purchase, WeekDay> entry) {
			// TODO Auto-generated method stub
			return entry.getKey().getName().equals(Constants.MEAT);
		}
	};
	
	public final static EntryChecker CHECK_FRIDAY = new EntryChecker() {
		
		@Override
		public boolean check(Entry<Purchase, WeekDay> entry) {
			// TODO Auto-generated method stub
			return entry.getValue()==WeekDay.FRIDAY;
		}
	};
	
}
