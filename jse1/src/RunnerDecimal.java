import by.gsu.epamlab.factories.DecimalResultFactory;
import by.gsu.epamlab.factories.ResultFactory;

public class RunnerDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String FILE_NAME = "results";
		
		
		ResultFactory resultFactory = new DecimalResultFactory();
		RunnerLogic.logic(resultFactory, FILE_NAME);
	} 
}
