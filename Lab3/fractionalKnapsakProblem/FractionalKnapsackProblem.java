package fractionalKnapsakProblem;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Класс задачи о рюкзаке (№1 в л/р). Решение с помощью жадного алгоритма.
 */
public class FractionalKnapsackProblem {
	
	private ItemsInKnapsackNodeList theItemsList;
	private Item[] availableItems;
	private int knapsackСapacity;
	private int currentKnapsackWeight;
	private double currentKnapsackPrice;
	private int currentItemIndex;
	
	public FractionalKnapsackProblem(int itemsNumber) {
		availableItems = new Item[itemsNumber];
		theItemsList = new ItemsInKnapsackNodeList();
		
		for (int i = 0; i < availableItems.length; i++) {
			int currentItemWeight = 1 + (int) (Math.random() * availableItems.length);
			int currentItemPrice = 1 + (int) (Math.random() * 1000);
			availableItems[i] = new Item(currentItemWeight, currentItemPrice);
			knapsackСapacity += currentItemWeight;
		}
		
		// Делаем вместимость рюкзака, равную примерно половине совокупного веса доступных предметов
		knapsackСapacity = Math.round(knapsackСapacity / 2);
	}
	
	// Сортирует предметы, которые можно положить в рюкзак, в порядке убывания по удельной стоимости предмета
	private void sortAvailableItemsByPricePerUnitOfWeight() {
		Arrays.sort(availableItems, Comparator.comparingDouble(Item::getPricePerUnitOfWeight).reversed());
	}
	
	private void putItemsInKnapsack() {
		// Пока есть предметы, которые мы можем выбрать, и свободное место в рюкзаке
		while (currentItemIndex < availableItems.length && currentKnapsackWeight != knapsackСapacity) {
			if (currentKnapsackWeight + availableItems[currentItemIndex].getWeight() < knapsackСapacity) {
				// Складываем в рюкзак целый предмет
				theItemsList.addItemInKnapsack(availableItems[currentItemIndex].getWeight(), availableItems[currentItemIndex].getPrice());
				
				currentKnapsackPrice += availableItems[currentItemIndex].getPrice();
				currentKnapsackWeight += availableItems[currentItemIndex].getWeight();
			}
			else {
				// Складываем в рюкзак часть предмета
				theItemsList.addItemInKnapsack((knapsackСapacity - currentKnapsackWeight), ((knapsackСapacity - currentKnapsackWeight) / 
						(double) availableItems[currentItemIndex].getWeight()) *
						availableItems[currentItemIndex].getPrice());
				
				currentKnapsackPrice += ((knapsackСapacity - currentKnapsackWeight) / 
						(double) availableItems[currentItemIndex].getWeight()) *
						availableItems[currentItemIndex].getPrice();
				currentKnapsackWeight = knapsackСapacity;
			}
			
			currentItemIndex++;
		}
	}
	
	private String getAvailableItemsToString() {
		String result = "";
		
		for (int i = 0; i < availableItems.length - 1; i++) {
			result += availableItems[i].toString() + ", ";
		}
		result += availableItems[availableItems.length - 1].toString();
		
		return result;
	}
	
	private String getItemsInKnapsackToString() {
		return theItemsList.toString();
	}
	
	public void printCurrentProblemState() {
		System.out.println("Вместимость рюкзака: " + knapsackСapacity);
		if (!(currentKnapsackPrice == 0)) {
			System.out.println("Предметы, которые можно положить в рюкзак, отсортированные в порядке убывания удельной стоимости:\n" + getAvailableItemsToString());
			System.out.println("Наилучший набор вещей, который был выбран жадным алгоритмом и сложен в рюкзак:\n" + getItemsInKnapsackToString());
			System.out.println("Цена этого набора вещей при данной вместимости и данных доступных предметах: " + currentKnapsackPrice);
		}
		else {
			System.out.println("Предметы, которые можно положить в рюкзак:\n" + getAvailableItemsToString());
		}
	}
	
	public void solveProblem() {
		sortAvailableItemsByPricePerUnitOfWeight();
		putItemsInKnapsack();
	}
}
