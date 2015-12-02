import java.util.List;

import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultsSAXBuilder;

public class Runner {

	public static void main(String[] args) {
		final String FILE_NAME="src/results.xml";
		
		ResultsSAXBuilder saxBuilder = new ResultsSAXBuilder();
		saxBuilder.buildListResults(FILE_NAME);
		List<Result> results = saxBuilder.getResults();
		
		for(Result result : results) {
			System.out.println(result);
		}
	}
}