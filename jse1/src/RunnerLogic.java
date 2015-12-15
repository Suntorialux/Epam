import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultFactory;
import by.gsu.epamlab.ResultsLoader;

public class RunnerLogic {

	public static void logic(ResultFactory resultFactory, String fileName) {
		
		IResultDAO reader = resultFactory.getResultDaoFromFactory(resultFactory, fileName);
		ResultsLoader.loadResults(reader);
		
		
	}

}
