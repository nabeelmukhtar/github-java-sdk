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
 * The Class LoginTokenAuthentication.
 */
public class LoginTokenAuthentication implements ParameterBasedAuthentication {
	
	/** The login. */
	private String login;
	
	/** The token. */
	private String token;
	
	/**
	 * Instantiates a new login token authentication.
	 * 
	 * @param login
	 *            the login
	 * @param token
	 *            the token
	 */
	public LoginTokenAuthentication(String login, String token) {
		this.login = login;
		this.token = token;
	}

	/**
	 * Gets the login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the token.
	 * 
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 * 
	 * @param token
	 *            the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.auth.ParameterBasedAuthentication#getParameters()
	 */
	@Override
	public Map<String, String> getParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ParameterNames.LOGIN, login);
		parameters.put(ParameterNames.TOKEN, token);
		return parameters;
	}
}
