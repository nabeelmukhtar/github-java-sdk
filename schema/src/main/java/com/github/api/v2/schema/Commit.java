/**
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;
import java.util.List;

/**
 * @author nmukhtar
 *
 */
public class Commit extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	private String message;
	private long time;
	private List<String> parents;
	private Date date;
	private User author;
	private String id;
	private int space;
	private String gravatar;
	private String login;
	private String url;
	private Date committedDate;
	private Date authoredDate;
	private String tree;
	private User committer;
	private List<Delta> added;
	private List<Delta> removed;
	private List<Delta> modified;
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
	/**
	 * @return the parents
	 */
	public List<String> getParents() {
		return parents;
	}
	/**
	 * @param parents the parents to set
	 */
	public void setParents(List<String> parents) {
		this.parents = parents;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
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
	 * @return the space
	 */
	public int getSpace() {
		return space;
	}
	/**
	 * @param space the space to set
	 */
	public void setSpace(int space) {
		this.space = space;
	}
	/**
	 * @return the gravatar
	 */
	public String getGravatar() {
		return gravatar;
	}
	/**
	 * @param gravatar the gravatar to set
	 */
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the committedDate
	 */
	public Date getCommittedDate() {
		return committedDate;
	}
	/**
	 * @param committedDate the committedDate to set
	 */
	public void setCommittedDate(Date committedDate) {
		this.committedDate = committedDate;
	}
	/**
	 * @return the authoredDate
	 */
	public Date getAuthoredDate() {
		return authoredDate;
	}
	/**
	 * @param authoredDate the authoredDate to set
	 */
	public void setAuthoredDate(Date authoredDate) {
		this.authoredDate = authoredDate;
	}
	/**
	 * @return the tree
	 */
	public String getTree() {
		return tree;
	}
	/**
	 * @param tree the tree to set
	 */
	public void setTree(String tree) {
		this.tree = tree;
	}
	/**
	 * @return the committer
	 */
	public User getCommitter() {
		return committer;
	}
	/**
	 * @param committer the committer to set
	 */
	public void setCommitter(User committer) {
		this.committer = committer;
	}
	/**
	 * @return the added
	 */
	public List<Delta> getAdded() {
		return added;
	}
	/**
	 * @param added the added to set
	 */
	public void setAdded(List<Delta> added) {
		this.added = added;
	}
	/**
	 * @return the removed
	 */
	public List<Delta> getRemoved() {
		return removed;
	}
	/**
	 * @param removed the removed to set
	 */
	public void setRemoved(List<Delta> removed) {
		this.removed = removed;
	}
	/**
	 * @return the modified
	 */
	public List<Delta> getModified() {
		return modified;
	}
	/**
	 * @param modified the modified to set
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
