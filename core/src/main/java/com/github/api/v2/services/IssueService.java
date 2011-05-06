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

import java.util.Date;
import java.util.List;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Event;
import com.github.api.v2.schema.Issue;
import com.github.api.v2.schema.Label;
import com.github.api.v2.schema.Milestone;
import com.github.api.v2.schema.Issue.State;

/**
 * The Interface IssueService.
 */
public interface IssueService extends GitHubService {
	
	/**
	 * Search issues.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param state
	 *            the state
	 * @param keyword
	 *            the keyword
	 * 
	 * @return the list< issue>
	 */
	public List<Issue> searchIssues(String userName, String repositoryName, State state, String keyword);
	
	/**
	 * Gets the issues.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param label
	 *            the label
	 * 
	 * @return the issues
	 */
	public List<Issue> getIssues(String userName, String repositoryName, String label);
	
	/**
	 * Gets the issues.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param state
	 *            the state
	 * 
	 * @return the issues
	 */
	public List<Issue> getIssues(String userName, String repositoryName, State state);
	
	/**
	 * Gets the issue.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * 
	 * @return the issue
	 */
	public Issue getIssue(String userName, String repositoryName, int issueNumber);
	
	/**
	 * Gets the issue comments.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * 
	 * @return the issue comments
	 */
	public List<Comment> getIssueComments(String userName, String repositoryName, int issueNumber);
	
	/**
	 * Gets the issue comment.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * @param commentId
	 *            the comment id
	 * 
	 * @return the issue comment
	 */
	public Comment getIssueComment(String userName, String repositoryName, int issueNumber, String commentId);
	
	/**
	 * Creates the issue.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param title
	 *            the title
	 * @param body
	 *            the body
	 */
	public void createIssue(String userName, String repositoryName, String title, String body);
	
	/**
	 * Close issue.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 */
	@Deprecated
	public void closeIssue(String userName, String repositoryName, int issueNumber);
	
	/**
	 * Reopen issue.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 */
	@Deprecated
	public void reopenIssue(String userName, String repositoryName, int issueNumber);
	
	/**
	 * Update issue.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * @param title
	 *            the title
	 * @param body
	 *            the body
	 */
	public void updateIssue(String userName, String repositoryName, int issueNumber, String title, String body);
	
	/**
	 * Update issue.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * @param title
	 *            the title
	 * @param body
	 *            the body
	 * @param state
	 *            the state
	 */
	public void updateIssue(String userName, String repositoryName, int issueNumber, String title, String body, State state);
	
	/**
	 * Gets the issue labels.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the issue labels
	 */
	public List<Label> getIssueLabels(String userName, String repositoryName);
	
	/**
	 * Gets the milestone labels.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param milestoneId
	 *            the milestone id
	 * 
	 * @return the milestone labels
	 */
	public List<Label> getMilestoneLabels(String userName, String repositoryName, String milestoneId);
	
	/**
	 * Gets the issue label.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param labelId
	 *            the label id
	 * 
	 * @return the issue label
	 */
	public Label getIssueLabel(String userName, String repositoryName, String labelId);
	
	/**
	 * Adds the label.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * @param label
	 *            the label
	 * 
	 * @return the list< label>
	 */
	public List<Label> addLabel(String userName, String repositoryName, int issueNumber, String label);
	
	/**
	 * Adds the label.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param label
	 *            the label
	 * @param color
	 *            the color
	 * 
	 * @return the label
	 */
	public Label addLabel(String userName, String repositoryName, String label, String color);
	
	/**
	 * Update label.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param labelId
	 *            the label id
	 * @param label
	 *            the label
	 * @param color
	 *            the color
	 * 
	 * @return the label
	 */
	public Label updateLabel(String userName, String repositoryName, String labelId, String label, String color);
	
	/**
	 * Delete label.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param labelId
	 *            the label id
	 */
	public void deleteLabel(String userName, String repositoryName, String labelId);
	
	/**
	 * Removes the label.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * @param labelId
	 *            the label id
	 * 
	 * @return the list< label>
	 */
	public List<Label> removeLabel(String userName, String repositoryName, int issueNumber, String labelId);
	
	/**
	 * Removes the labels.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 */
	public void removeLabels(String userName, String repositoryName, int issueNumber);
	
	/**
	 * Update labels.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * @param labels
	 *            the labels
	 * 
	 * @return the list< label>
	 */
	public List<Label> updateLabels(String userName, String repositoryName, int issueNumber, List<String> labels);
	
	/**
	 * Adds the comment.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * @param comment
	 *            the comment
	 */
	public void addComment(String userName, String repositoryName, int issueNumber, String comment);
	
	/**
	 * Update comment.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param commentId
	 *            the comment id
	 * @param comment
	 *            the comment
	 */
	public void updateComment(String userName, String repositoryName, String commentId, String comment);
	
	/**
	 * Delete comment.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param commentId
	 *            the comment id
	 */
	public void deleteComment(String userName, String repositoryName, String commentId);
	
	/**
	 * Gets the milestones.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the milestones
	 */
	public List<Milestone> getMilestones(String userName, String repositoryName);
	
	/**
	 * Gets the milestones.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param state
	 *            the state
	 * 
	 * @return the milestones
	 */
	public List<Milestone> getMilestones(String userName, String repositoryName, Milestone.State state);
	
	/**
	 * Gets the milestone.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param milestoneId
	 *            the milestone id
	 * 
	 * @return the milestone
	 */
	public Milestone getMilestone(String userName, String repositoryName, String milestoneId);
	
	/**
	 * Creates the milestone.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param title
	 *            the title
	 * @param description
	 *            the description
	 * @param state
	 *            the state
	 * @param dueDate
	 *            the due date
	 * 
	 * @return the milestone
	 */
	public Milestone createMilestone(String userName, String repositoryName, String title, String description, Milestone.State state, Date dueDate);
	
	/**
	 * Update milestone.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param milestoneId
	 *            the milestone id
	 * @param title
	 *            the title
	 * @param description
	 *            the description
	 * @param state
	 *            the state
	 * @param dueDate
	 *            the due date
	 * 
	 * @return the milestone
	 */
	public Milestone updateMilestone(String userName, String repositoryName, String milestoneId, String title, String description, Milestone.State state, Date dueDate);
	
	/**
	 * Delete milestone.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param milestoneId
	 *            the milestone id
	 */
	public void deleteMilestone(String userName, String repositoryName, String milestoneId);
	
	/**
	 * Gets the issue events.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param issueNumber
	 *            the issue number
	 * 
	 * @return the issue events
	 */
	public List<Event> getIssueEvents(String userName, String repositoryName, int issueNumber);
	
	/**
	 * Gets the issue event.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param eventId
	 *            the event id
	 * 
	 * @return the issue event
	 */
	public Event getIssueEvent(String userName, String repositoryName, String eventId);
	
	/**
	 * Gets the repository events.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the repository events
	 */
	public List<Event> getRepositoryEvents(String userName, String repositoryName);
	

}
