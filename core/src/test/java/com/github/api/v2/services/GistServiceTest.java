package com.github.api.v2.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GistServiceTest extends BaseGitHubServiceTest {
	private GistService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createGistService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testGetGist() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGistContent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserGists() {
		fail("Not yet implemented");
	}

}
