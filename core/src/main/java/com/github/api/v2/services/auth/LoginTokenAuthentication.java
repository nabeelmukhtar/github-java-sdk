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
public class LoginTokenAuthentication implements ParameterBasedAuthentication {
	private String login;
	private String token;
	
	public LoginTokenAuthentication(String login, String token) {
		this.login = login;
		this.token = token;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Map<String, String> getParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ParameterNames.LOGIN, login);
		parameters.put(ParameterNames.TOKEN, token);
		return parameters;
	}
}
