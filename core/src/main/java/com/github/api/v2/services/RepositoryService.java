/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.schema.Repository.Visibility;

/**
 * @author nmukhtar
 *
 */
public interface RepositoryService extends GitHubService {
	public List<Repository> searchRepositories(String query);
	public List<Repository> searchRepositories(String query, Language language);
	public List<Repository> searchRepositories(String query, int pageNumber);
	public List<Repository> searchRepositories(String query, Language language, int pageNumber);
	public Repository getRepository(String userName, String repositoryName);
	public void updateRepository(Repository repository);
	public List<Repository> getRepositories(String userName);
	public void watchRepository(String userName, String repositoryName);
	public void unwatchRepository(String userName, String repositoryName);
	public Repository forkRepository(String userName, String repositoryName);
	public void createRepository(String name, String description, String homePage, Visibility visibility);
	public void deleteRepository(String repositoryName);
	public void changeVisibility(String repositoryName, Visibility visibility);
	public List<Key> getDeployKeys(String repositoryName);
	public String addDeployKey(String repositoryName, String title, String key);
	public void removeDeployKey(String repository, String id);
	public List<String> getCollaborators(String userName, String repositoryName);
	public void addCollaborator(String repositoryName, String collaboratorName);
	public void removeCollaborator(String repositoryName, String collaboratorName);
	public List<Repository> getPushableRepositories();
	public List<User> getContributors(String userName, String repositoryName);
	public List<String> getWatchers(String userName, String repositoryName);
	public List<Repository> getForks(String userName, String repositoryName);
	public Map<Language, Long> getLanguageBreakdown(String userName, String repositoryName);
	public Map<String, String> getTags(String userName, String repositoryName);
	public Map<String, String> getBranches(String userName, String repositoryName);
}
