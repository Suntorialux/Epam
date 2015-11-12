package by.gsu.epamlab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PurchasesList {
	
	private List<Purchase> purchases;

	public PurchasesList() {
		this.purchases=new ArrayList<Purchase>();
	}

	public PurchasesList(String fileName) {
		purchases = new ArrayList<Purchase>();
		Scanner scanner = null;
		try {
			scanner=new Scanner(new FileReader(fileName));
			String line;
			while(scanner.hasNext()){
				line = scanner.nextLine();
				try {
					purchases.add(PurchaseFactory.getPurchaseFromFactory(line));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					System.err.println(line+"   ->   "+ " exeption");
				}
			}
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File not found"); 
		}
		
		}

	public void print() {
		for (Purchase purchase:purchases) {
			
			System.out.println(purchase); 
			
		}
	}
	
	
	
	

}
