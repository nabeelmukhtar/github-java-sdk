/**
 * 
 */
package com.github.api.v2.services;

import com.github.api.v2.schema.Feed;


/**
 * The Interface FeedService.
 */
public interface FeedService extends GitHubService {
	
	public Feed getPublicUserFeed(String userName);
	public Feed getPrivateUserFeed(String userName);
	public Feed getCommitFeed(String userName, String repositoryName);
	public Feed getNetworkFeed(String userName, String repositoryName);
	public Feed getWikiFeed(String userName, String repositoryName);
	public Feed getPublicTimelineFeed();
}
