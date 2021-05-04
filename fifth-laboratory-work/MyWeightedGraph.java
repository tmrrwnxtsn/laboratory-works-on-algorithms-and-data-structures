import java.util.LinkedList;

/*
 * Класс НЕориентированного взвешенного графа, реализованного через списки смежности.
 */
public class MyWeightedGraph {

	private final int MAX_NUMBER_OF_VERTEXES = 32;
	private MyVertex arrayOfVertexes[];
	private int currentNumberOfVertexes;
	private LinkedList<MyEdge> adjLists[];
	private int currentVertex;
	private MyPriorityQueue thePQ;

	@SuppressWarnings("unchecked")
	public MyWeightedGraph() {
		arrayOfVertexes = new MyVertex[MAX_NUMBER_OF_VERTEXES];

		currentNumberOfVertexes = 0;

		adjLists = new LinkedList[MAX_NUMBER_OF_VERTEXES];
		for (int i = 0; i < MAX_NUMBER_OF_VERTEXES; i++)
			adjLists[i] = new LinkedList<MyEdge>();

		thePQ = new MyPriorityQueue();
	}

	public void addVertex(int vertexID) {
		arrayOfVertexes[currentNumberOfVertexes++] = new MyVertex(vertexID);
	}

	public void addEdge(int vertex, int adjVertex, int distance) {
		adjLists[vertex].add(new MyEdge(vertex, adjVertex, distance));
		adjLists[adjVertex].add(new MyEdge(adjVertex, vertex, distance));
	}

	public void putInPQ(int newVertex, int newDistance) {
		// Существует ли другое ребро с той же конечной вершиной?
		// Получение индекса
		int pqIndex = thePQ.findEdgeIndexByEndVertex(newVertex);
		// Если ребро существует, получить его
		if (pqIndex != -1) {
			MyEdge tempEdge = thePQ.getEdgeByIndex(pqIndex);
			int oldDistance = tempEdge.getDistance();
			// Если новое ребро короче
			if (oldDistance > newDistance) {
				// Удалить старое ребро
				thePQ.removeEdgeByIndex(pqIndex);
				MyEdge theEdge = new MyEdge(currentVertex, newVertex, newDistance);
				// Вставка нового ребра
				thePQ.insertEdge(theEdge);
			}
			// Иначе ничего не делается: оставляем старую вершину
		} else { // Ребра с той же конечной вершиной не существует
			MyEdge theEdge = new MyEdge(currentVertex, newVertex, newDistance);
			// Вставка нового ребра
			thePQ.insertEdge(theEdge);
		}
	}

	public void findMinimumSpanningTree(int start) {
		System.out.print("Минимальное остовное дерево: ");

		currentVertex = start;
		int currentNumberOfTreeVertexes = 0;
		int minimumSpanningTreeWeight = 0;

		while (currentNumberOfTreeVertexes < currentNumberOfVertexes - 1) {
			arrayOfVertexes[currentVertex].setInTree(true);
			currentNumberOfTreeVertexes++;

			LinkedList<MyEdge> listOfAdjacentVertexesToCurrent = adjLists[currentVertex];

			for (int i = 0; i < listOfAdjacentVertexesToCurrent.size(); i++) {
				MyEdge iAdjEdge = listOfAdjacentVertexesToCurrent.get(i);

				int iAdjVertex = iAdjEdge.getEndVertex();

				// Пропустить, если вершина уже есть в МОД
				if (arrayOfVertexes[iAdjVertex].isInTree())
					continue;

				int iAdjEdgeWeight = iAdjEdge.getDistance();

				putInPQ(iAdjVertex, iAdjEdgeWeight);
			}

			if (thePQ.isEmpty()) {
				System.out.println("Граф несвязный!");
				return;
			}

			// Удаление ребра с минимальным расстоянием из очереди
			MyEdge theEdgeWithMinDistance = thePQ.removeMinEdge();
			int startVertex = theEdgeWithMinDistance.getStartVertex();
			currentVertex = theEdgeWithMinDistance.getEndVertex();
			minimumSpanningTreeWeight += theEdgeWithMinDistance.getDistance();

			System.out.print(startVertex + "" + currentVertex + " ");
		}

		for (int i = 0; i < currentNumberOfVertexes; i++)
			arrayOfVertexes[i].setInTree(false);

		System.out.println("(Вес: " + minimumSpanningTreeWeight + ")");
	}

	public void displayAdjacencyLists() {
		System.out.println("Списки смежности (вершина: смежные с ней вершины, написанные через пробел):");
		for (int i = 0; i < currentNumberOfVertexes; i++) {
			LinkedList<MyEdge> arrayOfAdjacentVertexesToI = adjLists[i];
			System.out.print(i + ": ");
			for (int j = 0; j < arrayOfAdjacentVertexesToI.size(); j++)
				System.out.print(arrayOfAdjacentVertexesToI.get(j).getEndVertex() + " ");
			System.out.println();
		}
	}
}
