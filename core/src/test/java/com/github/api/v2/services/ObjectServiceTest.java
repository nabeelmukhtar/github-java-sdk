package com.github.api.v2.services;

import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;

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
		Blob blob = service.getBlob("", "", "", "");
		assertNotNull("Blob cannot be null or empty", blob);
	}

	@Test
	public void testGetBlobs() {
		List<Blob> blobs = service.getBlobs("", "", "");
		assertNotNullOrEmpty("Blobs cannot be null or empty", blobs);
	}

	@Test
	public void testGetObjectContent() {
		InputStream objectContent = service.getObjectContent("", "", "");
		assertNotNullOrEmpty("Object content cannot be null or empty", convertStreamToString(objectContent));
	}

	@Test
	public void testGetTree() {
		List<Tree> trees = service.getTree("", "", "");
		assertNotNullOrEmpty("Tree cannot be null or empty", trees);
	}
}
