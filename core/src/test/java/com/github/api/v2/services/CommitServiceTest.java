package com.github.api.v2.services;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.services.constant.TestConstants;

public class CommitServiceTest extends BaseGitHubServiceTest {
	private CommitService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createCommitService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testGetCommit() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test SHA."), TestConstants.TEST_COMMIT_HASH);
		Commit commit = service.getCommit(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_COMMIT_HASH);
		assertNotNull("Commit cannot be null", commit);
	}

	@Test
	public void testGetCommitsStringStringString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test SHA."), TestConstants.TEST_COMMIT_HASH);
		List<Commit> commits = service.getCommits(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Repository.MASTER);
		assertNotNullOrEmpty("Commits cannot be null or empty", commits);
	}

	@Test
	public void testGetCommitsStringStringStringString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test SHA."), TestConstants.TEST_COMMIT_HASH);
		List<Commit> commits = service.getCommits(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Repository.MASTER);
		assertNotNullOrEmpty("Commits cannot be null or empty", commits);
	}
}
