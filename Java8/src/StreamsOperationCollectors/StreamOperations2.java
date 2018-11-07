//toMap() has 2 input : (function,function) for (key,value)
package StreamsOperationCollectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import StreamsOperationSlicing.Book;
import StreamsOperationSlicing.DataExtractor;

public class StreamOperations2 {

	private static void collectToMap(List<Book> books) {
		System.out.println("\nIn collectToMap ...");
		Map<Long, Book> map = books.stream()
				.collect(Collectors.toMap(b -> b.getIsbn(), b -> b));
		//.collect(Collectors.toMap(b -> b.getIsbn(), b -> b, (b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2));
		for (Entry<Long, Book> entry : map.entrySet()) {
			System.out.println("isbn: " + entry.getKey() + ", book: " + entry.getValue());
		}

		System.out.println(map instanceof HashMap);

		Map<Long, Book> treeMap = books.stream()
				//.collect(Collectors.toMap(b -> b.getIsbn(), b -> b));
				.collect(Collectors.toMap(Book::getIsbn, Function.identity(), (b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2, () -> new TreeMap()));
		for (Entry<Long, Book> entry : treeMap.entrySet()) {
			System.out.println("isbn: " + entry.getKey() + ", book: " + entry.getValue());
		}

		/*Map<Double, List<Book>> ratingsMap = treeMap.values().stream()
				.collect(Collectors.toMap(Book::getRating, b -> Collections.singletonList(b), (l1, l2) -> { ArrayList<Book> l = new ArrayList<>(l1);
																				l.addAll(l2);
																				return l;}));
			for (Entry<Double, List<Book>> entry : ratingsMap.entrySet()) {
				System.out.println("\nRating: " + entry.getKey());
				for (Book b : entry.getValue()) {
					System.out.println(b);
				}
			}*/

		Map<Double, List<Book>> ratingsMap1 = treeMap.values().stream()
				.collect(Collectors.groupingBy(Book::getRating));
		for (Entry<Double, List<Book>> entry : ratingsMap1.entrySet()) {
			System.out.println("\nRating: " + entry.getKey());
			for (Book b : entry.getValue()) {
				System.out.println(b);
			}
		}
	}

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();

		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));

		// intermediate operations (return stream objects)
		//slice(books);		

		// terminal operations (return non-stream objects)
		//match(books);  // matching stream elements to some criteria

		// All matching & finding operations + limit 
		//    are short-circuit operations (recall &&, ||)	

		// find(books);		

		//reduce(books);
		//reduceImperatively(books);
		//overloadedReductions();	

		//mutableReduction();
		//collectToCollection(books);

		collectToMap(books);
	}
}
