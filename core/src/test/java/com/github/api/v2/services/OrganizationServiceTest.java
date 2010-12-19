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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class RepositoryServiceTest.
 */
public class OrganizationServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private OrganizationService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createOrganizationService();
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

	@Test
	public void testAddTeamMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTeamRepository() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllOrganizationRepositories() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrganization() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPublicMembers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPublicRepositories() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeamMembers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeamRepositories() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeams() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserOrganizationsString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserOrganizations() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveTeamMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveTeamRepository() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOrganization() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTeam() {
		fail("Not yet implemented");
	}
}
