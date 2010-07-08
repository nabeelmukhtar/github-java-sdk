/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Issue;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class GoogleSearchJsonQueryTest.
 */
public class GitHubJsonServiceTest extends BaseGitHubServiceTest {
	
	/** The factory. */
	private GitHubServiceFactory factory;
	

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		factory = GitHubServiceFactory.newInstance(TestConstants.TEST_API_KEY);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		factory = null;
	}

	/**
	 * 
	 */
	@Test
	public void testUserService() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		UserService service = factory.createUserService();
		List<User> result = service.searchUsersByName(TestConstants.TEST_QUERY);
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * 
	 */
	@Test
	public void testIssueService() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		IssueService service = factory.createIssueService();
		List<Issue> result = service.searchIssues("", "", null, TestConstants.TEST_QUERY);
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
}
