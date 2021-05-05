/*
 * Класс для работы с графами.
 */
public class GraphsApp {

	public static void main(String[] args) {
		MyWeightedGraph theWeightedGraph = getWeightedGraph(1);
		theWeightedGraph.findMinimumSpanningTree(3);

		MyOrientedGraph theOrientedGraph = getOrientedGraph(1);
		theOrientedGraph.traverseInDepth();
		theOrientedGraph.displayMatrix(theOrientedGraph.getAdjacencyMatrix());
		theOrientedGraph.displayMatrix(theOrientedGraph.warshallAlgorithm());
		theOrientedGraph.getPathFromFirstVToSecondV(1, 6);
		System.out.println(theOrientedGraph.isVertexNumberInGraph(9));

	}

	public static MyWeightedGraph getWeightedGraph(int typeOfGraph) {
		MyWeightedGraph theWeightedGraph = new MyWeightedGraph();
		switch (typeOfGraph) {
		case 1:
			theWeightedGraph.addVertex(0);
			theWeightedGraph.addVertex(1);
			theWeightedGraph.addVertex(2);
			theWeightedGraph.addVertex(3);
			theWeightedGraph.addVertex(4);
			theWeightedGraph.addEdge(0, 1, 1);
			theWeightedGraph.addEdge(1, 2, 3);
			theWeightedGraph.addEdge(2, 3, 2);
			theWeightedGraph.addEdge(3, 0, 5);
			theWeightedGraph.addEdge(4, 0, 3);
			theWeightedGraph.addEdge(4, 1, 6);
			theWeightedGraph.addEdge(4, 2, 2);
			theWeightedGraph.addEdge(4, 3, 1);
			break;
		case 2:
			theWeightedGraph.addVertex(0);
			theWeightedGraph.addVertex(1);
			theWeightedGraph.addVertex(2);
			theWeightedGraph.addVertex(3);
			theWeightedGraph.addVertex(4);
			theWeightedGraph.addVertex(5);
			theWeightedGraph.addEdge(0, 1, 6);
			theWeightedGraph.addEdge(0, 3, 4);
			theWeightedGraph.addEdge(1, 2, 10);
			theWeightedGraph.addEdge(1, 3, 7);
			theWeightedGraph.addEdge(1, 4, 7);
			theWeightedGraph.addEdge(2, 3, 8);
			theWeightedGraph.addEdge(2, 4, 5);
			theWeightedGraph.addEdge(2, 5, 6);
			theWeightedGraph.addEdge(3, 4, 12);
			theWeightedGraph.addEdge(4, 5, 7);
			break;
		case 3:
			theWeightedGraph.addVertex(0);
			theWeightedGraph.addVertex(1);
			theWeightedGraph.addVertex(2);
			theWeightedGraph.addVertex(3);
			theWeightedGraph.addVertex(4);
			theWeightedGraph.addVertex(5);
			theWeightedGraph.addVertex(6);
			theWeightedGraph.addEdge(0, 1, 5);
			theWeightedGraph.addEdge(0, 6, 15);
			theWeightedGraph.addEdge(1, 6, 7);
			theWeightedGraph.addEdge(2, 6, 5);
			theWeightedGraph.addEdge(2, 4, 15);
			theWeightedGraph.addEdge(2, 3, 5);
			theWeightedGraph.addEdge(3, 6, 5);
			theWeightedGraph.addEdge(3, 4, 5);
			theWeightedGraph.addEdge(3, 5, 1);
			theWeightedGraph.addEdge(4, 5, 3);
			theWeightedGraph.addEdge(4, 6, 5);
			theWeightedGraph.addEdge(5, 6, 25);
			break;
		}
		return theWeightedGraph;
	}

	public static MyOrientedGraph getOrientedGraph(int typeOfGraph) {
		MyOrientedGraph theDirectedGraph = new MyOrientedGraph();
		switch (typeOfGraph) {
		case 1:
			theDirectedGraph.addVertex(0);
			theDirectedGraph.addVertex(1);
			theDirectedGraph.addVertex(2);
			theDirectedGraph.addVertex(3);
			theDirectedGraph.addVertex(4);
			theDirectedGraph.addEdge(0, 1);
			theDirectedGraph.addEdge(1, 2);
			theDirectedGraph.addEdge(2, 3);
			theDirectedGraph.addEdge(3, 0);
			theDirectedGraph.addEdge(4, 0);
			theDirectedGraph.addEdge(4, 1);
			theDirectedGraph.addEdge(4, 2);
			theDirectedGraph.addEdge(4, 3);
			break;
		case 2:
			theDirectedGraph.addVertex(0);
			theDirectedGraph.addVertex(1);
			theDirectedGraph.addVertex(2);
			theDirectedGraph.addVertex(3);
			theDirectedGraph.addVertex(4);
			theDirectedGraph.addVertex(5);
			theDirectedGraph.addEdge(0, 1);
			theDirectedGraph.addEdge(0, 3);
			theDirectedGraph.addEdge(1, 2);
			theDirectedGraph.addEdge(1, 3);
			theDirectedGraph.addEdge(1, 4);
			theDirectedGraph.addEdge(2, 3);
			theDirectedGraph.addEdge(2, 4);
			theDirectedGraph.addEdge(2, 5);
			theDirectedGraph.addEdge(3, 4);
			theDirectedGraph.addEdge(4, 5);
			break;
		case 3:
			theDirectedGraph.addVertex(0);
			theDirectedGraph.addVertex(1);
			theDirectedGraph.addVertex(2);
			theDirectedGraph.addVertex(3);
			theDirectedGraph.addVertex(4);
			theDirectedGraph.addVertex(5);
			theDirectedGraph.addVertex(6);
			theDirectedGraph.addEdge(0, 1);
			theDirectedGraph.addEdge(0, 6);
			theDirectedGraph.addEdge(1, 6);
			theDirectedGraph.addEdge(2, 6);
			theDirectedGraph.addEdge(2, 4);
			theDirectedGraph.addEdge(2, 3);
			theDirectedGraph.addEdge(3, 6);
			theDirectedGraph.addEdge(3, 4);
			theDirectedGraph.addEdge(3, 5);
			theDirectedGraph.addEdge(4, 5);
			theDirectedGraph.addEdge(4, 6);
			theDirectedGraph.addEdge(5, 6);
			break;
		}
		return theDirectedGraph;
	}
}
