/*
 * Интерфейс бинарного дерева поиска, содержащий базовые операции с деревьями: поиск, вставка и удаление узлов (и вспомогательными).
 */
public interface IBinarySearchTree<T> {
	MyBinarySearchTreeNode<T> findNode(int key);
	boolean insertNode(int key, T value);
	boolean removeNode(int key);
	boolean isTreeEmpty();
}
