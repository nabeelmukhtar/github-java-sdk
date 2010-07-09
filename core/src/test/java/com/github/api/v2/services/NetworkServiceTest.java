package com.github.api.v2.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NetworkServiceTest extends BaseGitHubServiceTest {
	private NetworkService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createNetworkService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testGetNetworkDataStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNetworkDataStringStringStringIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNetworkMeta() {
		fail("Not yet implemented");
	}

}
