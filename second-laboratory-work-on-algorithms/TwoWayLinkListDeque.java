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
	
	public void display() {
		theTwoWayLinkList.displayTwoWayLinkList();
	}
}
