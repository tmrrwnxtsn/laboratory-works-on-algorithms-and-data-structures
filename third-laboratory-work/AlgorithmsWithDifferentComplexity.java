import java.util.Arrays;

/*
 * Класс-аккумулят алгоритмов с различной сложностью.
 */
public class AlgorithmsWithDifferentComplexity {
	
	private int[] arrayOfDigits;
	
	public AlgorithmsWithDifferentComplexity(int elementsNumber) {
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
	
	/*
	 * Задача, которую решает алгоритм: необходимо из всех цифр неупорядоченного массива составить наибольшее число.
	 * Сложность алгоритма: O(N * logN) + O(N) = O(N * logN).
	 */
	public String makeLargestNumberAlgorithm() {
		String result = "";
		
		Arrays.sort(arrayOfDigits);
		
		for (int i = arrayOfDigits.length - 1; i >= 0; i--)
			result += arrayOfDigits[i];
		
		return result;
	}
	
	/*
	 * Задача, которую решает алгоритм: необходимо найти минимальный элемент в неотсортированном массиве.
	 * Сложность алгоритма: Θ(N). 
	 */
	public int getMinItem() {
		int min = arrayOfDigits[0];
		for (int i = 0; i < arrayOfDigits.length; i++) {
			if (arrayOfDigits[i] < min)
				min = arrayOfDigits[i];
		}
		return min;
	}
	
	/*
	 * Задача, которую решает алгоритм: необходимо отсортировать неотсортированный массив в порядке неубывания.
	 * Сложность алгоритма: Θ(N^2). 
	 */
	public void sortInNonDecreasingOrder() {
        for (int out = arrayOfDigits.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (arrayOfDigits[in] > arrayOfDigits[in + 1]) {
                	int tmp = arrayOfDigits[in];
                	arrayOfDigits[in] = arrayOfDigits[in + 1];
                	arrayOfDigits[in + 1] = tmp;
                }
            }
        }
    }
}
