package com.github.api.v2.services;

import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Gist;

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
		Gist gist = service.getGist("");
		assertNotNull("Gist cannot be null", gist);
	}

	@Test
	public void testGetGistContent() {
		InputStream gistContent = service.getGistContent("", "");
		assertNotNullOrEmpty("Gist content cannot be null or empty", convertStreamToString(gistContent));
	}

	@Test
	public void testGetUserGists() {
		List<Gist> gists = service.getUserGists("");
		assertNotNullOrEmpty("Gists cannot be null or empty.", gists);
	}
}
