package com.github.api.v2.services;

import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;
import com.github.api.v2.services.constant.TestConstants;

public class ObjectServiceTest extends BaseGitHubServiceTest {
	private ObjectService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createObjectService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testGetBlob() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_TREE_SHA);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_FILE_PATH);
		Blob blob = service.getBlob(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_TREE_SHA, TestConstants.TEST_FILE_PATH);
		assertNotNull("Blob cannot be null or empty", blob);
	}

	@Test
	public void testGetBlobs() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_TREE_SHA);
		List<Blob> blobs = service.getBlobs(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_TREE_SHA);
		assertNotNullOrEmpty("Blobs cannot be null or empty", blobs);
	}

	@Test
	public void testGetObjectContent() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_TREE_SHA);
		InputStream objectContent = service.getObjectContent(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_TREE_SHA);
		assertNotNullOrEmpty("Object content cannot be null or empty", convertStreamToString(objectContent));
	}

	@Test
	public void testGetTree() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_TREE_SHA);
		List<Tree> trees = service.getTree(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_TREE_SHA);
		assertNotNullOrEmpty("Tree cannot be null or empty", trees);
	}
}
