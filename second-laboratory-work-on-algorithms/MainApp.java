
public class MainApp {
	
	public static void main(String[] args) {
		TwoWayLinkListDeque theTwoWayLinkListDeque = new TwoWayLinkListDeque();
		theTwoWayLinkListDeque.randomlyFillLeft(10);
		theTwoWayLinkListDeque.display();
		theTwoWayLinkListDeque.randomlyFillRight(10);
		theTwoWayLinkListDeque.display();
		
	}
}
