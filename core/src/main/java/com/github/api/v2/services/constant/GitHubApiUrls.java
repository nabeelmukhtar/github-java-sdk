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
package com.github.api.v2.services.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.api.v2.schema.ValueEnum;

/**
 * The Class GitHubApiUrls.
 */
public final class GitHubApiUrls {

    /** The Constant API_URLS_FILE. */
    public static final String API_URLS_FILE = "GitHubApiUrls.properties";

    /** The Constant logger. */
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
    
    /**
	 * The Interface OAuthUrls.
	 */
    public static interface OAuthUrls {
    	
	    /** The Constant AUTHORIZE_URL. */
	    public static final String AUTHORIZE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.oauthService.authorize");
    	
	    /** The Constant ACCESS_TOKEN_URL. */
	    public static final String ACCESS_TOKEN_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.oauthService.accessToken");
    }
    
    /**
	 * The Interface UserApiUrls.
	 */
    public static interface UserApiUrls {
    	
	    /** The Constant SEARCH_USERS_BY_NAME_URL. */
	    public static final String SEARCH_USERS_BY_NAME_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.searchUsersByName");
    	
	    /** The Constant SEARCH_USERS_BY_EMAIL_URL. */
	    public static final String SEARCH_USERS_BY_EMAIL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.searchUsersByEmail");
    	
	    /** The Constant GET_USER_URL. */
	    public static final String GET_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getUser");
    	
	    /** The Constant GET_CURRENT_USER_URL. */
	    public static final String GET_CURRENT_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getCurrentUser");
    	
	    /** The Constant UPDATE_USER_URL. */
	    public static final String UPDATE_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.updateUser");
    	
	    /** The Constant GET_USER_FOLLOWERS_URL. */
	    public static final String GET_USER_FOLLOWERS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getUserFollowers");
    	
	    /** The Constant GET_USER_FOLLOWING_URL. */
	    public static final String GET_USER_FOLLOWING_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getUserFollowing");
    	
	    /** The Constant FOLLOW_USER_URL. */
	    public static final String FOLLOW_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.followUser");
    	
	    /** The Constant UNFOLLOW_USER_URL. */
	    public static final String UNFOLLOW_USER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.unfollowUser");
    	
	    /** The Constant GET_WATCHED_REPOSITORIES_URL. */
	    public static final String GET_WATCHED_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getWatchedRepositories");
    	
	    /** The Constant GET_KEYS_URL. */
	    public static final String GET_KEYS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getKeys");
    	
	    /** The Constant ADD_KEY_URL. */
	    public static final String ADD_KEY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.addKey");
    	
	    /** The Constant REMOVE_KEY_URL. */
	    public static final String REMOVE_KEY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.removeKey");
    	
	    /** The Constant GET_EMAILS_URL. */
	    public static final String GET_EMAILS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getEmails");
    	
	    /** The Constant ADD_EMAIL_URL. */
	    public static final String ADD_EMAIL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.addEmail");
    	
	    /** The Constant REMOVE_EMAIL_URL. */
	    public static final String REMOVE_EMAIL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.removeEmail");
	    
	    /** The Constant GET_USER_ORGANIZATIONS. */
	    public static final String GET_USER_ORGANIZATIONS = gitHubApiUrls.getProperty("com.github.api.v2.services.userService.getUserOrganizations");
	    
    }

    /**
	 * The Interface IssueApiUrls.
	 */
    public static interface IssueApiUrls {
    	
	    /** The Constant SEARCH_ISSUES_URL. */
	    public static final String SEARCH_ISSUES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.searchIssues");
    	
	    /** The Constant GET_ISSUES_URL. */
	    public static final String GET_ISSUES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssues");
    	
	    /** The Constant GET_ISSUE_URL. */
	    public static final String GET_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssue");
    	
	    /** The Constant GET_ISSUE_COMMENTS_URL. */
	    public static final String GET_ISSUE_COMMENTS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssueComments");
    	
	    /** The Constant CREATE_ISSUE_URL. */
	    public static final String CREATE_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.createIssue");
    	
	    /** The Constant CLOSE_ISSUE_URL. */
	    public static final String CLOSE_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.closeIssue");
    	
	    /** The Constant REOPEN_ISSUE_URL. */
	    public static final String REOPEN_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.reopenIssue");
    	
	    /** The Constant UPDATE_ISSUE_URL. */
	    public static final String UPDATE_ISSUE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.updateIssue");
    	
	    /** The Constant GET_ISSUE_LABELS_URL. */
	    public static final String GET_ISSUE_LABELS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssueLabels");
    	
	    /** The Constant ADD_LABEL_URL. */
	    public static final String ADD_LABEL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.addLabel");
    	
	    /** The Constant REMOVE_LABEL_URL. */
	    public static final String REMOVE_LABEL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.removeLabel");
    	
	    /** The Constant ADD_COMMENT_URL. */
	    public static final String ADD_COMMENT_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.addComment");

		/** The Constant GET_ISSUES_BY_LABEL_URL. */
		public static final String GET_ISSUES_BY_LABEL_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.issueService.getIssuesByLabel");
    }
    
    /**
	 * The Interface GistApiUrls.
	 */
    public static interface GistApiUrls {
    	
	    /** The Constant GET_GIST_URL. */
	    public static final String GET_GIST_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.gistService.getGist");
    	
	    /** The Constant GET_GIST_CONTENT_URL. */
	    public static final String GET_GIST_CONTENT_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.gistService.getGistContent");
    	
	    /** The Constant GET_USER_GISTS_URL. */
	    public static final String GET_USER_GISTS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.gistService.getUserGists");
    }
    
    /**
	 * The Interface NetworkApiUrls.
	 */
    public static interface NetworkApiUrls {
    	
	    /** The Constant GET_NETWORK_META_URL. */
	    public static final String GET_NETWORK_META_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.networkService.getNetworkMeta");
    	
	    /** The Constant GET_NETWORK_DATA_URL. */
	    public static final String GET_NETWORK_DATA_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.networkService.getNetworkData");
    }
    
    /**
	 * The Interface RepositoryApiUrls.
	 */
    public static interface RepositoryApiUrls {
    	
	    /** The Constant SEARCH_REPOSITORIES_URL. */
	    public static final String SEARCH_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.searchRepositories");
    	
	    /** The Constant GET_REPOSITORY_URL. */
	    public static final String GET_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getRepository");
    	
	    /** The Constant UPDATE_REPOSITORY_URL. */
	    public static final String UPDATE_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.updateRepository");
    	
	    /** The Constant GET_REPOSITORIES_URL. */
	    public static final String GET_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getRepositories");
    	
	    /** The Constant WATCH_REPOSITORY_URL. */
	    public static final String WATCH_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.watchRepository");
    	
	    /** The Constant UNWATCH_REPOSITORY_URL. */
	    public static final String UNWATCH_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.unwatchRepository");
    	
	    /** The Constant FORK_REPOSITORY_URL. */
	    public static final String FORK_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.forkRepository");
    	
	    /** The Constant CREATE_REPOSITORY_URL. */
	    public static final String CREATE_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.createRepository");
    	
	    /** The Constant DELETE_REPOSITORY_URL. */
	    public static final String DELETE_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.deleteRepository");
    	
	    /** The Constant CHANGE_VISIBILITY_URL. */
	    public static final String CHANGE_VISIBILITY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.changeVisibility");
    	
	    /** The Constant GET_DEPLOY_KEYS_URL. */
	    public static final String GET_DEPLOY_KEYS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getKeys");
    	
	    /** The Constant ADD_DEPLOY_KEY_URL. */
	    public static final String ADD_DEPLOY_KEY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.addKey");
    	
	    /** The Constant REMOVE_DEPLOY_KEY_URL. */
	    public static final String REMOVE_DEPLOY_KEY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.removeKey");
    	
	    /** The Constant GET_COLLABORATORS_URL. */
	    public static final String GET_COLLABORATORS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getCollaborators");
    	
	    /** The Constant ADD_COLLABORATOR_URL. */
	    public static final String ADD_COLLABORATOR_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.addCollaborator");
    	
	    /** The Constant REMOVE_COLLABORATOR_URL. */
	    public static final String REMOVE_COLLABORATOR_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.removeCollaborator");
    	
	    /** The Constant GET_PUSHABLE_REPOSITORIES_URL. */
	    public static final String GET_PUSHABLE_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getPushableRepositories");
    	
	    /** The Constant GET_CONTRIBUTORS_URL. */
	    public static final String GET_CONTRIBUTORS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getContributors");
    	
	    /** The Constant GET_WATCHERS_URL. */
	    public static final String GET_WATCHERS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getWatchers");
    	
	    /** The Constant GET_FORKS_URL. */
	    public static final String GET_FORKS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getForks");
    	
	    /** The Constant GET_LANGUAGE_BREAKDOWN_URL. */
	    public static final String GET_LANGUAGE_BREAKDOWN_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getLanguageBreakdown");
    	
	    /** The Constant GET_TAGS_URL. */
	    public static final String GET_TAGS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getTags");
    	
	    /** The Constant GET_BRANCHES_URL. */
	    public static final String GET_BRANCHES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getBranches");

	    /** The Constant GET_REPOSITORY_ARCHIVE_URL. */
	    public static final String GET_REPOSITORY_ARCHIVE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.repositoryService.getRepositoryArchive");
    }
    
    /**
	 * The Interface CommitApiUrls.
	 */
    public static interface CommitApiUrls {
    	
	    /** The Constant GET_COMMITS_URL. */
	    public static final String GET_COMMITS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.commitService.getCommits");
    	
	    /** The Constant GET_COMMITS_FILE_URL. */
	    public static final String GET_COMMITS_FILE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.commitService.getCommitsFile");
    	
	    /** The Constant GET_COMMIT_URL. */
	    public static final String GET_COMMIT_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.commitService.getCommit");
    }
    
    /**
	 * The Interface ObjectApiUrls.
	 */
    public static interface ObjectApiUrls {
    	
	    /** The Constant GET_TREE_URL. */
	    public static final String GET_TREE_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.objectService.getTree");
    	
	    /** The Constant GET_BLOB_URL. */
	    public static final String GET_BLOB_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.objectService.getBlob");
    	
	    /** The Constant GET_BLOBS_URL. */
	    public static final String GET_BLOBS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.objectService.getBlobs");
    	
	    /** The Constant GET_OBJECT_CONTENT_URL. */
	    public static final String GET_OBJECT_CONTENT_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.objectService.getObjectContent");
    }
    
    /**
	 * The Interface OrganizationApiUrls.
	 */
    public static interface OrganizationApiUrls {
    	
	    /** The Constant GET_ORGANIZATION_URL. */
	    public static final String GET_ORGANIZATION_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getOrganization");
	    
	    /** The Constant GET_ORGANIZATIONS_URL. */
	    public static final String GET_ORGANIZATIONS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getOrganizations");
	    
	    /** The Constant UPDATE_ORGANIZATION_URL. */
	    public static final String UPDATE_ORGANIZATION_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.updateOrganization");
	    
	    /** The Constant GET_ALL_REPOSITORIES_URL. */
	    public static final String GET_ALL_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getAllRepositories");

	    /** The Constant GET_PUBLIC_REPOSITORIES_URL. */
	    public static final String GET_PUBLIC_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getPublicRepositories");

	    /** The Constant GET_PUBLIC_MEMBERS_URL. */
	    public static final String GET_PUBLIC_MEMBERS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getPublicMembers");

	    /** The Constant GET_TEAMS_URL. */
	    public static final String GET_TEAMS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getTeams");

	    /** The Constant CREATE_TEAM_URL. */
	    public static final String CREATE_TEAM_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.createTeam");

	    /** The Constant GET_TEAM_URL. */
	    public static final String GET_TEAM_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getTeam");

	    /** The Constant UPDATE_TEAM_URL. */
	    public static final String UPDATE_TEAM_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.updateTeam");

	    /** The Constant DELETE_TEAM_URL. */
	    public static final String DELETE_TEAM_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.deleteTeam");

	    /** The Constant GET_TEAM_MEMBERS_URL. */
	    public static final String GET_TEAM_MEMBERS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getTeamMembers");

	    /** The Constant ADD_TEAM_MEMBER_URL. */
	    public static final String ADD_TEAM_MEMBER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.addTeamMember");

	    /** The Constant REMOVE_TEAM_MEMBER_URL. */
	    public static final String REMOVE_TEAM_MEMBER_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.removeTeamMember");
	    
	    /** The Constant GET_TEAM_REPOSITORIES_URL. */
	    public static final String GET_TEAM_REPOSITORIES_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getTeamRepositories");

	    /** The Constant ADD_TEAM_REPOSITORY_URL. */
	    public static final String ADD_TEAM_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.addTeamRepository");
	    
	    /** The Constant REMOVE_TEAM_REPOSITORY_URL. */
	    public static final String REMOVE_TEAM_REPOSITORY_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.removeTeamRepository");

		/** The Constant GET_OWNERS_URL. */
		public static final String GET_OWNERS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.organizationService.getOwners");;
    }
    
    /**
	 * The Interface PullRequestApiUrls.
	 */
    public static interface PullRequestApiUrls {
    	
	    /** The Constant CREATE_PULL_REQUEST_URL. */
	    public static final String CREATE_PULL_REQUEST_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.pullRequestService.createPullRequest");
    	
	    /** The Constant GET_PULL_REQUESTS_URL. */
	    public static final String GET_PULL_REQUESTS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.pullRequestService.getPullRequests");
    	
	    /** The Constant GET_PULL_REQUEST_URL. */
	    public static final String GET_PULL_REQUEST_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.pullRequestService.getPullRequest");
    }
    
    /**
	 * The Interface JobApiUrls.
	 */
    public static interface JobApiUrls {
    	
	    /** The Constant SEARCH_JOBS_URL. */
	    public static final String SEARCH_JOBS_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.jobService.searchJobs");
    	
	    /** The Constant GET_JOB_URL. */
	    public static final String GET_JOB_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.jobService.getJob");
    }
    
    /**
	 * The Interface FeedUrls.
	 */
    public static interface FeedUrls {
	    
    	/** The Constant GET_PUBLIC_USER_FEED_URL. */
	    public static final String GET_PUBLIC_USER_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getPublicUserFeed");

	    /** The Constant GET_PRIVATE_USER_FEED_URL. */
	    public static final String GET_PRIVATE_USER_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getPrivateUserFeed");

	    /** The Constant GET_COMMIT_FEED_URL. */
	    public static final String GET_COMMIT_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getCommitFeed");

	    /** The Constant GET_NETWORK_FEED_URL. */
	    public static final String GET_NETWORK_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getNetworkFeed");

	    /** The Constant GET_WIKI_FEED_URL. */
	    public static final String GET_WIKI_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getWikiFeed");

	    /** The Constant GET_PUBLIC_TIMELINE_FEED_URL. */
	    public static final String GET_PUBLIC_TIMELINE_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getPublicTimelineFeed");
	    
	    /** The Constant GET_DISCUSSIONS_FEED_URL. */
	    public static final String GET_DISCUSSIONS_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getDiscussionsFeed");

	    /** The Constant GET_DISCUSSIONS_FEED_BY_TOPIC_URL. */
	    public static final String GET_DISCUSSIONS_FEED_BY_TOPIC_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getDiscussionsFeedByTopic");

	    /** The Constant GET_JOB_POSITIONS_FEED_URL. */
	    public static final String GET_JOB_POSITIONS_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getJobPositionsFeed");

	    /** The Constant GET_BLOG_FEED_URL. */
	    public static final String GET_BLOG_FEED_URL = gitHubApiUrls.getProperty("com.github.api.v2.services.feedService.getBlogFeed");
    }
    
    /**
	 * Instantiates a new git hub api urls.
	 */
    private GitHubApiUrls() {}

    /**
	 * The Class GitHubApiUrlBuilder.
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
		 * Instantiates a new git hub api url builder.
		 * 
		 * @param urlFormat
		 *            the url format
		 */
	    public GitHubApiUrlBuilder(String urlFormat) {
	    	this(urlFormat, ApplicationConstants.DEFAULT_API_VERSION, ApplicationConstants.DEFAULT_FORMAT);
    	}
    	
    	/**
		 * Instantiates a new git hub api url builder.
		 * 
		 * @param urlFormat
		 *            the url format
		 * @param apiVersion
		 *            the api version
		 * @param format
		 *            the format
		 */
	    public GitHubApiUrlBuilder(String urlFormat, String apiVersion, String format) {
    		this.urlFormat = urlFormat;
    		fieldsMap.put(ParameterNames.VERSION, apiVersion);
    		fieldsMap.put(ParameterNames.FORMAT, format);
    	}
	    
    	/**
		 * With parameter.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * 
		 * @return the git hub api url builder
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
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * 
		 * @return the git hub api url builder
		 */
	    public GitHubApiUrlBuilder withParameterEnum(String name, ValueEnum value) {
	    	withParameter(name, value.value());
    		
    		return this;
    	}
	    
    	/**
		 * With parameter enum set.
		 * 
		 * @param name
		 *            the name
		 * @param enumSet
		 *            the enum set
		 * @param separator
		 *            the separator
		 * 
		 * @return the git hub api url builder
		 */
	    public GitHubApiUrlBuilder withParameterEnumSet(String name, Set<? extends ValueEnum> enumSet, String separator) {
	    	StringBuilder builder = new StringBuilder();
	    	
	    	for (Iterator<? extends ValueEnum> iterator = enumSet.iterator(); iterator.hasNext();) {
	    		builder.append(encodeUrl(iterator.next().value()));
	    		if (iterator.hasNext()) {
	    			builder.append(separator);
	    		}
			}
	    	
	    	parametersMap.put(name, builder.toString());
	    	
    		return this;
    	}
	    
		/**
		 * With empty field.
		 * 
		 * @param name
		 *            the name
		 * 
		 * @return the git hub api url builder
		 */
		public GitHubApiUrlBuilder withEmptyField(String name) {
			fieldsMap.put(name, "");

			return this;
		}

		/**
		 * With field.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * 
		 * @return the git hub api url builder
		 */
		public GitHubApiUrlBuilder withField(String name, String value) {
			withField(name, value, false);

			return this;
		}

		/**
		 * With field.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * @param escape
		 *            the escape
		 * 
		 * @return the git hub api url builder
		 */
		public GitHubApiUrlBuilder withField(String name, String value,
				boolean escape) {
			if (escape) {
				fieldsMap.put(name, encodeUrl(value));
			} else {
				fieldsMap.put(name, value);
			}

			return this;
		}

		/**
		 * With field enum.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * 
		 * @return the git hub api url builder
		 */
		public GitHubApiUrlBuilder withFieldEnum(String name, ValueEnum value) {
			if (value.value() == null || value.value().length() == 0) {
				fieldsMap.put(name, "");
			} else {
				fieldsMap.put(name, value.value());
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
		 * @param original
		 *            the original
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
