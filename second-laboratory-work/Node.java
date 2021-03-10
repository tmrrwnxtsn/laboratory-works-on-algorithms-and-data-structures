/*
 * Класс элемента списка
 */
public class Node {
	
	public Node nextNode;
	public int data;
	
	public Node(int intData) {
		data = intData;
		nextNode = null;
	}
	
	public void displayNode() {
		System.out.print(data + " ");
	}
}
