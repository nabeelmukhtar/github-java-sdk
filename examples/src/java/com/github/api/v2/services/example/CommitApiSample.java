/**
 * 
 */
package com.github.api.v2.services.example;

import java.util.List;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.services.CommitService;
import com.github.api.v2.services.GitHubServiceFactory;

/**
 * The Class CommitApiSample.
 */
public class CommitApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		CommitService service = factory.createCommitService();
		
		List<Commit> commits = service.getCommits("facebook", "tornado", Repository.MASTER, "setup.py");
		System.out.println(commits.size());
		for (Commit commit : commits) {
			printResult(commit);
		}
		Commit commit = service.getCommit("facebook", "tornado", "7b80c2f4db226d6fa3a7");
		printResult(commit);
	}
    

	/**
	 * Prints the result.
	 * 
	 * @param commit
	 *            the commit
	 */
	private static void printResult(Commit commit) {
		System.out.println(commit);
	}
}
