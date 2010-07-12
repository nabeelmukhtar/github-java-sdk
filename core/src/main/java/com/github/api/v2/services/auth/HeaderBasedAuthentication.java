/**
 * 
 */
package com.github.api.v2.services.auth;

import java.util.Map;

/**
 * @author nmukhtar
 *
 */
public interface HeaderBasedAuthentication extends Authentication {
	public Map<String, String> getHeaders();
}
