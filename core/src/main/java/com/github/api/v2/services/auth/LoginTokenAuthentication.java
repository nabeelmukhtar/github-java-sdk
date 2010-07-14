/**
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
