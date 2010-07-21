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
 * The Class Commit.
 */
public class Commit extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The message. */
	private String message;
	
	/** The time. */
	private long time;
	
	/** The parents. */
	private List<Id> parents;
	
	/** The date. */
	private Date date;
	
	/** The author. */
	private User author;
	
	/** The id. */
	private String id;
	
	/** The space. */
	private int space;
	
	/** The gravatar. */
	private String gravatar;
	
	/** The login. */
	private String login;
	
	/** The url. */
	private String url;
	
	/** The committed date. */
	private Date committedDate;
	
	/** The authored date. */
	private Date authoredDate;
	
	/** The tree. */
	private String tree;
	
	/** The committer. */
	private User committer;
	
	/** The added. */
	private List<String> added;
	
	/** The removed. */
	private List<String> removed;
	
	/** The modified. */
	private List<Delta> modified;
	
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
	public List<Id> getParents() {
		return parents;
	}
	
	/**
	 * Sets the parents.
	 * 
	 * @param parents
	 *            the new parents
	 */
	public void setParents(List<Id> parents) {
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
	public User getAuthor() {
		return author;
	}
	
	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(User author) {
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
	 * Gets the committed date.
	 * 
	 * @return the committed date
	 */
	public Date getCommittedDate() {
		return committedDate;
	}
	
	/**
	 * Sets the committed date.
	 * 
	 * @param committedDate
	 *            the new committed date
	 */
	public void setCommittedDate(Date committedDate) {
		this.committedDate = committedDate;
	}
	
	/**
	 * Gets the authored date.
	 * 
	 * @return the authored date
	 */
	public Date getAuthoredDate() {
		return authoredDate;
	}
	
	/**
	 * Sets the authored date.
	 * 
	 * @param authoredDate
	 *            the new authored date
	 */
	public void setAuthoredDate(Date authoredDate) {
		this.authoredDate = authoredDate;
	}
	
	/**
	 * Gets the tree.
	 * 
	 * @return the tree
	 */
	public String getTree() {
		return tree;
	}
	
	/**
	 * Sets the tree.
	 * 
	 * @param tree
	 *            the new tree
	 */
	public void setTree(String tree) {
		this.tree = tree;
	}
	
	/**
	 * Gets the committer.
	 * 
	 * @return the committer
	 */
	public User getCommitter() {
		return committer;
	}
	
	/**
	 * Sets the committer.
	 * 
	 * @param committer
	 *            the new committer
	 */
	public void setCommitter(User committer) {
		this.committer = committer;
	}
	
	/**
	 * Gets the added.
	 * 
	 * @return the added
	 */
	public List<String> getAdded() {
		return added;
	}
	
	/**
	 * Sets the added.
	 * 
	 * @param added
	 *            the new added
	 */
	public void setAdded(List<String> added) {
		this.added = added;
	}
	
	/**
	 * Gets the removed.
	 * 
	 * @return the removed
	 */
	public List<String> getRemoved() {
		return removed;
	}
	
	/**
	 * Sets the removed.
	 * 
	 * @param removed
	 *            the new removed
	 */
	public void setRemoved(List<String> removed) {
		this.removed = removed;
	}
	
	/**
	 * Gets the modified.
	 * 
	 * @return the modified
	 */
	public List<Delta> getModified() {
		return modified;
	}
	
	/**
	 * Sets the modified.
	 * 
	 * @param modified
	 *            the new modified
	 */
	public void setModified(List<Delta> modified) {
		this.modified = modified;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Commit [added=" + added + ", author=" + author
				+ ", authoredDate=" + authoredDate + ", committedDate="
				+ committedDate + ", committer=" + committer + ", date=" + date
				+ ", gravatar=" + gravatar + ", id=" + id + ", login=" + login
				+ ", message=" + message + ", modified=" + modified
				+ ", parents=" + parents + ", removed=" + removed + ", space="
				+ space + ", time=" + time + ", tree=" + tree + ", url=" + url
				+ "]";
	}
}
