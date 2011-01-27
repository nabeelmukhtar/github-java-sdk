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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Gist.
 */
public class Gist extends SchemaEntity {
	
	/**
	 * The Enum Visibility.
	 */
	public enum Visibility implements ValueEnum {
		
		/** The PUBLIC. */
		PUBLIC("public"), 
 
 /** The PRIVATE. */
 PRIVATE("private");
		
	    /** The Constant stringToEnum. */
		private static final Map<String, Visibility> stringToEnum = new HashMap<String, Visibility>();

		static { // Initialize map from constant name to enum constant
			for (Visibility op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /**
		 * Instantiates a new visibility.
		 * 
		 * @param value
		 *            the value
		 */
	    Visibility(String value) {
	        this.value = value;
	    }

		/* (non-Javadoc)
		 * @see com.github.api.v2.schema.ValueEnum#value()
		 */
		@Override
		public String value() {
			return value;
		}
		
		/**
		 * From value.
		 * 
		 * @param value
		 *            the value
		 * 
		 * @return the visibility
		 */
		public static Visibility fromValue(String value) {
			return stringToEnum.get(value);
		}
	}
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The description. */
	private String description;
	
	/** The repo. */
	private String repo;
	
	/** The visibility. */
	@SerializedName("public")
	private boolean visibility;
	
	/** The created at. */
	private Date createdAt;
	
	/** The files. */
	private List<String> files;
	
	/** The owner. */
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
		return visibility ? Visibility.PUBLIC : Visibility.PRIVATE;
	}
	
	/**
	 * Sets the visibility.
	 * 
	 * @param visibility
	 *            the new visibility
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = (visibility == Visibility.PUBLIC);
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
	 * Gets the owner.
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owner.
	 * 
	 * @param owner
	 *            the new owner
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
