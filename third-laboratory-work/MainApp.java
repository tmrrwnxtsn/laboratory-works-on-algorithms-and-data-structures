import java.time.Duration;
import java.time.Instant;

import fractionalKnapsakProblem.FractionalKnapsackProblem;

public class MainApp {

	public static void main(String[] args) {
		solveFractionalKnapsackProblem(10);
	}
	
	public static void solveFractionalKnapsackProblem(int numberElements) {
		FractionalKnapsackProblem theProblem = new FractionalKnapsackProblem(numberElements);
		
		Instant start = Instant.now();
		
		theProblem.solveProblem();
		
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Решение задачи о рюкзаке для " + numberElements + " элементов занимает " + elapsed +" мс.");
	}
}
