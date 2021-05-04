/*
 * Класс ребра графа MyWeightedGraph.
 */
public class MyEdge {

	private int startVertexIndex;
	private int endVertexIndex;
	private int distance;

	public MyEdge(int startVertexIndex, int endVertexIndex, int distance) {
		this.startVertexIndex = startVertexIndex;
		this.endVertexIndex = endVertexIndex;
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public int getEndVertex() {
		return endVertexIndex;
	}

	public int getStartVertex() {
		return startVertexIndex;
	}
}