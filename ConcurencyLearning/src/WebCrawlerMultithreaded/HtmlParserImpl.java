package WebCrawlerMultithreaded;

import java.util.List;

public class HtmlParserImpl implements HtmlParser {

	@Override
	public List<String> getUrls(String url) {

		if (url.equals("http://news.yahoo.com/news")) {
			return List.of("http://news.yahoo.com/news", "http://news.yahoo.com/news/topics/",
					"http://news.yahoo.com/us", "http://news.google.com");
		}

		if (url.equals("http://news.yahoo.com/topics")) {
			return List.of("http://news.yahoo.com/news/topics/", "http://news.yahoo.com/us");
		}

		return List.of();
	}

}
