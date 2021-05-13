/*
 * Класс сортированного односвязного списка.
 */
public class SortedNodeList {
	
	private Node firstNode;
	
	public SortedNodeList() {
		firstNode = null;
	}
	
	// Вставка в порядке сортировки
	public void insert(Node insertingNode) {
		int key = insertingNode.getKey();
		Node prevNode = null;
		Node currentNode = firstNode;
		
		// До конца списка или пока значение currentNode <= значение insertingNode
		while (currentNode != null && key > currentNode.getKey()) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if (prevNode == null)
			firstNode = insertingNode;
		else
			prevNode.setNextNode(insertingNode);
		
		insertingNode.setNextNode(currentNode);
	}
	
	// Предполагается, что список не пуст
	public void delete(int key) {
		Node prevNode = null;
		Node currentNode = firstNode;
		
		while (currentNode != null && key != currentNode.getKey()) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if (prevNode == null)
			firstNode = firstNode.getNextNode();
		else
			prevNode.setNextNode(currentNode.getNextNode());
	}
	
	public Node find(int key) {
		Node currentNode = firstNode;
		
		while (currentNode != null && currentNode.getKey() <= key) {
			if (currentNode.getKey() == key)
				return currentNode;
			currentNode = currentNode.getNextNode();
		}
		return null;
	}
	
	public void displayList() {
		System.out.println("Список: (от первого к последнему): ");
		Node currentNode = firstNode;
		
		while (currentNode != null) {
			currentNode.displayNode();
			currentNode = currentNode.getNextNode();
		}
		
		System.out.println();
	}
}
