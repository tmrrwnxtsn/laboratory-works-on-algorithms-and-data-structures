import java.time.Duration;
import java.time.Instant;

public class MainApp {
	
	public static void main(String[] args) {
		randomlyFillLeftDeques(10);
		randomlyFillRightDeques(10);
		clearFromLeftDeques(10);
		clearFromRightDeques(10);
	}
	
	public static void randomlyFillLeftDeques(int numberElements) {
		System.out.println("Заполнение случайными числами деков добавлением с левой стороны.");
		ArrayDeque theArrayDeque = new ArrayDeque(numberElements);
		
		Instant start = Instant.now();
		
		theArrayDeque.randomlyFillLeft();
		
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Дек на массиве, мс: " + elapsed);
		
		TwoWayNodeListDeque theTwoWayNodeListDeque = new TwoWayNodeListDeque();
		
		start = Instant.now();
		
		theTwoWayNodeListDeque.randomlyFillLeft(numberElements);
		
		finish = Instant.now();
		elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Дек на двустороннем списке, мс: " + elapsed);
	}
	
	public static void randomlyFillRightDeques(int numberElements) {
		System.out.println("Заполнение случайными числами деков добавлением с правой стороны.");
		ArrayDeque theArrayDeque = new ArrayDeque(numberElements);
		
		Instant start = Instant.now();
		
		theArrayDeque.randomlyFillRight();
		
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Дек на массиве, мс: " + elapsed);
		
		TwoWayNodeListDeque theTwoWayNodeListDeque = new TwoWayNodeListDeque();
		
		start = Instant.now();
		
		theTwoWayNodeListDeque.randomlyFillRight(numberElements);
		
		finish = Instant.now();
		elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Дек на двустороннем списке, мс: " + elapsed);
	}
	
	public static void clearFromLeftDeques(int numberElements) {
		System.out.println("Очищение деков с левой стороны.");
		ArrayDeque theArrayDeque = new ArrayDeque(numberElements);
		theArrayDeque.randomlyFillRight();
		
		Instant start = Instant.now();
		
		theArrayDeque.clearFromLeft();
		
		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Дек на массиве, мс: " + elapsed);
		
		TwoWayNodeListDeque theTwoWayNodeListDeque = new TwoWayNodeListDeque();
		theTwoWayNodeListDeque.randomlyFillRight(numberElements);
		
		start = Instant.now();
		
		theTwoWayNodeListDeque.clearFromLeft();
		
		finish = Instant.now();
		elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Дек на двустороннем списке, мс: " + elapsed);
	}
	
	public static void clearFromRightDeques(int numberElements) {
		System.out.println("Очищение деков с правой стороны.");
		ArrayDeque theArrayDeque = new ArrayDeque(numberElements);
		theArrayDeque.randomlyFillRight();
		
		Instant start = Instant.now();
		
		theArrayDeque.clearFromRight();

		Instant finish = Instant.now();
		long elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Дек на массиве, мс: " + elapsed);
		
		TwoWayNodeListDeque theTwoWayNodeListDeque = new TwoWayNodeListDeque();
		theTwoWayNodeListDeque.randomlyFillRight(numberElements);
		
		start = Instant.now();
		
		theTwoWayNodeListDeque.clearFromRight();
		
		finish = Instant.now();
		elapsed = Duration.between(start, finish).toMillis();
		System.out.println("Дек на двустороннем списке, мс: " + elapsed);
	}
}
