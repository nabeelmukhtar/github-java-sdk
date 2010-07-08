/**
 *
 */
package com.github.api.v2.services.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.api.v2.schema.ValueEnum;

/**
 * The Class GoogleSearchApiUrls.
 */
public final class GitHubApiUrls {

    /** The Constant API_URLS_FILE. */
    public static final String API_URLS_FILE = "GitHubApiUrls.properties";

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(GitHubApiUrls.class.getCanonicalName());
    
    /** The Constant googleApiUrls. */
    private static final Properties gitHubApiUrls = new Properties();

    static {
        try {
            gitHubApiUrls.load(GitHubApiUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }
    
    public static interface UserApiUrls {
        /** The Constant SEARCH_WEB_URL. */
        public static final String SEARCH_WEB_URL =
            gitHubApiUrls.getProperty("com.googleapis.ajax.services.search.web");
    }

    public static interface IssueApiUrls {
        /** The Constant SEARCH_WEB_URL. */
        public static final String SEARCH_WEB_URL =
            gitHubApiUrls.getProperty("com.googleapis.ajax.services.search.web");
    }
    
    public static interface GistApiUrls {
        /** The Constant SEARCH_WEB_URL. */
        public static final String SEARCH_WEB_URL =
            gitHubApiUrls.getProperty("com.googleapis.ajax.services.search.web");
    }
    
    public static interface NetworkApiUrls {
        /** The Constant SEARCH_WEB_URL. */
        public static final String SEARCH_WEB_URL =
            gitHubApiUrls.getProperty("com.googleapis.ajax.services.search.web");
    }
    
    public static interface RepositoryApiUrls {
        /** The Constant SEARCH_WEB_URL. */
        public static final String SEARCH_WEB_URL =
            gitHubApiUrls.getProperty("com.googleapis.ajax.services.search.web");
    }
    
    public static interface CommitApiUrls {
        /** The Constant SEARCH_WEB_URL. */
        public static final String SEARCH_WEB_URL =
            gitHubApiUrls.getProperty("com.googleapis.ajax.services.search.web");
    }
    
    public static interface ObjectApiUrls {
        /** The Constant SEARCH_WEB_URL. */
        public static final String SEARCH_WEB_URL =
            gitHubApiUrls.getProperty("com.googleapis.ajax.services.search.web");
    }
    
    /**
     * Instantiates a new google search api urls.
     */
    private GitHubApiUrls() {}

    /**
     * The Class GoogleSearchApiUrlBuilder.
     */
    public static class GitHubApiUrlBuilder {
        
        /** The Constant API_URLS_PLACEHOLDER_START. */
        private static final char API_URLS_PLACEHOLDER_START = '{';

        /** The Constant API_URLS_PLACEHOLDER_END. */
        private static final char API_URLS_PLACEHOLDER_END = '}';
        
        /** The Constant QUERY_PARAMETERS_PLACEHOLDER. */
        private static final String QUERY_PARAMETERS_PLACEHOLDER = "queryParameters";
    	
    	/** The url format. */
	    private String urlFormat;
	    
    	/** The parameters map. */
	    private Map<String, Collection<String>> parametersMap = new HashMap<String, Collection<String>>();
    	
    	/**
	     * Instantiates a new google search api url builder.
	     * 
	     * @param urlFormat the url format
	     */
	    public GitHubApiUrlBuilder(String urlFormat) {
	    	this(urlFormat, ApplicationConstants.DEFAULT_API_VERSION);
    	}
    	
    	/**
	     * Instantiates a new google search api url builder.
	     * 
	     * @param urlFormat the url format
	     * @param apiVersion the api version
	     */
	    public GitHubApiUrlBuilder(String urlFormat, String apiVersion) {
    		this.urlFormat = urlFormat;
    		parametersMap.put(ParameterNames.VERSION, Collections.singleton(encodeUrl(apiVersion)));
    	}
	    
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the google search api url builder
	     */
	    public GitHubApiUrlBuilder withParameter(String name, String value) {
	    	if (value != null && value.length() > 0) {
	    		Collection<String> values = parametersMap.get(name);
	    		if (values == null) {
	    			values = new ArrayList<String>();
		    		parametersMap.put(name, values);
	    		}
	    		values.add(encodeUrl(value));
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the google search api url builder
	     */
	    public GitHubApiUrlBuilder withParameterSuffix(String name, String suffix) {
	    	if (suffix != null && suffix.length() > 0) {
	    		Collection<String> values = parametersMap.get(name);
	    		if (values != null) {
	    			List<String> updatedValues = new ArrayList<String>(values.size());
	    			for (String value : values) {
	    				updatedValues.add(encodeUrl(suffix) + value);	    				
	    			}
		    		parametersMap.put(name, updatedValues);
	    		}
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * With parameters.
	     * 
	     * @param name the name
	     * @param values the values
	     * 
	     * @return the google search api url builder
	     */
	    public GitHubApiUrlBuilder withParameters(String name, Collection<String> values) {
	    	List<String> encodedValues = new ArrayList<String>(values.size());
	    	for (String value : values) {
	    		encodedValues.add(encodeUrl(value));
	    	}
    		parametersMap.put(name, encodedValues);
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * 
	     * @return the google search api url builder
	     */
	    public GitHubApiUrlBuilder withParameterEnumSet(String name, Set<? extends ValueEnum> enumSet) {
	    	Set<String> values = new HashSet<String>(enumSet.size());
	    	
	    	for (ValueEnum fieldEnum : enumSet) {
	    		values.add(encodeUrl(fieldEnum.value()));
	    	}
	    	
    		parametersMap.put(name, values);
    		
    		return this;
    	}
	    
    	/**
	     * With parameter enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the google search api url builder
	     */
	    public GitHubApiUrlBuilder withParameterEnum(String name, ValueEnum value) {
	    	withParameter(name, value.value());
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum map.
	     * 
	     * @param enumMap the enum map
	     * 
	     * @return the google search api url builder
	     */
	    public GitHubApiUrlBuilder withParameterEnumMap(Map<? extends ValueEnum, String> enumMap) {
	    	for (ValueEnum parameter : enumMap.keySet()) {
	    		withParameter(parameter.value(), enumMap.get(parameter));
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * Builds the url.
	     * 
	     * @return the string
	     */
		public String buildUrl() {
        	StringBuilder urlBuilder = new StringBuilder();
        	StringBuilder placeHolderBuilder = new StringBuilder();
        	boolean placeHolderFlag = false;
        	for (int i = 0; i < urlFormat.length(); i++) {
        		if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
        			placeHolderBuilder = new StringBuilder();
        			placeHolderFlag = true;
        		} else if (placeHolderFlag && urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
        			String placeHolder = placeHolderBuilder.toString();
        			if (QUERY_PARAMETERS_PLACEHOLDER.equals(placeHolder)) {
    			    	StringBuilder builder = new StringBuilder();
    			    	if (!parametersMap.isEmpty()) {
    			    		Iterator<String> iter = parametersMap.keySet().iterator();
    			    		while (iter.hasNext()) {
    			    			String name = iter.next();
			    				Collection<String> parameterValues = parametersMap.get(name);
			    				Iterator<String> iterParam = parameterValues.iterator();
			    				while (iterParam.hasNext()) {
    			    				builder.append(name);
    			    				builder.append("=");
    			    				builder.append(iterParam.next());
    			    				if (iterParam.hasNext()) {
        			    				builder.append("&");
    			    				}
			    				}
    			    			if (iter.hasNext()) {
    			    				builder.append("&");
    			    			}
    			    		}
    			    	}
    			    	urlBuilder.append(builder.toString());
        			} else {
        				// we did not find a binding for the placeholder.
        				// append it as it is.
        				urlBuilder.append(API_URLS_PLACEHOLDER_START);
        				urlBuilder.append(placeHolder);
        				urlBuilder.append(API_URLS_PLACEHOLDER_END);
        			}
        			placeHolderFlag = false;
        		} else if (placeHolderFlag) {
        			placeHolderBuilder.append(urlFormat.charAt(i));
        		} else {
        			urlBuilder.append(urlFormat.charAt(i));
        		}
        	}

        	return urlBuilder.toString();
    	}
    	
        /**
         * Encode url.
         * 
         * @param original the original
         * 
         * @return the string
         */
        private static String encodeUrl(String original) {
        	try {
    			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
    		} catch (UnsupportedEncodingException e) {
    			// should never be here..
    			return original;
    		}
        }
    }
}
