/*
 * Класс приоритетной очереди для поиска минимального остовного дерева у графа MyWeightedGraph. 
 */
public class MyPriorityQueue {

	private final int SIZE = 32;
	private WeightedGraphEdge[] pqArray;
	private int currentPQSize;

	public MyPriorityQueue() {
		pqArray = new WeightedGraphEdge[SIZE];
		currentPQSize = 0;
	}

	public void insertEdge(WeightedGraphEdge theEdge) {
		int i;

		for (i = 0; i < currentPQSize; i++)
			if (theEdge.getDistance() >= pqArray[i].getDistance())
				break;

		for (int j = currentPQSize - 1; j >= i; j--)
			pqArray[j + 1] = pqArray[j];

		pqArray[i] = theEdge;
		currentPQSize++;
	}

	public WeightedGraphEdge getMinEdge() {
		return pqArray[currentPQSize - 1];
	}

	public WeightedGraphEdge removeMinEdge() {
		return pqArray[--currentPQSize];
	}

	public WeightedGraphEdge getEdgeByIndex(int edgeIndex) {
		return pqArray[edgeIndex];
	}

	public void removeEdgeByIndex(int edgeIndex) {
		for (int i = edgeIndex; i < currentPQSize - 1; i++)
			pqArray[i] = pqArray[i + 1];
		currentPQSize--;
	}

	public int findEdgeIndexByEndVertex(int endVertexNumber) {
		for (int i = 0; i < currentPQSize; i++)
			if (pqArray[i].getEndVertex().getVertexNumber() == endVertexNumber)
				return i;
		return -1;
	}

	public boolean isEmpty() {
		return currentPQSize == 0;
	}
}
