
public class MyBinarySearchTreeNode<T> {
	
	private int key;
	private T data;
	private MyBinarySearchTreeNode<T> leftChildNode;
	private MyBinarySearchTreeNode<T> rightChildNode;
	
	public MyBinarySearchTreeNode(int key, T data) {
		this.key = key;
		this.data = data;
	}
	
	public T getData() {return data;}
	
	public int getKey() {return key;}
	
	public MyBinarySearchTreeNode<T> getLeftChildNode() {return leftChildNode;}
	
	public void setLeftChildNode(MyBinarySearchTreeNode<T> leftChildNode) {this.leftChildNode = leftChildNode;}
	
	public MyBinarySearchTreeNode<T> getRightChildNode() {return rightChildNode;}
	
	public void setRightChildNode(MyBinarySearchTreeNode<T> rightChildNode) {this.rightChildNode = rightChildNode;}
	
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
