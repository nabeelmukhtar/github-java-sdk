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
 * The Class Plan.
 */
public class Plan extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -716103936969784665L;
	
	/** The name. */
	private String name;
	
	/** The collaborators. */
	private int collaborators;
	
	/** The space. */
	private long space;
	
	/** The private repos. */
	private int privateRepos;
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the collaborators.
	 * 
	 * @return the collaborators
	 */
	public int getCollaborators() {
		return collaborators;
	}
	
	/**
	 * Sets the collaborators.
	 * 
	 * @param collaborators
	 *            the new collaborators
	 */
	public void setCollaborators(int collaborators) {
		this.collaborators = collaborators;
	}
	
	/**
	 * Gets the space.
	 * 
	 * @return the space
	 */
	public long getSpace() {
		return space;
	}
	
	/**
	 * Sets the space.
	 * 
	 * @param space
	 *            the new space
	 */
	public void setSpace(long space) {
		this.space = space;
	}
	
	/**
	 * Gets the private repos.
	 * 
	 * @return the private repos
	 */
	public int getPrivateRepos() {
		return privateRepos;
	}
	
	/**
	 * Sets the private repos.
	 * 
	 * @param privateRepos
	 *            the new private repos
	 */
	public void setPrivateRepos(int privateRepos) {
		this.privateRepos = privateRepos;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Plan [collaborators=" + collaborators + ", name=" + name
				+ ", privateRepos=" + privateRepos + ", space=" + space + "]";
	}
}
