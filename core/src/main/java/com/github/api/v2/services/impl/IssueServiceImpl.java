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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Event;
import com.github.api.v2.schema.Issue;
import com.github.api.v2.schema.Label;
import com.github.api.v2.schema.Milestone;
import com.github.api.v2.schema.Issue.State;
import com.github.api.v2.services.IssueService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_ISSUE_COMMENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.COMMENT, comment);
        callApiPost(apiUrl, parameters, 201);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#addLabel(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public List<Label> addLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL, label).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        
        return unmarshall(new TypeToken<List<Label>>(){}, json.get("labels"));
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
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Comment>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueLabels(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Label> getIssueLabels(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_LABELS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Label>>(){}, json.get("labels"));
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
	public List<Label> removeLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.DELETE_ISSUE_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL, label).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiPost(apiUrl, new HashMap<String, String>()));
        
        return unmarshall(new TypeToken<List<Label>>(){}, json.get("labels"));
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
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.impl.BaseGitHubService#getGsonBuilder()
	 */
	@Override
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder gson = super.getGsonBuilder();
		gson.setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		return gson;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#addLabel(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Label addLabel(String userName, String repositoryName, String label,
			String color) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#createMilestone(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.github.api.v2.schema.Milestone.State, java.util.Date)
	 */
	@Override
	public Milestone createMilestone(String userName, String repositoryName,
			String title, String description,
			com.github.api.v2.schema.Milestone.State state, Date dueDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#deleteComment(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteComment(String userName, String repositoryName,
			String commentId) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#deleteLabel(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteLabel(String userName, String repositoryName,
			String labelId) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#deleteMilestone(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteMilestone(String userName, String repositoryName,
			String milestoneId) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueComment(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public Comment getIssueComment(String userName, String repositoryName,
			int issueNumber, String commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueEvent(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Event getIssueEvent(String userName, String repositoryName,
			String eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueEvents(java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Event> getIssueEvents(String userName, String repositoryName,
			int issueNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueLabel(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Label getIssueLabel(String userName, String repositoryName,
			String labelId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getMilestone(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Milestone getMilestone(String userName, String repositoryName,
			String milestoneId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getMilestoneLabels(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Label> getMilestoneLabels(String userName,
			String repositoryName, String milestoneId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getMilestones(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Milestone> getMilestones(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getMilestones(java.lang.String, java.lang.String, com.github.api.v2.schema.Milestone.State)
	 */
	@Override
	public List<Milestone> getMilestones(String userName,
			String repositoryName,
			com.github.api.v2.schema.Milestone.State state) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getRepositoryEvents(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Event> getRepositoryEvents(String userName,
			String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#removeLabels(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void removeLabels(String userName, String repositoryName,
			int issueNumber) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateComment(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateComment(String userName, String repositoryName,
			String commentId, String comment) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateIssue(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, com.github.api.v2.schema.Issue.State)
	 */
	@Override
	public void updateIssue(String userName, String repositoryName,
			int issueNumber, String title, String body, State state) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateLabel(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Label updateLabel(String userName, String repositoryName,
			String labelId, String label, String color) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateLabels(java.lang.String, java.lang.String, int, java.util.List)
	 */
	@Override
	public List<Label> updateLabels(String userName, String repositoryName,
			int issueNumber, List<String> labels) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateMilestone(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.github.api.v2.schema.Milestone.State, java.util.Date)
	 */
	@Override
	public Milestone updateMilestone(String userName, String repositoryName,
			String milestoneId, String title, String description,
			com.github.api.v2.schema.Milestone.State state, Date dueDate) {
		// TODO Auto-generated method stub
		return null;
	}
}
