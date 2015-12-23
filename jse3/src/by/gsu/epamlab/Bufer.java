package by.gsu.epamlab;

import by.gsu.epamlab.beans.Result;

public class Bufer {
	
	private Result result=null;
	
	public synchronized Result getResult() {
       
        while (this.result==null) {
           try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           }
        Result getResult = this.result;
        this.result = null;
        System.out.println("get - > "+ getResult);
        this.notifyAll();
        return getResult;
    }
	
	public synchronized void setResult (Result newResult) {
       
        while (this.result!=null) {
           
                try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
             
        this.result = newResult;
        System.out.println("SET -> " + result);
        this.notifyAll();
    }
	
	public synchronized boolean hasResult () {
		boolean   isResult = false;
		if(this.result!=null) {
			isResult = true;
		}
		return isResult;
	}
	
	

}
