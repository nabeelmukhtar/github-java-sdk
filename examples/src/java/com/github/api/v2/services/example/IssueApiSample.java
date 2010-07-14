/**
 * 
 */
package com.github.api.v2.services.example;

import java.util.List;

import com.github.api.v2.schema.Issue;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.IssueService;

/**
 * The Class IssueApiSample.
 */
public class IssueApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		IssueService service = factory.createIssueService();
		List<Issue> issues = service.searchIssues("facebook", "tornado", Issue.State.OPEN, "type");
		for (Issue issue : issues) {
			printResult(issue);
		}
		Issue issue = service.getIssue("facebook", "tornado", 1);
		printResult(issue);
	}
    
	/**
	 * Prints the result.
	 * 
	 * @param issue
	 *            the issue
	 */
	private static void printResult(Issue issue) {
		System.out.println(issue);
	}
}
