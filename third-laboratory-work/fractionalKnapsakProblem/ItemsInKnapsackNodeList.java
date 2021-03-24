package fractionalKnapsakProblem;

/*
 * Класс для хранения предметов (или их частей), сложенных в рюкзак.
 */
public class ItemsInKnapsackNodeList {
	
	private Node firstNode;
	
	public ItemsInKnapsackNodeList() {
		firstNode = null;
	}
	
	public void addItemInKnapsack(double weight, double price) {
		Node newNode = new Node(weight, price);
		newNode.nextNode = firstNode;
		firstNode = newNode;
	}
	
	public String toString() {
		String result = "";
		
		Node currentNode = firstNode;
		while(currentNode.nextNode != null) {
			result += currentNode.toString() + ", ";
			currentNode = currentNode.nextNode;
		}
		result += currentNode.toString();
		
		return result;
	}
}
