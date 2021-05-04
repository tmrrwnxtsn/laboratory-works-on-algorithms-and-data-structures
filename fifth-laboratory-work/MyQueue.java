/*
 * Класс очереди, на которой основан обход графа в ширину (матрица смежности).
 */
public class MyQueue {

	private final int QUEUE_SIZE = 32;
	private int[] theQueue;
	private int firstElementIndex;
	private int lastElementIndex;

	public MyQueue() {
		theQueue = new int[QUEUE_SIZE];
		firstElementIndex = 0;
		lastElementIndex = -1;
	}

	public void insert(int element) {
		if (lastElementIndex == QUEUE_SIZE - 1)
			lastElementIndex = -1;

		theQueue[++lastElementIndex] = element;
	}

	public int remove() {
		int tmp = theQueue[firstElementIndex++];

		if (firstElementIndex == QUEUE_SIZE)
			firstElementIndex = 0;
		return tmp;
	}

	public boolean isEmpty() {
		return ((lastElementIndex + 1 == firstElementIndex)
				|| (firstElementIndex + QUEUE_SIZE - 1 == lastElementIndex));
	}
}
