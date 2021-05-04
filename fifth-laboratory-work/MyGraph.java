/*
 * Класс направленного (ориентированного) невзвешенного графа, реализованного через матрицу смежности.
 */
public class MyGraph {

	private final int MAX_NUMBER_OF_VERTEXES = 32;
	private MyVertex arrayOfVertexes[];
	private int adjacencyMatrix[][];
	private int currentNumberOfVertexes;

	public MyGraph(boolean isDirected) {
		arrayOfVertexes = new MyVertex[MAX_NUMBER_OF_VERTEXES];

		adjacencyMatrix = new int[MAX_NUMBER_OF_VERTEXES][MAX_NUMBER_OF_VERTEXES];
		currentNumberOfVertexes = 0;
		for (int i = 0; i < MAX_NUMBER_OF_VERTEXES; i++)
			for (int j = 0; j < MAX_NUMBER_OF_VERTEXES; j++)
				adjacencyMatrix[i][j] = 0;
	}

	public void addVertex(int vertexID) {
		arrayOfVertexes[currentNumberOfVertexes++] = new MyVertex(vertexID);
	}

	public void addEdge(int start, int end) {
		adjacencyMatrix[start][end] = 1;
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

	// Последовательный обход графа в глубину с каждой вершины
	public void traverseInDepth() {
		for (int vertexIndex = 0; vertexIndex < currentNumberOfVertexes; vertexIndex++) {
			arrayOfVertexes[vertexIndex].visitVertex(true);
			displayVertex(vertexIndex);

			MyStack theStack = new MyStack();
			theStack.push(vertexIndex);

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

			System.out.println();
		}
	}

	// Алгоритм Флойда-Уоршалла (преобразование матрицы смежности в транзитивное
	// замыкание графа)
	public int[][] floydWarshallAlgorithm() {
		int transitiveClosureOfGraph[][] = new int[currentNumberOfVertexes][currentNumberOfVertexes];

		// Копируем матрицу смежности, чтобы построить видоизменённую матрицу смежности
		// согласно данному алгоритму
		for (int i = 0; i < currentNumberOfVertexes; i++)
			for (int j = 0; j < currentNumberOfVertexes; j++)
				transitiveClosureOfGraph[i][j] = adjacencyMatrix[i][j];

		// Перебираем строки
		for (int k = 0; k < currentNumberOfVertexes; k++)
			// Перебираем все ячейки текущей строки
			for (int i = 0; i < currentNumberOfVertexes; i++)
				// Если в ячейке (i, k) обнаруживается 1, значит, в графе существует ребро от k
				// к i
				if (transitiveClosureOfGraph[i][k] == 1)
					// Просматриваем ячейки в столбце k и ищем ребро, завершающееся в k
					for (int j = 0; j < currentNumberOfVertexes; j++)
						// Если элемент на пересечении столбца k со строкой j содержит 1, значит,
						// существует ребро от j к k
						if (transitiveClosureOfGraph[k][j] == 1)
							// Из факта существования двух ребер — от j к k и от k к i — делается вывод о
							// существовании пути от j к i
							transitiveClosureOfGraph[i][j] = 1;

		return transitiveClosureOfGraph;
	}

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
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
