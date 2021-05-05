import java.util.Stack;

/*
 * Класс ориентированного НЕвзвешенного графа, реализованного через матрицу смежности.
 */
public class MyOrientedGraph {

	private final int MAX_NUMBER_OF_VERTEXES = 32;
	private MyVertex arrayOfVertexes[];
	private int adjacencyMatrix[][];
	private int currentNumberOfVertexes;

	public MyOrientedGraph() {
		arrayOfVertexes = new MyVertex[MAX_NUMBER_OF_VERTEXES];

		currentNumberOfVertexes = 0;

		adjacencyMatrix = new int[MAX_NUMBER_OF_VERTEXES][MAX_NUMBER_OF_VERTEXES];
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

		arrayOfVertexes[firstVertexNumber].setInTree(true);

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
				arrayOfVertexes[indexOfAdjUnvisitedVertex].setInTree(true);
				pathArray[elementsInPath++] = indexOfAdjUnvisitedVertex;
				theStack.push(indexOfAdjUnvisitedVertex);
				if (indexOfAdjUnvisitedVertex == secondVertexNumber)
					isPathExist = true;
			}
		}

		// Сброс флагов
		for (int i = 0; i < currentNumberOfVertexes; i++)
			arrayOfVertexes[i].setInTree(false);

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
			if (adjacencyMatrix[vertexIndex][currentAdjVertex] == 1 && !arrayOfVertexes[currentAdjVertex].isInTree())
				return currentAdjVertex;
		return -1;
	}

	public void traverseInDepth() {
		System.out.println("Последовательный обход графа,");
		for (int vertexNumber = 0; vertexNumber < currentNumberOfVertexes; vertexNumber++) {
			System.out.print(" начиная с " + vertexNumber + ": ");
			arrayOfVertexes[vertexNumber].setInTree(true);
			displayVertex(vertexNumber);

			Stack<Integer> theStack = new Stack<Integer>();
			theStack.push(vertexNumber);

			while (!theStack.isEmpty()) {
				// Получение непосещенной вершины, смежной к текущей
				int indexOfAdjUnvisitedVertex = getAdjUnvisitedVertex(theStack.peek());

				if (indexOfAdjUnvisitedVertex == -1)
					theStack.pop();
				else {
					arrayOfVertexes[indexOfAdjUnvisitedVertex].setInTree(true);
					displayVertex(indexOfAdjUnvisitedVertex);
					theStack.push(indexOfAdjUnvisitedVertex);
				}
			}

			// Сброс флагов
			for (int i = 0; i < currentNumberOfVertexes; i++)
				arrayOfVertexes[i].setInTree(false);

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

		for (int k = 0; k < currentNumberOfVertexes; k++)
			for (int i = 0; i < currentNumberOfVertexes; i++)
				if (transitiveClosureOfGraph[i][k] == 1)
					for (int j = 0; j < currentNumberOfVertexes; j++)
						if (transitiveClosureOfGraph[k][j] == 1)
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
