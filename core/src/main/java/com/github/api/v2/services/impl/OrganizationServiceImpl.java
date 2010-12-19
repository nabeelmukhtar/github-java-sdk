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
package com.github.api.v2.services.impl;

import java.util.List;

import com.github.api.v2.schema.Organization;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.Team;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.OrganizationService;
import com.google.gson.GsonBuilder;

/**
 * The Class OrganizationServiceImpl.
 */
public class OrganizationServiceImpl extends BaseGitHubService implements
		OrganizationService {

	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.impl.BaseGitHubService#getGsonBuilder()
	 */
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder gson = super.getGsonBuilder();
		gson.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return gson;
	}

	@Override
	public void addTeamMember(String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTeamRepository(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeam(String teamId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Repository> getAllOrganizationRepositories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organization getOrganization(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getPublicMembers(String organizationName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> getPublicRepositories(String organizationName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getTeam(String teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getTeamMembers(String teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> getTeamRepositories(String teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getTeams(String organizationName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organization> getUserOrganizations(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organization> getUserOrganizations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeTeamMember(String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTeamRepository(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrganization(Organization organization) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		
	}
}
