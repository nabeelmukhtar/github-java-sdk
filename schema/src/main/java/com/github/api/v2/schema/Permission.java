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