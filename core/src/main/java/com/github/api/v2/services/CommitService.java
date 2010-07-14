/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import com.github.api.v2.schema.Commit;

/**
 * The Interface CommitService.
 */
public interface CommitService extends GitHubService {
	
	/**
	 * Gets the commits.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param branch
	 *            the branch
	 * 
	 * @return the commits
	 */
	public List<Commit> getCommits(String userName, String repositoryName, String branch);
	
	/**
	 * Gets the commits.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param branch
	 *            the branch
	 * @param filePath
	 *            the file path
	 * 
	 * @return the commits
	 */
	public List<Commit> getCommits(String userName, String repositoryName, String branch, String filePath);
	
	/**
	 * Gets the commit.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param sha
	 *            the sha
	 * 
	 * @return the commit
	 */
	public Commit getCommit(String userName, String repositoryName, String sha);
}
