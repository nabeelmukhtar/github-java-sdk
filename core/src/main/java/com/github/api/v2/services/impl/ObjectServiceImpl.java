/**
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
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * @author nmukhtar
 *
 */
public class ObjectServiceImpl extends BaseGitHubService implements
		ObjectService {

	public ObjectServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public Blob getBlob(String userName, String repositoryName, String treeSha,
			String filePath) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.ObjectApiUrls.GET_BLOBS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, treeSha).withField(ParameterNames.FILE_PATH, filePath).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Blob>(){}, json.getAsJsonObject().get("blob"));
	}

	@Override
	public List<Blob> getBlobs(String userName, String repositoryName,
			String treeSha) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.ObjectApiUrls.GET_BLOBS_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, treeSha).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Blob>>(){}, json.getAsJsonObject().get("blobs"));
	}

	@Override
	public InputStream getObjectContent(String userName, String repositoryName,
			String objectSha) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.ObjectApiUrls.GET_OBJECT_CONTENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, objectSha).buildUrl();
        return callApiGet(apiUrl);
	}

	@Override
	public List<Tree> getTree(String userName, String repositoryName,
			String treeSha) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.ObjectApiUrls.GET_TREE_URL);
        String                apiUrl  = builder.withField(ParameterNames.USER_NAME, userName).withField(ParameterNames.REPOSITORY_NAME, repositoryName).withField(ParameterNames.SHA, treeSha).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Tree>>(){}, json.getAsJsonObject().get("tree"));
	}
}
