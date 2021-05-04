/*
 * Класс вершины графа.
 */
public class MyVertex {

	private int vertexID;
	private boolean wasVisited;

	public MyVertex(int vertexID) {
		this.vertexID = vertexID;
	}

	public int getVertexID() {
		return vertexID;
	}

	public boolean wasVisited() {
		return wasVisited;
	}

	public void visitVertex(boolean flag) {
		wasVisited = flag;
	}
}
