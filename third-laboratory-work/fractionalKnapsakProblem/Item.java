package fractionalKnapsakProblem;
/*
 * Класс делимого на части предмета, который (или часть которого) мы можем положить в рюкзак.
 */
public class Item {
	
	private int weight = 0;
	private int price = 0;
	
	public Item(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
	
	public double getPricePerUnitOfWeight() {
		return (double) (price / weight);
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price; 
	}
	
	public String toString() {
		return "{Вес: " + weight + ", цена: " + price + "}";
	}
}
