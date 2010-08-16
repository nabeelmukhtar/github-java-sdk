/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.github.api.v2.services;

import com.github.api.v2.schema.Feed;


/**
 * The Interface FeedService.
 */
public interface FeedService extends GitHubService {
	
	public Feed getPublicUserFeed(String userName, int count);
	public Feed getPrivateUserFeed(String userName, int count);
	public Feed getCommitFeed(String userName, String repositoryName, String branchName, int count);
	public Feed getNetworkFeed(String userName, String repositoryName, int count);
	public Feed getWikiFeed(String userName, String repositoryName, int count);
	public Feed getPublicTimelineFeed(int count);
	
	public Feed getDiscussionsFeed(int count);
	public Feed getDiscussionsFeed(String topic, int count);
	public Feed getJobPositionsFeed(int count);
	public Feed getBlogFeed(int count);
}
