package by.gsu.epamlab;

import by.gsu.epamlab.beans.Result;

public class Bufer {
	
	private Result result;
	private boolean empty = true;
			
	public synchronized Result getResult() {
       
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        notifyAll();
        return result;
    }
	
	public synchronized void setResult (Result result) {
       
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }
        
        empty = false;
       
        this.result = result;
        
        notifyAll();
    }
	
	

}
