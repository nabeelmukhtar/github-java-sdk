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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.api.v2.schema.Issue.State;

/**
 * The Class PullRequest.
 */
public class PullRequest extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The user. */
	private User user;
	
	/** The gravatar id. */
	private String gravatarId;
	
	/** The issue updated at. */
	private Date issueUpdatedAt;
	
	/** The votes. */
	private int votes;
	
	/** The number. */
	private int number;
	
	/** The comments. */
	private int comments;
	
	/** The position. */
	private double position;
	
	/** The title. */
	private String title;
	
	/** The body. */
	private String body;
	
	/** The state. */
	private State state;
	
	/** The created at. */
	private Date createdAt;
	
	/** The issue created at. */
	private Date issueCreatedAt;
	
	/** The html url. */
	private String htmlUrl;
	
	/** The diff url. */
	private String diffUrl;
	
	/** The patch url. */
	private String patchUrl;
	
	/** The issue user. */
	private User issueUser;
	
	/** The base. */
	private Version base;
	
	/** The head. */
	private Version head;
	
	/** The labels. */
	private List<String> labels = new ArrayList<String>();
	
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
	 * Gets the issue updated at.
	 * 
	 * @return the issue updated at
	 */
	public Date getIssueUpdatedAt() {
		return issueUpdatedAt;
	}
	
	/**
	 * Sets the issue updated at.
	 * 
	 * @param updatedAt
	 *            the new issue updated at
	 */
	public void setIssueUpdatedAt(Date updatedAt) {
		this.issueUpdatedAt = updatedAt;
	}
	
	/**
	 * Gets the votes.
	 * 
	 * @return the votes
	 */
	public int getVotes() {
		return votes;
	}
	
	/**
	 * Sets the votes.
	 * 
	 * @param votes
	 *            the new votes
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	/**
	 * Gets the number.
	 * 
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Sets the number.
	 * 
	 * @param number
	 *            the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Gets the position.
	 * 
	 * @return the position
	 */
	public double getPosition() {
		return position;
	}
	
	/**
	 * Sets the position.
	 * 
	 * @param position
	 *            the new position
	 */
	public void setPosition(double position) {
		this.position = position;
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
	 * Gets the state.
	 * 
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 * 
	 * @param state
	 *            the new state
	 */
	public void setState(State state) {
		this.state = state;
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
	 * Gets the comments.
	 * 
	 * @return the comments
	 */
	public int getComments() {
		return comments;
	}
	
	/**
	 * Sets the comments.
	 * 
	 * @param comments
	 *            the new comments
	 */
	public void setComments(int comments) {
		this.comments = comments;
	}

	/**
	 * Gets the issue created at.
	 * 
	 * @return the issue created at
	 */
	public Date getIssueCreatedAt() {
		return issueCreatedAt;
	}

	/**
	 * Sets the issue created at.
	 * 
	 * @param issueCreatedAt
	 *            the new issue created at
	 */
	public void setIssueCreatedAt(Date issueCreatedAt) {
		this.issueCreatedAt = issueCreatedAt;
	}

	/**
	 * Gets the html url.
	 * 
	 * @return the html url
	 */
	public String getHtmlUrl() {
		return htmlUrl;
	}

	/**
	 * Sets the html url.
	 * 
	 * @param htmlUrl
	 *            the new html url
	 */
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	/**
	 * Gets the diff url.
	 * 
	 * @return the diff url
	 */
	public String getDiffUrl() {
		return diffUrl;
	}

	/**
	 * Sets the diff url.
	 * 
	 * @param diffUrl
	 *            the new diff url
	 */
	public void setDiffUrl(String diffUrl) {
		this.diffUrl = diffUrl;
	}

	/**
	 * Gets the patch url.
	 * 
	 * @return the patch url
	 */
	public String getPatchUrl() {
		return patchUrl;
	}

	/**
	 * Sets the patch url.
	 * 
	 * @param patchUrl
	 *            the new patch url
	 */
	public void setPatchUrl(String patchUrl) {
		this.patchUrl = patchUrl;
	}

	/**
	 * Gets the issue user.
	 * 
	 * @return the issue user
	 */
	public User getIssueUser() {
		return issueUser;
	}

	/**
	 * Sets the issue user.
	 * 
	 * @param issueUser
	 *            the new issue user
	 */
	public void setIssueUser(User issueUser) {
		this.issueUser = issueUser;
	}

	/**
	 * Gets the base.
	 * 
	 * @return the base
	 */
	public Version getBase() {
		return base;
	}

	/**
	 * Sets the base.
	 * 
	 * @param base
	 *            the new base
	 */
	public void setBase(Version base) {
		this.base = base;
	}

	/**
	 * Gets the head.
	 * 
	 * @return the head
	 */
	public Version getHead() {
		return head;
	}

	/**
	 * Sets the head.
	 * 
	 * @param head
	 *            the new head
	 */
	public void setHead(Version head) {
		this.head = head;
	}

	/**
	 * Gets the labels.
	 * 
	 * @return the labels
	 */
	public List<String> getLabels() {
		return labels;
	}

	/**
	 * Sets the labels.
	 * 
	 * @param labels
	 *            the new labels
	 */
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PullRequest [base=" + base + ", body=" + body + ", comments="
				+ comments + ", createdAt=" + createdAt + ", diffUrl="
				+ diffUrl + ", gravatarId=" + gravatarId + ", head=" + head
				+ ", htmlUrl=" + htmlUrl + ", issueCreatedAt=" + issueCreatedAt
				+ ", issueUpdatedAt=" + issueUpdatedAt + ", issueUser="
				+ issueUser + ", labels=" + labels + ", number=" + number
				+ ", patchUrl=" + patchUrl + ", position=" + position
				+ ", state=" + state + ", title=" + title + ", user=" + user
				+ ", votes=" + votes + "]";
	}
}
