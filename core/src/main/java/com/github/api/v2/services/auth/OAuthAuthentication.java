/**
 * 
 */
package com.github.api.v2.services.auth;

import java.util.HashMap;
import java.util.Map;

import com.github.api.v2.services.constant.ParameterNames;


/**
 * The Class OAuthAuthentication.
 */
public class OAuthAuthentication implements ParameterBasedAuthentication {
	
	/** The access token. */
	private String accessToken;

	/**
	 * Instantiates a new o auth authentication.
	 * 
	 * @param accessToken
	 *            the access token
	 */
	public OAuthAuthentication(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Gets the access token.
	 * 
	 * @return the access token
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * Sets the access token.
	 * 
	 * @param accessToken
	 *            the new access token
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.auth.ParameterBasedAuthentication#getParameters()
	 */
	@Override
	public Map<String, String> getParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ParameterNames.ACCESS_TOKEN, accessToken);
		return parameters;
	}
}
