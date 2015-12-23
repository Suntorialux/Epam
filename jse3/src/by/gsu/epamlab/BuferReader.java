package by.gsu.epamlab;

public class BuferReader implements Runnable{

	private Bufer bufer;
	private IResultDAO reader;
	
	public BuferReader(Bufer bufer, IResultDAO reader) {
		this.bufer = bufer;
		this.reader = reader;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(reader.hasResult()) {
			
			bufer.setResult(reader.nextResult());
		}
		
		
	}

}
