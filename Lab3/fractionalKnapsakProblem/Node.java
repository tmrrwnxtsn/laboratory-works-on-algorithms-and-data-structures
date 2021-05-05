package fractionalKnapsakProblem;

/*
 * Класс узла односвязного списка, который будет включать в себя свойства предмета (или его части), сложенного в рюкзак.
 */
public class Node {
	
	public double weight;
	public double price;
	public Node nextNode;
	
	public Node(double weight, double price) {
		this.weight = weight;
		this.price = price;
		nextNode = null;
	}
	
	public String toString() {
		return "{Вес: " + weight + ", цена: " + price + "}";
	}

}
