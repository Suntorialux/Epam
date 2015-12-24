package by.gsu.epamlab;

public class BuferRunnable implements Runnable {


	private IResultDAO reader;

	
	
	public BuferRunnable(IResultDAO reader) {
		this.reader = reader;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(reader.hasResult()) { 	
		
		reader.nextResult(); 
		
		
		}
		
	}
}
