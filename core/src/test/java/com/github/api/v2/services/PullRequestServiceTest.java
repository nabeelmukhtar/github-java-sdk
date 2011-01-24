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

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.PullRequest;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class PullRequestServiceTest.
 */
public class PullRequestServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private PullRequestService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createPullRequestService();
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
	 * Test get pull request.
	 */
	@Test
	public void testGetPullRequest() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue Number."), TestConstants.TEST_ISSUE_NUMBER);
		PullRequest pullRequest = service.getPullRequest(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER));
		assertNotNull("Pull request cannot be null or empty", pullRequest);
	}

	/**
	 * Test get pull requests.
	 */
	@Test
	public void testGetPullRequests() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Tree SHA."), TestConstants.TEST_TREE_SHA);
		List<PullRequest> pullRequests = service.getPullRequests(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Pull requests cannot be null or empty", pullRequests);
	}

	/**
	 * Test create pull request.
	 */
	@Test
	public void testCreatePullRequest() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Base SHA."), TestConstants.TEST_BASE_SHA);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Head SHA."), TestConstants.TEST_HEAD_SHA);
		service.createPullRequest(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_BASE_SHA, TestConstants.TEST_HEAD_SHA, TestConstants.TEST_ISSUE_TITLE, TestConstants.TEST_ISSUE_BODY);
	}
}
