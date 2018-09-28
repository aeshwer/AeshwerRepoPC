package FunctionalInterface2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import FunctionalInterface.Indexer;

public class ConsumerSuplierExample {
public static void main(String[] args) {
		
		String doc1 = "<html><body>One of the most common uses of <i>streams</i> is to represent queries over data in collections</body></html>";
		String doc2 = "<html><body>Information integration systems provide valuable services to users by integrating information from a number of autonomous, heterogeneous and distributed Web sources</body></html>";
		String doc3 = "<html><body>Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene</body></html>";
		String doc4 = "<html><body>Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism</body></html>";
		
		List<String> documents = new ArrayList<>(Arrays.asList(doc1, doc2, doc3, doc4));
		
		List<String> targetDocuments = new ArrayList<>();
		
		for (String doc : documents) {
				//boolean isTargetDoc = filter(doc, d -> d.contains("stream"));
			    			    
			    BiFunction<String, String, Boolean> biFunction = (d, c) -> d.contains(c);
			    
			    if (biFunction.apply(doc, "stream")) {
				    //doc = transform(doc, d -> Indexer.stripHtmlTags(d));
					//doc = transform(doc, d -> Indexer.removeStopwords(d));
					
					Function<String, String> htmlCleaner = d -> Indexer.stripHtmlTags(d);
					//doc = transform(doc, htmlCleaner);
					
					Function<String, String> stopwordRemover = d -> Indexer.removeStopwords(d);
					//stopwordRemover.apply(doc);
					
					Function<String, String> docProcessor = htmlCleaner.andThen(stopwordRemover);
					doc = transform(doc, docProcessor);
					
					//System.out.println(doc);
					
					targetDocuments.add(doc);
				}							
				
		}
		
		// the for-each method takes a consumer as input
		targetDocuments.forEach(d -> System.out.println(d));
		//2nd way
		/*targetDocuments.forEach(new Consumer<String>() {
			@Override
			public void accept(String d) {
				System.out.println(d);
			}
		});*/
		
		// Demonstrating supplier, (UseCase: if HTML doc size >80 thrown exception)
		for (String doc : targetDocuments) {
			try {
				if (doc.length() > 80) {
					throw new Exception("Oversized document!!!");
				}
			} catch (Exception e) {
				print(() -> e.getMessage() + " ~ " + doc); // deferred execution style : concatenation happens only when supplier.get is called
			}
		}
		
	}	
	
	private static boolean errorFlag = true;
	private static void print(Supplier<String> supplier) {
		if (errorFlag) {
			System.out.println(supplier.get());
		}
	}
	
	static boolean filter(String doc, Predicate<String> filter) {
		return filter.test(doc);
	}
	
	/*static String transform(String doc, UnaryOperator<String> transformer) {
		return transformer.apply(doc);
	}*/
	static String transform(String doc, Function<String, String> transformer) {
		return transformer.apply(doc);
	}
	
}