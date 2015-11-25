import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Runner {

     public static void main(String[] args) {
    	
    	final String FILE_PATH="src/in.txt";
    	final int PURCHASES_NUMBER=6;
    	
        Scanner sc = null;
        
        // 1. Create an array for 6 objects.
        
        Purchase [] purchases = new Purchase[PURCHASES_NUMBER];
        
        try {
        	
            sc = new Scanner(new FileReader(FILE_PATH));
            
            int maxCost=0;
            Purchase maxPurchase=null;
            boolean areEqual = true;
              
            for (int index = 0; index < purchases.length; index++) {
            	
         // 2. Input data from the given file into the array.
            	
                purchases[index]= PurchasesFactory.getPurchaseFromFactory(sc);
                
         // 3. Print the array content to the console (one element per line).
                
                System.out.println(purchases[index]);
                
         // 4. Define the purchase with maximum cost.
                
                if(purchases[index].getCost()>maxCost) {
                	maxCost=purchases[index].getCost();
                	maxPurchase=purchases[index];
                }
                
         // 5. Determine whether all purchases are equal.
                
                if (areEqual){
                	areEqual = purchases[index].equals(purchases[0]); 
                }
            }
            
         // 6. Print results of subtasks 4–5.
            
            System.out.println("The purchase with maximum cost " + maxPurchase); 
            System.out.println("All purchases are equal is " + areEqual); 

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } finally {
            if(sc != null) {
                sc.close();
            }
        }
    }
}
