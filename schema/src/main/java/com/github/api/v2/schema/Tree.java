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
 * The Class Tree.
 */
public class Tree extends SchemaEntity {
	
	/**
	 * The Enum Type.
	 */
	public enum Type implements ValueEnum {
		
		/** The TREE. */
		TREE("tree"),
		
		/** The BLOB. */
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
	
	/** The name. */
	private String name;
	
	/** The sha. */
	private String sha;
	
	/** The mode. */
	private String mode;
	
	/** The type. */
	private Type type;
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the sha.
	 * 
	 * @return the sha
	 */
	public String getSha() {
		return sha;
	}
	
	/**
	 * Sets the sha.
	 * 
	 * @param sha
	 *            the new sha
	 */
	public void setSha(String sha) {
		this.sha = sha;
	}
	
	/**
	 * Gets the mode.
	 * 
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	
	/**
	 * Sets the mode.
	 * 
	 * @param mode
	 *            the new mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
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
