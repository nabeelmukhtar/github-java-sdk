package com.github.api.v2.services;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Network;

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
		List<Commit> commits = service.getNetworkData("", "", "");
		assertNotNullOrEmpty("Commits should not be null or empty.", commits);
	}

	@Test
	public void testGetNetworkDataStringStringStringIntInt() {
		List<Commit> commits = service.getNetworkData("", "", "", 1, 5);
		assertNotNullOrEmpty("Commits should not be null or empty.", commits);
	}

	@Test
	public void testGetNetworkMeta() {
		Network networkMeta = service.getNetworkMeta("", "");
		assertNotNull("Network cannot be null", networkMeta);
	}

}
