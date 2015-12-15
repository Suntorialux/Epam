
import by.gsu.epamlab.factories.ResultFactory;

public class RunnerInt {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		final String FILE_NAME = "results";	
			
		ResultFactory resultFactory = new ResultFactory();
		RunnerLogic.logic(resultFactory, FILE_NAME);
	}
}
