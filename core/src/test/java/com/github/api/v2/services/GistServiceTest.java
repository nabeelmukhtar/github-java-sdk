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

import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Gist;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class GistServiceTest.
 */
public class GistServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private GistService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createGistService();
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
	 * Test get gist.
	 */
	@Test
	public void testGetGist() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Gist Id."), TestConstants.TEST_GIST_ID);
		Gist gist = service.getGist(TestConstants.TEST_GIST_ID);
		assertNotNull("Gist cannot be null", gist);
	}

	/**
	 * Test get gist content.
	 */
	@Test
	public void testGetGistContent() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Gist Id."), TestConstants.TEST_GIST_ID);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Gist File."), TestConstants.TEST_GIST_FILE);
		InputStream gistContent = service.getGistContent(TestConstants.TEST_GIST_ID, TestConstants.TEST_GIST_FILE);
		assertNotNullOrEmpty("Gist content cannot be null or empty", convertStreamToString(gistContent));
	}

	/**
	 * Test get user gists.
	 */
	@Test
	public void testGetUserGists() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<Gist> gists = service.getUserGists(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("Gists cannot be null or empty.", gists);
	}
}
