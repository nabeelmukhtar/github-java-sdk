/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.Tag;
import com.github.api.v2.schema.User;
import com.github.api.v2.schema.Repository.Visibility;
import com.github.api.v2.services.RepositoryService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * @author nmukhtar
 *
 */
public class RepositoryServiceImpl extends BaseGitHubService implements
		RepositoryService {

	@Override
	public void addCollaborator(String repositoryName, String collaboratorName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.ADD_COLLABORATOR_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.USER_NAME, collaboratorName).buildUrl();
        unmarshall(callApiPost(apiUrl, EMPTY_PARAMETERS));
	}

	@Override
	public String addDeployKey(String repositoryName, String title, String key) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.ADD_DEPLOY_KEY_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.TITLE, title);
        parameters.put(ParameterNames.KEY, key);
        JsonElement json = unmarshall(callApiPost(apiUrl, parameters));
        
        return unmarshall(new TypeToken<String>(){}, json.getAsJsonObject());
	}

	@Override
	public void changeVisibility(String repositoryName, Visibility visibility) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.CHANGE_VISIBILITY_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).withFieldEnum(ParameterNames.VISIBILITY, visibility).buildUrl();
        JsonElement json = unmarshall(callApiPost(apiUrl, EMPTY_PARAMETERS));
        
        unmarshall(new TypeToken<Repository>(){}, json.getAsJsonObject().get("repository"));
	}

	@Override
	public void createRepository(String name, String description,
			String homePage, Visibility visibility) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.CREATE_REPOSITORY_URL);
        String                apiUrl  = builder.buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.DESCRIPTION, "");
        parameters.put(ParameterNames.HOME_PAGE, "");
        parameters.put(ParameterNames.HAS_WIKI, "");
        parameters.put(ParameterNames.HAS_ISSUES, "");
        parameters.put(ParameterNames.HAS_DOWNLOADS, "");
        JsonElement json = unmarshall(callApiPost(apiUrl, parameters));
        
        unmarshall(new TypeToken<Repository>(){}, json.getAsJsonObject().get("repository"));
	}

	@Override
	public void deleteRepository(String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.DELETE_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiPost(apiUrl, EMPTY_PARAMETERS));
        
        unmarshall(new TypeToken<Repository>(){}, json.getAsJsonObject().get("repository"));
	}

	@Override
	public Repository forkRepository(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.FORK_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiPost(apiUrl, EMPTY_PARAMETERS));
        return unmarshall(new TypeToken<Repository>(){}, json.getAsJsonObject().get("repository"));
	}

	@Override
	public List<Tag> getBranches(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_BRANCHES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Tag>>(){}, json.getAsJsonObject().get("branches"));
	}

	@Override
	public List<User> getCollaborators(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_COLLABORATORS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<User>>(){}, json.getAsJsonObject().get("collaborators"));
	}

	@Override
	public List<User> getContributors(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_CONTRIBUTORS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<User>>(){}, json.getAsJsonObject().get("contributors"));
	}

	@Override
	public List<Repository> getForks(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_FORKS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.getAsJsonObject().get("network"));
	}

	@Override
	public List<Key> getDeployKeys(String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_DEPLOY_KEYS_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Key>>(){}, json.getAsJsonObject().get("public_keys"));
	}

	@Override
	public Map<Language, Long> getLanguageBreakdown(String userName,
			String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_LANGUAGE_BREAKDOWN_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Map<Language, Long>>(){}, json.getAsJsonObject().get("languages"));
	}

	@Override
	public List<Repository> getPushableRepositories() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_PUSHABLE_REPOSITORIES_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.getAsJsonObject().get("repositories"));
	}

	@Override
	public List<Repository> getRepositories(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.getAsJsonObject().get("repositories"));
	}

	@Override
	public Repository getRepository(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Repository>(){}, json.getAsJsonObject().get("repository"));
	}

	@Override
	public List<Tag> getTags(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_TAGS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Tag>>(){}, json.getAsJsonObject().get("tags"));
	}

	@Override
	public List<User> getWatchers(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.GET_WATCHERS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<User>>(){}, json.getAsJsonObject().get("watchers"));
	}

	@Override
	public void removeCollaborator(String repositoryName,
			String collaboratorName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.REMOVE_COLLABORATOR_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.USER_NAME, collaboratorName).buildUrl();
        unmarshall(callApiPost(apiUrl, EMPTY_PARAMETERS));
	}

	@Override
	public void removeDeployKey(String repositoryName, String id) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.REMOVE_DEPLOY_KEY_URL);
        String                apiUrl  = builder.withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.ID, id);
        unmarshall(callApiPost(apiUrl, parameters));
	}

	@Override
	public List<Repository> searchRepositories(String query) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.SEARCH_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, query).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.getAsJsonObject().get("repositories"));
	}

	@Override
	public List<Repository> searchRepositories(String query, Language language) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.SEARCH_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, query).withParameterEnum(ParameterNames.LANGUAGE, language).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.getAsJsonObject().get("repositories"));
	}

	@Override
	public List<Repository> searchRepositories(String query, int pageNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.SEARCH_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, query).withParameter(ParameterNames.START_PAGE, String.valueOf(pageNumber)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.getAsJsonObject().get("repositories"));
	}

	@Override
	public List<Repository> searchRepositories(String query, Language language,
			int pageNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.SEARCH_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.KEYWORD, query).withParameterEnum(ParameterNames.LANGUAGE, language).withParameter(ParameterNames.START_PAGE, String.valueOf(pageNumber)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.getAsJsonObject().get("repositories"));
	}

	@Override
	public void unwatchRepository(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.UNWATCH_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        unmarshall(callApiPost(apiUrl, EMPTY_PARAMETERS));
	}

	@Override
	public void updateRepository(Repository repository) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.UPDATE_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, "").withField(ParameterNames.REPOSITORY_NAME, "").buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.DESCRIPTION, "");
        parameters.put(ParameterNames.HOME_PAGE, "");
        parameters.put(ParameterNames.HAS_WIKI, "");
        parameters.put(ParameterNames.HAS_ISSUES, "");
        parameters.put(ParameterNames.HAS_DOWNLOADS, "");
        JsonElement json = unmarshall(callApiPost(apiUrl, parameters));
        
        unmarshall(new TypeToken<Repository>(){}, json.getAsJsonObject().get("repository"));
	}

	@Override
	public void watchRepository(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.RepositoryApiUrls.WATCH_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        unmarshall(callApiPost(apiUrl, EMPTY_PARAMETERS));
	}
}
