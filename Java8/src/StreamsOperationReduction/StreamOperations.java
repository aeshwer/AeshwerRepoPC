//Reduce Operation is a immutable reduction
//Reduce Operation Reduces the stream into a Single Value. 
//The Reduce operator returns a Optional and takes a binary operator since it works on 2 element at a time.
// we can also use a different version of method and return a value instead of optional : GOTO LINE 51
package StreamsOperationReduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import StreamsOperationSlicing.Book;
import StreamsOperationSlicing.DataExtractor;

public class StreamOperations {

	// Find the lowest priced book with a rating >= 4.5
	private static void reduce(List<Book> books) {
		System.out.println("\nReduce ...");
		books.stream()
		.filter(b -> b.getRating() >= 4.5)
		//.parallel() // to use this the reduction operation must be associative : (a+b)+c = a+(b+ c) , else we get incorrect result or inconsistent value ,exmaple:average
		.reduce((b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2)
		.ifPresent(b -> System.out.println("Lowest priced book: " + b));				
	}

	// Limitations:
	//   1. Cumbersome
	//   2. Parallelizing is painful
	//   3. Synchronizing shared mutable variable is expensive
	private static void reduceImperatively(List<Book> books) {
		System.out.println("\nReducing imperatively ...");
		Book result = null;

		for (Book book : books) {
			// Initialize result with first book having rating >= 4.5
			if (result == null) {
				if (book.getRating() >= 4.5) {
					result = book;
				}				
				continue;
			}

			if (book.getRating() >= 4.5 && result.getPrice() > book.getPrice()) {
				result = book;
			}
		}

		System.out.println("(Imperative) Lowest priced book with rating >= 4.5: " + result);

	}		


	static void overloadedReductions() {
		System.out.println("\noverloadedReductions ... ");

		String[] grades = {"A", "A", "B"};

		String concat1 = Arrays.stream(grades).reduce("", (s1, s2) -> s1 + s2);
		System.out.println("concat1: " + concat1);

		StringBuilder concat2 = Arrays.stream(grades).reduce(new StringBuilder(), (sb, s) -> sb.append(s),
						(sb1, sb2) -> sb1.append(sb2));
		System.out.println("concat2: " + concat2);

	}
	public static void main(String[] args) {

		List<Book> books = new ArrayList<>();

		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));

		// intermediate operations (return stream objects)
		//slice(books);		

		// terminal operations (return non-stream objects)
		//match(books);  // matching stream elements to some criteria

		// All matching & finding operations + limit  are short-circuit operations (recall &&, ||)	

		// find(books);		

		reduce(books);
		reduceImperatively(books);
		overloadedReductions();		

	}	

}