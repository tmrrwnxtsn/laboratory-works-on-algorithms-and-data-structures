/*
 * Класс графа, реализованного через матрицу смежности.
 */
public class MyGraph {

	private final int MAX_NUMBER_OF_VERTEXES = 32;
	private MyVertex arrayOfVertexes[];
	private int adjacencyMatrix[][];
	private int currentNumberOfVertexes;
	private boolean isDirected;

	public MyGraph(boolean isDirected) {
		arrayOfVertexes = new MyVertex[MAX_NUMBER_OF_VERTEXES];

		adjacencyMatrix = new int[MAX_NUMBER_OF_VERTEXES][MAX_NUMBER_OF_VERTEXES];
		currentNumberOfVertexes = 0;
		for (int i = 0; i < MAX_NUMBER_OF_VERTEXES; i++)
			for (int j = 0; j < MAX_NUMBER_OF_VERTEXES; j++)
				adjacencyMatrix[i][j] = 0;

		this.isDirected = isDirected;
	}

	public void addVertex(int vertexID) {
		arrayOfVertexes[currentNumberOfVertexes++] = new MyVertex(vertexID);
	}

	public void addEdge(int start, int end, int edgeWeight) {
		adjacencyMatrix[start][end] = edgeWeight;
		if (!isDirected)
			adjacencyMatrix[end][start] = edgeWeight;
	}

	public void displayVertex(int vertexIndex) {
		System.out.print(arrayOfVertexes[vertexIndex].getVertexID());
	}

	// Метод возвращает непосещенную вершину, смежную по отношению к vertexIndex
	private int getAdjUnvisitedVertex(int vertexIndex) {
		for (int currentAdjVertex = 0; currentAdjVertex < currentNumberOfVertexes; currentAdjVertex++)
			if (adjacencyMatrix[vertexIndex][currentAdjVertex] == 1 && !arrayOfVertexes[currentAdjVertex].wasVisited())
				return currentAdjVertex;
		return -1;
	}

	// Обход графа в глубину
	public void traverseInDepth() {
		arrayOfVertexes[0].visitVertex(true);
		displayVertex(0);

		MyStack theStack = new MyStack();
		theStack.push(0);

		while (!theStack.isEmpty()) {
			// Получение непосещенной вершины, смежной к текущей
			int indexOfAdjUnvisitedVertex = getAdjUnvisitedVertex(theStack.getTopElement());

			if (indexOfAdjUnvisitedVertex == -1)
				theStack.pop();
			else {
				arrayOfVertexes[indexOfAdjUnvisitedVertex].visitVertex(true);
				displayVertex(indexOfAdjUnvisitedVertex);
				theStack.push(indexOfAdjUnvisitedVertex);
			}
		}

		// Сброс флагов
		for (int i = 0; i < currentNumberOfVertexes; i++)
			arrayOfVertexes[i].visitVertex(false);
	}

	// Обход графа в ширину
	public void traverseInWidth() {
		arrayOfVertexes[0].visitVertex(true);
		displayVertex(0);

		MyQueue theQueue = new MyQueue();
		theQueue.insert(0);

		while (!theQueue.isEmpty()) {
			int currentVertexIndex = theQueue.remove();

			int neighborOfCurrentVertexIndex = getAdjUnvisitedVertex(currentVertexIndex);
			// Пока остаются непосещенные соседи
			while (neighborOfCurrentVertexIndex != -1) {
				arrayOfVertexes[neighborOfCurrentVertexIndex].visitVertex(true);
				displayVertex(neighborOfCurrentVertexIndex);
				theQueue.insert(neighborOfCurrentVertexIndex);
				neighborOfCurrentVertexIndex = getAdjUnvisitedVertex(currentVertexIndex);
			}
		}

		// Сброс флагов
		for (int i = 0; i < currentNumberOfVertexes; i++)
			arrayOfVertexes[i].visitVertex(false);
	}

	// Алгоритм построения минимального оставного дерева через обход в глубину
	public void buildMinimumSpanningTree() {
		arrayOfVertexes[0].visitVertex(true);

		MyStack theStack = new MyStack();
		theStack.push(0);

		while (!theStack.isEmpty()) {
			int currentVertex = theStack.getTopElement();

			// Получение непосещенной вершины, смежной к текущей
			int indexOfAdjUnvisitedVertex = getAdjUnvisitedVertex(currentVertex);

			if (indexOfAdjUnvisitedVertex == -1)
				theStack.pop();
			else {
				arrayOfVertexes[indexOfAdjUnvisitedVertex].visitVertex(true);
				theStack.push(indexOfAdjUnvisitedVertex);

				// Вывод ребра от currentVertex к indexOfAdjUnvisitedVertex
				displayVertex(currentVertex);
				displayVertex(indexOfAdjUnvisitedVertex);
				System.out.print(" ");
			}
		}

		// Сброс флагов
		for (int i = 0; i < currentNumberOfVertexes; i++)
			arrayOfVertexes[i].visitVertex(false);
	}

	// Алгоритм Флойда-Уоршалла
	public int[][] floydWarshallAlgorithm() {
		int resultingMatrix[][] = new int[currentNumberOfVertexes][currentNumberOfVertexes];

		for (int i = 0; i < currentNumberOfVertexes; i++)
			for (int j = 0; j < currentNumberOfVertexes; j++)
				resultingMatrix[i][j] = adjacencyMatrix[i][j];

		for (int k = 0; k < currentNumberOfVertexes; k++)
			for (int i = 0; i < currentNumberOfVertexes; i++)
				for (int j = 0; j < currentNumberOfVertexes; j++)
					if (resultingMatrix[i][k] > 0 && resultingMatrix[k][j] > 0 && i != j)
						if (resultingMatrix[i][k] + resultingMatrix[k][j] < resultingMatrix[i][j]
								|| resultingMatrix[i][j] == 0)
							resultingMatrix[i][j] = resultingMatrix[i][k] + resultingMatrix[k][j];

		return resultingMatrix;
	}

	public void displayMatrix(int[][] matrix) {
		for (int i = 0; i < currentNumberOfVertexes; i++) {
			System.out.println();
			for (int j = 0; j < currentNumberOfVertexes; j++)
				System.out.print(matrix[i][j]);
		}
		System.out.println();
	}
}
