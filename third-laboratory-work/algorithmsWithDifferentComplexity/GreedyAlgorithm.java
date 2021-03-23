package algorithmsWithDifferentComplexity;

import java.util.Arrays;

/*
 * Класс жадного алгоритма.
 * Задача, которую решает алгоритм: необходимо из всех цифр неупорядоченного массива составить наибольшее число.
 * Сложность алгоритма: O(N * logN) + O(N) = O(N * logN).
 */
public class GreedyAlgorithm {
	
	private int[] arrayOfDigits;
	
	public GreedyAlgorithm(int elementsNumber) {
		arrayOfDigits = new int[elementsNumber];
		
		for (int i = 0; i < elementsNumber; i++)
			arrayOfDigits[i] = 0 + (int) (Math.random() * 10);
	}
	
	public String getArrayOfDigitsToString() {
		String result = "";
		
		for (int i = 0; i < arrayOfDigits.length; i++)
			result += arrayOfDigits[i] + " ";
		
		return result;
	}
	
	public String makeLargestNumber() {
		String result = "";
		
		Arrays.sort(arrayOfDigits);
		
		for (int i = arrayOfDigits.length - 1; i >= 0; i--)
			result += arrayOfDigits[i];
		
		return result;
	}
}
