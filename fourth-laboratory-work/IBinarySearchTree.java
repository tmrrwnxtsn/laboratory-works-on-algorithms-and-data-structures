/*
 * Интерфейс бинарного дерева поиска, содержащий базовые операции с деревьями (поиск, вставка и удаление узлов) и дополнительные (обходы: симметричный, прямой и обратный).
 */
public interface IBinarySearchTree<T> {
	
	MyBinarySearchTreeNode<T> findNode(int key);
	
	boolean insertNode(int key, T value);
	
	boolean removeNode(int key);
	
	boolean isTreeEmpty();
	
	void traversePreOrder(MyBinarySearchTreeNode<T> root);
	
	void traverseInOrder(MyBinarySearchTreeNode<T> root);
	
	void traversePostOrder(MyBinarySearchTreeNode<T> root);
}
