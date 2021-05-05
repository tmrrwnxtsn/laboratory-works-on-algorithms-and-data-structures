/*
 * Работа с деком на одномерном массиве
 */
public class ArrayDeque {
	
	private Array theArray;
	
	public ArrayDeque(int dequeSize) {
		theArray = new Array(dequeSize);
	}
	
	public void randomlyFillLeft() {
		while (!theArray.isFull()) {
			theArray.insertToBeginning(-1000 + (int) (Math.random() * 2000));
		}
	}
	
	public void randomlyFillRight() {
		while (!theArray.isFull()) {
			theArray.insertToEnd(-1000 + (int) (Math.random() * 2000));
		}
	}
	
	public void clearFromLeft() {
		while (!theArray.isEmpty()) {
			theArray.removeFromBeginning();
		}
	}
	
	public void clearFromRight() {
		while (!theArray.isEmpty()) {
			theArray.removeFromEnd();
		}
	}
	
	public void insertLeft(int value) {
		theArray.insertToBeginning(value);
	}
	
	public void insertRight(int value) {
		theArray.insertToEnd(value);
	}
	
	public void removeLeft() {
		theArray.removeFromBeginning();
	}
	
	public void removeRight() {
		theArray.removeFromEnd();
	}
	
	public void display() {
		theArray.display();
	}
}
