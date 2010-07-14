/*
 * 
 */
package com.github.api.v2.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.github.api.v2.schema.ValueEnum;

/**
 * The Interface OAuthService.
 */
public interface OAuthService extends GitHubService {
	
	/**
	 * The Enum Permission.
	 */
	public enum Permission implements ValueEnum {
		
		/** The USER. */
		USER("user"), 
 /** The REPOSITORY. */
 REPOSITORY("repo");
		
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

    /**
	 * Gets the authorization url.
	 * 
	 * @param callBackUrl
	 *            the call back url
	 * 
	 * @return the authorization url
	 */
    public String getAuthorizationUrl(String callBackUrl);
    
    /**
	 * Gets the authorization url.
	 * 
	 * @param callBackUrl
	 *            the call back url
	 * @param permissions
	 *            the permissions
	 * 
	 * @return the authorization url
	 */
    public String getAuthorizationUrl(String callBackUrl, Set<Permission> permissions);

    /**
	 * Gets the access token.
	 * 
	 * @param callBackUrl
	 *            the call back url
	 * @param code
	 *            the code
	 * 
	 * @return the access token
	 */
    public String getAccessToken(String callBackUrl, String code);
}
