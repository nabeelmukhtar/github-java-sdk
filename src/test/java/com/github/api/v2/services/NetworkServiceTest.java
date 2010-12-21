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

import com.github.api.v2.schema.NetworkCommit;
import com.github.api.v2.schema.NetworkMeta;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class NetworkServiceTest.
 */
public class NetworkServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private NetworkService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createNetworkService();
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
	 * Test get network data string string string.
	 */
	@Test
	public void testGetNetworkDataStringStringString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Network Hash."), TestConstants.TEST_NETWORK_HASH);
		List<NetworkCommit> commits = service.getNetworkData(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_NETWORK_HASH);
		assertNotNullOrEmpty("Commits should not be null or empty.", commits);
	}

	/**
	 * Test get network data string string string int int.
	 */
	@Test
	public void testGetNetworkDataStringStringStringIntInt() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Network Hash."), TestConstants.TEST_NETWORK_HASH);
		List<NetworkCommit> commits = service.getNetworkData(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_NETWORK_HASH, 1, 5);
		assertNotNullOrEmpty("Commits should not be null or empty.", commits);
	}

	/**
	 * Test get network meta.
	 */
	@Test
	public void testGetNetworkMeta() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		NetworkMeta networkMeta = service.getNetworkMeta(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNull("Network cannot be null", networkMeta);
	}

}
