import Comparators.PurchaseComparatorBuilder;
import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesList;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		final String IN_FILE_NAME = args[Constants.INDEX_FIRST_ELEMENT]+Constants.FILE_EXTENSION;
        final String ADDON_FILE_NAME = args[Constants.INDEX_FIRST]+Constants.FILE_EXTENSION;
        final String COMPARATOR_NAME = args[Constants.INDEX_SECOND];
        
        PurchaseComparatorBuilder.buildPurchaseComparator(COMPARATOR_NAME); 
		
    // – create an instance of the developed class, loading collection’s elements from a main file		
		PurchasesList purchasesListMain = new PurchasesList(IN_FILE_NAME);

	// – print the collection;		
		System.out.println(purchasesListMain.printTable()); 
		
	// – create another instance of the developed class, loading collection’s elements from an additional file;
		PurchasesList purchasesListAddon= new PurchasesList(ADDON_FILE_NAME);

	// – insert the last element of the second collection at the position 0 of the first collection;
		int lastElementIndex = purchasesListAddon.getPurchases().size()-Constants.INDEX_FIRST;
		Purchase lastElement = purchasesListAddon.getPurchases().get(lastElementIndex);
		purchasesListMain.insertPurchase(Constants.INDEX_FIRST_ELEMENT, lastElement);

	// – insert the initial element of the second collection at the position 1000 of the first collection;
		Purchase initialElement = purchasesListAddon.getPurchases().get(Constants.INDEX_FIRST_ELEMENT);
		purchasesListMain.insertPurchase(1000, initialElement);

	// – insert the element with index 2 of the second collection at the position 2 of the first collection;
		Purchase elementIndex2 = purchasesListAddon.getPurchases().get(Constants.INDEX_SECOND);
		purchasesListMain.insertPurchase(Constants.INDEX_SECOND, elementIndex2);
		
	// – try to delete elements with indices 3, 10 and –5;
		remove(purchasesListMain,Constants.INDEX_THREE);
		remove(purchasesListMain,Constants.INDEX_TEN);
		remove(purchasesListMain,Constants.INDEX_MINUS_FIVE);
		
	// – print the first collection;
		System.out.println(purchasesListMain.printTable());

	// – sort the first collection;
		purchasesListMain.sort();

	// – print the first collection;
		System.out.println(purchasesListMain.printTable());

	// – find the element with index 1 and the element with index 3 of the second collection in the first collection and print obtained results.
		Purchase elementIndex1 = purchasesListAddon.getPurchases().get(Constants.INDEX_FIRST);
		Purchase elementIndex3 = purchasesListAddon.getPurchases().get(Constants.INDEX_THREE);
		purchasesListMain.found(elementIndex1);
		purchasesListMain.found(elementIndex3);
	}

	private static void remove(PurchasesList purchasesList, int index) {
		try {
		purchasesList.deletePurchase(index);
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}
}
