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
 * The Class Event.
 */
public class Event extends SchemaEntity {
	
	/**
	 * The Enum Type.
	 */
	public enum Type implements ValueEnum {
		
		/** The CLOSED. */
		CLOSED("closed"), 
 
 /** The REOPENED. */
		REOPENED("reopened"),
 
 /** The SUBSCRIBED. */
		SUBSCRIBED("subscribed"),
		
		/** The MERGED. */
		MERGED("merged"),
		
		/** The REFERENCED. */
		REFERENCED("referenced"),
		
		/** The MENTIONED. */
		MENTIONED("mentioned"),
		
		/** The ASSIGNED. */
		ASSIGNED("assigned");

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
	
	/** The actor. */
	private User actor;
	
	/** The event. */
	private Type event;
	
	/** The commit id. */
	private String commitId;
	
	/** The created at. */
	private Date createdAt;
	
	/**
	 * Gets the actor.
	 * 
	 * @return the actor
	 */
	public User getActor() {
		return actor;
	}
	
	/**
	 * Sets the actor.
	 * 
	 * @param actor
	 *            the new actor
	 */
	public void setActor(User actor) {
		this.actor = actor;
	}
	
	/**
	 * Gets the event.
	 * 
	 * @return the event
	 */
	public Type getEvent() {
		return event;
	}
	
	/**
	 * Sets the event.
	 * 
	 * @param event
	 *            the new event
	 */
	public void setEvent(Type event) {
		this.event = event;
	}
	
	/**
	 * Gets the commit id.
	 * 
	 * @return the commit id
	 */
	public String getCommitId() {
		return commitId;
	}
	
	/**
	 * Sets the commit id.
	 * 
	 * @param commitId
	 *            the new commit id
	 */
	public void setCommitId(String commitId) {
		this.commitId = commitId;
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
}
