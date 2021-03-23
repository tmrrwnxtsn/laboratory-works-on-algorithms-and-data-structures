
public class MainApp {

	public static void main(String[] args) {
		FractionalKnapsackProblem theProblem = new FractionalKnapsackProblem(10);
		theProblem.solveProblem();
		theProblem.printCurrentProblemState();
	}

}
