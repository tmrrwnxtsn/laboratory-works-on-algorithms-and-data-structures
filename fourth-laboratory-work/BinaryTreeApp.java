import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Основной класс, который запускается для просмотра реализации.
 */
public class BinaryTreeApp {

	public static void main(String[] args) throws IOException {
		MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();		 
		int key, value;
		while (true) {
			System.out.print("1 - вывести текущее дерево\n2 - совершить обход текущего дерева\n3 - добавить в дерево пару {key, value}\n4 - найти узел, в котором хранится пара {key, value}\n5 - удалить узел, в котором хранится пара {key, value}\nВведите цифру, чтобы совершить соответствующую ей операцию над деревом: ");
			int choice = getInt();
			switch(choice) {
			case 1:
				System.out.println(theTree.toString());
				break;
			case 2:
				System.out.println("\n1 - прямой обход\n2 - симметричный обход\n3 - обратный обход\nВведите цифру, чтобы совершить соответствующий ей обход: ");
				key = getInt();
				theTree.traverse(key);
				break;
			case 3:
				System.out.println("Введите пару ключ-значение (каждое значениена новой строке):");
				key = getInt();
				value = getInt();
				theTree.insertNode(key, value);
				break;
			case 4:
				System.out.print("Введите ключ: ");
				key = getInt();
				MyBinaryTreeNode<Integer> found = theTree.findNode(key);
				if (found != null) {
					System.out.print("\nНайденное значение по ключу: ");
					System.out.println(found.toString());
					System.out.println();
				}
				else {
					System.out.println("\nЗначение не найдено!");
				}
				break;
			case 5:
				System.out.print("Введите ключ: ");
				key = getInt();
				boolean a = theTree.removeNode(key);
				System.out.println("Статус удаления:");
				System.out.print(a);
				break;
			}
			System.out.println();
		}
	}
	
	public static int getInt() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	// Замер общего времени, затрачиваемого на добавление элементов (от 10000 до 100000) в дерево
	public static void firstWayToMeasureTimeOfAddingItems() {
		Random random = new Random();
		System.out.println("1 way:");
		long start = System.currentTimeMillis();
        MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();
        for (int i = 0; i <= 100000000; i++)
        	theTree.insertNode(random.nextInt() % 10000, random.nextInt());
        System.out.println("Tree(" + 10000 + ") insert " + (System.currentTimeMillis() - start) + " ms.");
	}
	
	// Замер среднего времени, затрачиваемого на добавление 1 элемента (от 10000 до 100000) в дерево
	public static void secondWayToMeasureTimeOfAddingItems() {
		Random random = new Random();
		System.out.println("2 way:");
		for(long listsize = 10000; listsize <= 1000000000; listsize*=10) {
			long start = System.currentTimeMillis();
	        MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();
	        for (int i = 0; i <= listsize; i++)
	            	theTree.insertNode(random.nextInt() % 10000, random.nextInt());
	        System.out.println("Tree(" + listsize + ") insert " + (double)(System.currentTimeMillis() - start)/listsize  + " ms.");
	    }
	}
	
	// Замер среднего времени, затрачиваемого на добавление (listsize+1)-го элемента в дерево
	public static void thirdWayToMeasureTimeOfAddingItems() {
		Random random = new Random();
		System.out.println("3 way:");
		for(long listsize = 10000; listsize <= 100000000; listsize*=10) {
			MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();
			for (int i = 0; i <= listsize; i++)
				theTree.insertNode(random.nextInt() % 10000, random.nextInt());
		    long start = System.currentTimeMillis();
		    theTree.insertNode(random.nextInt() % 10000, random.nextInt());
		    System.out.println("Tree(" + listsize + ") insert " + (System.currentTimeMillis() - start) + " ms.");
		}
	}
	
	// Замер среднего времени, затрачиваемого на добавление (listsize+1000) элементов в дерево
	public static void fourthWayToMeasureTimeOfAddingItems() {
		Random random = new Random();
		System.out.println("4 way:");
		for(long listsize = 10000; listsize <= 100000000; listsize*=10) {
			MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();
			for (int i = 0; i <= listsize; i++)
				theTree.insertNode(random.nextInt() % 10000, random.nextInt());
			long start = System.currentTimeMillis();
			for (int i = 0; i <= 1000; i++)
				theTree.insertNode(random.nextInt() % 10000, random.nextInt());
			System.out.println("Tree(" + listsize + ") insert " + (System.currentTimeMillis() - start) + " ms.");
		}
	}
	
	// Замер времени, затрачиваемого на обход traversePreOrder
	public static void toMeasureTimeOfTraversePreOrder() {
		Random random = new Random();
		MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();
		for (int i = 0; i <= 100000001; i++)
			theTree.insertNode(random.nextInt() % 10000, random.nextInt());
		long start = System.currentTimeMillis();
		theTree.traversePreOrder(theTree.root);
		System.out.println((System.currentTimeMillis() - start) + " ms.");
	}
	
	// Замер времени, затрачиваемого на обход traverseInOrder
	public static void toMeasureTimeOfTraverseInOrder() {
		Random random = new Random();
		MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();
		for (int i = 0; i <= 100000001; i++)
			theTree.insertNode(random.nextInt() % 10000, random.nextInt());
		long start = System.currentTimeMillis();
		theTree.traverseInOrder(theTree.root);
		System.out.println((System.currentTimeMillis() - start) + " ms.");
	}
	
	// Замер времени, затрачиваемого на обход traversePostOrder
	public static void toMeasureTimeOfTraversePostOrder() {
		Random random = new Random();
		MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();
		for (int i = 0; i <= 100000001; i++)
			theTree.insertNode(random.nextInt() % 10000, random.nextInt());
		long start = System.currentTimeMillis();
		theTree.traversePostOrder(theTree.root);
		System.out.println((System.currentTimeMillis() - start) + " ms.");
	}
	
	// Замер времени, затрачиваемого на поиск (N+1)-го элемента, вставленного последним
	public static void toMeasureTimeOfFindingAndRemoving() {
		Random random = new Random();
		MyBinaryTree<Integer> theTree = new MyBinaryTree<Integer>();
		for (int i = 0; i < 100000000; i++)
			theTree.insertNode(random.nextInt() % 10000, random.nextInt());
		int findingNodeKey = random.nextInt() % 10000;
		theTree.insertNode(findingNodeKey, random.nextInt());
		long start = System.currentTimeMillis();
		theTree.findNode(findingNodeKey); // Ищем последний вставленный элемент
		System.out.println((System.currentTimeMillis() - start) + " ms.");
		start = System.currentTimeMillis();
		theTree.removeNode(findingNodeKey); // Удаляем последний вставленный элемент
		System.out.println((System.currentTimeMillis() - start) + " ms.");
	}
}
