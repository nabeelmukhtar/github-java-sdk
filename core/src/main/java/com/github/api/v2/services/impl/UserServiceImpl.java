/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.UserService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * @author nmukhtar
 *
 */
public class UserServiceImpl extends BaseGitHubService implements
		UserService {

	public UserServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public void addEmail(String email) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.ADD_EMAIL_URL);
        String                apiUrl  = builder.buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.EMAIL, email);
		callApiPost(apiUrl, parameters);
	}

	@Override
	public void addKey(String title, String key) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.ADD_KEY_URL);
        String                apiUrl  = builder.buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.TITLE, title);
        parameters.put(ParameterNames.KEY, key);
		callApiPost(apiUrl, parameters);
	}

	@Override
	public void followUser(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.FOLLOW_USER_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
		callApiPost(apiUrl, EMPTY_PARAMETERS);
	}

	@Override
	public User getCurrentUser() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.GET_CURRENT_USER_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<User>(){}, json.getAsJsonObject().get("user"));
	}

	@Override
	public List<String> getEmails() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.GET_EMAILS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.getAsJsonObject().get("emails"));
	}

	@Override
	public List<Key> getKeys() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.GET_KEYS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Key>>(){}, json.getAsJsonObject().get("keys"));
	}

	@Override
	public User getUser(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.GET_USER_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<User>(){}, json.getAsJsonObject().get("user"));
	}

	@Override
	public List<String> getUserFollowers(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.GET_USER_FOLLOWERS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.getAsJsonObject().get("users"));
	}

	@Override
	public List<String> getUserFollowing(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.GET_USER_FOLLOWING_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.getAsJsonObject().get("users"));
	}

	@Override
	public List<Repository> getWatchedRepositories(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.GET_WATCHED_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.getAsJsonObject().get("repositories"));
	}

	@Override
	public void removeEmail(String email) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.REMOVE_EMAIL_URL);
        String                apiUrl  = builder.buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.EMAIL, email);
		callApiPost(apiUrl, parameters);
	}

	@Override
	public void removeKey(String id) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.REMOVE_KEY_URL);
        String                apiUrl  = builder.buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.ID, id);
		callApiPost(apiUrl, parameters);
	}

	@Override
	public List<User> searchUsersByEmail(String email) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.SEARCH_USERS_BY_NAME_URL);
        String                apiUrl  = builder.withField(ParameterNames.EMAIL, email).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<User>>(){}, json.getAsJsonObject().get("users"));
	}

	@Override
	public List<User> searchUsersByName(String name) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.SEARCH_USERS_BY_NAME_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, name).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<User>>(){}, json.getAsJsonObject().get("users"));
	}

	@Override
	public void unfollowUser(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.UNFOLLOW_USER_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
		callApiPost(apiUrl, EMPTY_PARAMETERS);
	}

	@Override
	public void updateUser(User user) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.UserApiUrls.UPDATE_USER_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, user.getUsername()).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.NAME, user.getName());
        parameters.put(ParameterNames.EMAIL, user.getEmail());
        parameters.put(ParameterNames.BLOG, user.getBlog());
        parameters.put(ParameterNames.COMPANY, user.getCompany());
        parameters.put(ParameterNames.LOCATION, user.getLocation());
		callApiPost(apiUrl, parameters);
	}

}
