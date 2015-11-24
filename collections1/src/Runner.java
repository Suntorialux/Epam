import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchaseFactory;
import by.gsu.epamlab.PurchaseList;
import by.gsu.epamlab.WeekDay;
import exceptions.CsvLineException;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Purchase, WeekDay> mapLastPurchase = new HashMap<Purchase, WeekDay>();
		Map<Purchase, WeekDay> mapFirstPurchase = new HashMap<Purchase, WeekDay>();
		Map<WeekDay, PurchaseList> weekDayMap = new TreeMap<WeekDay, PurchaseList>();
		
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(Constants.FILE_NAME));
			while(sc.hasNext()) {
				try {
					Purchase purchase = PurchaseFactory.getPurchaseFromFactory(sc);
					WeekDay weekDay= WeekDay.valueOf(sc.nextLine());
					
		//load the content of the file in.csv into the map where a purchase is a key and a weekday of last purchase is a value;

					mapLastPurchase.put(purchase, weekDay);
					
		//load the content of the file in.csv into the map where a purchase is a key and a weekday of first purchase is a value;

					if(!(mapFirstPurchase.containsKey(purchase))) {
						mapFirstPurchase.put(purchase, weekDay);
					}
					
		//load the content of the file in.csv into the sorted map where a weekday is a key and purchases list for this weekday is a value;

					if(!weekDayMap.containsKey(weekDay))  {
	                    weekDayMap.put(weekDay,new PurchaseList(purchase));
	                }
	                else {
	                    weekDayMap.get(weekDay).addPurchase(purchase);
	                }
					
								
				} catch (CsvLineException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}
			}
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(Constants.ERROR_FILE_FOUND);
		} finally {
			if (sc!=null) {
				sc.close();
			}
		}
		
		//print the map by for–each cycle;
		
		print(mapLastPurchase);
		print(mapFirstPurchase);

		//find the first and the last weekdays for bread with price 1550;
		
		System.out.print(Constants.FIRST_WEEKDAY);
		findWeekday(mapFirstPurchase, Constants.BREAD_1550);
		System.out.print(Constants.LAST_WEEKDAY);
		findWeekday(mapLastPurchase, Constants.BREAD_1550);

		//find the first weekday for bread with price 1700;
		
		System.out.print(Constants.FIRST_WEEKDAY);
		findWeekday(mapFirstPurchase, Constants.BREAD_1700);
			
		//remove all entries from the first map where the purchase name is meat;

		delete(mapLastPurchase, Constants.MEAT);

		//remove all entries from the second map for FRIDAY;
		
		delete(mapFirstPurchase, WeekDay.FRIDAY);
		
		//print the map by for–each cycle;
		
		print(mapLastPurchase);
		print(mapFirstPurchase);
		print(weekDayMap);
		
		//print the total cost of all purchases for each weekday.
		
		for(Map.Entry<WeekDay, PurchaseList> map : weekDayMap.entrySet()) {
			System.out.println(Constants.TOTAL_COST+map.getKey()+Constants.EQUALLY+map.getValue().getTotalCost());
		}
		System.out.println();
		
		
		
		
	}

	private static void findWeekday(Map<Purchase, WeekDay> map, Purchase purchase) {
		StringBuilder result = new StringBuilder();
		result.append(purchase.getName()).append(Constants.WITH_PRICE).append(purchase.getPrice())
			.append(Constants.SPACE).append(map.containsKey(purchase)?map.get(purchase):Constants.NOT_FOUND_POSITION).append(Constants.NEW_LINE);
		System.out.println(result.toString());
	}

	private static void delete(Map<Purchase, WeekDay> map, Object o) {
		Iterator<Entry<Purchase, WeekDay>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Purchase, WeekDay> entry = iterator.next();
			boolean equals = entry.getKey().getName().equals(o);
			boolean equal = entry.getValue().equals(o);
			if(equals||equal) {
				iterator.remove();
			}
		}
	}

	private static <K, V> void print(Map<K, V> purchaseMap) {
		for(Map.Entry<K, V> map : purchaseMap.entrySet()) {
			System.out.println(map.getKey()+Constants.EQUALLY+map.getValue());
		}
		System.out.println();
	}

}
