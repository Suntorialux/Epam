import java.io.IOException;

import by.gsu.epamlab.Bufer;
import by.gsu.epamlab.BuferReader;
import by.gsu.epamlab.BuferRunnable;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.exceptions.ConnectionException;
import by.gsu.epamlab.factories.ResultFactory;

public class RunnerInt {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		final String FILE_NAME = "results";	
			
		ResultFactory resultFactory = new ResultFactory();
		final Bufer bufer = new Bufer();
		try {
				
			final IResultDAO readerCSV = resultFactory.getResultDaoFromFactory(FILE_NAME);
		
				
				
			Runnable runnable = new BuferRunnable(bufer, readerCSV);
		
			Thread loader = new Thread(runnable);
			loader.start();
			
			System.out.println("Runner");
			IResultDAO reader = new BuferReader(readerCSV, bufer);	
			ResultsLoader.loadResults(reader);
			System.out.println("exit");
			
	
		
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
