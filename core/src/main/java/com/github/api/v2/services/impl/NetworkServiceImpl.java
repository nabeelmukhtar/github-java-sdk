/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.List;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Network;
import com.github.api.v2.services.NetworkService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * @author nmukhtar
 *
 */
public class NetworkServiceImpl extends BaseGitHubService implements
		NetworkService {

	@Override
	public List<Commit> getNetworkData(String userName, String repositoryName,
			String networkHash) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.NetworkApiUrls.GET_NETWORK_DATA_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withParameter(ParameterNames.NET_HASH, networkHash).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Commit>>(){}, json.get("commits"));
	}

	@Override
	public List<Commit> getNetworkData(String userName, String repositoryName,
			String networkHash, int startIndex, int endIndex) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.NetworkApiUrls.GET_NETWORK_DATA_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withParameter(ParameterNames.NET_HASH, networkHash).withParameter(ParameterNames.START_INDEX, String.valueOf(startIndex)).withParameter(ParameterNames.END_INDEX, String.valueOf(endIndex)).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Commit>>(){}, json.get("commits"));
	}

	@Override
	public Network getNetworkMeta(String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.NetworkApiUrls.GET_NETWORK_META_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Network>(){}, json);
	}
}
