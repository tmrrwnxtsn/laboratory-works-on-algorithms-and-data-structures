/*
 * Класс ребра графа MyWeightedGraph.
 */
public class MyEdge {

	private int startVertexNumber;
	private int endVertexNumber;
	private int distance;

	public MyEdge(int startVertexNumber, int endVertexNumber, int distance) {
		this.startVertexNumber = startVertexNumber;
		this.endVertexNumber = endVertexNumber;
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public int getEndVertex() {
		return endVertexNumber;
	}

	public int getStartVertex() {
		return startVertexNumber;
	}
}