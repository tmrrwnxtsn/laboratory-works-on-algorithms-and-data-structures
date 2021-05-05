/*
 * Класс вершины ориентированного НЕвзвешенного графа.
 */
public class OrientedGraphVertex extends Vertex {

	private boolean wasVisited;

	public OrientedGraphVertex(int vertexNumber) {
		super(vertexNumber);
		wasVisited = false;
	}

	public boolean isWasVisited() {
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}

}
