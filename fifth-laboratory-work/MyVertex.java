/*
 * Класс вершины графа.
 */
public class MyVertex {

	private int vertexNumber;
	private boolean isInTree;

	public MyVertex(int vertexNumber) {
		this.vertexNumber = vertexNumber;
		isInTree = false;
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public boolean isInTree() {
		return isInTree;
	}

	public void setInTree(boolean isInTree) {
		this.isInTree = isInTree;
	}
}
