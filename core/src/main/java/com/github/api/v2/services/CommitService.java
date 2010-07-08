/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import com.github.api.v2.schema.Commit;

/**
 * @author nmukhtar
 *
 */
public interface CommitService extends GitHubService {
	public List<Commit> getCommits(String userName, String repositoryName, String branch);
	public List<Commit> getCommits(String userName, String repositoryName, String branch, String filePath);
	public Commit getCommit(String userName, String repositoryName, String sha);
}
