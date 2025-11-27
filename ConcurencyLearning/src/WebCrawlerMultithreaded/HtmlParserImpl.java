package WebCrawlerMultithreaded;

import java.util.ArrayList;
import java.util.List;

public class HtmlParserImpl implements HtmlParser {

	@Override
	public List<String> getUrls(String url) {
		List<String> urls = new ArrayList<>();

		if (url.equals("http://news.yahoo.com/news")) {
			urls.add("http://news.yahoo.com/news/topics/");
			urls.add("http://news.yahoo.com/us");
			urls.add("http://news.google.com"); // Should be filtered out
		} else if (url.equals("http://news.yahoo.com/news/topics/")) {
			urls.add("http://news.yahoo.com/news"); // Cycle back to start
			urls.add("http://news.yahoo.com/tech");
		} else if (url.equals("http://news.yahoo.com/us")) {
			urls.add("http://news.yahoo.com/us/politics");
		}

		// Simulate network delay
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}

		return urls;
	}

}
