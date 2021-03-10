/*
 * Работа с деком на двустороннем односвязном списке
 */
public class TwoWayNodeListDeque {

	private TwoWayNodeList theTwoWayNodeList;
	
	public TwoWayNodeListDeque() {
		theTwoWayNodeList = new TwoWayNodeList();
	}
	
	public void randomlyFillLeft(long numberElements) {
		for (long i = 0; i < numberElements; i++) {
			theTwoWayNodeList.insertToBeginning(-1000 + (int) (Math.random() * 2000));
		}
	}
	
	public void randomlyFillRight(long numberElements) {
		for (long i = 0; i < numberElements; i++) {
			theTwoWayNodeList.insertToEnd(-1000 + (int) (Math.random() * 2000));
		}
	}
	
	public void clearFromLeft() {
		while (!theTwoWayNodeList.isEmpty()) {
			theTwoWayNodeList.removeFirstNode();
		}
	}
	
	public void clearFromRight() {
		while (!theTwoWayNodeList.isEmpty()) {
			theTwoWayNodeList.removeLastNode();
		}
	}
	
	public void insertLeft(int value) {
		theTwoWayNodeList.insertToBeginning(value);
	}
	
	public void insertRight(int value) {
		theTwoWayNodeList.insertToEnd(value);
	}
	
	public void removeLeft() {
		theTwoWayNodeList.removeFirstNode();
	}
	
	public void removeRight() {
		theTwoWayNodeList.removeLastNode();
	}
	
	public void display() {
		theTwoWayNodeList.displayTwoWayNodeList();
	}
}
