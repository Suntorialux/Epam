import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.EntryChecker;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchaseFactory;
import by.gsu.epamlab.WeekDay;
import exceptions.CsvLineException;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Purchase, WeekDay> mapLastPurchase = new HashMap<Purchase, WeekDay>();
		Map<Purchase, WeekDay> mapFirstPurchase = new HashMap<Purchase, WeekDay>();
		Map<WeekDay, List<Purchase>> weekDayMap = new TreeMap<WeekDay, List<Purchase>>();
		
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

					List<Purchase> purchases = weekDayMap.get(weekDay);
					if(purchases==null) {
						weekDayMap.put(weekDay, purchases=new ArrayList<Purchase>());
					}
					purchases.add(purchase);
						
										
				} catch (CsvLineException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
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

			EntryChecker checkMeat = new EntryChecker() {
				
				@Override
				public boolean check(Entry<Purchase, WeekDay> entry) {
					// TODO Auto-generated method stub
					return entry.getKey().getName().equals("meat");
				}
			};

			removeEntries(mapLastPurchase, checkMeat);
			
			//remove all entries from the second map for FRIDAY;
			
			EntryChecker checkFriday = new EntryChecker() {
				
				@Override
				public boolean check(Entry<Purchase, WeekDay> entry) {
					// TODO Auto-generated method stub
					return entry.getValue()==WeekDay.FRIDAY;
				}
			};
			
			removeEntries(mapFirstPurchase, checkFriday);
			
			//print the map by for–each cycle;
			
			print(mapLastPurchase);
			print(mapFirstPurchase);
			print(weekDayMap);
			
			//print the total cost of all purchases for each weekday.
			
			for(Map.Entry<WeekDay, List<Purchase>> entry: weekDayMap.entrySet()) {
				System.out.println(Constants.TOTAL_COST+entry.getKey()+Constants.EQUALLY+getTotalCost(entry.getValue()));
			}
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(Constants.ERROR_FILE_FOUND);
		} finally {
			if (sc!=null) {
				sc.close();
			}
		}
		
	}

	private static int getTotalCost(List<Purchase> purchases) {
		int totalCost = 0;
		for(Purchase purchase : purchases) {
			totalCost+=purchase.getCost();
		}
		return totalCost;
	}
		
	private static void findWeekday(Map<Purchase, WeekDay> map, Purchase purchase) {
		StringBuilder result = new StringBuilder();
		result.append(purchase.getName()).append(Constants.WITH_PRICE).append(purchase.getPrice())
			.append(Constants.SPACE).append(map.containsKey(purchase)?map.get(purchase):Constants.NOT_FOUND_POSITION).append(Constants.NEW_LINE);
		System.out.println(result.toString());
	}

	// It is method which remove all entries from the map a given purchase or weekday;
	 
	private static void removeEntries(Map<Purchase, WeekDay> map, EntryChecker checker) {
		Iterator<Entry<Purchase, WeekDay>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Purchase, WeekDay> entry = iterator.next();
			if(checker.check(entry)) {
				iterator.remove();
			}
		}
	}

	
	
	
/*	private static void delete(Map<Purchase, WeekDay> map, Object o) {
		Iterator<Entry<Purchase, WeekDay>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Purchase, WeekDay> entry = iterator.next();
			boolean isEqualsName = entry.getKey().getName().equals(o);
			boolean isEqualsWeekDay = entry.getValue().equals(o);
			if(isEqualsName||isEqualsWeekDay) {
				iterator.remove();
			}
		}
	}  */

	// It is method which print the map 
	private static <K, V> void print(Map<K, V> purchaseMap) {
		for(Map.Entry<K, V> map : purchaseMap.entrySet()) {
			System.out.println(map.getKey()+Constants.EQUALLY+map.getValue());
		}
		System.out.println();
	}

}
