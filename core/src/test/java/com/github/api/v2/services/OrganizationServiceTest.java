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
 * The Class OrganizationServiceTest.
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

	/**
	 * Test add team member.
	 */
	@Test
	public void testAddTeamMember() {
		fail("Not yet implemented");
	}

	/**
	 * Test add team repository.
	 */
	@Test
	public void testAddTeamRepository() {
		fail("Not yet implemented");
	}

	/**
	 * Test create team.
	 */
	@Test
	public void testCreateTeam() {
		fail("Not yet implemented");
	}

	/**
	 * Test delete team.
	 */
	@Test
	public void testDeleteTeam() {
		fail("Not yet implemented");
	}

	/**
	 * Test get all organization repositories.
	 */
	@Test
	public void testGetAllOrganizationRepositories() {
		fail("Not yet implemented");
	}

	/**
	 * Test get organization.
	 */
	@Test
	public void testGetOrganization() {
		fail("Not yet implemented");
	}

	/**
	 * Test get public members.
	 */
	@Test
	public void testGetPublicMembers() {
		fail("Not yet implemented");
	}

	/**
	 * Test get public repositories.
	 */
	@Test
	public void testGetPublicRepositories() {
		fail("Not yet implemented");
	}

	/**
	 * Test get team.
	 */
	@Test
	public void testGetTeam() {
		fail("Not yet implemented");
	}

	/**
	 * Test get team members.
	 */
	@Test
	public void testGetTeamMembers() {
		fail("Not yet implemented");
	}

	/**
	 * Test get team repositories.
	 */
	@Test
	public void testGetTeamRepositories() {
		fail("Not yet implemented");
	}

	/**
	 * Test get teams.
	 */
	@Test
	public void testGetTeams() {
		fail("Not yet implemented");
	}

	/**
	 * Test get user organizations string.
	 */
	@Test
	public void testGetUserOrganizationsString() {
		fail("Not yet implemented");
	}

	/**
	 * Test get user organizations.
	 */
	@Test
	public void testGetUserOrganizations() {
		fail("Not yet implemented");
	}

	/**
	 * Test remove team member.
	 */
	@Test
	public void testRemoveTeamMember() {
		fail("Not yet implemented");
	}

	/**
	 * Test remove team repository.
	 */
	@Test
	public void testRemoveTeamRepository() {
		fail("Not yet implemented");
	}

	/**
	 * Test update organization.
	 */
	@Test
	public void testUpdateOrganization() {
		fail("Not yet implemented");
	}

	/**
	 * Test update team.
	 */
	@Test
	public void testUpdateTeam() {
		fail("Not yet implemented");
	}
}
