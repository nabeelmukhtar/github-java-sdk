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

/**
 * The Class Organization.
 */
public class Organization extends SchemaEntity {
	
	/**
	 * The Enum Type.
	 */
	public enum Type implements ValueEnum {
		
		/** The ORGANIZATION. */
		ORGANIZATION("Organization");
		
		
	    /** The Constant stringToEnum. */
		private static final Map<String, Type> stringToEnum = new HashMap<String, Type>();

		static { // Initialize map from constant name to enum constant
			for (Type op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /**
		 * Instantiates a new type.
		 * 
		 * @param value
		 *            the value
		 */
	    Type(String value) {
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
		 * @return the type
		 */
		public static Type fromValue(String value) {
			return stringToEnum.get(value);
		}
	}
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2665103321482505351L;

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
	
	/** The owned private repo count. */
	private int ownedPrivateRepoCount;
	
	/** The private gist count. */
	private int privateGistCount;
	
	/** The created at. */
	private Date createdAt;
	
	/** The permission. */
	private Permission permission;
	
	/** The billing email. */
	private String billingEmail;
	
	/** The type. */
	private Type type;
	
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

	/**
	 * Gets the billing email.
	 * 
	 * @return the billing email
	 */
	public String getBillingEmail() {
		return billingEmail;
	}

	/**
	 * Sets the billing email.
	 * 
	 * @param billingEmail
	 *            the new billing email
	 */
	public void setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(Type type) {
		this.type = type;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Organization [billingEmail=" + billingEmail + ", blog=" + blog
				+ ", company=" + company + ", createdAt=" + createdAt
				+ ", email=" + email + ", followersCount=" + followersCount
				+ ", followingCount=" + followingCount + ", gravatarId="
				+ gravatarId + ", id=" + id + ", location=" + location
				+ ", login=" + login + ", name=" + name
				+ ", ownedPrivateRepoCount=" + ownedPrivateRepoCount
				+ ", permission=" + permission + ", privateGistCount="
				+ privateGistCount + ", publicGistCount=" + publicGistCount
				+ ", publicRepoCount=" + publicRepoCount
				+ ", totalPrivateRepoCount=" + totalPrivateRepoCount
				+ ", type=" + type + "]";
	}
}
