import java.time.Duration;
import java.time.Instant;

import fractionalKnapsakProblem.FractionalKnapsackProblem;

public class MainApp {

	public static void main(String[] args) {
		measureTimeOfMyAlgorithms(100000);
	}
	
	public static void measureTimeOfKnapsackProblemSolution(int numberElements) {
		FractionalKnapsackProblem theProblem = new FractionalKnapsackProblem(numberElements);
		
		// Измерение времени для реализации решения задачи о рюкзаке с помощью жадного алгоритма
		Instant start = Instant.now();
		
		theProblem.solveProblem();
		
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Решение задачи о рюкзаке для " + numberElements + " элементов занимает " + elapsed +" мс.");
	}
	
	public static void measureTimeOfMakeLargestNumberAlgorithm(int numberElements) {
		AlgorithmsWithDifferentComplexity theAnalyzedArray = new AlgorithmsWithDifferentComplexity(numberElements);
		
		// Измерение времени для 1-го алгоритма (O(N * logN))
		Instant start = Instant.now();
		
		theAnalyzedArray.makeLargestNumberAlgorithm();
		
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Составление наибольшего числа из цифр неупорядоченного массива из " + numberElements + " элементов занимает " + elapsed +" мс.");
	}
	
	public static void measureTimeOfGetMinItemAlgorithm(int numberElements) {
		AlgorithmsWithDifferentComplexity theAnalyzedArray = new AlgorithmsWithDifferentComplexity(numberElements);
		
		// Измерение времени для 2-го алгоритма (O(N))
		Instant start = Instant.now();
		
		theAnalyzedArray.getMinItem();
		
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Поиск минимального элемента в неупорядоченном массиве из " + numberElements + " элементов занимает " + elapsed +" мс.");		
	}
	
	public static void measureTimeOfSortInNonDecreasingOrderAlgorithm(int numberElements) {
		AlgorithmsWithDifferentComplexity theAnalyzedArray = new AlgorithmsWithDifferentComplexity(numberElements);
		
		// Измерение времени для 3-го алгоритма (O(N^2))
		Instant start = Instant.now();
				
		theAnalyzedArray.sortInNonDecreasingOrder();
				
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Пузырьковая сортировка в порядке неубывания неупорядоченного массива из " + numberElements + " элементов занимает " + elapsed +" мс.");
	}
	
	/*
	 * №2* в л/р.
	 * Задача, которую решает алгоритм: необходимо найти число Фибоначчи на данной позиции, используя динамическое программирование.
	 * Сложность алгоритма: O(N)
	 */
	public static int getCirtainFibonacciNumber(int fibNumberPosition) {
		if (fibNumberPosition == 1 || fibNumberPosition == 2) {
			return 1;
		}
		else {
			int[] fibonacciNumbers = new int[fibNumberPosition];
			
			fibonacciNumbers[0] = 1;
			fibonacciNumbers[1] = 1;
			
			for (int i = 2; i < fibNumberPosition; i++)
				fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
			
			return fibonacciNumbers[fibNumberPosition - 1];
		}
	}
	
	public static void measureTimeOfSearchingCirtainFibonacciNumber(int fibNumberPosition) {
		// Измерение времени для поиска n-ного числа Фибоначчи
		Instant start = Instant.now();
						
		getCirtainFibonacciNumber(fibNumberPosition);
		
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Поиск " + fibNumberPosition + "-ого числа Фибоначчи занимает " + elapsed +" мс.");
			
	}
	
	public static void measureTimeOfMyAlgorithms(int numberElements) {
		measureTimeOfKnapsackProblemSolution(numberElements);
		System.out.println();
		measureTimeOfSortInNonDecreasingOrderAlgorithm(numberElements);
		System.out.println();
		measureTimeOfMakeLargestNumberAlgorithm(numberElements);
		System.out.println();
		measureTimeOfGetMinItemAlgorithm(numberElements);
		System.out.println();
		measureTimeOfSearchingCirtainFibonacciNumber(numberElements);
	}
}
