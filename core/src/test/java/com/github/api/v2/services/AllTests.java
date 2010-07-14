/*
 * 
 */
package com.github.api.v2.services;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * The Class AllTests.
 */
public class AllTests {

	/**
	 * Suite.
	 * 
	 * @return the test
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.github.api.v2.services");
		//$JUnit-BEGIN$
//		suite.addTestSuite(OAuthServiceTest.class);
		suite.addTestSuite(CommitServiceTest.class);
		suite.addTestSuite(RepositoryServiceTest.class);
		suite.addTestSuite(IssueServiceTest.class);
		suite.addTestSuite(ObjectServiceTest.class);
		suite.addTestSuite(NetworkServiceTest.class);
		suite.addTestSuite(UserServiceTest.class);
		suite.addTestSuite(GistServiceTest.class);
		//$JUnit-END$
		return suite;
	}

}
