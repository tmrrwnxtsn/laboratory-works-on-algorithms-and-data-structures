
public class MainApp {

	public static void main(String[] args) {
		TwoWayLinkList theList = new TwoWayLinkList();
		 theList.insertToBeginning(22); // Вставка в начало списка
		 theList.insertToBeginning(44);
		 theList.insertToBeginning(66);
		 theList.insertToEnd(11); // Вставка в конец списка
		 theList.insertToEnd(33);
		 theList.insertToEnd(55);
		 theList.displayTwoWayLinkList();
		 theList.removeLastLink();
		 theList.removeLastLink();
		 theList.removeLastLink();
		 theList.removeLastLink();
		 theList.removeLastLink();
		 theList.removeLastLink();
		 theList.displayTwoWayLinkList();
	}

}
