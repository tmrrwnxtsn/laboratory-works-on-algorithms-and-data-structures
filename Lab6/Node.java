/*
 * Класс узла односвязного сортированного списка.
 */
public class Node {
	
	private int key;
	private Node nextNode;
	
	public Node(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}
	
	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public void displayNode() {
		System.out.print(key + " ");
	}
}
