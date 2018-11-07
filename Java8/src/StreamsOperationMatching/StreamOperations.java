package StreamsOperationMatching;

import java.util.ArrayList;
import java.util.List;

import StreamsOperationSlicing.Book;
import StreamsOperationSlicing.DataExtractor;

public class StreamOperations {
	// Queries:
	//  (a) Is there at least one highly rated book (>= 4.8) that is inexpensive (<= $50)?
	//  (b) Do all the books have a rating >= 4.8
	//  (c) Check if none of books have bad rating (2.0)?
	private static void match(List<Book> books) {
		System.out.println("\nMatching ... ");
		boolean anyMatch = books.stream()
				.anyMatch(d -> d.getRating() >= 4.8 && d.getPrice() <= 50.0);
		System.out.println("anyMatch? " + anyMatch);

		boolean allMatch = books.stream()
				.allMatch(d -> d.getRating() >= 4.8);
		//.noneMatch(d -> d.getRating() < 4.8);
		System.out.println("allMatch? " + allMatch);

		boolean noneMatch = books.stream()
				.noneMatch(d -> d.getRating() <= 2.0);
		// .allMatch(d -> d.getRating() > 2.0);
		//.anyMatch(d -> d.getRating() <= 2.0);
		System.out.println("noneMatch? " + noneMatch);		

	}
	public static void main(String[] args) {

		List<Book> books = new ArrayList<>();

		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));

		// intermediate operations (return stream objects)
		//slice(books);		

		// terminal operations (return non-stream objects)
		match(books);  // matching stream elements to some criteria

		// All matching & finding operations + limit  are short-circuit operations (eg:  &&, || ) : ie. once match find rest elements are not processed 		

	}
}
