/**
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
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.CommitApiUrls.GET_COMMITS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.BRANCH, branch).buildUrl();
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
