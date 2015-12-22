import by.gsu.epamlab.factories.HalfResultFactory;
import by.gsu.epamlab.factories.ResultFactory;

public class RunnerHalf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String FILE_NAME = "results";
		
		ResultFactory resultFactory = new HalfResultFactory();
		RunnerLogic.logic(resultFactory, FILE_NAME);
	}
}
