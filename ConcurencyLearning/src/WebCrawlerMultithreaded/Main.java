package WebCrawlerMultithreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	// Store the hostname from startUrl to filter URLs
	private String hostName;

	// Thread-safe map to store visited URLs and avoid duplicates
	private ConcurrentHashMap<String, Boolean> urlHashMap = new ConcurrentHashMap<>();

	// Thread pool to process URLs concurrently
	private ExecutorService executor = Executors.newFixedThreadPool(5);

	// Counter to track URLs to be processed - used as a stopping condition 
	private AtomicInteger numOfUrlsToParse = new AtomicInteger(0);

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		// startUrl Split Array = ["http:", "", "news.yahoo.com", "news", "topics", ""]
		// hostname = "news.yahoo.com"
		// 1. Extract hostname from startUrl
		String hostName = startUrl.split("/")[2];
		System.out.println("Target HostName: " + hostName);

		// 2. Mark startUrl as visited
		urlHashMap.put(startUrl, true);
		numOfUrlsToParse.set(1); // Set directly to 1 for the start

		// 3. Submit first task
		executor.submit(new Task(startUrl, numOfUrlsToParse, executor, urlHashMap, hostName, htmlParser));

		// 4. Wait logic
		// We wait as long as there are URLs being parsed or queued
		while (numOfUrlsToParse.get() > 0) {
			try {
				// Sleep to avoid busy waiting
				Thread.sleep(80);
			} catch (Exception e) {
				// Handle exceptions
			}
		}

		// Shutdown the thread pool
		executor.shutdown();

		// Return all discovered URLs
		return new ArrayList<>(urlHashMap.keySet());
	}

	public static void main(String[] args) {
		Main main = new Main();
		HtmlParser htmlParser = new HtmlParserImpl();
		main.crawl("http://news.yahoo.com/news", new HtmlParserImpl());
	}

}
