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

/**
 * The Class NetworkCommit.
 */
public class NetworkCommit extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The message. */
	private String message;
	
	/** The time. */
	private long time;
	
	/** The parents. */
	private List<List<String>> parents;
	
	/** The date. */
	private Date date;
	
	/** The author. */
	private String author;
	
	/** The id. */
	private String id;
	
	/** The space. */
	private int space;
	
	/** The gravatar. */
	private String gravatar;
	
	/** The login. */
	private String login;
	
	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 * 
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Gets the time.
	 * 
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	
	/**
	 * Sets the time.
	 * 
	 * @param time
	 *            the new time
	 */
	public void setTime(long time) {
		this.time = time;
	}
	
	/**
	 * Gets the parents.
	 * 
	 * @return the parents
	 */
	public List<List<String>> getParents() {
		return parents;
	}
	
	/**
	 * Sets the parents.
	 * 
	 * @param parents
	 *            the new parents
	 */
	public void setParents(List<List<String>> parents) {
		this.parents = parents;
	}
	
	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * Gets the space.
	 * 
	 * @return the space
	 */
	public int getSpace() {
		return space;
	}
	
	/**
	 * Sets the space.
	 * 
	 * @param space
	 *            the new space
	 */
	public void setSpace(int space) {
		this.space = space;
	}
	
	/**
	 * Gets the gravatar.
	 * 
	 * @return the gravatar
	 */
	public String getGravatar() {
		return gravatar;
	}
	
	/**
	 * Sets the gravatar.
	 * 
	 * @param gravatar
	 *            the new gravatar
	 */
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NetworkCommit [author=" + author + ", date=" + date
				+ ", gravatar=" + gravatar + ", id=" + id + ", login=" + login
				+ ", message=" + message + ", parents=" + parents + ", space="
				+ space + ", time=" + time + "]";
	}
}
