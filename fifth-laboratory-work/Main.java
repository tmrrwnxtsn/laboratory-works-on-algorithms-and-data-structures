
public class Main {

	public static void main(String[] args) {
		MyGraph theGraph = new MyGraph(true);
		theGraph.addVertex(0); // 0 (исходная вершина)
		theGraph.addVertex(1); // 1
		theGraph.addVertex(2); // 2
		theGraph.addVertex(3); // 2
		theGraph.addVertex(4); // 2
		theGraph.addEdge(0, 2, 1); // AB
		theGraph.addEdge(1, 0, 1); // AE
		theGraph.addEdge(1, 4, 1); // BC
		theGraph.addEdge(3, 4, 1); // BC
		theGraph.addEdge(4, 2, 1); // BC

		theGraph.displayMatrix(theGraph.floydWarshallAlgorithm());
	}

}
