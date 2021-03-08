
public class TwoWayLinkListDeque {

	private TwoWayLinkList theList;
	
	public TwoWayLinkListDeque() {
		theList = new TwoWayLinkList();
	}
	
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	
	public void insertLeft(long value) {
		theList.insertToBeginning(value);
	}
	
	public void insertRight(long value) {
		theList.insertToEnd(value);
	}
	
	public void removeLeft() {
		theList.removeFirstLink();
	}
	
	public void removeRight() {
		theList.removeLastLink();
	}
	
	public void displayDeque() {
		System.out.print("Дек (от первого к последнему):");
		theList.displayTwoWayLinkList();
	}
}
