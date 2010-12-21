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

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class CommitServiceTest.
 */
public class CommitServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private CommitService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createCommitService();
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
	 * Test get commit.
	 */
	@Test
	public void testGetCommit() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test SHA."), TestConstants.TEST_COMMIT_HASH);
		Commit commit = service.getCommit(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_COMMIT_HASH);
		assertNotNull("Commit cannot be null", commit);
	}

	/**
	 * Test get commits string string string.
	 */
	@Test
	public void testGetCommitsStringStringString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test SHA."), TestConstants.TEST_COMMIT_HASH);
		List<Commit> commits = service.getCommits(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Repository.MASTER);
		assertNotNullOrEmpty("Commits cannot be null or empty", commits);
	}

	/**
	 * Test get commits string string string string.
	 */
	@Test
	public void testGetCommitsStringStringStringString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test SHA."), TestConstants.TEST_COMMIT_HASH);
		List<Commit> commits = service.getCommits(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Repository.MASTER);
		assertNotNullOrEmpty("Commits cannot be null or empty", commits);
	}
}
