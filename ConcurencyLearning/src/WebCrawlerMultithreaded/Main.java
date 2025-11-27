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

	// Counter to track URLs to be processed
	private AtomicInteger numOfUrlsToParse = new AtomicInteger(0);

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		// Extract hostname from startUrl
		// startUrl Split Array = ["http:", "", "news.yahoo.com", "news", "topics", ""]
		// hostname = "news.yahoo.com"
		hostName = startUrl.split("/")[2];
		System.out.println("HostName is : " + hostName);

		// Mark startUrl as visited
		urlHashMap.put(startUrl, true);

		// Initialize counter and submit first task
		numOfUrlsToParse.addAndGet(1);
		executor.submit(new Task(startUrl, numOfUrlsToParse, executor));

		// Wait until all URLs have been processed
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
