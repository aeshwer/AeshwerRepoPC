package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurentModificationErrorTry {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Java");
		names.add("PHP");
		names.add("SQL");
		names.add("Angular 2");
		System.out.println(Collections.binarySearch(names, "SQL"));
		
		List<String> first2Names = names.subList(0, 2);

		System.out.println(names + " , " + first2Names);

		names.set(1, "JavaScript");
		// check the output below. :)
		System.out.println(names + " , " + first2Names);

		// Let's modify the list size and get ConcurrentModificationException
		names.add("NodeJS");
		System.out.println(names);
		System.out.println(names + " , " + first2Names); // this line throws exception

	}
}
