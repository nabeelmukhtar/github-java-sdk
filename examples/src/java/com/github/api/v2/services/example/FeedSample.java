/**
 * 
 */
package com.github.api.v2.services.example;

import com.github.api.v2.schema.Feed;
import com.github.api.v2.schema.FeedEntry;
import com.github.api.v2.services.FeedService;
import com.github.api.v2.services.GitHubServiceFactory;

/**
 * The Class ObjectApiSample.
 */
public class FeedSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		FeedService service = factory.createFeedService();
		Feed feed = service.getPublicUserFeed("apache");
		printResult(feed);
	}

	private static void printResult(Feed feed) {
		if (feed != null) {
			System.out.println(feed.getAuthor());
			System.out.println(feed.getLink());
			System.out.println(feed.getDescription());
			for (FeedEntry entry : feed.getEntries()) {
				System.out.println(entry);
			}
		}
	}
}
