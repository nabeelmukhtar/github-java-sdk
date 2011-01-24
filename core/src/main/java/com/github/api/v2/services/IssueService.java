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

import java.util.List;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Issue;
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
	 * Gets the issue labels.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the issue labels
	 */
	public List<String> getIssueLabels(String userName, String repositoryName);
	
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
	 * @return the list< string>
	 */
	public List<String> addLabel(String userName, String repositoryName, int issueNumber, String label);
	
	/**
	 * Removes the label.
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
	 * @return the list< string>
	 */
	public List<String> removeLabel(String userName, String repositoryName, int issueNumber, String label);
	
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

}
