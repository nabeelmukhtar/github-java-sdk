/**
 * 
 */
package com.github.api.v2.services.auth;

import java.util.HashMap;
import java.util.Map;

import com.github.api.v2.services.constant.ParameterNames;


/**
 * @author nmukhtar
 *
 */
public class OAuthAuthentication implements ParameterBasedAuthentication {
	private String accessToken;

	public OAuthAuthentication(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public Map<String, String> getParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ParameterNames.ACCESS_TOKEN, accessToken);
		return parameters;
	}
}
