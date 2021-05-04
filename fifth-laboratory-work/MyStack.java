/*
 * Класс стека, на котором основан обход графа в глубину (матрица смежности).
 */
public class MyStack {

	private final int MAX_SIZE = 32;
	private int[] theStack;
	private int top;

	public MyStack() {
		theStack = new int[MAX_SIZE];
		top = -1;
	}

	public void push(int element) {
		theStack[++top] = element;
	}

	public int pop() {
		return theStack[top--];
	}

	public int getTopElement() {
		return theStack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}
}
