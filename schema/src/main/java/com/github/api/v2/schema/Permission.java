package com.github.api.v2.schema;

import java.util.HashMap;
import java.util.Map;


/**
	 * The Enum Permission.
	 */
	public enum Permission implements ValueEnum {
		
		/** The ADMIN. */
		ADMIN("admin"), 
		/** The PULL. */
		PULL("pull"), 
		/** The PUSH. */
		PUSH("push");
		
	    /** The Constant stringToEnum. */
		private static final Map<String, Permission> stringToEnum = new HashMap<String, Permission>();

		static { // Initialize map from constant name to enum constant
			for (Permission op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /**
		 * Instantiates a new permission.
		 * 
		 * @param value
		 *            the value
		 */
	    Permission(String value) {
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
		 * @return the permission
		 */
		public static Permission fromValue(String value) {
			return stringToEnum.get(value);
		}
	}