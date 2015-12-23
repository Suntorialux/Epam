package by.gsu.epamlab;

public class BuferRunnable implements Runnable {

	private Bufer bufer;
	private IResultDAO reader;

	
	
	public BuferRunnable(Bufer bufer, IResultDAO reader) {
		this.bufer = bufer;
		this.reader = reader;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(reader.hasResult()) { 	
		
		bufer.setResult(reader.nextResult()); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
}
