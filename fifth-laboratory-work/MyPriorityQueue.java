/*
 * Класс приоритетной очереди для поиска минимального остовного дерева у графа MyWeightedGraph. 
 */
public class MyPriorityQueue {

	private final int SIZE = 32;
	private MyEdge[] pqArray;
	private int currentPQSize;

	public MyPriorityQueue() {
		pqArray = new MyEdge[SIZE];
		currentPQSize = 0;
	}

	public void insertEdge(MyEdge theEdge) {
		int i;

		for (i = 0; i < currentPQSize; i++)
			if (theEdge.getDistance() >= pqArray[i].getDistance())
				break;

		for (int j = currentPQSize - 1; j >= i; j--)
			pqArray[j + 1] = pqArray[j];

		pqArray[i] = theEdge;
		currentPQSize++;
	}

	public MyEdge getMinEdge() {
		return pqArray[currentPQSize - 1];
	}

	public MyEdge removeMinEdge() {
		return pqArray[--currentPQSize];
	}

	public MyEdge getEdgeByIndex(int index) {
		return pqArray[index];
	}

	public void removeEdgeByIndex(int index) {
		for (int i = index; i < currentPQSize - 1; i++)
			pqArray[i] = pqArray[i + 1];
		currentPQSize--;
	}

	public int findEdgeIndexByEndVertex(int endVertex) {
		for (int i = 0; i < currentPQSize; i++)
			if (pqArray[i].getEndVertex() == endVertex)
				return i;
		return -1;
	}

	public boolean isEmpty() {
		return currentPQSize == 0;
	}
}
