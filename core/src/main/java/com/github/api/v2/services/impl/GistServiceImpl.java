/**
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
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * @author nmukhtar
 *
 */
public class GistServiceImpl extends BaseGitHubService implements
		GistService {

	public GistServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public Gist getGist(String gistId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_GIST_URL);
        String                apiUrl  = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        List<Gist> gists = unmarshall(new TypeToken<List<Gist>>(){}, json.getAsJsonObject().get("gists"));
        return (gists.isEmpty())? null : gists.get(0);
	}

	@Override
	public InputStream getGistContent(String gistId, String fileName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_GIST_CONTENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.GIST_ID, gistId).withField(ParameterNames.FILE_NAME, fileName).buildUrl();
        return callApiGet(apiUrl);
	}

	@Override
	public List<Gist> getUserGists(String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_USER_GISTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Gist>>(){}, json.getAsJsonObject().get("gists"));
	}
}
