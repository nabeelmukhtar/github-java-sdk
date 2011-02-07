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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.github.api.v2.services.constant.ApplicationConstants;

/**
 * The Class Discussion.
 */
public class Discussion extends SchemaEntity {
	
	/** The Constant COMMENT_DATE_FORMAT. */
	private static final SimpleDateFormat COMMENT_DATE_FORMAT = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);
	
	/** The Constant COMMIT_DATE_FORMAT. */
	private static final SimpleDateFormat COMMIT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	/**
	 * The Enum Type.
	 */
	public enum Type implements ValueEnum {
		
		/** The ISSU e_ comment. */
		ISSUE_COMMENT("IssueComment"), 
 /** The COMMIT. */
 COMMIT("Commit");

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
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The created at. */
	private String createdAt;
	
	/** The body. */
	private String body;
	
	/** The updated at. */
	private Date updatedAt;
	
	/** The id. */
	private long id;
	
	/** The user. */
	private User user;
	
	/** The gravatar id. */
	private String gravatarId;
	
	/** The type. */
	private Type type;
	
	/** The sha. */
	private String sha;
	
	/** The author. */
	private String author;
	
	/** The subject. */
	private String subject;
	
	/** The email. */
	private String email; 
	
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
	 * Gets the created at.
	 * 
	 * @return the created at
	 */
	public Date getCreatedAt() {
		try {
			return getDateFormat().parse(createdAt);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * Sets the created at.
	 * 
	 * @param createdAt
	 *            the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = getDateFormat().format(createdAt);
	}
	
	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * Sets the body.
	 * 
	 * @param body
	 *            the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * Gets the updated at.
	 * 
	 * @return the updated at
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * Sets the updated at.
	 * 
	 * @param updatedAt
	 *            the new updated at
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
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
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 * 
	 * @param subject
	 *            the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [body=" + body + ", createdAt=" + createdAt
				+ ", gravatarId=" + gravatarId + ", id=" + id + ", updatedAt="
				+ updatedAt + ", user=" + user + "]";
	}
	
	/**
	 * Gets the date format.
	 * 
	 * @return the date format
	 */
	private SimpleDateFormat getDateFormat() {
		return (getType() == Type.COMMIT)? COMMIT_DATE_FORMAT : COMMENT_DATE_FORMAT;		
	}
}
