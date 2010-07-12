/*
 * 
 */
package com.github.api.v2.services.impl;

import java.util.Set;
import java.util.regex.Matcher;

import com.github.api.v2.services.GitHubException;
import com.github.api.v2.services.OAuthService;
import com.github.api.v2.services.constant.ApplicationConstants;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;

/**
 * The Class FacebookOAuthServiceImpl.
 */
public class OAuthServiceImpl extends BaseGitHubService implements OAuthService {

    private final String clientId;
    private final String secret;

    /**
     * Instantiates a new facebook o auth service impl.
     * 
     * @param apiConsumer the api consumer
     */
    public OAuthServiceImpl(String clientId, String secret) {
    	this.clientId = clientId;
    	this.secret = secret;
    }
    
    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.oauth.FacebookOAuthService#getAuthorizationUrl(java.lang.String)
     */
    @Override
	public String getAuthorizationUrl(String callBackUrl) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.OAuthUrls.AUTHORIZE_URL);
		builder.withParameter(ParameterNames.CLIENT_ID, clientId).withParameter(ParameterNames.REDIRECT_URI, callBackUrl);
		return builder.buildUrl();
	}
    
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.oauth.FacebookOAuthService#getAuthorizationUrl(java.lang.String, java.util.Set)
	 */
	@Override
	public String getAuthorizationUrl(String callBackUrl,
			Set<Permission> permissions) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.OAuthUrls.AUTHORIZE_URL);
		builder.withParameter(ParameterNames.CLIENT_ID, clientId).withParameter(ParameterNames.REDIRECT_URI, callBackUrl);
		builder.withParameterEnumSet(ParameterNames.SCOPE, permissions, ",");
		return builder.buildUrl();
	}

    /* (non-Javadoc)
     * @see com.google.code.facebook.graph.client.oauth.FacebookOAuthService#getAccessToken(java.lang.String, java.lang.String)
     */
    @Override
	public String getAccessToken(String callBackUrl, String code) {
    	try {
    		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.OAuthUrls.ACCESS_TOKEN_URL);
    		builder.withParameter(ParameterNames.CLIENT_ID, clientId);
    		builder.withParameter(ParameterNames.CLIENT_SECRET, secret);
    		builder.withParameter(ParameterNames.REDIRECT_URI, callBackUrl);
    		builder.withParameter(ParameterNames.CODE, code);
    		
			String response = convertStreamToString(callApiGet(builder.buildUrl()));
			Matcher matcher = ApplicationConstants.ACCESS_TOKEN_PATTERN.matcher(response);
			if (matcher.find()) {
            	return matcher.group(1);
            } else {
            	throw new GitHubException(response);
            }
		} catch (Exception e) {
			throw new GitHubException(e);
		}
	}
}
