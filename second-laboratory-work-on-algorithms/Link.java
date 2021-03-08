
public class Link {
	
	public Link nextLink;
	public long data;
	
	public Link(long longData) {
		data = longData;
		nextLink = null;
	}
	
	public void displayLink() {
		System.out.print(data + " ");
	}
}
