package by.gsu.epamlab;

import by.gsu.epamlab.beans.Result;

public class Bufer {
	
	private Result result;
	private volatile boolean empty = true;
			
	public synchronized Result getResult() {
       
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        
        notifyAll();
        System.out.println("get - > "+ result);
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
        System.out.println("SET -> " + result);
        
        notifyAll();
    }
	
	public synchronized boolean hasResult () {
		return !empty;
	}
	
	

}
