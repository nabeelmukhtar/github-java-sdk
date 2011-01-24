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

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class ObjectServiceTest.
 */
public class ObjectServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private ObjectService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createObjectService();
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
	 * Test get blob.
	 */
	@Test
	public void testGetBlob() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Tree SHA."), TestConstants.TEST_TREE_SHA);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test File Path."), TestConstants.TEST_FILE_PATH);
		Blob blob = service.getBlob(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_TREE_SHA, TestConstants.TEST_FILE_PATH);
		assertNotNull("Blob cannot be null or empty", blob);
	}

	/**
	 * Test get blobs.
	 */
	@Test
	public void testGetBlobs() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Tree SHA."), TestConstants.TEST_TREE_SHA);
		List<Blob> blobs = service.getBlobs(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_TREE_SHA);
		assertNotNullOrEmpty("Blobs cannot be null or empty", blobs);
	}

	/**
	 * Test get object content.
	 */
	@Test
	public void testGetObjectContent() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Tree SHA."), TestConstants.TEST_TREE_SHA);
		InputStream objectContent = service.getObjectContent(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_TREE_SHA);
		assertNotNullOrEmpty("Object content cannot be null or empty", convertStreamToString(objectContent));
	}

	/**
	 * Test get tree.
	 */
	@Test
	public void testGetTree() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Tree SHA."), TestConstants.TEST_TREE_SHA);
		List<Tree> trees = service.getTree(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_TREE_SHA);
		assertNotNullOrEmpty("Tree cannot be null or empty", trees);
	}
}
