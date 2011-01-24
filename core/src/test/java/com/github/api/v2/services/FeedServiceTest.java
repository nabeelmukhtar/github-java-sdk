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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Feed;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class FeedServiceTest.
 */
public class FeedServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private FeedService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createFeedService();
		service.setAuthentication(authentication);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	/**
	 * Test get commit feed.
	 */
	@Test
	public void testGetCommitFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Feed feed = service.getCommitFeed(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Repository.MASTER, 10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	/**
	 * Test get network feed.
	 */
	@Test
	public void testGetNetworkFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Feed feed = service.getNetworkFeed(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, 10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	/**
	 * Test get private user feed.
	 */
	@Test
	public void testGetPrivateUserFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	Feed feed = service.getPrivateUserFeed(TestConstants.TEST_USER_NAME, 10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	/**
	 * Test get public timeline feed.
	 */
	@Test
	public void testGetPublicTimelineFeed() {
    	Feed feed = service.getPublicTimelineFeed(10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	/**
	 * Test get public user feed.
	 */
	@Test
	public void testGetPublicUserFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	Feed feed = service.getPublicUserFeed(TestConstants.TEST_USER_NAME, 10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	/**
	 * Test get wiki feed.
	 */
	@Test
	public void testGetWikiFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Feed feed = service.getWikiFeed(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, 10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}
	
	/**
	 * Test get blog feed.
	 */
	@Test
	public void testGetBlogFeed() {
    	Feed feed = service.getBlogFeed(10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	/**
	 * Test get discussions feed.
	 */
	@Test
	public void testGetDiscussionsFeed() {
    	Feed feed = service.getDiscussionsFeed(10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	/**
	 * Test get discussions feed string.
	 */
	@Test
	public void testGetDiscussionsFeedString() {
    	Feed feed = service.getDiscussionsFeed("api", 10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	/**
	 * Test get job positions feed.
	 */
	@Test
	public void testGetJobPositionsFeed() {
    	Feed feed = service.getJobPositionsFeed(10);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}
}
