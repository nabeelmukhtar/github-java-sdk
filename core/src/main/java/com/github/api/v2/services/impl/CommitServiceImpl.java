/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.List;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.services.CommitService;

/**
 * @author nmukhtar
 *
 */
public class CommitServiceImpl extends BaseGitHubService implements
		CommitService {

	public CommitServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public Commit getCommit(String userName, String repositoryName, String sha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commit> getCommits(String userName, String repositoryName,
			String branch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commit> getCommits(String userName, String repositoryName,
			String branch, String filePath) {
		// TODO Auto-generated method stub
		return null;
	}
}
