package com.github.api.v2.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		fail("Not yet implemented");
	}

	@Test
	public void testGetBlobs() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetObjectContent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTree() {
		fail("Not yet implemented");
	}

}
