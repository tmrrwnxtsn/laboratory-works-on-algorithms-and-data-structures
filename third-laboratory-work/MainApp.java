import algorithmsWithDifferentComplexity.*;
import fractionalKnapsakProblem.FractionalKnapsackProblem;

public class MainApp {

	public static void main(String[] args) {
//		FractionalKnapsackProblem theProblem = new FractionalKnapsackProblem(10);
//		theProblem.solveProblem();
//		theProblem.printCurrentProblemState();
		
		GreedyAlgorithm theProblem = new GreedyAlgorithm(5);
		System.out.println(theProblem.getArrayOfDigitsToString());
		System.out.println(theProblem.makeLargestNumber());
	}

}
