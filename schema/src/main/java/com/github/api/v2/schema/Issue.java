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

}
