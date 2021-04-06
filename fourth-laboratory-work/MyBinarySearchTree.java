import java.util.Stack;

/*
 * Класс, реализующий интерфейс бинарного дерева поиска.
 */
public class MyBinarySearchTree<T> implements IBinarySearchTree<T> {

	private MyBinarySearchTreeNode<T> root;
	
	public MyBinarySearchTreeNode<T> getRoot() {return root;}

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
	
	/*
	 * Возвращает true, если удалось вставить узел, иначе - false.
	 */
	@Override
	public boolean insertNode(int key, T value) {
		
		MyBinarySearchTreeNode<T> newNode = new MyBinarySearchTreeNode<T>(key, value);
		
		if (isTreeEmpty()) {
			root = newNode;
			return true;
		}
			
		MyBinarySearchTreeNode<T> currentNode = root;
		MyBinarySearchTreeNode<T> parentOfCurrentNode = currentNode;
		
		while (true) {
			if (key < currentNode.getKey()) {
				currentNode = currentNode.getLeftChildNode();
				if (currentNode == null) {
					parentOfCurrentNode.setLeftChildNode(newNode);
					return true;
				}
			}
			else {
				if (key > currentNode.getKey()) {
					currentNode = currentNode.getRightChildNode();
					if (currentNode == null) {
						parentOfCurrentNode.setRightChildNode(newNode);
						return true;
					}
				}
				else
					return false;
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
		MyBinarySearchTreeNode<T> parentOfCurrentNode = root;
		boolean isCurrentNodeRightChild = true;
		
		while (currentNode.getKey() != key) {
			parentOfCurrentNode = currentNode;
			
			if (key < currentNode.getKey()) {
				isCurrentNodeRightChild = false;
				currentNode = currentNode.getLeftChildNode();
			}
			else {
				isCurrentNodeRightChild = true;
				currentNode = currentNode.getRightChildNode();
			}
			
			// Узел не найден
			if (currentNode == null) {return false;}
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
				else {
					// У найденного узла 2 потомка, заменяем найденный узел преемником
					MyBinarySearchTreeNode<T> successorNode = getSuccessor(currentNode);
					
					if (currentNode == root)
						root = successorNode;
					else {
						if (isCurrentNodeRightChild)
							parentOfCurrentNode.setRightChildNode(successorNode);
						else
							parentOfCurrentNode.setLeftChildNode(successorNode);
					}
					
					successorNode.setLeftChildNode(currentNode.getLeftChildNode());
				}
			}
		}
		return true;
	}
	
	/*
	 * Метод поиска преемника удаляемого узла (узел со следующим по величине ключом), которым будет заменяться узел с 2 потомками.
	 */
	private MyBinarySearchTreeNode<T> getSuccessor(MyBinarySearchTreeNode<T> removingNode) {
		
		MyBinarySearchTreeNode<T> successorParrentNode = removingNode;
		MyBinarySearchTreeNode<T> successorNode = removingNode;
		MyBinarySearchTreeNode<T> currentNode = removingNode.getRightChildNode();
		
		while (currentNode != null) {
			successorParrentNode = successorNode;
			successorNode = currentNode;
			currentNode = currentNode.getLeftChildNode();
		}
		
		if (successorNode != removingNode.getRightChildNode()) {
			successorParrentNode.setLeftChildNode(successorNode.getRightChildNode());
			successorNode.setRightChildNode(removingNode.getRightChildNode());
		}
		
		return successorNode;
	}

	@Override
	public boolean isTreeEmpty() {return root == null;}
	
	@Override
	public void traversePreOrder(MyBinarySearchTreeNode<T> root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			traversePreOrder(root.getLeftChildNode());
			traversePreOrder(root.getRightChildNode());
		}
	 }
	
	@Override
	public void traverseInOrder(MyBinarySearchTreeNode<T> root) {
		if (root != null) {
			 traverseInOrder(root.getLeftChildNode());
			 System.out.print(root.getData() + " ");
			 traverseInOrder(root.getRightChildNode());
		}
	 }

	@Override
	public void traversePostOrder(MyBinarySearchTreeNode<T> root) {
		if (root != null) {
			 traversePostOrder(root.getLeftChildNode());
			 traversePostOrder(root.getRightChildNode());
			 System.out.print(root.getData() + " ");
		}
	 }
	 
	 public void traverse(int traverseType) {
		 switch (traverseType) {
		 case 1: 
			 System.out.print("\nПрямой обход (вершина, левое поддерево, правое поддерево): ");
			 traversePreOrder(root);
			 break;
		 case 2: 
			 System.out.print("\nСимметричный обход (левое поддерево, вершина, правое поддерево): ");
			 traverseInOrder(root);
			 break;
		 case 3: 
			 System.out.print("\nОбратный обход (левое поддерево, правое поддерево, вершина): ");
			 traversePostOrder(root);
			 break;
		 }
		 System.out.println();
	 }
	 
	 @Override
	 public String toString() {
		 StringBuilder sb = new StringBuilder("_________________________________________________________________\n\n");
		 Stack<MyBinarySearchTreeNode<T>> globalStack = new Stack<MyBinarySearchTreeNode<T>>();
		 globalStack.push(root);
		 int nBlanks = 32;
		 boolean isRowEmpty = false;
		 while (isRowEmpty == false) {
			 Stack<MyBinarySearchTreeNode<T>> localStack = new Stack<MyBinarySearchTreeNode<T>>();
			 isRowEmpty = true;
			 for (int j = 0; j < nBlanks; j++)
				 sb.append(' ');
			 while (globalStack.isEmpty() == false) {
				 MyBinarySearchTreeNode<T> temp = (MyBinarySearchTreeNode<T>) globalStack.pop();
				 if (temp != null) {
					 sb.append(temp.toString());
					 localStack.push(temp.getLeftChildNode());
					 localStack.push(temp.getRightChildNode());
					 if (temp.getLeftChildNode() != null || temp.getRightChildNode() != null)
						 isRowEmpty = false;
				 }
				 else {
					 sb.append("--");
					 localStack.push(null);
					 localStack.push(null);
				 }
				 for (int j = 0; j < nBlanks * 2 - 2; j++)
					 sb.append(' ');
			 }
			 sb.append("\n");
			 nBlanks /= 2;
			 while (localStack.isEmpty() == false)
				 globalStack.push(localStack.pop());
			 }
		 sb.append("\n_________________________________________________________________");
		 return sb.toString();
	}
}

