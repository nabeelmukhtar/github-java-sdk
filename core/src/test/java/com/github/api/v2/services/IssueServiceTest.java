package com.github.api.v2.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IssueServiceTest extends BaseGitHubServiceTest {
	private IssueService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createIssueService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testAddComment() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddLabel() {
		fail("Not yet implemented");
	}

	@Test
	public void testCloseIssue() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateIssue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIssue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIssueComments() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIssueLabels() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIssues() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveLabel() {
		fail("Not yet implemented");
	}

	@Test
	public void testReopenIssue() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchIssues() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateIssue() {
		fail("Not yet implemented");
	}

}
