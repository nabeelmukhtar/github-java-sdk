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

public class FeedServiceTest extends BaseGitHubServiceTest {
	private FeedService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createFeedService();
		service.setAuthentication(authentication);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testGetCommitFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Feed feed = service.getCommitFeed(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Repository.MASTER);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	@Test
	public void testGetNetworkFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Feed feed = service.getNetworkFeed(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	@Test
	public void testGetPrivateUserFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	Feed feed = service.getPrivateUserFeed(TestConstants.TEST_USER_NAME);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	@Test
	public void testGetPublicTimelineFeed() {
    	Feed feed = service.getPublicTimelineFeed();
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	@Test
	public void testGetPublicUserFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	Feed feed = service.getPublicUserFeed(TestConstants.TEST_USER_NAME);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}

	@Test
	public void testGetWikiFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Feed feed = service.getWikiFeed(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNull("Feed cannot be null.", feed);
    	assertNotNullOrEmpty("Feed entries cannot be null or empty.", feed.getEntries());
	}
}
