/**
 * 
 */
package com.github.api.v2.services.auth;

import java.util.Map;

/**
 * The Interface ParameterBasedAuthentication.
 */
public interface ParameterBasedAuthentication extends Authentication {
	
	/**
	 * Gets the parameters.
	 * 
	 * @return the parameters
	 */
	public Map<String, String> getParameters();
}
