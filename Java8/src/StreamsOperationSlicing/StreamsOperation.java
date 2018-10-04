package StreamsOperationSlicing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsOperation {
		// Print at most 5 DISTINCT books with rating >= 4.5
		// DB world: select distinct (ISBN) from book where rating >= 4.5 limit 0, 5;
		private static void slice(List<Book> books) {
			System.out.println("\nSlice ... ");
			/*List<String> result = books.stream()
				.filter(d -> d.getRating() >= 4.5)
				.distinct()
				//.peek(d -> System.out.println(d.getTitle() + " " + d.getRating())) // used to peak in the stream
				.limit(5)
				//.skip(5)  // skips the first 5 element
				.map(d -> d.getTitle())
				//.forEach(System.out::println);
				.collect(Collectors.toList());  // terminal operation which collects the m odified data to list

			for(String title : result)
				System.out.println("title: " + title);*/

			Stream<Book> booksStream = books.stream()
					.filter(d -> d.getRating() >= 4.5)
					.distinct()
					.peek(d -> System.out.println(d))
					//.peek(d -> System.out.println(d.getTitle() + " " + d.getRating()))
					.limit(5);

			Stream<String> titleStream = booksStream.map(d -> d.getTitle());
			titleStream.forEach(System.out::println);
		}

	public static void main(String[] args) {

		List<Book> books = new ArrayList<>();

		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));

		slice(books);		
	}
}
