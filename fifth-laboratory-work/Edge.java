/*
 * Класс ребра графа.
 */
public class Edge<T> {

	private T startVertex;
	private T endVertex;
	private int distance;

	public Edge(T startVertex, T endVertex, int distance) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public T getEndVertex() {
		return endVertex;
	}

	public T getStartVertex() {
		return startVertex;
	}
}
