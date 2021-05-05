/*
 * Класс ребра графа НЕориентированного взвешенного графа.
 */
public class WeightedGraphEdge extends Edge<WeightedGraphVertex> {

	public WeightedGraphEdge(WeightedGraphVertex startVertex, WeightedGraphVertex endVertex, int distance) {
		super(startVertex, endVertex, distance);
	}

}