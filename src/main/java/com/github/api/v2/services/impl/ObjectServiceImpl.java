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

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;
import com.github.api.v2.services.ObjectService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The Class ObjectServiceImpl.
 */
public class ObjectServiceImpl extends BaseGitHubService implements
		ObjectService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.ObjectService#getBlob(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Blob getBlob(String userName, String repositoryName, String treeSha,
			String filePath) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.ObjectApiUrls.GET_BLOBS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, treeSha).withField(ParameterNames.FILE_PATH, filePath).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Blob>(){}, json.get("blob"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.ObjectService#getBlobs(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Blob> getBlobs(String userName, String repositoryName,
			String treeSha) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.ObjectApiUrls.GET_BLOBS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, treeSha).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Blob>>(){}, json.get("blobs"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.ObjectService#getObjectContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public InputStream getObjectContent(String userName, String repositoryName,
			String objectSha) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.ObjectApiUrls.GET_OBJECT_CONTENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, objectSha).buildUrl();
        return callApiGet(apiUrl);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.ObjectService#getTree(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Tree> getTree(String userName, String repositoryName,
			String treeSha) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.ObjectApiUrls.GET_TREE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, treeSha).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Tree>>(){}, json.get("tree"));
	}
}
