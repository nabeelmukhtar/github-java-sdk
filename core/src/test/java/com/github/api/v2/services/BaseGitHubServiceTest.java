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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import com.github.api.v2.services.auth.Authentication;
import com.github.api.v2.services.auth.LoginTokenAuthentication;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class BaseGitHubServiceTest.
 */
public class BaseGitHubServiceTest extends TestCase {
    
    /** The Constant RESOURCE_MISSING_MESSAGE. */
	protected static final String RESOURCE_MISSING_MESSAGE = "Please define a test %s in TestConstants.properties file.";
	
	/** The factory. */
	protected GitHubServiceFactory factory;
	
	/** The authentication. */
	protected Authentication authentication;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test API Key."), TestConstants.TEST_API_KEY);
    	authentication = new LoginTokenAuthentication(TestConstants.TEST_USER_NAME, TestConstants.TEST_API_KEY);
		factory = GitHubServiceFactory.newInstance();
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		factory = null;
	}
	
	/**
	 * Assert not null or empty.
	 * 
	 * @param message
	 *            the message
	 * @param value
	 *            the value
	 */
	protected static void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}
	
	/**
	 * Assert not null or empty.
	 * 
	 * @param message
	 *            the message
	 * @param value
	 *            the value
	 */
	protected static void assertNotNullOrEmpty(String message, Collection<?> value) {
		assertNotNull(message, value);
		assertFalse(message, value.isEmpty());
	}
	
	/**
	 * Convert stream to string.
	 * 
	 * @param is
	 *            the is
	 * 
	 * @return the string
	 */
	protected static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	
	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    return sb.toString();
	}
}
