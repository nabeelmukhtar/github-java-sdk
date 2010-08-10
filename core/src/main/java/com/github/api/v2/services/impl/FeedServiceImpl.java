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
package com.github.api.v2.services.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;

import com.github.api.v2.schema.Feed;
import com.github.api.v2.schema.FeedEntry;
import com.github.api.v2.services.FeedService;
import com.github.api.v2.services.GitHubException;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;

/**
 * The Class NetworkServiceImpl.
 */
public class FeedServiceImpl extends GitHubApiGateway implements
		FeedService {
	
	public FeedServiceImpl() {
        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
	}

	@Override
	public Feed getCommitFeed(String userName, String repositoryName, String branchName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_COMMIT_FEED_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.BRANCH, branchName).buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}

	@Override
	public Feed getNetworkFeed(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_NETWORK_FEED_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}

	@Override
	public Feed getPrivateUserFeed(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_PRIVATE_USER_FEED_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}

	@Override
	public Feed getPublicTimelineFeed() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_PUBLIC_TIMELINE_FEED_URL);
        String                apiUrl  = builder.buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}

	@Override
	public Feed getPublicUserFeed(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_PUBLIC_USER_FEED_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}

	@Override
	public Feed getWikiFeed(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_WIKI_FEED_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}
	
	@Override
	public Feed getBlogFeed() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_BLOG_FEED_URL);
        String                apiUrl  = builder.buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}

	@Override
	public Feed getDiscussionsFeed() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_DISCUSSIONS_FEED_URL);
        String                apiUrl  = builder.buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}

	@Override
	public Feed getDiscussionsFeed(String topic) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_DISCUSSIONS_FEED_BY_TOPIC_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, topic).buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}

	@Override
	public Feed getJobPositionsFeed() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.FeedUrls.GET_JOB_POSITIONS_FEED_URL);
        String                apiUrl  = builder.buildUrl();
        return unmarshall(callApiGet(apiUrl));
	}
	
	
	protected Feed unmarshall(InputStream is) {
        try {
            final SyndFeedInput input = new SyndFeedInput();
			final SyndFeed feed = input.build(new InputSource(is));
			return populateFeed(feed);
		} catch (Exception e) {
			throw new GitHubException("Error while fetching feed.", e);
		} finally {
			closeStream(is);
		}
	}
	
	@SuppressWarnings("unchecked")
	private Feed populateFeed(SyndFeed feed) {
		Feed retVal = new Feed();
		retVal.setAuthor(feed.getAuthor());
		retVal.setDescription(feed.getDescription());
		retVal.setLink(feed.getLink());
		retVal.setTitle(feed.getTitle());
		List<FeedEntry> entries = new ArrayList<FeedEntry>(feed.getEntries().size());
		retVal.setEntries(entries);
		
		for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
			FeedEntry feedEntry = new FeedEntry();
			feedEntry.setAuthor(entry.getAuthor());
//			feedEntry.setCategories(entry.getCategories());
			if (entry.getContents() != null) {
				StringBuilder builder = new StringBuilder();
				for (SyndContent content : (List<SyndContent>) entry.getContents()) {
					builder.append(content.getValue());
				}
				feedEntry.setContent(builder.toString());
			}
			feedEntry.setLink(entry.getLink());
			feedEntry.setPublishedDate(entry.getPublishedDate());
			feedEntry.setTitle(entry.getTitle());
			
			entries.add(feedEntry);
		}
		return retVal;
	}

	/**
	 * Creates the git hub api url builder.
	 * 
	 * @param urlFormat
	 *            the url format
	 * 
	 * @return the git hub api url builder
	 */
	protected GitHubApiUrlBuilder createGitHubApiUrlBuilder(String urlFormat) {
		return new GitHubApiUrlBuilder(urlFormat);
	}
}
