/**
 * 
 */
package com.github.api.v2.services.auth;

import java.util.HashMap;
import java.util.Map;

import com.github.api.v2.services.util.Base64;


/**
 * @author nmukhtar
 *
 */
public class LoginPasswordAuthentication implements HeaderBasedAuthentication {
	/** The Constant REFERRER. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant REFERRER. */
	private static final String BASIC = "Basic ";
	
	public String login;
	public String password;

	public LoginPasswordAuthentication(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
    	String credentials = login + ":" + password;
    	headers.put(AUTHORIZATION, BASIC + Base64.encodeBytes(credentials.getBytes()));
    	return headers;
	}
}
