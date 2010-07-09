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
public class Repository extends SchemaEntity {
	public enum Visibility implements ValueEnum {
		PUBLIC("public"), PRIVATE("private");
		
	    /** The Constant stringToEnum. */
		private static final Map<String, Visibility> stringToEnum = new HashMap<String, Visibility>();

		static { // Initialize map from constant name to enum constant
			for (Visibility op : values()) {
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
	    Visibility(String value) {
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
		public static Visibility fromValue(String value) {
			return stringToEnum.get(value);
		}
	}
	
	public static final String MASTER = "master";

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;

}
