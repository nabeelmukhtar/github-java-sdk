/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.github.api.v2.services;

/**
 * The Class GitHubException.
 */
public class GitHubException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2392119987027760999L;

	/**
	 * Instantiates a new git hub exception.
	 */
	public GitHubException() {}

	/**
	 * Instantiates a new git hub exception.
	 * 
	 * @param message
	 *            the message
	 */
	public GitHubException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new git hub exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public GitHubException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new git hub exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public GitHubException(String message, Throwable cause) {
		super(message, cause);
	}
}
