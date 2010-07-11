/**
 *
 */
package com.github.api.v2.services.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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
    private static final Logger logger = Logger.getLogger(GitHubApiUrls.class.getCanonicalName());
    
    /** The Constant gitHubApiUrls. */
    private static final Properties gitHubApiUrls = new Properties();

    static {
        try {
            gitHubApiUrls.load(GitHubApiUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	logger.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }
    
    public static interface UserApiUrls {
    	public static final String SEARCH_USERS_BY_NAME_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.searchUsersByName");
    	public static final String SEARCH_USERS_BY_EMAIL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.searchUsersByEmail");
    	public static final String GET_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getUser");
    	public static final String GET_CURRENT_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getCurrentUser");
    	public static final String UPDATE_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.updateUser");
    	public static final String GET_USER_FOLLOWERS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getUserFollowers");
    	public static final String GET_USER_FOLLOWING_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getUserFollowing");
    	public static final String FOLLOW_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.followUser");
    	public static final String UNFOLLOW_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.unfollowUser");
    	public static final String GET_WATCHED_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getWatchedRepositories");
    	public static final String GET_KEYS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getKeys");
    	public static final String ADD_KEY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.addKey");
    	public static final String REMOVE_KEY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.removeKey");
    	public static final String GET_EMAILS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getEmails");
    	public static final String ADD_EMAIL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.addEmail");
    	public static final String REMOVE_EMAIL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.removeEmail");
    }

    public static interface IssueApiUrls {
    	public static final String SEARCH_ISSUES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.searchIssues");
    	public static final String GET_ISSUES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssues");
    	public static final String GET_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssue");
    	public static final String GET_ISSUE_COMMENTS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssueComments");
    	public static final String CREATE_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.createIssue");
    	public static final String CLOSE_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.closeIssue");
    	public static final String REOPEN_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.reopenIssue");
    	public static final String UPDATE_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.updateIssue");
    	public static final String GET_ISSUE_LABELS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssueLabels");
    	public static final String ADD_LABEL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.addLabel");
    	public static final String REMOVE_LABEL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.removeLabel");
    	public static final String ADD_COMMENT_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.addComment");
    }
    
    public static interface GistApiUrls {
    	public static final String GET_GIST_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.gistService.getGist");
    	public static final String GET_GIST_CONTENT_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.gistService.getGistContent");
    	public static final String GET_USER_GISTS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.gistService.getUserGists");
    }
    
    public static interface NetworkApiUrls {
    	public static final String GET_NETWORK_META_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.networkService.getNetworkMeta");
    	public static final String GET_NETWORK_DATA_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.networkService.getNetworkData");
    }
    
    public static interface RepositoryApiUrls {
    	public static final String SEARCH_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.searchRepositories");
    	public static final String GET_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getRepository");
    	public static final String UPDATE_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.updateRepository");
    	public static final String GET_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getRepositories");
    	public static final String WATCH_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.watchRepository");
    	public static final String UNWATCH_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.unwatchRepository");
    	public static final String FORK_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.forkRepository");
    	public static final String CREATE_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.createRepository");
    	public static final String DELETE_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.deleteRepository");
    	public static final String CHANGE_VISIBILITY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.changeVisibility");
    	public static final String GET_DEPLOY_KEYS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getKeys");
    	public static final String ADD_DEPLOY_KEY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.addKey");
    	public static final String REMOVE_DEPLOY_KEY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.removeKey");
    	public static final String GET_COLLABORATORS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getCollaborators");
    	public static final String ADD_COLLABORATOR_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.addCollaborator");
    	public static final String REMOVE_COLLABORATOR_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.removeCollaborator");
    	public static final String GET_PUSHABLE_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getPushableRepositories");
    	public static final String GET_CONTRIBUTORS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getContributors");
    	public static final String GET_WATCHERS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getWatchers");
    	public static final String GET_FORKS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getForks");
    	public static final String GET_LANGUAGE_BREAKDOWN_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getLanguageBreakdown");
    	public static final String GET_TAGS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getTags");
    	public static final String GET_BRANCHES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getBranches");
    }
    
    public static interface CommitApiUrls {
    	public static final String GET_COMMITS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.commitService.getCommits");
    	public static final String GET_COMMITS_FILE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.commitService.getCommitsFile");
    	public static final String GET_COMMIT_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.commitService.getCommit");
    }
    
    public static interface ObjectApiUrls {
    	public static final String GET_TREE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.objectService.getTree");
    	public static final String GET_BLOB_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.objectService.getBlob");
    	public static final String GET_BLOBS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.objectService.getBlobs");
    	public static final String GET_OBJECT_CONTENT_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.objectService.getObjectContent");
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
        
    	/** The url format. */
	    private String urlFormat;
	    
    	/** The parameters map. */
	    private Map<String, String> parametersMap = new HashMap<String, String>();
    	
		/** The fields map. */
		private Map<String, String> fieldsMap = new HashMap<String, String>();
	    
    	/**
	     * Instantiates a new google search api url builder.
	     * 
	     * @param urlFormat the url format
	     */
	    public GitHubApiUrlBuilder(String urlFormat) {
	    	this(urlFormat, ApplicationConstants.DEFAULT_API_VERSION, ApplicationConstants.DEFAULT_FORMAT);
    	}
    	
    	/**
	     * Instantiates a new google search api url builder.
	     * 
	     * @param urlFormat the url format
	     * @param apiVersion the api version
	     */
	    public GitHubApiUrlBuilder(String urlFormat, String apiVersion, String format) {
    		this.urlFormat = urlFormat;
    		fieldsMap.put(ParameterNames.VERSION, apiVersion);
    		fieldsMap.put(ParameterNames.FORMAT, format);
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
	    		parametersMap.put(name, encodeUrl(value));
	    	}
    		
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
	    
		public GitHubApiUrlBuilder withEmptyField(String name) {
			fieldsMap.put(name, "");

			return this;
		}

		public GitHubApiUrlBuilder withField(String name, String value) {
			withField(name, value, false);

			return this;
		}

		public GitHubApiUrlBuilder withField(String name, String value,
				boolean escape) {
			if (escape) {
				fieldsMap.put(name, encodeUrl(value));
			} else {
				fieldsMap.put(name, value);
			}

			return this;
		}

		public GitHubApiUrlBuilder withFieldEnum(String name, ValueEnum value) {
			if (value.value() == null || value.value().length() == 0) {
				fieldsMap.put(name, "");
			} else {
				fieldsMap.put(name, value.value());
			}

			return this;
		}
	    
    	
		public String buildUrl() {
			StringBuilder urlBuilder = new StringBuilder();
			StringBuilder placeHolderBuilder = new StringBuilder();
			boolean placeHolderFlag = false;
			boolean firstParameter = true;
			for (int i = 0; i < urlFormat.length(); i++) {
				if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
					placeHolderBuilder = new StringBuilder();
					placeHolderFlag = true;
				} else if (placeHolderFlag
						&& urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
					String placeHolder = placeHolderBuilder.toString();
					if (fieldsMap.containsKey(placeHolder)) {
						urlBuilder.append(fieldsMap.get(placeHolder));
					} else if (parametersMap.containsKey(placeHolder)) {
						StringBuilder builder = new StringBuilder();
						if (firstParameter) {
							firstParameter = false;
						} else {
							builder.append("&");
						}
						builder.append(placeHolder);
						builder.append("=");
						builder.append(parametersMap.get(placeHolder));
						urlBuilder.append(builder.toString());
					} else {
						// we did not find a binding for the placeholder.
						// skip it.
						// urlBuilder.append(API_URLS_PLACEHOLDER_START);
						// urlBuilder.append(placeHolder);
						// urlBuilder.append(API_URLS_PLACEHOLDER_END);
					}
					placeHolderFlag = false;
				} else if (placeHolderFlag) {
					placeHolderBuilder.append(urlFormat.charAt(i));
				} else {
					urlBuilder.append(urlFormat.charAt(i));
				}
			}


			logger.log(Level.FINE, "URL generated: " + urlBuilder.toString());
			
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
