import by.gsu.epamlab.HalfResultFactory;
import by.gsu.epamlab.ResultFactory;

public class RunnerHalf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultFactory resultFactory = new HalfResultFactory();
		RunnerLogic.logic(resultFactory, "results");
	}
}
