/**
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;

/**
 * @author nmukhtar
 *
 */
public class User extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	
	private String id;
	private String gravatarId;
	private String login;
	private String name;
	private String email;
	private String location;
	private String fullname;
	private String username;
	private String blog;
	private String company;
	private int followingCount;
	private int followersCount;
	private int publicGistCount;
	private int publicRepoCount;
	private int totalPrivateRepoCount;
	private int collaborators;
	private int diskUsage;
	private int ownedPrivateRepoCount;
	private int privateGistCount;
	private Date createdAt;
	private Plan plan;
	
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the blog
	 */
	public String getBlog() {
		return blog;
	}
	/**
	 * @param blog the blog to set
	 */
	public void setBlog(String blog) {
		this.blog = blog;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the followingCount
	 */
	public int getFollowingCount() {
		return followingCount;
	}
	/**
	 * @param followingCount the followingCount to set
	 */
	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}
	/**
	 * @return the followersCount
	 */
	public int getFollowersCount() {
		return followersCount;
	}
	/**
	 * @param followersCount the followersCount to set
	 */
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	/**
	 * @return the publicGistCount
	 */
	public int getPublicGistCount() {
		return publicGistCount;
	}
	/**
	 * @param publicGistCount the publicGistCount to set
	 */
	public void setPublicGistCount(int publicGistCount) {
		this.publicGistCount = publicGistCount;
	}
	/**
	 * @return the publicRepoCount
	 */
	public int getPublicRepoCount() {
		return publicRepoCount;
	}
	/**
	 * @param publicRepoCount the publicRepoCount to set
	 */
	public void setPublicRepoCount(int publicRepoCount) {
		this.publicRepoCount = publicRepoCount;
	}
	/**
	 * @return the totalPrivateRepoCount
	 */
	public int getTotalPrivateRepoCount() {
		return totalPrivateRepoCount;
	}
	/**
	 * @param totalPrivateRepoCount the totalPrivateRepoCount to set
	 */
	public void setTotalPrivateRepoCount(int totalPrivateRepoCount) {
		this.totalPrivateRepoCount = totalPrivateRepoCount;
	}
	/**
	 * @return the collaborators
	 */
	public int getCollaborators() {
		return collaborators;
	}
	/**
	 * @param collaborators the collaborators to set
	 */
	public void setCollaborators(int collaborators) {
		this.collaborators = collaborators;
	}
	/**
	 * @return the diskUsage
	 */
	public int getDiskUsage() {
		return diskUsage;
	}
	/**
	 * @param diskUsage the diskUsage to set
	 */
	public void setDiskUsage(int diskUsage) {
		this.diskUsage = diskUsage;
	}
	/**
	 * @return the ownedPrivateRepoCount
	 */
	public int getOwnedPrivateRepoCount() {
		return ownedPrivateRepoCount;
	}
	/**
	 * @param ownedPrivateRepoCount the ownedPrivateRepoCount to set
	 */
	public void setOwnedPrivateRepoCount(int ownedPrivateRepoCount) {
		this.ownedPrivateRepoCount = ownedPrivateRepoCount;
	}
	/**
	 * @return the privateGistCount
	 */
	public int getPrivateGistCount() {
		return privateGistCount;
	}
	/**
	 * @param privateGistCount the privateGistCount to set
	 */
	public void setPrivateGistCount(int privateGistCount) {
		this.privateGistCount = privateGistCount;
	}
	/**
	 * @return the plan
	 */
	public Plan getPlan() {
		return plan;
	}
	/**
	 * @param plan the plan to set
	 */
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the gravatarId
	 */
	public String getGravatarId() {
		return gravatarId;
	}
	/**
	 * @param gravatarId the gravatarId to set
	 */
	public void setGravatarId(String gravatarId) {
		this.gravatarId = gravatarId;
	}
}
