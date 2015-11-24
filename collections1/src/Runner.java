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
			sc = new Scanner(new FileReader("src/in.csv"));
			while(sc.hasNext()) {
				try {
					Purchase purchase = PurchaseFactory.getPurchaseFromFactory(sc);
					WeekDay weekDay= WeekDay.valueOf(sc.nextLine());
					mapLastPurchase.put(purchase, weekDay);
					if(!(mapFirstPurchase.containsKey(purchase))) {
						mapFirstPurchase.put(purchase, weekDay);
					}
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
		
		print(mapLastPurchase);

		print(mapFirstPurchase);

		System.out.print(Constants.FIRST_WEEKDAY+findWeekday(mapFirstPurchase, Constants.BREAD_1550));
		System.out.print(Constants.LAST_WEEKDAY+findWeekday(mapLastPurchase, Constants.BREAD_1550));
		System.out.print(Constants.FIRST_WEEKDAY+findWeekday(mapFirstPurchase, Constants.BREAD_1700));
			
		delete(mapLastPurchase, Constants.MEAT);
		delete(mapFirstPurchase, WeekDay.FRIDAY);
		print(mapLastPurchase);
		
		
		print(mapFirstPurchase);
		
		print(weekDayMap);
		
	}

	private static String findWeekday(Map<Purchase, WeekDay> map, Purchase purchase) {
		StringBuilder result = new StringBuilder();
		result.append(purchase.getCommodityName()).append(Constants.WITH_PRICE).append(purchase.getPrice())
			.append(Constants.SPACE).append(map.containsKey(purchase)?map.get(purchase):Constants.NOT_FOUND_POSITION).append(Constants.NEW_LINE);
		return result.toString();
	}

	private static void delete(Map<Purchase, WeekDay> map, Object o) {
		Iterator<Entry<Purchase, WeekDay>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Purchase, WeekDay> entry = iterator.next();
			boolean equals = entry.getKey().getCommodityName().equals(o);
			boolean equal = entry.getValue().equals(o);
			if(equals||equal) {
				iterator.remove();
			}
		}
	}

	private static <K, V> void print(Map<K, V> purchaseMap) {
		for(Map.Entry<K, V> map : purchaseMap.entrySet()) {
			System.out.println(map.getKey()+" = "+map.getValue());
		}
		System.out.println();
	}

}
