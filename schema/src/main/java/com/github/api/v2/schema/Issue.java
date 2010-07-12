/**
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nmukhtar
 *
 */
public class Issue extends SchemaEntity {
	public enum State implements ValueEnum {
		OPEN("open"),
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
	     * Instantiates a new blog sort order.
	     * 
	     * @param value the value
	     */
	    State(String value) {
	        this.value = value;
	    }

		@Override
		public String value() {
			return value;
		}
		
		/**
		 * From value.
		 * 
		 * @param value the value
		 * 
		 * @return the blog sort order
		 */
		public static State fromValue(String value) {
			return stringToEnum.get(value);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	
	private String user;
	private String gravatarId;
	private Date updatedAt;
	private int votes;
	private int number;
	private int comments;
	private double position;
	private String title;
	private String body;
	private State state;
	private Date createdAt;
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
	 * @return the votes
	 */
	public int getVotes() {
		return votes;
	}
	/**
	 * @param votes the votes to set
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the position
	 */
	public double getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(double position) {
		this.position = position;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
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
	 * @return the comments
	 */
	public int getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(int comments) {
		this.comments = comments;
	}
}
