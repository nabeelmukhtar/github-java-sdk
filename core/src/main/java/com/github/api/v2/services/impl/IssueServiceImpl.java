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
 * The Class IssueServiceImpl.
 */
public class IssueServiceImpl extends BaseGitHubService implements
		IssueService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#addComment(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public void addComment(String userName, String repositoryName,
			int issueNumber, String comment) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_COMMENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.COMMENT, comment);
        callApiPost(apiUrl, parameters, 201);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#addLabel(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public List<String> addLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL, label).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.get("labels"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#closeIssue(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void closeIssue(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.CLOSE_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		callApiPost(apiUrl, new HashMap<String, String>());
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#createIssue(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void createIssue(String userName, String repositoryName,
			String title, String body) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.CREATE_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.TITLE, title);
        parameters.put(ParameterNames.BODY, body);
//        JsonObject json = unmarshall(callApiPost(apiUrl, parameters));
        callApiPost(apiUrl, parameters, 201);
//        return unmarshall(new TypeToken<Issue>(){}, json.get("issue"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssue(java.lang.String, java.lang.String, int)
	 */
	@Override
	public Issue getIssue(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Issue>(){}, json.get("issue"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueComments(java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Comment> getIssueComments(String userName,
			String repositoryName, int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_COMMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Comment>>(){}, json.get("comments"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueLabels(java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> getIssueLabels(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_LABELS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.get("labels"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssues(java.lang.String, java.lang.String, com.github.api.v2.schema.Issue.State)
	 */
	@Override
	public List<Issue> getIssues(String userName, String repositoryName,
			State state) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withFieldEnum(ParameterNames.STATE, state).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Issue>>(){}, json.get("issues"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#removeLabel(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public List<String> removeLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.REMOVE_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL, label).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        
        return unmarshall(new TypeToken<List<String>>(){}, json.get("labels"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#reopenIssue(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void reopenIssue(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.REOPEN_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		callApiPost(apiUrl, new HashMap<String, String>());
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#searchIssues(java.lang.String, java.lang.String, com.github.api.v2.schema.Issue.State, java.lang.String)
	 */
	@Override
	public List<Issue> searchIssues(String userName, String repositoryName,
			State state, String keyword) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.SEARCH_ISSUES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withFieldEnum(ParameterNames.STATE, state).withField(ParameterNames.KEYWORD, keyword).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Issue>>(){}, json.get("issues"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssues(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Issue> getIssues(String userName, String repositoryName,
			String label) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUES_BY_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL, label).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Issue>>(){}, json.get("issues"));
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateIssue(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)
	 */
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
