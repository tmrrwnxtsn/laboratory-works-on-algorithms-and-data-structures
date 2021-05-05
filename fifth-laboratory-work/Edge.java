/*
 * Класс ребра графа.
 */
public class Edge {

	private Vertex startVertex;
	private Vertex endVertex;
	private int distance;

	public Edge(Vertex startVertex, Vertex endVertex, int distance) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public Vertex getEndVertex() {
		return endVertex;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}
}
