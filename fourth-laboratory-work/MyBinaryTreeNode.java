/*
 * Класс узла бинарного дерева поиска.
 */
public class MyBinaryTreeNode<T> {
	
	private int key;
	private T data;
	private MyBinaryTreeNode<T> leftChildNode;
	private MyBinaryTreeNode<T> rightChildNode;
	
	public MyBinaryTreeNode(int key, T data) {
		this.key = key;
		this.data = data;
	}
	
	public T getData() {return data;}
	
	public int getKey() {return key;}
	
	public MyBinaryTreeNode<T> getLeftChildNode() {return leftChildNode;}
	
	public void setLeftChildNode(MyBinaryTreeNode<T> leftChildNode) {this.leftChildNode = leftChildNode;}
	
	public MyBinaryTreeNode<T> getRightChildNode() {return rightChildNode;}
	
	public void setRightChildNode(MyBinaryTreeNode<T> rightChildNode) {this.rightChildNode = rightChildNode;}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(key);
		sb.append(", ");
		sb.append(data);
		sb.append("}");
		return sb.toString();
	}
}
