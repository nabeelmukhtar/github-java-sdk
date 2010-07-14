/**
 * 
 */
package com.github.api.v2.services.auth;

import java.util.Map;

/**
 * The Interface HeaderBasedAuthentication.
 */
public interface HeaderBasedAuthentication extends Authentication {
	
	/**
	 * Gets the headers.
	 * 
	 * @return the headers
	 */
	public Map<String, String> getHeaders();
}
