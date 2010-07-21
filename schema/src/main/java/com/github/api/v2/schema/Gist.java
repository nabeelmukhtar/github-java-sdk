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

import java.util.Date;
import java.util.List;

import com.github.api.v2.schema.Repository.Visibility;

/**
 * The Class Gist.
 */
public class Gist extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The description. */
	private String description;
	
	/** The repo. */
	private String repo;
	
	/** The visibility. */
	private Visibility visibility;
	
	/** The created at. */
	private Date createdAt;
	
	/** The files. */
	private List<String> files;
	
	private String owner;
	
	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the repo.
	 * 
	 * @return the repo
	 */
	public String getRepo() {
		return repo;
	}
	
	/**
	 * Sets the repo.
	 * 
	 * @param repo
	 *            the new repo
	 */
	public void setRepo(String repo) {
		this.repo = repo;
	}
	
	/**
	 * Gets the visibility.
	 * 
	 * @return the visibility
	 */
	public Visibility getVisibility() {
		return visibility;
	}
	
	/**
	 * Sets the visibility.
	 * 
	 * @param visibility
	 *            the new visibility
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	
	/**
	 * Gets the created at.
	 * 
	 * @return the created at
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * Sets the created at.
	 * 
	 * @param createdAt
	 *            the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * Gets the files.
	 * 
	 * @return the files
	 */
	public List<String> getFiles() {
		return files;
	}
	
	/**
	 * Sets the files.
	 * 
	 * @param files
	 *            the new files
	 */
	public void setFiles(List<String> files) {
		this.files = files;
	}
	
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gist [createdAt=" + createdAt + ", description=" + description
				+ ", files=" + files + ", repo=" + repo + ", visibility="
				+ visibility + ", owner=" + owner + "]";
	}
}
