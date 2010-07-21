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

import com.github.api.v2.services.util.Base64;


/**
 * The Class LoginPasswordAuthentication.
 */
public class LoginPasswordAuthentication implements HeaderBasedAuthentication {
	
	/** The Constant AUTHORIZATION. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant BASIC. */
	private static final String BASIC = "Basic ";
	
	/** The login. */
	public String login;
	
	/** The password. */
	public String password;

	/**
	 * Instantiates a new login password authentication.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 */
	public LoginPasswordAuthentication(String login, String password) {
		this.login = login;
		this.password = password;
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
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.auth.HeaderBasedAuthentication#getHeaders()
	 */
	@Override
	public Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
    	String credentials = login + ":" + password;
    	headers.put(AUTHORIZATION, BASIC + Base64.encodeBytes(credentials.getBytes()));
    	return headers;
	}
}
