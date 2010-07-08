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
    public void setApplicationKey(String applicationKey);

    /**
     * Gets the application key.
     * 
     * @return the application key
     */
    public String getApplicationKey();
    
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
