
public class Main {

	public static void main(String[] args) {
		MyGraph theGraph = new MyGraph(true);
		theGraph.addVertex(0);
		theGraph.addVertex(1);
		theGraph.addVertex(2);
		theGraph.addVertex(3);
		theGraph.addVertex(4);
		theGraph.addEdge(1, 0);
		theGraph.addEdge(0, 2);
		theGraph.addEdge(1, 4);
		theGraph.addEdge(4, 2);
		theGraph.addEdge(3, 4);
		System.out.println("Visits: ");
		theGraph.traverseInDepth(); // Обход в глубину
		System.out.println();
	}

}
