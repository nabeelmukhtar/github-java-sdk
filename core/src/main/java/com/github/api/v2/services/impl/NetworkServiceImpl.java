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

import com.github.api.v2.schema.NetworkCommit;
import com.github.api.v2.schema.NetworkMeta;
import com.github.api.v2.services.NetworkService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The Class NetworkServiceImpl.
 */
public class NetworkServiceImpl extends BaseGitHubService implements
		NetworkService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.NetworkService#getNetworkData(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<NetworkCommit> getNetworkData(String userName, String repositoryName,
			String networkHash) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.NetworkApiUrls.GET_NETWORK_DATA_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withParameter(ParameterNames.NET_HASH, networkHash).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<NetworkCommit>>(){}, json.get("commits"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.NetworkService#getNetworkData(java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public List<NetworkCommit> getNetworkData(String userName, String repositoryName,
			String networkHash, int startIndex, int endIndex) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.NetworkApiUrls.GET_NETWORK_DATA_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withParameter(ParameterNames.NET_HASH, networkHash).withParameter(ParameterNames.START_INDEX, String.valueOf(startIndex)).withParameter(ParameterNames.END_INDEX, String.valueOf(endIndex)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<NetworkCommit>>(){}, json.get("commits"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.NetworkService#getNetworkMeta(java.lang.String, java.lang.String)
	 */
	@Override
	public NetworkMeta getNetworkMeta(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.NetworkApiUrls.GET_NETWORK_META_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
		Gson gson = getGsonBuilder().setDateFormat("yyyy-MM-dd").create();
		return gson.fromJson(json, NetworkMeta.class);
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.impl.BaseGitHubService#getGsonBuilder()
	 */
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder gson = super.getGsonBuilder();
		gson.setDateFormat("yyyy-MM-dd HH:mm:ss");
		return gson;
	}
}
