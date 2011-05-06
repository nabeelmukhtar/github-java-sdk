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
 * The Class Milestone.
 */
public class Milestone extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
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
	
	/** The number. */
	private int number;
	
	/** The state. */
	private State state;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The creator. */
	private User creator;
	
	/** The open issues. */
	private int openIssues;
	
	/** The closed issues. */
	private int closedIssues;
	
	/** The created at. */
	private Date createdAt;
	
	/** The due on. */
	private Date dueOn;
	
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
	
	/**
	 * Gets the creator.
	 * 
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}
	
	/**
	 * Sets the creator.
	 * 
	 * @param creator
	 *            the new creator
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	/**
	 * Gets the open issues.
	 * 
	 * @return the open issues
	 */
	public int getOpenIssues() {
		return openIssues;
	}
	
	/**
	 * Sets the open issues.
	 * 
	 * @param openIssues
	 *            the new open issues
	 */
	public void setOpenIssues(int openIssues) {
		this.openIssues = openIssues;
	}
	
	/**
	 * Gets the closed issues.
	 * 
	 * @return the closed issues
	 */
	public int getClosedIssues() {
		return closedIssues;
	}
	
	/**
	 * Sets the closed issues.
	 * 
	 * @param closedIssues
	 *            the new closed issues
	 */
	public void setClosedIssues(int closedIssues) {
		this.closedIssues = closedIssues;
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
	 * Gets the due on.
	 * 
	 * @return the due on
	 */
	public Date getDueOn() {
		return dueOn;
	}
	
	/**
	 * Sets the due on.
	 * 
	 * @param dueOn
	 *            the new due on
	 */
	public void setDueOn(Date dueOn) {
		this.dueOn = dueOn;
	}
}
