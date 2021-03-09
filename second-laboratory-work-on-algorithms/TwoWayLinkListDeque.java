/*
 * Реализация дека на двустороннем односвязном списке
 */
public class TwoWayLinkListDeque {

	private TwoWayLinkList theTwoWayLinkList;
	
	public TwoWayLinkListDeque() {
		theTwoWayLinkList = new TwoWayLinkList();
	}
	
	public void randomlyFillLeft(long numberElements) {
		for (long i = 0; i < numberElements; i++) {
			theTwoWayLinkList.insertToBeginning(-1000 + (int) (Math.random() * 2000));
		}
	}
	
	public void randomlyFillRight(long numberElements) {
		for (long i = 0; i < numberElements; i++) {
			theTwoWayLinkList.insertToEnd(-1000 + (int) (Math.random() * 2000));
		}
	}
	
	public void clearFromLeft() {
		while (!theTwoWayLinkList.isEmpty()) {
			theTwoWayLinkList.removeFirstLink();
		}
	}
	
	public void clearFromRight() {
		while (!theTwoWayLinkList.isEmpty()) {
			theTwoWayLinkList.removeLastLink();
		}
	}
	
	public void insertLeft(int value) {
		theTwoWayLinkList.insertToBeginning(value);
	}
	
	public void insertRight(int value) {
		theTwoWayLinkList.insertToEnd(value);
	}
	
	public void removeLeft() {
		theTwoWayLinkList.removeFirstLink();
	}
	
	public void removeRight() {
		theTwoWayLinkList.removeLastLink();
	}
	
	public void display() {
		theTwoWayLinkList.displayTwoWayLinkList();
	}
}
