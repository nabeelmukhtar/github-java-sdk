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
package com.github.api.v2.schema;


/**
 * The Class Version.
 */
public class Version extends SchemaEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The label. */
	private String label;
	
	/** The sha. */
	private String sha;
	
	/** The ref. */
	private String ref;
	
	/** The repository. */
	private Repository repository;

	/** The user. */
	private User user;
	
	/**
	 * Gets the label.
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Sets the label.
	 * 
	 * @param label
	 *            the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Gets the sha.
	 * 
	 * @return the sha
	 */
	public String getSha() {
		return sha;
	}
	
	/**
	 * Sets the sha.
	 * 
	 * @param sha
	 *            the new sha
	 */
	public void setSha(String sha) {
		this.sha = sha;
	}
	
	/**
	 * Gets the ref.
	 * 
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	
	/**
	 * Sets the ref.
	 * 
	 * @param ref
	 *            the new ref
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * Gets the repository.
	 * 
	 * @return the repository
	 */
	public Repository getRepository() {
		return repository;
	}

	/**
	 * Sets the repository.
	 * 
	 * @param repository
	 *            the new repository
	 */
	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
