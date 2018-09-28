package FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class PredicateAndFuntion {

	public static void main(String[] args) {

		String doc1 = "<html><body>One of the most common uses of <i>streams</i> is to represent queries over data in collections</body></html>";
		String doc2 = "<html><body>Information integration systems provide valuable services to users by integrating information from a number of autonomous, heterogeneous and distributed Web sources</body></html>";
		String doc3 = "<html><body>Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene</body></html>";
		String doc4 = "<html><body>Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism</body></html>";

		List<String> documents = new ArrayList<>(Arrays.asList(doc1, doc2, doc3, doc4));

		for (String doc : documents) {
			boolean isTargetDoc = filter(doc, d -> d.contains("stream"));
			// old way
			/*boolean isTargetDoc = filter(doc, new Predicate<String>(
					) {
						@Override
						public boolean test(String d) {
							return d.contains("Stream");
						}
			});*/

			if (isTargetDoc) {
				//1st way to write
				doc = transform(doc, d -> Indexer.stripHtmlTags(d));
				doc = transform(doc, d -> Indexer.removeStopwords(d));

				// 2nd way to write
				/*Function<String, String> htmlCleaner = d -> Indexer.stripHtmlTags(d);
				doc = transform(doc, htmlCleaner);
				Function<String, String> stopwordRemover = d -> Indexer.removeStopwords(d);
				stopwordRemover.apply(doc); //doing directly
				 */

				System.out.println(doc);
			}
		}
	}	

	static boolean filter(String doc, Predicate<String> filter) {
		return filter.test(doc);
	}

	/*static String transform(String doc, Function<String, String> transformer) {
		return transformer.apply(doc);
	}*/

	// unary operator can be used when input and output has same type
	static String transform(String doc, UnaryOperator<String> transformer) {
		return transformer.apply(doc);
	}

}