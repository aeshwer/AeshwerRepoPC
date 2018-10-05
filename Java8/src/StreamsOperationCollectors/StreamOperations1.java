package StreamsOperationCollectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import StreamsOperationSlicing.Book;
import StreamsOperationSlicing.DataExtractor;

public class StreamOperations1 {

	private static void collectToCollection(List<Book> books) {
		System.out.println("\nIn collectToCollection ...");
		List<Book> list1 = books.stream()
				.filter(b -> b.getRating() >= 4.5)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("list1.size: " + list1.size());

		Set<Book> set1 = books.stream()
				.filter(b -> b.getRating() >= 4.5)
				.collect(Collectors.toSet());
		System.out.println("set1.size: " + set1.size());

		TreeSet<Book> set2 = books.stream()
				.filter(b -> b.getRating() >= 4.5)
				.collect(Collectors.toCollection(() -> new TreeSet()));
		System.out.println("set2.size: " + set2.size());
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

		collectToCollection(books);

	}	

}
