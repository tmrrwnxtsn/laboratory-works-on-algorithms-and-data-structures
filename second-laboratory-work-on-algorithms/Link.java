/*
 * Класс элемента списка
 */
public class Link {
	
	public Link nextLink;
	public int data;
	
	public Link(int intData) {
		data = intData;
		nextLink = null;
	}
	
	public void displayLink() {
		System.out.print(data + " ");
	}
}
