// collect() also do reduction , but it is a mutable reduction
// Collect Operation Reduces the stream into a Container Object : can be list/set/map/string builder/summaryObject etc. 
package StreamsOperationReductionWithCOllectOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import StreamsOperationSlicing.Book;
import StreamsOperationSlicing.DataExtractor;

public class StreamOperations {

	// if accumulator mutates, use collect(). Otherwise, use reduce()
	private static void mutableReduction() {
		System.out.println("\nmutableReduction ... ");
		String[] grades = {"A", "A", "B"};

		StringBuilder concat2 = Arrays.stream(grades).parallel()
				.collect(() -> new StringBuilder(), 
						(sb, s) -> sb.append(s),
						(sb1, sb2) -> sb1.append(sb2));
		System.out.println("concat2: " + concat2);

		//predefined reductions ... Collector is a helper class
		String concatWithJoining = Arrays.stream(grades).parallel()
				.collect(Collectors.joining());
		System.out.println("concatWithJoining: " + concatWithJoining);
	}

	static void overloadedReductions() {
		System.out.println("\noverloadedReductions ... ");

		String[] grades = {"A", "A", "B"};

		String concat1 = Arrays.stream(grades)
				.reduce("", (s1, s2) -> s1 + s2);
		System.out.println("concat1: " + concat1);

		StringBuilder concat2 = Arrays.stream(grades)/*.parallel()*/ // will give wrong output
				.reduce(new StringBuilder(), 
						(sb, s) -> sb.append(s),
						(sb1, sb2) -> sb1.append(sb2));
		//null);
		System.out.println("concat2: " + concat2);


		// Not efficient: Each accumulation step creates a new StringBuilder
		StringBuilder concat3 = Arrays.stream(grades).parallel()
				.reduce(new StringBuilder(), 
						(sb, s) -> new StringBuilder().append(sb).append(s),
						(sb1, sb2) -> sb1.append(sb2));						
		System.out.println("concat3: " + concat3);

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
		overloadedReductions();	

		mutableReduction();
	}
}