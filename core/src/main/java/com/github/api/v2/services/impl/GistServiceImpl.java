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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.File;
import com.github.api.v2.schema.Gist;
import com.github.api.v2.schema.Gist.Visibility;
import com.github.api.v2.services.GistService;
import com.github.api.v2.services.constant.ApplicationConstants;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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
        return unmarshall(new TypeToken<Gist>(){}, json);
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
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Gist>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#getOwnedGists()
	 */
	@Override
	public List<Gist> getOwnedGists() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_OWNED_GISTS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Gist>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#getPublicGists()
	 */
	@Override
	public List<Gist> getPublicGists() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_PUBLIC_GISTS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Gist>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#getStarredGists()
	 */
	@Override
	public List<Gist> getStarredGists() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_STARRED_GISTS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Gist>>(){}, json);
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#createGist(java.lang.String, java.lang.String, com.github.api.v2.schema.Gist.Visibility, java.util.Map)
	 */
	@Override
	public Gist createGist(String userName, String description, Visibility visibility,
			Map<String, String> contents) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.CREATE_GIST_URL);
		String apiUrl = builder.withField(ParameterNames.USER_NAME, userName).buildUrl();
		Gist gist = new Gist();
		gist.setDescription(description);
		gist.setVisibility(visibility);
		for (String filename : contents.keySet()) {
			File file = new File();
			file.setFilename(filename);
			file.setContent(contents.get(filename));
			
			gist.getFiles().put(filename, file);
		}
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(gist), ApplicationConstants.CONTENT_TYPE_JSON, "POST", 201));
        return unmarshall(new TypeToken<Gist>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#deleteGist(java.lang.String)
	 */
	@Override
	public void deleteGist(String gistId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.DELETE_GIST_URL);
		String apiUrl = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
		callApiDelete(apiUrl, 200);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#forkGist(java.lang.String)
	 */
	@Override
	public void forkGist(String gistId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.DELETE_GIST_URL);
		String apiUrl = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
		Map<String, String> parameters = new HashMap<String, String>();
		callApiPost(apiUrl, parameters, 201);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#isGistStarred(java.lang.String)
	 */
	@Override
	public boolean isGistStarred(String gistId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.IS_GIST_STARRED_URL);
		String apiUrl = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
		try {
			callApiGet(apiUrl, 204);
			return true;
		} catch (Exception e) {}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#starGist(java.lang.String)
	 */
	@Override
	public void starGist(String gistId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.STAR_GIST_URL);
		String apiUrl = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
		Map<String, String> parameters = new HashMap<String, String>();
		callApiPost(apiUrl, parameters, 201);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#unstarGist(java.lang.String)
	 */
	@Override
	public void unstarGist(String gistId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.UNSTAR_GIST_URL);
		String apiUrl = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
		callApiDelete(apiUrl, 204);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#updateGist(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public Gist updateGist(String gistId, String description,
			Map<String, String> contents) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.UPDATE_GIST_URL);
		String apiUrl = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
		Gist gist = new Gist();
		gist.setDescription(description);
		for (String filename : contents.keySet()) {
			File file = new File();
			file.setFilename(filename);
			file.setContent(contents.get(filename));
			
			gist.getFiles().put(filename, file);
		}
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(gist), ApplicationConstants.CONTENT_TYPE_JSON, "POST", 200));
        return unmarshall(new TypeToken<Gist>(){}, json);
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#createGistComment(java.lang.String, java.lang.String)
	 */
	@Override
	public Comment createGistComment(String gistId, String commentText) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.CREATE_GIST_COMMENT_URL);
		String apiUrl = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
		Comment comment = new Comment();
		comment.setBody(commentText);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(comment), ApplicationConstants.CONTENT_TYPE_JSON, "POST", 201));
        return unmarshall(new TypeToken<Comment>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#deleteGistComment(java.lang.String)
	 */
	@Override
	public void deleteGistComment(String commentId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.DELETE_GIST_COMMENT_URL);
		String apiUrl = builder.withField(ParameterNames.COMMENT_ID, commentId).buildUrl();
		callApiDelete(apiUrl, 200);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#getGistComment(java.lang.String)
	 */
	@Override
	public Comment getGistComment(String commentId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_GIST_COMMENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.COMMENT_ID, commentId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        return unmarshall(new TypeToken<Comment>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#getGistComments(java.lang.String)
	 */
	@Override
	public List<Comment> getGistComments(String gistId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.GET_GIST_COMMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.GIST_ID, gistId).buildUrl();
        JsonElement json = unmarshallArray(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Comment>>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.GistService#updateGistComment(java.lang.String, java.lang.String)
	 */
	@Override
	public Comment updateGistComment(String commentId, String commentText) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.GistApiUrls.UPDATE_GIST_COMMENT_URL);
		String apiUrl = builder.withField(ParameterNames.COMMENT_ID, commentId).buildUrl();
		Comment comment = new Comment();
		comment.setBody(commentText);
        JsonObject json = unmarshall(callApiMethod(apiUrl, marshall(comment), ApplicationConstants.CONTENT_TYPE_JSON, "POST", 200));
        return unmarshall(new TypeToken<Comment>(){}, json);
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.impl.BaseGitHubService#getGsonBuilder()
	 */
	@Override
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder gson = super.getGsonBuilder();
		gson.setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		return gson;
	}
}
