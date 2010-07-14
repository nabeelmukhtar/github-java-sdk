/**
 * 
 */
package com.github.api.v2.services.example;

import java.util.List;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.NetworkService;

/**
 * The Class NetworkApiSample.
 */
public class NetworkApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		NetworkService service = factory.createNetworkService();
		List<Commit> commits = service.getNetworkData("facebook", "tornado", "7b80c2f4db226d6fa3a7f3dfa59277da1d642f91");
		for (Commit commit : commits) {
			printResult(commit);
		}
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
