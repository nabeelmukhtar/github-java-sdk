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
package com.github.api.v2.services.impl;

import java.util.List;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.services.CommitService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The Class CommitServiceImpl.
 */
public class CommitServiceImpl extends BaseGitHubService implements
		CommitService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.CommitService#getCommit(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Commit getCommit(String userName, String repositoryName, String sha) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.CommitApiUrls.GET_COMMIT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, sha).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Commit>(){}, json.get("commit"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.CommitService#getCommits(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Commit> getCommits(String userName, String repositoryName,
			String branch) {
        return getCommits(userName, repositoryName, branch, 1);
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.CommitService#getCommits(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Commit> getCommits(String userName, String repositoryName,
			String branch, int pageNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.CommitApiUrls.GET_COMMITS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.BRANCH, branch).withParameter(ParameterNames.PAGE, String.valueOf(pageNumber)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Commit>>(){}, json.get("commits"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.CommitService#getCommits(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Commit> getCommits(String userName, String repositoryName,
			String branch, String filePath) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.CommitApiUrls.GET_COMMITS_FILE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.BRANCH, branch).withField(ParameterNames.FILE_PATH, filePath).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Commit>>(){}, json.get("commits"));
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.impl.BaseGitHubService#getGsonBuilder()
	 */
	@Override
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder gson = super.getGsonBuilder();
		gson.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return gson;
	}
}
