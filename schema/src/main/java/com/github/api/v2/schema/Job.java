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
 * The Class Job.
 */
public class Job extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/**
	 * The Enum Type.
	 */
	public enum Type implements ValueEnum {
		
		/** The CONTRACT. */
		CONTRACT("Contract"), 
 
 /** The FUL l_ time. */
 FULL_TIME("Full Time");

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
	
	
	/** The company. */
	private String company;
	
	/** The location. */
	private String location;
	
	/** The created at. */
	private Date createdAt;
	
	/** The company url. */
	private String companyUrl;
	
	/** The title. */
	private String title;
	
	/** The url. */
	private String url;
	
	/** The id. */
	private String id;
	
	/** The company logo. */
	private String companyLogo;
	
	/** The type. */
	private Type type;
	
	/** The how to apply. */
	private String howToApply;
	
	/** The description. */
	private String description;
	
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
	 * Gets the company url.
	 * 
	 * @return the company url
	 */
	public String getCompanyUrl() {
		return companyUrl;
	}
	
	/**
	 * Sets the company url.
	 * 
	 * @param companyUrl
	 *            the new company url
	 */
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
	
	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * Gets the company logo.
	 * 
	 * @return the company logo
	 */
	public String getCompanyLogo() {
		return companyLogo;
	}
	
	/**
	 * Sets the company logo.
	 * 
	 * @param companyLogo
	 *            the new company logo
	 */
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
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
	 * Gets the how to apply.
	 * 
	 * @return the how to apply
	 */
	public String getHowToApply() {
		return howToApply;
	}
	
	/**
	 * Sets the how to apply.
	 * 
	 * @param howToApply
	 *            the new how to apply
	 */
	public void setHowToApply(String howToApply) {
		this.howToApply = howToApply;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Job [company=" + company + ", companyLogo=" + companyLogo
				+ ", companyUrl=" + companyUrl + ", createdAt=" + createdAt
				+ ", description=" + description + ", howToApply=" + howToApply
				+ ", id=" + id + ", location=" + location + ", title=" + title
				+ ", type=" + type + ", url=" + url + "]";
	}
}
