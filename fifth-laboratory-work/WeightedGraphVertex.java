/*
 * Класс вершины НЕориентированного взвешенного графа графа.
 */
public class WeightedGraphVertex extends Vertex {

	private boolean isInTree;

	public WeightedGraphVertex(int vertexNumber) {
		super(vertexNumber);
		isInTree = false;
	}

	public boolean isInTree() {
		return isInTree;
	}

	public void setInTree(boolean isInTree) {
		this.isInTree = isInTree;
	}

}
