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

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Event;
import com.github.api.v2.schema.Issue;
import com.github.api.v2.schema.Label;
import com.github.api.v2.schema.Milestone;
import com.github.api.v2.schema.Issue.State;
import com.github.api.v2.services.IssueService;
import com.github.api.v2.services.constant.ApplicationConstants;
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
	public Comment addIssueComment(String userName, String repositoryName,
			int issueNumber, String comment) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_ISSUE_COMMENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		Comment bean = new Comment();
		bean.setBody(comment);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(bean), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 201));
        return unmarshall(new TypeToken<Comment>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#addLabel(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public List<Label> addIssueLabels(String userName, String repositoryName,
			int issueNumber, List<String> labels) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_ISSUE_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonElement json = unmarshallArray(callApiMethod(apiUrl, marshall(labels), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 200));
        return unmarshall(new TypeToken<List<Label>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#closeIssue(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void closeIssue(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_ISSUE_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		Issue issue = new Issue();
		issue.setState(Issue.State.CLOSED);
        callApiMethod(apiUrl, marshall(issue), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 200);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#createIssue(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Issue createIssue(String userName, String repositoryName,
			String title, String body) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.CREATE_ISSUE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
		Issue issue = new Issue();
		issue.setTitle(title);
		issue.setBody(body);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(issue), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 201));
        return unmarshall(new TypeToken<Issue>(){}, json);
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
        
        return unmarshall(new TypeToken<Issue>(){}, json);
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
	public List<Label> getLabels(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_LABELS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Label>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueLabels(java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Label> getIssueLabels(String userName, String repositoryName, int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_LABELS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Label>>(){}, json);
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssues(java.lang.String, java.lang.String, com.github.api.v2.schema.Issue.State)
	 */
	@Override
	public List<Issue> getIssues(String userName, String repositoryName,
			State state) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withParameterEnum(ParameterNames.STATE, state).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Issue>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#removeLabel(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public List<Label> removeIssueLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.DELETE_ISSUE_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL, label).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonElement json = unmarshallArray(callApiPost(apiUrl, new HashMap<String, String>()));
        
        return unmarshall(new TypeToken<List<Label>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#reopenIssue(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void reopenIssue(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_ISSUE_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		Issue issue = new Issue();
		issue.setState(Issue.State.OPEN);
        callApiMethod(apiUrl, marshall(issue), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 200);
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
	public Issue updateIssue(String userName, String repositoryName,
			int issueNumber, String title, String body) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_ISSUE_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		Issue issue = new Issue();
		issue.setTitle(title);
		issue.setBody(body);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(issue), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 200));
        return unmarshall(new TypeToken<Issue>(){}, json);
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
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.ADD_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Label bean = new Label();
        bean.setName(label);
        bean.setColor(color);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(bean), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 201));
        
        return unmarshall(new TypeToken<Label>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#createMilestone(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.github.api.v2.schema.Milestone.State, java.util.Date)
	 */
	@Override
	public Milestone createMilestone(String userName, String repositoryName,
			String title, String description,
			com.github.api.v2.schema.Milestone.State state, Date dueDate) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.CREATE_MILESTONE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Milestone bean = new Milestone();
        bean.setTitle(title);
        bean.setDescription(description);
        bean.setState(state);
        bean.setDueOn(dueDate);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(bean), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 201));
        
        return unmarshall(new TypeToken<Milestone>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#deleteComment(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteIssueComment(String userName, String repositoryName,
			String commentId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.DELETE_ISSUE_COMMENT_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.COMMENT_ID, commentId).buildUrl();
		callApiDelete(apiUrl, 200);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#deleteLabel(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteLabel(String userName, String repositoryName,
			String labelId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.DELETE_LABEL_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL_ID, labelId).buildUrl();
		callApiDelete(apiUrl, 200);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#deleteMilestone(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteMilestone(String userName, String repositoryName,
			String milestoneId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.DELETE_MILESTONE_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.MILESTONE_ID, milestoneId).buildUrl();
		callApiDelete(apiUrl, 200);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueComment(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public Comment getIssueComment(String userName, String repositoryName,
			int issueNumber, String commentId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_COMMENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).withField(ParameterNames.COMMENT_ID, commentId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Comment>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueEvent(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Event getIssueEvent(String userName, String repositoryName,
			String eventId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_EVENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.EVENT_ID, eventId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Event>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueEvents(java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Event> getIssueEvents(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_ISSUE_EVENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Event>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getIssueLabel(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Label getIssueLabel(String userName, String repositoryName,
			String labelId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_LABEL_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL_ID, labelId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Label>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getMilestone(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Milestone getMilestone(String userName, String repositoryName,
			String milestoneId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_MILESTONE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.MILESTONE_ID, milestoneId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Milestone>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getMilestoneLabels(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Label> getMilestoneLabels(String userName,
			String repositoryName, String milestoneId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_MILESTONE_LABELS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.MILESTONE_ID, milestoneId).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Label>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getMilestones(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Milestone> getMilestones(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_MILESTONES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Milestone>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getMilestones(java.lang.String, java.lang.String, com.github.api.v2.schema.Milestone.State)
	 */
	@Override
	public List<Milestone> getMilestones(String userName,
			String repositoryName,
			com.github.api.v2.schema.Milestone.State state) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_MILESTONES_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withParameterEnum(ParameterNames.STATE, state).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Milestone>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#getRepositoryEvents(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Event> getRepositoryEvents(String userName,
			String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.GET_REPOSITORY_EVENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Event>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#removeLabels(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void removeIssueLabels(String userName, String repositoryName,
			int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.DELETE_ISSUE_LABELS_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		callApiDelete(apiUrl, 200);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateComment(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Comment updateIssueComment(String userName, String repositoryName,
			String commentId, String comment) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_ISSUE_COMMENT_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.COMMENT_ID, commentId).buildUrl();
		Comment bean = new Comment();
		bean.setBody(comment);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(bean), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 200));
        return unmarshall(new TypeToken<Comment>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateIssue(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, com.github.api.v2.schema.Issue.State)
	 */
	@Override
	public Issue updateIssue(String userName, String repositoryName,
			int issueNumber, String title, String body, State state) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_ISSUE_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
		Issue issue = new Issue();
		issue.setTitle(title);
		issue.setBody(body);
		issue.setState(state);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(issue), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 200));
        return unmarshall(new TypeToken<Issue>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateLabel(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Label updateLabel(String userName, String repositoryName,
			String labelId, String label, String color) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_LABEL_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.LABEL_ID, labelId).buildUrl();
		Label bean = new Label();
		bean.setName(label);
		bean.setColor(color);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(bean), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 200));
        return unmarshall(new TypeToken<Label>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateLabels(java.lang.String, java.lang.String, int, java.util.List)
	 */
	@Override
	public List<Label> updateIssueLabels(String userName, String repositoryName,
			int issueNumber, List<String> labels) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_LABEL_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonElement json = unmarshallArray(callApiMethod(apiUrl, marshall(labels), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.PUT, 200));
        return unmarshall(new TypeToken<List<Label>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.IssueService#updateMilestone(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.github.api.v2.schema.Milestone.State, java.util.Date)
	 */
	@Override
	public Milestone updateMilestone(String userName, String repositoryName,
			String milestoneId, String title, String description,
			com.github.api.v2.schema.Milestone.State state, Date dueDate) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.IssueApiUrls.UPDATE_MILESTONE_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.MILESTONE_ID, milestoneId).buildUrl();
		Milestone milestone = new Milestone();
		milestone.setTitle(title);
		milestone.setDescription(description);
		milestone.setState(state);
		milestone.setDueOn(dueDate);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(milestone), ApplicationConstants.CONTENT_TYPE_JSON, HttpMethod.POST, 200));
        return unmarshall(new TypeToken<Milestone>(){}, json);
	}
}
