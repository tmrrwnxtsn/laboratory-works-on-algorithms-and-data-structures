/*
 * Класс хеш-таблицы, у которой коллизии разрешаются квадратичным пробированием.
 */
public class HashTableQuad {

	private Item[] hashArray;
	private int arraySize;
	private Item nonExistingItem;

	public HashTableQuad(int arraySize) {
		this.arraySize = arraySize;
		hashArray = new Item[this.arraySize];
		nonExistingItem = new Item(-1);
	}

	public void displayTable() {
		System.out.print("Хеш-таблица:");

		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i] != null)
				System.out.print(hashArray[i].getKey() + " ");
			else
				System.out.print("__ ");
		}

		System.out.println();
	}

	public int hashFunction(int key) {
		return key % arraySize;
	}

	// Предполагается, что хеш-таблица не заполнена
	public void insert(Item item) {
		int key = item.getKey();
		int hashValue = hashFunction(key);
		int stepSize = 0;

		while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
			stepSize++;
			hashValue += (stepSize * stepSize);
			hashValue = hashValue % arraySize;
		}

		hashArray[hashValue] = item;
	}

	public Item delete(int key) {
		int hashValue = hashFunction(key);
		int stepSize = 0;

		// Пока не будет найдена пустая ячейка
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) {
				Item tmp = hashArray[hashValue];
				hashArray[hashValue] = nonExistingItem;
				return tmp;
			}
			stepSize++;
			hashValue += (stepSize * stepSize);
			hashValue = hashValue % arraySize;
		}

		return null;
	}

	// Предполагается, что хеш-таблица не заполнена
	public Item find(int key) {
		int hashValue = hashFunction(key);
		int stepSize = 0;

		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key)
				return hashArray[hashValue];
			stepSize++;
			hashValue += (stepSize * stepSize);
			hashValue = hashValue % arraySize;
		}

		return null;
	}
}
