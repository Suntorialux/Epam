import by.gsu.epamlab.IResultDAO;
import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.xml.ResultImplXml;

public class RunnerDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IResultDAO resultDAO = new ResultImplXml("src/results.xml");
		ResultsLoader.loadResults(resultDAO);
	}

}
