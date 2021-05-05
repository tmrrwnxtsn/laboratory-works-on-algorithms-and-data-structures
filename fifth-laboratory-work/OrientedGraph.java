import java.util.Stack;

/*
 * Класс ориентированного НЕвзвешенного графа, реализованного через матрицу смежности.
 */
public class OrientedGraph {

	private final int MAX_NUMBER_OF_VERTEXES = 32;
	private OrientedGraphVertex arrayOfVertexes[];
	private int adjacencyMatrix[][];
	private int currentNumberOfVertexes;

	public OrientedGraph() {
		arrayOfVertexes = new OrientedGraphVertex[MAX_NUMBER_OF_VERTEXES];

		currentNumberOfVertexes = 0;

		adjacencyMatrix = new int[MAX_NUMBER_OF_VERTEXES][MAX_NUMBER_OF_VERTEXES];
		for (int i = 0; i < MAX_NUMBER_OF_VERTEXES; i++)
			for (int j = 0; j < MAX_NUMBER_OF_VERTEXES; j++)
				adjacencyMatrix[i][j] = 0;
	}

	public void addVertex(int vertexID) {
		arrayOfVertexes[currentNumberOfVertexes++] = new OrientedGraphVertex(vertexID);
	}

	public void addEdge(int start, int end) {
		adjacencyMatrix[start][end] = 1;
	}

	public boolean isVertexNumberInGraph(int vertexNumber) {
		for (int i = 0; i < currentNumberOfVertexes; i++)
			if (arrayOfVertexes[i].getVertexNumber() == vertexNumber)
				return true;
		return false;
	}

	public void getPathFromFirstVToSecondV(int firstVertexNumber, int secondVertexNumber) {
		if (!isVertexNumberInGraph(firstVertexNumber) || !isVertexNumberInGraph(secondVertexNumber)) {
			System.out.println("Не удалось найти путь от " + firstVertexNumber + " до " + secondVertexNumber);
			return;
		}

		arrayOfVertexes[firstVertexNumber].setWasVisited(true);

		Stack<Integer> theStack = new Stack<Integer>();
		theStack.push(firstVertexNumber);

		int[] pathArray = new int[currentNumberOfVertexes];
		pathArray[0] = firstVertexNumber;
		int elementsInPath = 1;
		boolean isPathExist = false;

		while (!theStack.isEmpty() && !isPathExist) {
			// Получение непосещенной вершины, смежной к текущей
			int indexOfAdjUnvisitedVertex = getAdjUnvisitedVertex(theStack.peek());

			if (indexOfAdjUnvisitedVertex == -1)
				theStack.pop();
			else {
				arrayOfVertexes[indexOfAdjUnvisitedVertex].setWasVisited(true);
				pathArray[elementsInPath++] = indexOfAdjUnvisitedVertex;
				theStack.push(indexOfAdjUnvisitedVertex);
				if (indexOfAdjUnvisitedVertex == secondVertexNumber)
					isPathExist = true;
			}
		}

		// Сброс флагов
		for (int i = 0; i < currentNumberOfVertexes; i++)
			arrayOfVertexes[i].setWasVisited(false);

		if (isPathExist) {
			System.out.println("Путь от " + firstVertexNumber + " до " + secondVertexNumber + ": ");
			for (int i = 0; i < elementsInPath; i++)
				System.out.print(pathArray[i]);
		} else
			System.out.println("Не удалось найти путь от " + firstVertexNumber + " до " + secondVertexNumber);
	}

	// Метод возвращает непосещенную вершину, смежную по отношению к vertexIndex
	private int getAdjUnvisitedVertex(int vertexIndex) {
		for (int currentAdjVertex = 0; currentAdjVertex < currentNumberOfVertexes; currentAdjVertex++)
			if (adjacencyMatrix[vertexIndex][currentAdjVertex] == 1
					&& !arrayOfVertexes[currentAdjVertex].isWasVisited())
				return currentAdjVertex;
		return -1;
	}

	public void traverseInDepth() {
		System.out.println("Последовательный обход графа,");
		for (int vertexNumber = 0; vertexNumber < currentNumberOfVertexes; vertexNumber++) {
			System.out.print(" начиная с " + vertexNumber + ": ");
			arrayOfVertexes[vertexNumber].setWasVisited(true);
			displayVertex(vertexNumber);

			Stack<Integer> theStack = new Stack<Integer>();
			theStack.push(vertexNumber);

			while (!theStack.isEmpty()) {
				// Получение непосещенной вершины, смежной к текущей
				int indexOfAdjUnvisitedVertex = getAdjUnvisitedVertex(theStack.peek());

				if (indexOfAdjUnvisitedVertex == -1)
					theStack.pop();
				else {
					arrayOfVertexes[indexOfAdjUnvisitedVertex].setWasVisited(true);
					displayVertex(indexOfAdjUnvisitedVertex);
					theStack.push(indexOfAdjUnvisitedVertex);
				}
			}

			// Сброс флагов
			for (int i = 0; i < currentNumberOfVertexes; i++)
				arrayOfVertexes[i].setWasVisited(false);

			System.out.println();
		}
	}

	// Преобразование матрицы смежности в транзитивное замыкание графа
	public int[][] warshallAlgorithm() {
		int transitiveClosureOfGraph[][] = new int[currentNumberOfVertexes][currentNumberOfVertexes];

		// Копируем матрицу смежности, чтобы построить транзитивное замыкание графа
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
		System.out.println("Матрица:");
		System.out.print("   ");
		for (int i = 0; i < currentNumberOfVertexes; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.print(" |");
		for (int i = 1; i < currentNumberOfVertexes; i++)
			System.out.print("‾‾");
		System.out.println("‾‾");
		for (int i = 0; i < currentNumberOfVertexes; i++) {
			System.out.print(i + "| ");
			for (int j = 0; j < currentNumberOfVertexes; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public void displayVertex(int vertexIndex) {
		System.out.print(arrayOfVertexes[vertexIndex].getVertexNumber() + " ");
	}
}
