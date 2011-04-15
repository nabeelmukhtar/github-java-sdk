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
import com.github.api.v2.schema.Permission;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.Team;
import com.github.api.v2.schema.User;

/**
 * The Interface OrganizationService.
 */
public interface OrganizationService extends GitHubService {
	
	/**
	 * Gets the organization.
	 * 
	 * @param name
	 *            the name
	 * 
	 * @return the organization
	 */
	public Organization getOrganization(String name);
	
	/**
	 * Gets the user organizations.
	 * 
	 * @return the user organizations
	 */
	public List<Organization> getUserOrganizations();	
	
	/**
	 * Update organization.
	 * 
	 * @param organization
	 *            the organization
	 */
	public void updateOrganization(Organization organization);
	
	/**
	 * Gets the all organization repositories.
	 * 
	 * @return the all organization repositories
	 */
	public List<Repository> getAllOrganizationRepositories();
	
	/**
	 * Gets the public repositories.
	 * 
	 * @param organizationName
	 *            the organization name
	 * 
	 * @return the public repositories
	 */
	public List<Repository> getPublicRepositories(String organizationName);
	
	/**
	 * Gets the public members.
	 * 
	 * @param organizationName
	 *            the organization name
	 * 
	 * @return the public members
	 */
	public List<User> getPublicMembers(String organizationName);
	
	/**
	 * Gets the owners.
	 * 
	 * @param organizationName
	 *            the organization name
	 * 
	 * @return the owners
	 */
	public List<User> getOwners(String organizationName);
	
	/**
	 * Gets the teams.
	 * 
	 * @param organizationName
	 *            the organization name
	 * 
	 * @return the teams
	 */
	public List<Team> getTeams(String organizationName);
	
	/**
	 * Creates the team.
	 * 
	 * @param organizationName
	 *            the organization name
	 * @param teamName
	 *            the team name
	 * @param permission
	 *            the permission
	 * @param repoNames
	 *            the repo names
	 * 
	 * @return the team
	 */
	public Team createTeam(String organizationName, String teamName, Permission permission, List<String> repoNames);
	
	/**
	 * Gets the team.
	 * 
	 * @param teamId
	 *            the team id
	 * 
	 * @return the team
	 */
	public Team getTeam(String teamId);
	
	/**
	 * Update team.
	 * 
	 * @param team
	 *            the team
	 */
	public void updateTeam(Team team);
	
	/**
	 * Delete team.
	 * 
	 * @param teamId
	 *            the team id
	 */
	public void deleteTeam(String teamId);
	
	/**
	 * Gets the team members.
	 * 
	 * @param teamId
	 *            the team id
	 * 
	 * @return the team members
	 */
	public List<User> getTeamMembers(String teamId);
	
	/**
	 * Adds the team member.
	 * 
	 * @param teamId
	 *            the team id
	 * @param userName
	 *            the user name
	 */
	public void addTeamMember(String teamId, String userName);
	
	/**
	 * Removes the team member.
	 * 
	 * @param teamId
	 *            the team id
	 * @param userName
	 *            the user name
	 */
	public void removeTeamMember(String teamId, String userName);
	
	/**
	 * Gets the team repositories.
	 * 
	 * @param teamId
	 *            the team id
	 * 
	 * @return the team repositories
	 */
	public List<Repository> getTeamRepositories(String teamId);
	
	/**
	 * Adds the team repository.
	 * 
	 * @param teamId
	 *            the team id
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 */
	public void addTeamRepository(String teamId, String userName, String repositoryName);
	
	/**
	 * Removes the team repository.
	 * 
	 * @param teamId
	 *            the team id
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 */
	public void removeTeamRepository(String teamId, String userName, String repositoryName);
}
