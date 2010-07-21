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
