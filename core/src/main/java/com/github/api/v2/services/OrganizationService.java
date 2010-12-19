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

import java.util.List;

import com.github.api.v2.schema.Organization;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.Team;
import com.github.api.v2.schema.User;

/**
 * The Interface OrganizationService.
 */
public interface OrganizationService extends GitHubService {
	public Organization getOrganization(String name);
	public void updateOrganization(Organization organization);
	public List<Organization> getUserOrganizations(String userName);	
	public List<Organization> getUserOrganizations();	
	public List<Repository> getAllOrganizationRepositories();
	public List<Repository> getPublicRepositories(String organizationName);
	public List<User> getPublicMembers(String organizationName);
	public List<Team> getTeams(String organizationName);
	public void createTeam(Team team);
	public Team getTeam(String teamId);
	public void updateTeam(Team team);
	public void deleteTeam(String teamId);
	public List<User> getTeamMembers(String teamId);
	public void addTeamMember(String userName);
	public void removeTeamMember(String userName);
	public List<Repository> getTeamRepositories(String teamId);
	public void addTeamRepository(String userName, String repositoryName);
	public void removeTeamRepository(String userName, String repositoryName);
}
