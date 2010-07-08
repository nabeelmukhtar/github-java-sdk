/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.List;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Issue;
import com.github.api.v2.schema.Issue.State;
import com.github.api.v2.services.IssueService;

/**
 * @author nmukhtar
 *
 */
public class IssueServiceImpl extends BaseGitHubService implements
		IssueService {

	public IssueServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public void addComment(String userName, String repositoryName,
			int issueNumber, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> addLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeIssue(String userName, String repositoryName,
			int issueNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createIssue(String userName, String repositoryName,
			String title, String body) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Issue getIssue(String userName, String repositoryName,
			int issueNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getIssueComments(String userName,
			String repositoryName, int issueNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getIssueLabels(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getIssues(String userName, String repositoryName,
			State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> removeLabel(String userName, String repositoryName,
			int issueNumber, String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reopenIssue(String userName, String repositoryName,
			int issueNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Issue> searchIssues(String userName, String repositoryName,
			State state, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateIssue(String userName, String repositoryName,
			int issueNumber, String title, String body) {
		// TODO Auto-generated method stub
		
	}

}
