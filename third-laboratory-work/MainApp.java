import fractionalKnapsakProblem.FractionalKnapsackProblem;

public class MainApp {

	public static void main(String[] args) {
		FractionalKnapsackProblem theProblem = new FractionalKnapsackProblem(10);
		theProblem.solveProblem();
		theProblem.printCurrentProblemState();
		
//		AlgorithmsWithDifferentComplexity theArray = new AlgorithmsWithDifferentComplexity(5);
//		theArray.makeLargestNumberAlgorithm();
//		theArray.getMinItem();
//		theArray.sortInNonDecreasingOrder();
	}
}
