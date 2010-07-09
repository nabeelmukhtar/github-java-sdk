package com.github.api.v2.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		fail("Not yet implemented");
	}

	@Test
	public void testGetCommitsStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCommitsStringStringStringString() {
		fail("Not yet implemented");
	}

}
