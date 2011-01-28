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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.schema.Repository.Visibility;
import com.github.api.v2.services.RepositoryService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The Class RepositoryServiceImpl.
 */
public class RepositoryServiceImpl extends BaseGitHubService implements
		RepositoryService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#addCollaborator(java.lang.String, java.lang.String)
	 */
	@Override
	public void addCollaborator(String userName, String repositoryName, String collaboratorName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.ADD_COLLABORATOR_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.COLLABORATOR_NAME, collaboratorName).buildUrl();
        unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#addDeployKey(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Key> addDeployKey(String repositoryName, String title, String key) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.ADD_DEPLOY_KEY_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.TITLE, title);
        parameters.put(ParameterNames.KEY, key);
        JsonObject json = unmarshall(callApiPost(apiUrl, parameters));
        
        return unmarshall(new TypeToken<List<Key>>(){}, json.get("public_keys"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#changeVisibility(java.lang.String, com.github.api.v2.schema.Repository.Visibility)
	 */
	@Override
	public void changeVisibility(String repositoryName, Visibility visibility) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.CHANGE_VISIBILITY_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).withFieldEnum(ParameterNames.VISIBILITY, visibility).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        
        unmarshall(new TypeToken<Repository>(){}, json.get("repository"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#createRepository(java.lang.String, java.lang.String, java.lang.String, com.github.api.v2.schema.Repository.Visibility)
	 */
	@Override
	public Repository createRepository(String name, String description,
			String homePage, Visibility visibility) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.CREATE_REPOSITORY_URL);
        String                apiUrl  = builder.buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.NAME, name);
        parameters.put(ParameterNames.DESCRIPTION, description);
        parameters.put(ParameterNames.HOME_PAGE, homePage);
        parameters.put(ParameterNames.PUBLIC, ((visibility == Visibility.PUBLIC)? "1" : "0"));
        JsonObject json = unmarshall(callApiPost(apiUrl, parameters));
        
        return unmarshall(new TypeToken<Repository>(){}, json.get("repository"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#deleteRepository(java.lang.String)
	 */
	@Override
	public void deleteRepository(String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.DELETE_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        if (json.has("delete_token")) {
        	Map<String, String> parameters = new HashMap<String, String>();
        	parameters.put(ParameterNames.DELETE_TOKEN, json.get("delete_token").getAsString());
        	callApiPost(apiUrl, parameters);
        }
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#forkRepository(java.lang.String, java.lang.String)
	 */
	@Override
	public Repository forkRepository(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.FORK_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        return unmarshall(new TypeToken<Repository>(){}, json.get("repository"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getBranches(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, String> getBranches(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_BRANCHES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Map<String, String>>(){}, json.get("branches"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getCollaborators(java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> getCollaborators(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_COLLABORATORS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.get("collaborators"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getContributors(java.lang.String, java.lang.String)
	 */
	@Override
	public List<User> getContributors(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_CONTRIBUTORS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<User>>(){}, json.get("contributors"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getForks(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Repository> getForks(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_FORKS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("network"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getDeployKeys(java.lang.String)
	 */
	@Override
	public List<Key> getDeployKeys(String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_DEPLOY_KEYS_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Key>>(){}, json.get("public_keys"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getLanguageBreakdown(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<Language, Long> getLanguageBreakdown(String userName,
			String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_LANGUAGE_BREAKDOWN_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Map<Language, Long>>(){}, json.get("languages"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getPushableRepositories()
	 */
	@Override
	public List<Repository> getPushableRepositories() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_PUSHABLE_REPOSITORIES_URL);
        String                apiUrl  = builder.buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getRepositories(java.lang.String)
	 */
	@Override
	public List<Repository> getRepositories(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getRepository(java.lang.String, java.lang.String)
	 */
	@Override
	public Repository getRepository(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Repository>(){}, json.get("repository"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getTags(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, String> getTags(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_TAGS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Map<String, String>>(){}, json.get("tags"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getWatchers(java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> getWatchers(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_WATCHERS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.get("watchers"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#removeCollaborator(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeCollaborator(String userName, String repositoryName,
			String collaboratorName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.REMOVE_COLLABORATOR_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.COLLABORATOR_NAME, collaboratorName).buildUrl();
        unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#removeDeployKey(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeDeployKey(String repositoryName, String id) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.REMOVE_DEPLOY_KEY_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.ID, id);
        unmarshall(callApiPost(apiUrl, parameters));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#searchRepositories(java.lang.String)
	 */
	@Override
	public List<Repository> searchRepositories(String query) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.SEARCH_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, query).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#searchRepositories(java.lang.String, com.github.api.v2.schema.Language)
	 */
	@Override
	public List<Repository> searchRepositories(String query, Language language) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.SEARCH_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, query).withParameterEnum(ParameterNames.LANGUAGE, language).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#searchRepositories(java.lang.String, int)
	 */
	@Override
	public List<Repository> searchRepositories(String query, int pageNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.SEARCH_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, query).withParameter(ParameterNames.START_PAGE, String.valueOf(pageNumber)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#searchRepositories(java.lang.String, com.github.api.v2.schema.Language, int)
	 */
	@Override
	public List<Repository> searchRepositories(String query, Language language,
			int pageNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.SEARCH_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, query).withParameterEnum(ParameterNames.LANGUAGE, language).withParameter(ParameterNames.START_PAGE, String.valueOf(pageNumber)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#unwatchRepository(java.lang.String, java.lang.String)
	 */
	@Override
	public void unwatchRepository(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.UNWATCH_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#updateRepository(com.github.api.v2.schema.Repository)
	 */
	@Override
	public void updateRepository(Repository repository) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.UPDATE_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, repository.getOwner()).withField(ParameterNames.REPOSITORY_NAME, repository.getName()).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("values[" + ParameterNames.DESCRIPTION + "]", repository.getDescription());
        parameters.put("values[" + ParameterNames.HOME_PAGE + "]", repository.getHomepage());
        parameters.put("values[" + ParameterNames.HAS_WIKI + "]", String.valueOf(repository.isHasWiki()));
        parameters.put("values[" + ParameterNames.HAS_ISSUES + "]", String.valueOf(repository.isHasIssues()));
        parameters.put("values[" + ParameterNames.HAS_DOWNLOADS + "]", String.valueOf(repository.isHasDownloads()));
        JsonObject json = unmarshall(callApiPost(apiUrl, parameters));
        
        unmarshall(new TypeToken<Repository>(){}, json.get("repository"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#watchRepository(java.lang.String, java.lang.String)
	 */
	@Override
	public void watchRepository(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.WATCH_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.RepositoryService#getRepositoryArchive(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ZipInputStream getRepositoryArchive(String userName, String repositoryName, String branchName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_REPOSITORY_ARCHIVE_URL);
	    String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.BRANCH, branchName).buildUrl();
	    return new ZipInputStream(callApiGet(apiUrl));
	}
}
