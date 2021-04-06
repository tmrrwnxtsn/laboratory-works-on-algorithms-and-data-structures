import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Основной класс, который запускается для просмотра реализации.
 */
public class TreeApp {

	public static void main(String[] args) throws IOException {
		MyBinarySearchTree<Integer> theTree = new MyBinarySearchTree<Integer>();
		
		System.out.print("Сколько элементов добавить в дерево? Введите число от 1 до 20: ");
		int numberElements = getInt();
		for (int i = 0; i < numberElements; i++) {
			theTree.insertNode(-100 + (int) (Math.random() * 200), -1000 + (int) (Math.random() * 2000));
		}
		System.out.println();
		 
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
				MyBinarySearchTreeNode<Integer> found = theTree.findNode(key);
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
}
