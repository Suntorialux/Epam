
import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultImplCsv;
import by.gsu.epamlab.ResultsLoader;

public class Runner {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		IResultDAO resultDAO = new ResultImplCsv("results");
		ResultsLoader.loadResults(resultDAO);
	}
}
