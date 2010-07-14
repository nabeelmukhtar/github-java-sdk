/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Issue;
import com.github.api.v2.schema.Issue.State;
import com.github.api.v2.services.IssueService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * @author nmukhtar
 *
 */
public class IssueServiceImpl extends BaseGitHubService implements
		IssueService {

	@Override
	public void addComment(String userName, String repositoryName,
			int issueNumber, String comment) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_COMMENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.COMMENT, comment);
        callApiPost(apiUrl, parameters);
	}

	@Override
	public List<String> addLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL, label).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.get("labels"));
	}

	@Override
	public void closeIssue(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.CLOSE_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		callApiPost(apiUrl, new HashMap<String, String>());
	}

	@Override
	public void createIssue(String userName, String repositoryName,
			String title, String body) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.CREATE_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.TITLE, title);
        parameters.put(ParameterNames.BODY, body);
		callApiPost(apiUrl, parameters);
	}

	@Override
	public Issue getIssue(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Issue>(){}, json.get("issue"));
	}

	@Override
	public List<Comment> getIssueComments(String userName,
			String repositoryName, int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_COMMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Comment>>(){}, json.get("comments"));
	}

	@Override
	public List<String> getIssueLabels(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_LABELS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.get("labels"));
	}

	@Override
	public List<Issue> getIssues(String userName, String repositoryName,
			State state) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withFieldEnum(ParameterNames.STATE, state).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Issue>>(){}, json.get("issues"));
	}

	@Override
	public List<String> removeLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.REMOVE_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL, label).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.get("labels"));
	}

	@Override
	public void reopenIssue(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.REOPEN_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		callApiPost(apiUrl, new HashMap<String, String>());
	}

	@Override
	public List<Issue> searchIssues(String userName, String repositoryName,
			State state, String keyword) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.SEARCH_ISSUES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withFieldEnum(ParameterNames.STATE, state).withField(ParameterNames.KEYWORD, keyword).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Issue>>(){}, json.get("issues"));
	}

	@Override
	public void updateIssue(String userName, String repositoryName,
			int issueNumber, String title, String body) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.TITLE, title);
        parameters.put(ParameterNames.BODY, body);
		callApiPost(apiUrl, parameters);
	}
}
