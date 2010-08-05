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

import java.util.List;


/**
 * The Class Commit.
 */
public class NetworkUser extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	private String name;
	private String repo;
	private List<Head> heads;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the repo
	 */
	public String getRepo() {
		return repo;
	}
	/**
	 * @param repo the repo to set
	 */
	public void setRepo(String repo) {
		this.repo = repo;
	}
	/**
	 * @return the heads
	 */
	public List<Head> getHeads() {
		return heads;
	}
	/**
	 * @param heads the heads to set
	 */
	public void setHeads(List<Head> heads) {
		this.heads = heads;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NetworkUser [heads=" + heads + ", name=" + name + ", repo="
				+ repo + "]";
	}
}
