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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class Issue.
 */
public class Issue extends SchemaEntity {
	
	/**
	 * The Enum State.
	 */
	public enum State implements ValueEnum {
		
		/** The OPEN. */
		OPEN("open"),
		
		/** The CLOSED. */
		CLOSED("closed");
		
	    /** The Constant stringToEnum. */
		private static final Map<String, State> stringToEnum = new HashMap<String, State>();

		static { // Initialize map from constant name to enum constant
			for (State op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /**
		 * Instantiates a new state.
		 * 
		 * @param value
		 *            the value
		 */
	    State(String value) {
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
		 * @return the state
		 */
		public static State fromValue(String value) {
			return stringToEnum.get(value);
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The user. */
	private String user;
	
	/** The gravatar id. */
	private String gravatarId;
	
	/** The updated at. */
	private Date updatedAt;
	
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
	
	/** The closed at. */
	private Date closedAt;
	
	/** The labels. */
	private List<String> labels = new ArrayList<String>();
	
	/**
	 * Gets the closed at.
	 * 
	 * @return the closed at
	 */
	public Date getClosedAt() {
		return closedAt;
	}

	/**
	 * Sets the closed at.
	 * 
	 * @param closedAt
	 *            the new closed at
	 */
	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
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

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(String user) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Issue [body=" + body + ", comments=" + comments
				+ ", createdAt=" + createdAt + ", gravatarId=" + gravatarId
				+ ", number=" + number + ", position=" + position + ", state="
				+ state + ", title=" + title + ", updatedAt=" + updatedAt
				+ ", user=" + user + ", votes=" + votes + "]";
	}
}
