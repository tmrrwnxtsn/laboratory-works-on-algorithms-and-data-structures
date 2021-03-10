/*
 * Дек на двустороннем односвязном списке
 */
public class TwoWayNodeList {
	
	private Node firstNode; 
	private Node lastNode;
	
	public TwoWayNodeList() {
		firstNode = null;
		lastNode = null;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public void insertToBeginning(int data) {
		Node newNode = new Node(data);
		
		if (isEmpty())
			lastNode = newNode;
		
		newNode.nextNode = firstNode;
		firstNode = newNode;
	}
	
	public void insertToEnd(int data) {
		Node newNode = new Node(data);

		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.nextNode = newNode;
		
		lastNode = newNode;
	}
	
	// Предполагает, что дек не пуст
	public long removeFirstNode() {
		long tempData = firstNode.data;
		
		if (firstNode.nextNode == null)
			lastNode = null;
		
		firstNode = firstNode.nextNode;
		
		return tempData;
	}
	
	// Предполагает, что дек не пуст
	public long removeLastNode() {
		long tempData = lastNode.data;
		
		if (firstNode.nextNode == null) {
			lastNode = null;
			firstNode = null;
		}
		else {
			Node currentNode = firstNode;
			Node previousNode = firstNode;
			
			while (currentNode.nextNode != null) {
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
			}
			previousNode.nextNode = null;
			lastNode = previousNode;
		}
		
		return tempData;
	}
	
	public void displayTwoWayNodeList() {
		System.out.print("Дек на двустороннем односвязном списке: ");
		
		Node currentNode = firstNode;
		while (currentNode != null) {
			currentNode.displayNode();
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}
}
