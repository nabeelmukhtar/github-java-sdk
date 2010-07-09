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
public enum Language implements ValueEnum {
	JAVA("Java"), RUBY("Ruby"), PYTHON("Python"), C("C"), JAVA_SCRIPT("JavaScript");
	
    /** The Constant stringToEnum. */
	private static final Map<String, Language> stringToEnum = new HashMap<String, Language>();

	static { // Initialize map from constant name to enum constant
		for (Language op : values()) {
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
    Language(String value) {
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
	public static Language fromValue(String value) {
		return stringToEnum.get(value);
	}
}
