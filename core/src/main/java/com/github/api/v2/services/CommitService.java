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
	 * @param pageNumber
	 *            the page number
	 * 
	 * @return the commits
	 */
	public List<Commit> getCommits(String userName, String repositoryName, String branch, int pageNumber);
	
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
