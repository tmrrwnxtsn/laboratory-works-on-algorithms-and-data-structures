import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Класс, реализующий взаимодействие с хеш-таблицами.
 */
public class HashTablesApp {

	public static void main(String[] args) throws IOException {
		System.out.print(
				"С какой хеш-таблицой будете работать? Введите:\n1, если проблема коллизии решается квадратичным пробированием;\n2, если проблема коллизии решается методом цепочек (элемент хеша - односвязный список): ");
		int cmd = getInt();
		int aKey, hashTableSize, startNumberOfElements, keysPerCell;
		switch (cmd) {
		case 1:
			System.out.print("Введите размер хеш-таблицы: ");
			hashTableSize = getInt();
			System.out.println("Введите первоначальное количество элементов в хеш-таблице: ");
			startNumberOfElements = getInt();

			keysPerCell = 10; // Отношение размеров диапазона ключей и массива: означает, что для таблицы с
								// размером 10 значения ключей лежат в диапазоне от 0 до 100.

			HashTableQuad theHashTableQuad = new HashTableQuad(hashTableSize);
			Item aItem;
			for (int i = 0; i < startNumberOfElements; i++) {
				aKey = (int) (Math.random() * keysPerCell * hashTableSize);
				aItem = new Item(aKey);
				theHashTableQuad.insert(aItem);
			}

			while (true) // Взаимодействие с пользователем
			{
				System.out.print(
						"Введите:\n1, чтобы вывести хеш-таблицу;\n2, чтобы добавить элемент в хеш-таблицу;\n3, чтобы удалить элемент из хеш-таблицы;\n4, чтобы найти элемент в хеш-таблице; Ввод: ");
				int choice = getInt();
				switch (choice) {
				case 1:
					theHashTableQuad.displayTable();
					break;
				case 2:
					System.out.print("Введите ключ, чтобы вставить элемент: ");
					aKey = getInt();
					aItem = new Item(aKey);
					theHashTableQuad.insert(aItem);
					break;
				case 3:
					System.out.print("Введите ключ, чтобы удалить элемент: ");
					aKey = getInt();
					theHashTableQuad.delete(aKey);
					break;
				case 4:
					System.out.print("Введите значение элемента, которого нужно найти: ");
					aKey = getInt();
					aItem = theHashTableQuad.find(aKey);
					if (aItem != null) {
						System.out.println("Элемент найден. Ключ: " + aKey);
					} else
						System.out.println("Элемент не найден. Ключ: " + aKey);
					break;
				default:
					System.out.print("Некорректный ввод!\n");
				}
			}
		case 2:
			System.out.print("Введите размер хеш-таблицы: ");
			hashTableSize = getInt();
			System.out.println("Введите первоначальное количество элементов в хеш-таблице: ");
			startNumberOfElements = getInt();

			keysPerCell = 100; // Отношение размеров диапазона ключей и массива: означает, что для таблицы с
								// размером 100 значения ключей лежат в диапазоне от 0 до 10000.

			HashTableChains theHashTableChains = new HashTableChains(hashTableSize);
			Node aNodeItem;
			for (int i = 0; i < startNumberOfElements; i++) {
				aKey = (int) (Math.random() * keysPerCell * hashTableSize);
				aNodeItem = new Node(aKey);
				theHashTableChains.insert(aNodeItem);
			}

			while (true) {
				System.out.print(
						"Введите:\n1, чтобы вывести хеш-таблицу;\n2, чтобы добавить элемент в хеш-таблицу;\n3, чтобы удалить элемент из хеш-таблицы;\n4, чтобы найти элемент в хеш-таблице; Ввод: ");
				int choice = getInt();
				switch (choice) {
				case 1:
					theHashTableChains.displayTable();
					break;
				case 2:
					System.out.print("Введите ключ, чтобы вставить элемент: ");
					aKey = getInt();
					aNodeItem = new Node(aKey);
					theHashTableChains.insert(aNodeItem);
					break;
				case 3:
					System.out.print("Введите ключ, чтобы удалить элемент: ");
					aKey = getInt();
					theHashTableChains.delete(aKey);
					break;
				case 4:
					System.out.print("Введите значение элемента, которого нужно найти: ");
					aKey = getInt();
					aNodeItem = theHashTableChains.find(aKey);
					if (aNodeItem != null)
						System.out.println("Элемент найден. Ключ: " + aKey);
					else
						System.out.println("Элемент не найден. Ключ: " + aKey);
					break;
				default:
					System.out.print("Некорректный ввод!\n");
				}
			}
		default:
			System.out.println("Некорректный ввод!");
			break;
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}
