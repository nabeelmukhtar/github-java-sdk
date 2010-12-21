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

import java.io.InputStream;
import java.util.List;

import com.github.api.v2.schema.Gist;
import com.github.api.v2.services.GistService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The Class GistServiceImpl.
 */
public class GistServiceImpl extends BaseGitHubService implements
		GistService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#getGist(java.lang.String)
	 */
	@Override
	public Gist getGist(String gistId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_GIST_URL);
        String                apiUrl  = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        List<Gist> gists = unmarshall(new TypeToken<List<Gist>>(){}, json.get("gists"));
        return (gists.isEmpty())? null : gists.get(0);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#getGistContent(java.lang.String, java.lang.String)
	 */
	@Override
	public InputStream getGistContent(String gistId, String fileName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_GIST_CONTENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.GIST_ID, gistId).withField(ParameterNames.FILE_NAME, fileName).buildUrl();
        return callApiGet(apiUrl);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#getUserGists(java.lang.String)
	 */
	@Override
	public List<Gist> getUserGists(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_USER_GISTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Gist>>(){}, json.get("gists"));
	}
}
