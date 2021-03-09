/*
 * Дек на двустороннем односвязном списке
 */
public class TwoWayLinkList {
	
	private Link firstLink; 
	private Link lastLink;
	
	public TwoWayLinkList() {
		firstLink = null;
		lastLink = null;
	}
	
	public boolean isEmpty() {
		return firstLink == null;
	}
	
	public void insertToBeginning(int data) {
		Link newLink = new Link(data);
		
		if (isEmpty())
			lastLink = newLink;
		
		newLink.nextLink = firstLink;
		firstLink = newLink;
	}
	
	public void insertToEnd(int data) {
		Link newLink = new Link(data);

		if (isEmpty())
			firstLink = newLink;
		else
			lastLink.nextLink = newLink;
		
		lastLink = newLink;
	}
	
	// Предполагает, что дек не пуст
	public long removeFirstLink() {
		long tempData = firstLink.data;
		
		if (firstLink.nextLink == null)
			lastLink = null;
		
		firstLink = firstLink.nextLink;
		
		return tempData;
	}
	
	// Предполагает, что дек не пуст
	public long removeLastLink() {
		long tempData = lastLink.data;
		
		if (firstLink.nextLink == null) {
			lastLink = null;
			firstLink = null;
		}
		else {
			Link currentLink = firstLink;
			Link previousLink = firstLink;
			
			while (currentLink.nextLink != null) {
				previousLink = currentLink;
				currentLink = currentLink.nextLink;
			}
			previousLink.nextLink = null;
			lastLink = previousLink;
		}
		
		return tempData;
	}
	
	public void displayTwoWayLinkList() {
		System.out.print("Дек на двустороннем односвязном списке: ");
		
		Link currentLink = firstLink;
		while (currentLink != null) {
			currentLink.displayLink();
			currentLink = currentLink.nextLink;
		}
		System.out.println();
	}
}
