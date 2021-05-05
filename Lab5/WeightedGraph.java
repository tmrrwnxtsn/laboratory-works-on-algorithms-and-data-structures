import java.util.LinkedList;

/*
 * Класс НЕориентированного взвешенного графа, реализованного через списки смежности.
 */
public class WeightedGraph {

	private final int MAX_NUMBER_OF_VERTEXES = 32;
	private WeightedGraphVertex arrayOfVertexes[];
	private LinkedList<WeightedGraphEdge> adjLists[];
	private MyPriorityQueue thePQ;
	private int currentVertexNumber;
	private int currentNumberOfVertexes;

	@SuppressWarnings("unchecked")
	public WeightedGraph() {
		arrayOfVertexes = new WeightedGraphVertex[MAX_NUMBER_OF_VERTEXES];

		currentNumberOfVertexes = 0;

		adjLists = new LinkedList[MAX_NUMBER_OF_VERTEXES];
		for (int i = 0; i < MAX_NUMBER_OF_VERTEXES; i++)
			adjLists[i] = new LinkedList<WeightedGraphEdge>();

		thePQ = new MyPriorityQueue();
	}

	public void addVertex(int vertexNumber) {
		arrayOfVertexes[currentNumberOfVertexes++] = new WeightedGraphVertex(vertexNumber);
	}

	public void addEdge(int startVertexNumber, int endVertexNumber, int distance) {
		WeightedGraphVertex startVertex = new WeightedGraphVertex(startVertexNumber);
		WeightedGraphVertex endVertex = new WeightedGraphVertex(endVertexNumber);

		WeightedGraphEdge edgeFromStartToEnd = new WeightedGraphEdge(startVertex, endVertex, distance);
		WeightedGraphEdge edgeFromEndToStart = new WeightedGraphEdge(endVertex, startVertex, distance);

		adjLists[startVertexNumber].add(edgeFromStartToEnd);
		adjLists[endVertexNumber].add(edgeFromEndToStart);
	}

	public void putInPQ(WeightedGraphEdge newEdge, int newEdgeDistance) {
		int pqIndex = thePQ.findEdgeIndexByEndVertex(newEdge.getEndVertex().getVertexNumber());
		// Если ребро существует, получить его
		if (pqIndex != -1) {
			WeightedGraphEdge tempEdge = thePQ.getEdgeByIndex(pqIndex);
			int oldDistance = tempEdge.getDistance();
			// Если новое ребро короче
			if (oldDistance > newEdgeDistance) {
				thePQ.removeEdgeByIndex(pqIndex);
				thePQ.insertEdge(newEdge);
			}
		} else
			thePQ.insertEdge(newEdge);
	}

	public void findMinimumSpanningTree(int start) {
		System.out.print("Минимальное остовное дерево: ");

		currentVertexNumber = start;
		int currentNumberOfTreeVertexes = 0;
		int minimumSpanningTreeWeight = 0;

		while (currentNumberOfTreeVertexes < currentNumberOfVertexes - 1) {
			arrayOfVertexes[currentVertexNumber].setInTree(true);
			currentNumberOfTreeVertexes++;

			LinkedList<WeightedGraphEdge> listOfAdjacentVertexesToCurrent = adjLists[currentVertexNumber];

			for (int i = 0; i < listOfAdjacentVertexesToCurrent.size(); i++) {
				WeightedGraphEdge iAdjEdge = listOfAdjacentVertexesToCurrent.get(i);

				int iAdjVertex = iAdjEdge.getEndVertex().getVertexNumber();

				// Пропустить, если вершина уже есть в МОД
				if (arrayOfVertexes[iAdjVertex].isInTree())
					continue;

				putInPQ(iAdjEdge, iAdjEdge.getDistance());
			}

			if (thePQ.isEmpty()) {
				System.out.println("Граф несвязный!");
				return;
			}

			// Удаление ребра с минимальным расстоянием из очереди
			WeightedGraphEdge theEdgeWithMinDistance = thePQ.removeMinEdge();
			int startVertexNumber = theEdgeWithMinDistance.getStartVertex().getVertexNumber();
			currentVertexNumber = theEdgeWithMinDistance.getEndVertex().getVertexNumber();
			minimumSpanningTreeWeight += theEdgeWithMinDistance.getDistance();

			System.out.print(startVertexNumber + "" + currentVertexNumber + " ");
		}

		for (int i = 0; i < currentNumberOfVertexes; i++)
			arrayOfVertexes[i].setInTree(false);

		System.out.println("(Вес: " + minimumSpanningTreeWeight + ")");
	}

	public void displayConnectivityTable() {
		System.out.println("Списки смежности (вершина: смежные с ней вершины, написанные через пробел):");
		for (int i = 0; i < currentNumberOfVertexes; i++) {
			LinkedList<WeightedGraphEdge> arrayOfAdjacentVertexesToI = adjLists[i];
			System.out.print(i + ": ");
			for (int j = 0; j < arrayOfAdjacentVertexesToI.size(); j++)
				System.out.print(arrayOfAdjacentVertexesToI.get(j).getEndVertex().getVertexNumber() + " ");
			System.out.println();
		}
	}
}
