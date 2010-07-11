package com.github.api.v2.services;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Issue;

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
		service.addComment("", "", 1, "");
	}

	@Test
	public void testAddLabel() {
		service.addLabel("", "", 1, "");
	}

	@Test
	public void testCloseIssue() {
		service.closeIssue("", "", 1);
	}

	@Test
	public void testCreateIssue() {
		service.createIssue("", "", "", "");
	}

	@Test
	public void testGetIssue() {
		Issue issue = service.getIssue("", "", 1);
		assertNotNull("Issue cannot be null.", issue);
	}

	@Test
	public void testGetIssueComments() {
		List<Comment> issueComments = service.getIssueComments("", "", 1);
		assertNotNullOrEmpty("Issue comments cannot be null or empty.", issueComments);
	}

	@Test
	public void testGetIssueLabels() {
		List<String> issueLabels = service.getIssueLabels("", "");
		assertNotNullOrEmpty("Issue labels should not be null or empty.", issueLabels);
	}

	@Test
	public void testGetIssues() {
		List<Issue> issues = service.getIssues("", "", Issue.State.OPEN);
		assertNotNullOrEmpty("Issues cannot be null or empty.", issues);
	}

	@Test
	public void testRemoveLabel() {
		List<String> labels = service.removeLabel("", "", 1, "");
		assertFalse("Label should not be in the list.", labels.contains(""));
	}

	@Test
	public void testReopenIssue() {
		service.reopenIssue("", "", 1);
	}

	@Test
	public void testSearchIssues() {
		List<Issue> issues = service.searchIssues("", "", Issue.State.OPEN, "");
		assertNotNullOrEmpty("Issues cannot be null or empty.", issues);
	}

	@Test
	public void testUpdateIssue() {
		service.updateIssue("", "", 1, "", "");
	}
}
