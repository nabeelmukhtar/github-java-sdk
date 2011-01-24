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

import com.github.api.v2.schema.PullRequest;
import com.github.api.v2.schema.Issue.State;

/**
 * The Interface ObjectService.
 */
public interface PullRequestService extends GitHubService {
	
	/**
	 * Gets the tree.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param treeSha
	 *            the tree sha
	 * 
	 * @return the tree
	 */
	public List<PullRequest> getPullRequests(String userName, String repositoryName);
	
	/**
	 * Gets the tree.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param treeSha
	 *            the tree sha
	 * 
	 * @return the tree
	 */
	public List<PullRequest> getPullRequests(String userName, String repositoryName, State state);

	/**
	 * Gets the blob.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param treeSha
	 *            the tree sha
	 * @param filePath
	 *            the file path
	 * 
	 * @return the blob
	 */
	public PullRequest getPullRequest(String userName, String repositoryName, int issueNumber);
	
	public void createPullRequest(String userName, String repositoryName, String base, String head, String title, String body);
}
