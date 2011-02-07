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
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Repository.
 */
public class Repository extends SchemaEntity {
	
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
	
	/** The Constant MASTER. */
	public static final String MASTER = "master";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The watchers. */
	private int watchers;
	
	/** The owner. */
	private String owner;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The visibility. */
	@SerializedName("private")
	private boolean visibility;
	
	/** The url. */
	private String url;
	
	/** The open issues. */
	private int openIssues;
	
	/** The fork. */
	private boolean fork;
	
	/** The homepage. */
	private String homepage;
	
	/** The forks. */
	private int forks;
	
	/** The score. */
	private double score;
	
	/** The actions. */
	private int actions;
	
	/** The size. */
	private long size;
	
	/** The language. */
	private Language language;
	
	/** The followers. */
	private int followers;
	
	/** The username. */
	private String username;
	
	/** The type. */
	private String type;
	
	/** The id. */
	private String id;
	
	/** The pushed at. */
	private Date pushedAt;
	
	/** The created at. */
	private Date createdAt;
	
	/** The source. */
	private String source;
	
	/** The parent. */
	private String parent;
	
	/** The has wiki. */
	private boolean hasWiki;
	
	/** The has issues. */
	private boolean hasIssues;
	
	/** The has downloads. */
	private boolean hasDownloads;
	
	/** The organization. */
	private String organization;
	
	/** The permission. */
	private Permission permission;
	
	/**
	 * Gets the watchers.
	 * 
	 * @return the watchers
	 */
	public int getWatchers() {
		return watchers;
	}
	
	/**
	 * Sets the watchers.
	 * 
	 * @param watchers
	 *            the new watchers
	 */
	public void setWatchers(int watchers) {
		this.watchers = watchers;
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
	 * Gets the visibility.
	 * 
	 * @return the visibility
	 */
	public Visibility getVisibility() {
		return visibility ? Visibility.PRIVATE : Visibility.PUBLIC ;
	}
	
	/**
	 * Sets the visibility.
	 * 
	 * @param visibility
	 *            the new visibility
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = (visibility == Visibility.PRIVATE);
	}
	
	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the open issues.
	 * 
	 * @return the open issues
	 */
	public int getOpenIssues() {
		return openIssues;
	}
	
	/**
	 * Sets the open issues.
	 * 
	 * @param openIssues
	 *            the new open issues
	 */
	public void setOpenIssues(int openIssues) {
		this.openIssues = openIssues;
	}
	
	/**
	 * Checks if is fork.
	 * 
	 * @return true, if is fork
	 */
	public boolean isFork() {
		return fork;
	}
	
	/**
	 * Sets the fork.
	 * 
	 * @param fork
	 *            the new fork
	 */
	public void setFork(boolean fork) {
		this.fork = fork;
	}
	
	/**
	 * Gets the homepage.
	 * 
	 * @return the homepage
	 */
	public String getHomepage() {
		return homepage;
	}
	
	/**
	 * Sets the homepage.
	 * 
	 * @param homepage
	 *            the new homepage
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	
	/**
	 * Gets the forks.
	 * 
	 * @return the forks
	 */
	public int getForks() {
		return forks;
	}
	
	/**
	 * Sets the forks.
	 * 
	 * @param forks
	 *            the new forks
	 */
	public void setForks(int forks) {
		this.forks = forks;
	}
	
	/**
	 * Gets the score.
	 * 
	 * @return the score
	 */
	public double getScore() {
		return score;
	}
	
	/**
	 * Sets the score.
	 * 
	 * @param score
	 *            the new score
	 */
	public void setScore(double score) {
		this.score = score;
	}
	
	/**
	 * Gets the actions.
	 * 
	 * @return the actions
	 */
	public int getActions() {
		return actions;
	}
	
	/**
	 * Sets the actions.
	 * 
	 * @param actions
	 *            the new actions
	 */
	public void setActions(int actions) {
		this.actions = actions;
	}
	
	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public long getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 * 
	 * @param size
	 *            the new size
	 */
	public void setSize(long size) {
		this.size = size;
	}
	
	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}
	
	/**
	 * Sets the language.
	 * 
	 * @param language
	 *            the new language
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	/**
	 * Gets the followers.
	 * 
	 * @return the followers
	 */
	public int getFollowers() {
		return followers;
	}
	
	/**
	 * Sets the followers.
	 * 
	 * @param followers
	 *            the new followers
	 */
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	
	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the pushed at.
	 * 
	 * @return the pushed at
	 */
	public Date getPushedAt() {
		return pushedAt;
	}
	
	/**
	 * Sets the pushed at.
	 * 
	 * @param pushedAt
	 *            the new pushed at
	 */
	public void setPushedAt(Date pushedAt) {
		this.pushedAt = pushedAt;
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
	 * Sets the created.
	 * 
	 * @param createdAt
	 *            the new created
	 */
	public void setCreated(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * Gets the source.
	 * 
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * Sets the source.
	 * 
	 * @param source
	 *            the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent.
	 * 
	 * @param parent
	 *            the new parent
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	/**
	 * Checks if is checks for wiki.
	 * 
	 * @return true, if is checks for wiki
	 */
	public boolean isHasWiki() {
		return hasWiki;
	}
	
	/**
	 * Sets the checks for wiki.
	 * 
	 * @param hasWiki
	 *            the new checks for wiki
	 */
	public void setHasWiki(boolean hasWiki) {
		this.hasWiki = hasWiki;
	}
	
	/**
	 * Checks if is checks for issues.
	 * 
	 * @return true, if is checks for issues
	 */
	public boolean isHasIssues() {
		return hasIssues;
	}
	
	/**
	 * Sets the checks for issues.
	 * 
	 * @param hasIssues
	 *            the new checks for issues
	 */
	public void setHasIssues(boolean hasIssues) {
		this.hasIssues = hasIssues;
	}
	
	/**
	 * Checks if is checks for downloads.
	 * 
	 * @return true, if is checks for downloads
	 */
	public boolean isHasDownloads() {
		return hasDownloads;
	}
	
	/**
	 * Sets the checks for downloads.
	 * 
	 * @param hasDownloads
	 *            the new checks for downloads
	 */
	public void setHasDownloads(boolean hasDownloads) {
		this.hasDownloads = hasDownloads;
	}
	
	/**
	 * Gets the organization.
	 * 
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * Sets the organization.
	 * 
	 * @param organization
	 *            the new organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * Gets the permission.
	 * 
	 * @return the permission
	 */
	public Permission getPermission() {
		return permission;
	}

	/**
	 * Sets the permission.
	 * 
	 * @param permission
	 *            the new permission
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Repository [actions=" + actions + ", created=" + createdAt
				+ ", description=" + description + ", followers=" + followers
				+ ", fork=" + fork + ", forks=" + forks + ", hasDownloads="
				+ hasDownloads + ", hasIssues=" + hasIssues + ", hasWiki="
				+ hasWiki + ", homepage=" + homepage + ", id=" + id
				+ ", language=" + language + ", name=" + name + ", openIssues="
				+ openIssues + ", owner=" + owner + ", parent=" + parent
				+ ", pushed=" + pushedAt + ", score=" + score + ", size=" + size
				+ ", source=" + source + ", type=" + type + ", url=" + url
				+ ", username=" + username + ", visibiity=" + visibility
				+ ", watchers=" + watchers + "]";
	}
}
