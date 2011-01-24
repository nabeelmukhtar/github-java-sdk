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

/**
 * The Class User.
 */
public class User extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The id. */
	private String id;
	
	/** The gravatar id. */
	private String gravatarId;
	
	/** The login. */
	private String login;
	
	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
	
	/** The location. */
	private String location;
	
	/** The fullname. */
	private String fullname;
	
	/** The username. */
	private String username;
	
	/** The blog. */
	private String blog;
	
	/** The company. */
	private String company;
	
	/** The following count. */
	private int followingCount;
	
	/** The followers count. */
	private int followersCount;
	
	/** The public gist count. */
	private int publicGistCount;
	
	/** The public repo count. */
	private int publicRepoCount;
	
	/** The total private repo count. */
	private int totalPrivateRepoCount;
	
	/** The collaborators. */
	private int collaborators;
	
	/** The disk usage. */
	private int diskUsage;
	
	/** The owned private repo count. */
	private int ownedPrivateRepoCount;
	
	/** The private gist count. */
	private int privateGistCount;
	
	/** The created at. */
	private Date createdAt;
	
	/** The plan. */
	private Plan plan;
	
	/** The permission. */
	private Permission permission;
	
	/** The score. */
	private double score;
	
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
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 * 
	 * @param location
	 *            the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Gets the fullname.
	 * 
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	
	/**
	 * Sets the fullname.
	 * 
	 * @param fullname
	 *            the new fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the blog.
	 * 
	 * @return the blog
	 */
	public String getBlog() {
		return blog;
	}
	
	/**
	 * Sets the blog.
	 * 
	 * @param blog
	 *            the new blog
	 */
	public void setBlog(String blog) {
		this.blog = blog;
	}
	
	/**
	 * Gets the company.
	 * 
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * Sets the company.
	 * 
	 * @param company
	 *            the new company
	 */
	public void setCompany(String company) {
		this.company = company;
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
	 * Gets the login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Sets the login.
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Gets the following count.
	 * 
	 * @return the following count
	 */
	public int getFollowingCount() {
		return followingCount;
	}
	
	/**
	 * Sets the following count.
	 * 
	 * @param followingCount
	 *            the new following count
	 */
	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}
	
	/**
	 * Gets the followers count.
	 * 
	 * @return the followers count
	 */
	public int getFollowersCount() {
		return followersCount;
	}
	
	/**
	 * Sets the followers count.
	 * 
	 * @param followersCount
	 *            the new followers count
	 */
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	
	/**
	 * Gets the public gist count.
	 * 
	 * @return the public gist count
	 */
	public int getPublicGistCount() {
		return publicGistCount;
	}
	
	/**
	 * Sets the public gist count.
	 * 
	 * @param publicGistCount
	 *            the new public gist count
	 */
	public void setPublicGistCount(int publicGistCount) {
		this.publicGistCount = publicGistCount;
	}
	
	/**
	 * Gets the public repo count.
	 * 
	 * @return the public repo count
	 */
	public int getPublicRepoCount() {
		return publicRepoCount;
	}
	
	/**
	 * Sets the public repo count.
	 * 
	 * @param publicRepoCount
	 *            the new public repo count
	 */
	public void setPublicRepoCount(int publicRepoCount) {
		this.publicRepoCount = publicRepoCount;
	}
	
	/**
	 * Gets the total private repo count.
	 * 
	 * @return the total private repo count
	 */
	public int getTotalPrivateRepoCount() {
		return totalPrivateRepoCount;
	}
	
	/**
	 * Sets the total private repo count.
	 * 
	 * @param totalPrivateRepoCount
	 *            the new total private repo count
	 */
	public void setTotalPrivateRepoCount(int totalPrivateRepoCount) {
		this.totalPrivateRepoCount = totalPrivateRepoCount;
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
	 * Gets the disk usage.
	 * 
	 * @return the disk usage
	 */
	public int getDiskUsage() {
		return diskUsage;
	}
	
	/**
	 * Sets the disk usage.
	 * 
	 * @param diskUsage
	 *            the new disk usage
	 */
	public void setDiskUsage(int diskUsage) {
		this.diskUsage = diskUsage;
	}
	
	/**
	 * Gets the owned private repo count.
	 * 
	 * @return the owned private repo count
	 */
	public int getOwnedPrivateRepoCount() {
		return ownedPrivateRepoCount;
	}
	
	/**
	 * Sets the owned private repo count.
	 * 
	 * @param ownedPrivateRepoCount
	 *            the new owned private repo count
	 */
	public void setOwnedPrivateRepoCount(int ownedPrivateRepoCount) {
		this.ownedPrivateRepoCount = ownedPrivateRepoCount;
	}
	
	/**
	 * Gets the private gist count.
	 * 
	 * @return the private gist count
	 */
	public int getPrivateGistCount() {
		return privateGistCount;
	}
	
	/**
	 * Sets the private gist count.
	 * 
	 * @param privateGistCount
	 *            the new private gist count
	 */
	public void setPrivateGistCount(int privateGistCount) {
		this.privateGistCount = privateGistCount;
	}
	
	/**
	 * Gets the plan.
	 * 
	 * @return the plan
	 */
	public Plan getPlan() {
		return plan;
	}
	
	/**
	 * Sets the plan.
	 * 
	 * @param plan
	 *            the new plan
	 */
	public void setPlan(Plan plan) {
		this.plan = plan;
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
	 * Gets the gravatar id.
	 * 
	 * @return the gravatar id
	 */
	public String getGravatarId() {
		return gravatarId;
	}
	
	/**
	 * Sets the gravatar id.
	 * 
	 * @param gravatarId
	 *            the new gravatar id
	 */
	public void setGravatarId(String gravatarId) {
		this.gravatarId = gravatarId;
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
		return "User [blog=" + blog + ", collaborators=" + collaborators
				+ ", company=" + company + ", createdAt=" + createdAt
				+ ", diskUsage=" + diskUsage + ", email=" + email
				+ ", followersCount=" + followersCount + ", followingCount="
				+ followingCount + ", fullname=" + fullname + ", gravatarId="
				+ gravatarId + ", id=" + id + ", location=" + location
				+ ", login=" + login + ", name=" + name
				+ ", ownedPrivateRepoCount=" + ownedPrivateRepoCount
				+ ", plan=" + plan + ", privateGistCount=" + privateGistCount
				+ ", publicGistCount=" + publicGistCount + ", publicRepoCount="
				+ publicRepoCount + ", totalPrivateRepoCount="
				+ totalPrivateRepoCount + ", username=" + username + "]";
	}
}
