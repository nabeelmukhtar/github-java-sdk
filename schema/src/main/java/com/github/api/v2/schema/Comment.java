/**
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;

/**
 * @author nmukhtar
 *
 */
public class Comment extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	private Date createdAt;
	private String body;
	private Date updatedAt;
	private long id;
	private String user;
	private String gravatarId;
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
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [body=" + body + ", createdAt=" + createdAt
				+ ", gravatarId=" + gravatarId + ", id=" + id + ", updatedAt="
				+ updatedAt + ", user=" + user + "]";
	}
}
