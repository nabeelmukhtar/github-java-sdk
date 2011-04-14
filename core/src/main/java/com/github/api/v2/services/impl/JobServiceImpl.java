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
package com.github.api.v2.services.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.github.api.v2.schema.GeoLocation;
import com.github.api.v2.schema.Job;
import com.github.api.v2.services.GitHubException;
import com.github.api.v2.services.JobService;
import com.github.api.v2.services.constant.GitHubApiUrls;
import com.github.api.v2.services.constant.ParameterNames;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The Class JobServiceImpl.
 */
public class JobServiceImpl extends BaseGitHubService implements JobService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.JobService#getJob(java.lang.String)
	 */
	@Override
	public Job getJob(String id) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.JobApiUrls.GET_JOB_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, id).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        return unmarshall(new TypeToken<Job>(){}, json);        
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.JobService#searchFullTimeJobs(java.lang.String)
	 */
	@Override
	public List<Job> searchFullTimeJobs(String query) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.JobApiUrls.SEARCH_JOBS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.SEARCH, query).withParameter(ParameterNames.FULL_TIME, "true").buildUrl();
        JsonElement json = unmarshallList(callApiGet(apiUrl));
        return unmarshall(new TypeToken<List<Job>>(){}, json);	
    }

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.JobService#searchFullTimeJobs(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Job> searchFullTimeJobs(String query, String location) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.JobApiUrls.SEARCH_JOBS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.FULL_TIME, "true").withParameter(ParameterNames.SEARCH, query).withParameter(ParameterNames.LOCATION, location).buildUrl();
        JsonElement json = unmarshallList(callApiGet(apiUrl));
        return unmarshall(new TypeToken<List<Job>>(){}, json);	
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.JobService#searchFullTimeJobs(java.lang.String, com.github.api.v2.schema.GeoLocation)
	 */
	@Override
	public List<Job> searchFullTimeJobs(String query, GeoLocation location) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.JobApiUrls.SEARCH_JOBS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.FULL_TIME, "true").withParameter(ParameterNames.SEARCH, query).withParameter(ParameterNames.LATITUDE, String.valueOf(location.getLatitude())).withParameter(ParameterNames.LONGITUDE, String.valueOf(location.getLongitude())).buildUrl();
        JsonElement json = unmarshallList(callApiGet(apiUrl));
        return unmarshall(new TypeToken<List<Job>>(){}, json);	
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.JobService#searchJobs(java.lang.String)
	 */
	@Override
	public List<Job> searchJobs(String query) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.JobApiUrls.SEARCH_JOBS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.SEARCH, query).buildUrl();
        JsonElement json = unmarshallList(callApiGet(apiUrl));
        return unmarshall(new TypeToken<List<Job>>(){}, json);	
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.JobService#searchJobs(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Job> searchJobs(String query, String location) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.JobApiUrls.SEARCH_JOBS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.SEARCH, query).withParameter(ParameterNames.LOCATION, location).buildUrl();
        JsonElement json = unmarshallList(callApiGet(apiUrl));
        return unmarshall(new TypeToken<List<Job>>(){}, json);	
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.JobService#searchJobs(java.lang.String, com.github.api.v2.schema.GeoLocation)
	 */
	@Override
	public List<Job> searchJobs(String query, GeoLocation location) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(GitHubApiUrls.JobApiUrls.SEARCH_JOBS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.SEARCH, query).withParameter(ParameterNames.LATITUDE, String.valueOf(location.getLatitude())).withParameter(ParameterNames.LONGITUDE, String.valueOf(location.getLongitude())).buildUrl();
        JsonElement json = unmarshallList(callApiGet(apiUrl));
        return unmarshall(new TypeToken<List<Job>>(){}, json);	
	}
	
	/**
	 * Unmarshall list.
	 * 
	 * @param jsonContent
	 *            the json content
	 * 
	 * @return the json element
	 */
	protected JsonElement unmarshallList(InputStream jsonContent) {
        try {
        	return parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        } catch (Exception e) {
            throw new GitHubException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.impl.BaseGitHubService#getGsonBuilder()
	 */
	@Override
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder gson = super.getGsonBuilder();
		gson.setDateFormat("EEE MMM d HH:mm:ss z yyyy");
		return gson;
	}
	
}
