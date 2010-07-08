/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Issue;
import com.github.api.v2.schema.Issue.State;

/**
 * @author nmukhtar
 *
 */
public interface IssueService extends GitHubService {
	public List<Issue> searchIssues(String userName, String repositoryName, State state, String keyword);
	public List<Issue> getIssues(String userName, String repositoryName, State state);
	public Issue getIssue(String userName, String repositoryName, int issueNumber);
	public List<Comment> getIssueComments(String userName, String repositoryName, int issueNumber);
	public void createIssue(String userName, String repositoryName, String title, String body);
	public void closeIssue(String userName, String repositoryName, int issueNumber);
	public void reopenIssue(String userName, String repositoryName, int issueNumber);
	public void updateIssue(String userName, String repositoryName, int issueNumber, String title, String body);
	public List<String> getIssueLabels(String userName, String repositoryName);
	public List<String> addLabel(String userName, String repositoryName, int issueNumber, String label);
	public List<String> removeLabel(String userName, String repositoryName, int issueNumber, String label);
	public void addComment(String userName, String repositoryName, int issueNumber, String comment);

}
