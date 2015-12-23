import java.io.IOException;

import by.gsu.epamlab.Bufer;
import by.gsu.epamlab.BuferReader;
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.exceptions.ConnectionException;
import by.gsu.epamlab.factories.ResultFactory;

public class RunnerInt {
		public static synchronized void main(String[] args) {
		// TODO Auto-generated method stub
			
		final String FILE_NAME = "results";	
			
		ResultFactory resultFactory = new ResultFactory();
		final Bufer bufer = new Bufer();
		try {
			final IResultDAO readerCSV = resultFactory.getResultDaoFromFactory(FILE_NAME);
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(readerCSV.hasResult()) {
						bufer.setResult(readerCSV.nextResult());
					}
									
				}
			};
						
			Thread loader = new Thread(runnable);
			loader.start();
			
			IResultDAO reader = new BuferReader(bufer);		
			ResultsLoader.loadResults(reader);
		
			RunnerLogic.logic(resultFactory);
		
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
