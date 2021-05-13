/*
 * Класс хеш-таблицы, у которой коллизии разрешаются методом цепочек (элемент хеша - односвязный сортированный список).
 */
public class HashTableChains {
	
	private SortedNodeList[] hashArray;
	private int arraySize;
	
	public HashTableChains(int arraySize) {
		this.arraySize = arraySize;
		hashArray = new SortedNodeList[arraySize];
		for (int i = 0; i < arraySize; i++)
			hashArray[i] = new SortedNodeList();
	}
	
	public void displayTable() {
		System.out.println("Хеш-таблица:");
		
		for (int i = 0; i < arraySize; i++) {
			System.out.println(i + ". "); // Вывод номера ячейки
			hashArray[i].displayList();
		}
	}
	
	public int hashFunction(int key) {
		return key % arraySize;
	}
	
	public void insert(Node insertingNode) {
		int key = insertingNode.getKey();
		int hashValue = hashFunction(key);
		hashArray[hashValue].insert(insertingNode);
	}
	
	public void delete(int key) {
		int hashValue = hashFunction(key);
		hashArray[hashValue].delete(key);
	}
	
	public Node find(int key) {
		int hashValue = hashFunction(key);
		Node findingNode = hashArray[hashValue].find(key);
		return findingNode;
	}
}
