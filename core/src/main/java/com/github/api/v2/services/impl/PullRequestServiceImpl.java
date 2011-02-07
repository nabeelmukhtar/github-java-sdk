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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.PullRequest;
import com.github.api.v2.schema.Issue.State;
import com.github.api.v2.services.PullRequestService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The Class PullRequestServiceImpl.
 */
public class PullRequestServiceImpl extends BaseGitHubService implements
		PullRequestService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.ObjectService#getBlob(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public PullRequest getPullRequest(String userName, String repositoryName, int issueNumber) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.PullRequestApiUrls.GET_PULL_REQUEST_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.ISSUE_NUMBER, String.valueOf(issueNumber)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<PullRequest>(){}, json.get("pull"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.ObjectService#getBlobs(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<PullRequest> getPullRequests(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.PullRequestApiUrls.GET_PULL_REQUESTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.STATE, "").buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<PullRequest>>(){}, json.get("pulls"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.ObjectService#getBlobs(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<PullRequest> getPullRequests(String userName, String repositoryName, State state) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.PullRequestApiUrls.GET_PULL_REQUESTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.STATE, state.value()).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<PullRequest>>(){}, json.get("pulls"));
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.ObjectService#getObjectContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public PullRequest createPullRequest(String userName, String repositoryName, String base, String head, String title, String body) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.PullRequestApiUrls.CREATE_PULL_REQUEST_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("pull[" + ParameterNames.BASE + "]", base);
        parameters.put("pull[" + ParameterNames.HEAD + "]", head);
        parameters.put("pull[" + ParameterNames.TITLE + "]", title);
        parameters.put("pull[" + ParameterNames.BODY + "]", body);
        JsonObject json = unmarshall(callApiPost(apiUrl, parameters));
        
        return unmarshall(new TypeToken<PullRequest>(){}, json.get("pull"));
	}
}
