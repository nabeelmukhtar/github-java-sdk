/**
 *
 */
package com.github.api.v2.services;


/**
 * The Interface GoogleSearchAuthenticationClient.
 */
public interface GitHubAuthenticator extends GitHubCommunicator {

    /**
     * Sets the application key.
     * 
     * @param applicationKey the new application key
     */
    public void setCredentials(String userName, String applicationKey);

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
