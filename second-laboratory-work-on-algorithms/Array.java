/*
 * Дек на одномерном массиве
 */
public class Array {
	
	private int maxArraySize;
	private int[] theArray;
	private int firstElementIndex;
	private int lastElementIndex;
	private int numberElements;
	
	public Array(int size) {
		maxArraySize = size;
		theArray = new int[maxArraySize];
		firstElementIndex = 0;
		lastElementIndex = -1;
		numberElements = 0;
	}
	
	// Предполагает, что дек не заполнен
	public void insertToBeginning(int value) {
		numberElements++;
		
		// Циклический перенос
		if (numberElements == 2) {
			firstElementIndex = theArray.length;
		}
		
		if (firstElementIndex > 0) 
			firstElementIndex--;
		else 
			firstElementIndex = numberElements - 1;
		
		theArray[firstElementIndex] = value;
		
		if (numberElements == 1)
			lastElementIndex = firstElementIndex;
	}
	
	// Предполагает, что дек не заполнен
	public void insertToEnd(int value) {
		// Циклический перенос
		if (lastElementIndex == maxArraySize - 1)
			lastElementIndex = -1;
		
		theArray[++lastElementIndex] = value;
		numberElements++;
	}
	
	// Предполагает, что дек не пуст
	public int removeFromBeginning() {
		int removingValue = theArray[firstElementIndex++];
		
		// Циклический перенос
		if (firstElementIndex == maxArraySize)
			firstElementIndex = 0;
		
		numberElements--;
		
		return removingValue;
	}
	
	// Предполагает, что дек не пуст
	public int removeFromEnd() {
		int removingValue = theArray[lastElementIndex];
		
		// Циклический перенос
		if (lastElementIndex == 0)
			lastElementIndex = maxArraySize - 1;
		
		numberElements--;
		
		return removingValue;
	}
	
	public boolean isEmpty() {
		return numberElements == 0;
	}
	
	public boolean isFull() {
		return numberElements == maxArraySize;
	}
	
	public void display() {
		System.out.print("Дек на одномерном массиве: ");
		while (!isEmpty()) 
			System.out.print(removeFromBeginning() + " ");
	}
}
