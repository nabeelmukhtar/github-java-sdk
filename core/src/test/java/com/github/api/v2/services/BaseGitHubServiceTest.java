/**
 * 
 */
package com.github.api.v2.services;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class BaseGoogleSearchClientTest.
 */
public class BaseGitHubServiceTest extends TestCase {
    
    /** The Constant RESOURCE_MISSING_MESSAGE. */
	protected static final String RESOURCE_MISSING_MESSAGE = "Please define a test %s in TestConstants.properties file.";
	
	/** The factory. */
	protected GitHubServiceFactory factory;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test API Key"), TestConstants.TEST_API_KEY);
		factory = GitHubServiceFactory.newInstance(TestConstants.TEST_API_KEY);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		factory = null;
	}
	
	/**
	 * Assert not null or empty.
	 * 
	 * @param message the message
	 * @param value the value
	 */
	protected static void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}
	
	/**
	 * Assert not null or empty.
	 * 
	 * @param message the message
	 * @param value the value
	 */
	protected static void assertNotNullOrEmpty(String message, Collection<?> value) {
		assertNotNull(message, value);
		assertFalse(message, value.isEmpty());
	}
}
