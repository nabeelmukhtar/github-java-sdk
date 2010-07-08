/**
 * 
 */
package com.github.api.v2.services;

/**
 * The Class GoogleSearchException.
 */
public class GitHubException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2392119987027760999L;

	/**
	 * Instantiates a new google search exception.
	 */
	public GitHubException() {}

	/**
	 * Instantiates a new google search exception.
	 * 
	 * @param message the message
	 */
	public GitHubException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new google search exception.
	 * 
	 * @param cause the cause
	 */
	public GitHubException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new google search exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public GitHubException(String message, Throwable cause) {
		super(message, cause);
	}
}
