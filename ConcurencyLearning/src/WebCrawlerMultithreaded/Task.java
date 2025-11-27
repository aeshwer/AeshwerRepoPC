package WebCrawlerMultithreaded;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {
	private String url;

	// Store the hostname from startUrl to filter URLs
	private String hostName;

	// Thread-safe map to store visited URLs and avoid duplicates
	private ConcurrentHashMap<String, Boolean> urlHashMap;

	// Counter to track URLs to be processed
	private AtomicInteger numOfUrlsToParse;

	// Reference to the HtmlParser
	private HtmlParser htmlParser;

	// Thread pool to process URLs concurrently
	private ExecutorService executor;

	Task(String url, AtomicInteger numOfUrlsToParse, ExecutorService executor,
			ConcurrentHashMap<String, Boolean> urlHashMap, String hostName, HtmlParser htmlParser) {
		this.url = url;
		this.numOfUrlsToParse = numOfUrlsToParse;
		this.executor = executor;
		this.urlHashMap = urlHashMap;
		this.hostName = hostName;
		this.htmlParser = htmlParser;
	}

	@Override
	public void run() {
		System.out.println("Processing: " + url + " on thread: " + Thread.currentThread().getName());
		// Get all URLs from the current page
		for (String extractedUrl : htmlParser.getUrls(url)) {

			// Basic validation to prevent crash on malformed URLs
			if (!extractedUrl.startsWith("http")) {
				continue;
			}

			// Extract hostname from URL
			String curHostName = extractedUrl.split("/")[2];
			
			// Check if URL has same hostname and hasn't been visited
			if (curHostName.equals(hostName) && urlHashMap.putIfAbsent(extractedUrl, true) == null) {
				// Increment counter for active tasks
				numOfUrlsToParse.addAndGet(1);
				// Submit new task to process this URL
				executor.submit(new Task(extractedUrl, numOfUrlsToParse, executor, urlHashMap, hostName, htmlParser));
			}
		}
		// Decrement counter when task is complete
		numOfUrlsToParse.decrementAndGet();
	}
}
