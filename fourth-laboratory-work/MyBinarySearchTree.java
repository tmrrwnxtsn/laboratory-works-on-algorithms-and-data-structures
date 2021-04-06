
public class MyBinarySearchTree<T> implements IBinarySearchTree<T> {

	private MyBinarySearchTreeNode<T> root;

	@Override
	public MyBinarySearchTreeNode<T> findNode(int key) {
		
		if (isTreeEmpty()) {return null;}
		
		MyBinarySearchTreeNode<T> currentNode = root;
		
		while (currentNode.getKey() != key) {
			if (key < currentNode.getKey())
				currentNode = currentNode.getLeftChildNode();
			else
				currentNode = currentNode.getRightChildNode();
			if (currentNode == null)
				return null;
		}
		return currentNode;
	}

	@Override
	public void insertNode(int key, T value) {
		
		MyBinarySearchTreeNode<T> newNode = new MyBinarySearchTreeNode<T>(key, value);
		
		if (isTreeEmpty()) {
			root = newNode;
			return;
		}
			
		MyBinarySearchTreeNode<T> currentNode = root;
		MyBinarySearchTreeNode<T> parentOfCurrentNode = currentNode;
		
		while (true) {
			if (key < currentNode.getKey()) {
				currentNode = currentNode.getLeftChildNode();
				if (currentNode == null) {
					parentOfCurrentNode.setLeftChildNode(newNode);
					return;
				}
			}
			else {
				currentNode = currentNode.getRightChildNode();
				if (currentNode == null) {
					parentOfCurrentNode.setRightChildNode(newNode);
					return;
				}
			}
			parentOfCurrentNode = currentNode;
		}
	}
	
	/*
	 * Возвращает true, если удаление прошло успешно, иначе - false.
	 */
	@Override
	public boolean removeNode(int key) {
		
		if (isTreeEmpty()) {return false;}
		
		MyBinarySearchTreeNode<T> currentNode = root;
		MyBinarySearchTreeNode<T> parentOfCurrentNode = currentNode;
		boolean isCurrentNodeRightChild = true;
		
		while (currentNode.getKey() != key) {
			if (currentNode.getKey() < key) {
				currentNode = currentNode.getLeftChildNode();
				isCurrentNodeRightChild = false;
			}
			else {
				currentNode = currentNode.getRightChildNode();
				isCurrentNodeRightChild = true;
			}
			if (currentNode == null) {return false;} // Узел не найден
			
			parentOfCurrentNode = currentNode;
		}
		
		// Если у найденного узла нет потомков
		if (currentNode.getLeftChildNode() == null && currentNode.getRightChildNode() == null) {
			if (currentNode == root)
				root = null;
			else {
				if (isCurrentNodeRightChild)
					parentOfCurrentNode.setRightChildNode(null);
				else
					parentOfCurrentNode.setLeftChildNode(null);
			}
		}
		else {
			// Если у найденного узла есть 1 левый потомок
			if (currentNode.getRightChildNode() == null) {
				if (currentNode == root)
					root = currentNode.getLeftChildNode();
				else {
					if (isCurrentNodeRightChild) // Потомок найденного узла правый
						parentOfCurrentNode.setRightChildNode(currentNode.getLeftChildNode());
					else						 // Потомок найденного узла левый
						parentOfCurrentNode.setLeftChildNode(currentNode.getLeftChildNode());
				}
			}
			else {
				// Если у найденного узла есть 1 правый потомок
				if (currentNode.getLeftChildNode() == null) {
					if (currentNode == root) 
						root = currentNode.getRightChildNode();
					else {
						if (isCurrentNodeRightChild) // Потомок найденного узла правый
							parentOfCurrentNode.setRightChildNode(currentNode.getRightChildNode());
						else						 // Потомок найденного узла левый
							parentOfCurrentNode.setLeftChildNode(currentNode.getRightChildNode());
					}
				}
			}
		}
		
		return true;
	}

	@Override
	public boolean isTreeEmpty() {return root == null;}
}
