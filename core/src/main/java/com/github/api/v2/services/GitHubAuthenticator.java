/**
 *
 */
package com.github.api.v2.services;

import com.github.api.v2.services.auth.Authentication;


/**
 * The Interface GoogleSearchAuthenticationClient.
 */
public interface GitHubAuthenticator extends GitHubCommunicator {

    /**
     * Sets the application key.
     * @param authentication TODO
     */
    public void setAuthentication(Authentication authentication);

	/**
	 * Sets the user ip address.
	 * 
	 * @param userIpAddress the new user ip address
	 */
	public void setUserIpAddress(String userIpAddress);

	/**
	 * Sets the referrer.
	 * 
	 * @param referrer the new referrer
	 */
	public void setReferrer(String referrer);
}
