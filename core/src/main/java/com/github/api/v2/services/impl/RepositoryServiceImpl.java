/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.Tag;
import com.github.api.v2.schema.User;
import com.github.api.v2.schema.Repository.Visibility;
import com.github.api.v2.services.RepositoryService;

/**
 * @author nmukhtar
 *
 */
public class RepositoryServiceImpl extends BaseGitHubService implements
		RepositoryService {

	public RepositoryServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public void addCollaborator(String repositoryName, String collaboratorName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String addKey(String repositoryName, String title, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeVisibility(String repositoryName, Visibility visibility) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createRepository(String name, String description,
			String homePage, Visibility visibility) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRepository(String repositoryName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Repository forkRepository(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> getBranches(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getCollaborators(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getContributors(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> getForks(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Key> getKeys(String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Language, Long> getLanguageBreakdown(String userName,
			String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> getPushableRepositories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> getRepositories(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Repository getRepository(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> getTags(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getWatchers(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCollaborator(String repositoryName,
			String collaboratorName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeKey(String repository, String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Repository> searchRepositories(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> searchRepositories(String query, String language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> searchRepositories(String query, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> searchRepositories(String query, String language,
			int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unwatchRepository(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRepository(Repository repository) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void watchRepository(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		
	}

}
