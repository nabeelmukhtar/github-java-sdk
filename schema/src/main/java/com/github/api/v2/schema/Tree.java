/**
 * 
 */
package com.github.api.v2.schema;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nmukhtar
 *
 */
public class Tree extends SchemaEntity {
	public enum Type implements ValueEnum {
		TREE("tree"),
		BLOB("blob");
		
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
	     * Instantiates a new blog sort order.
	     * 
	     * @param value the value
	     */
	    Type(String value) {
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
		public static Type fromValue(String value) {
			return stringToEnum.get(value);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	
	private String name;
	private String sha;
	private String mode;
	private Type type;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sha
	 */
	public String getSha() {
		return sha;
	}
	/**
	 * @param sha the sha to set
	 */
	public void setSha(String sha) {
		this.sha = sha;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tree [mode=" + mode + ", name=" + name + ", sha=" + sha
				+ ", type=" + type + "]";
	}
}
