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
import java.util.Map;
import java.util.zip.ZipInputStream;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.schema.Repository.Visibility;

/**
 * The Interface RepositoryService.
 */
public interface RepositoryService extends GitHubService {
	
	/**
	 * Search repositories.
	 * 
	 * @param query
	 *            the query
	 * 
	 * @return the list< repository>
	 */
	public List<Repository> searchRepositories(String query);
	
	/**
	 * Search repositories.
	 * 
	 * @param query
	 *            the query
	 * @param language
	 *            the language
	 * 
	 * @return the list< repository>
	 */
	public List<Repository> searchRepositories(String query, Language language);
	
	/**
	 * Search repositories.
	 * 
	 * @param query
	 *            the query
	 * @param pageNumber
	 *            the page number
	 * 
	 * @return the list< repository>
	 */
	public List<Repository> searchRepositories(String query, int pageNumber);
	
	/**
	 * Search repositories.
	 * 
	 * @param query
	 *            the query
	 * @param language
	 *            the language
	 * @param pageNumber
	 *            the page number
	 * 
	 * @return the list< repository>
	 */
	public List<Repository> searchRepositories(String query, Language language, int pageNumber);
	
	/**
	 * Gets the repository.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the repository
	 */
	public Repository getRepository(String userName, String repositoryName);
	
	/**
	 * Update repository.
	 * 
	 * @param repository
	 *            the repository
	 */
	public void updateRepository(Repository repository);
	
	/**
	 * Gets the repositories.
	 * 
	 * @param userName
	 *            the user name
	 * 
	 * @return the repositories
	 */
	public List<Repository> getRepositories(String userName);
	
	/**
	 * Watch repository.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 */
	public void watchRepository(String userName, String repositoryName);
	
	/**
	 * Unwatch repository.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 */
	public void unwatchRepository(String userName, String repositoryName);
	
	/**
	 * Fork repository.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the repository
	 */
	public Repository forkRepository(String userName, String repositoryName);
	
	/**
	 * Creates the repository.
	 * 
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param homePage
	 *            the home page
	 * @param visibility
	 *            the visibility
	 * 
	 * @return the repository
	 */
	public Repository createRepository(String name, String description, String homePage, Visibility visibility);
	
	/**
	 * Delete repository.
	 * 
	 * @param repositoryName
	 *            the repository name
	 */
	public void deleteRepository(String repositoryName);
	
	/**
	 * Change visibility.
	 * 
	 * @param repositoryName
	 *            the repository name
	 * @param visibility
	 *            the visibility
	 */
	public void changeVisibility(String repositoryName, Visibility visibility);
	
	/**
	 * Gets the deploy keys.
	 * 
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the deploy keys
	 */
	public List<Key> getDeployKeys(String repositoryName);
	
	/**
	 * Adds the deploy key.
	 * 
	 * @param repositoryName
	 *            the repository name
	 * @param title
	 *            the title
	 * @param key
	 *            the key
	 * 
	 * @return the list< key>
	 */
	public List<Key> addDeployKey(String repositoryName, String title, String key);
	
	/**
	 * Removes the deploy key.
	 * 
	 * @param repository
	 *            the repository
	 * @param id
	 *            the id
	 */
	public void removeDeployKey(String repository, String id);
	
	/**
	 * Gets the collaborators.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the collaborators
	 */
	public List<String> getCollaborators(String userName, String repositoryName);
	
	/**
	 * Adds the collaborator.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param collaboratorName
	 *            the collaborator name
	 */
	public void addCollaborator(String userName, String repositoryName, String collaboratorName);
	
	/**
	 * Removes the collaborator.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param collaboratorName
	 *            the collaborator name
	 */
	public void removeCollaborator(String userName, String repositoryName, String collaboratorName);
	
	/**
	 * Gets the pushable repositories.
	 * 
	 * @return the pushable repositories
	 */
	public List<Repository> getPushableRepositories();
	
	/**
	 * Gets the contributors.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the contributors
	 */
	public List<User> getContributors(String userName, String repositoryName);
	
	/**
	 * Gets the watchers.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the watchers
	 */
	public List<String> getWatchers(String userName, String repositoryName);
	
	/**
	 * Gets the forks.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the forks
	 */
	public List<Repository> getForks(String userName, String repositoryName);
	
	/**
	 * Gets the language breakdown.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the language breakdown
	 */
	public Map<Language, Long> getLanguageBreakdown(String userName, String repositoryName);
	
	/**
	 * Gets the tags.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the tags
	 */
	public Map<String, String> getTags(String userName, String repositoryName);
	
	/**
	 * Gets the branches.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the branches
	 */
	public Map<String, String> getBranches(String userName, String repositoryName);
	
	/**
	 * Gets the repository archive.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param branchName
	 *            the branch name
	 * 
	 * @return the repository archive
	 */
	public ZipInputStream getRepositoryArchive(String userName, String repositoryName, String branchName);
}
