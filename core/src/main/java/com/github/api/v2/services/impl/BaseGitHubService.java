package com.github.api.v2.services.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Issue;
import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.SchemaEntity;
import com.github.api.v2.services.AsyncResponseHandler;
import com.github.api.v2.services.GitHubException;
import com.github.api.v2.services.GitHubService;
import com.github.api.v2.services.constant.ApplicationConstants;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * The Class BaseGoogleSearchApiQuery.
 */
public abstract class BaseGitHubService extends GitHubApiGateway implements GitHubService {
	
	/** The api url builder. */
	protected GitHubApiUrlBuilder apiUrlBuilder;
    
    /** The parser. */
    private final JsonParser parser = new JsonParser();
    
    /** The handlers. */
    private List<AsyncResponseHandler<List<? extends SchemaEntity>>> handlers = new ArrayList<AsyncResponseHandler<List<? extends SchemaEntity>>>();
    
    protected static final Map<String, String> EMPTY_PARAMETERS = Collections.emptyMap(); 
	
	/**
	 * Instantiates a new base google search api query.
	 * 
	 * @param applicationId the application id
	 */
	public BaseGitHubService(String applicationId) {
		super.setApplicationKey(applicationId);
        requestHeaders = new HashMap<String, String>();

        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
	}

	/**
	 * Instantiates a new base google search api query.
	 * 
	 * @param applicationId the application id
	 * @param apiVersion the api version
	 */
	public BaseGitHubService(String applicationId, String apiVersion) {
		this(applicationId);
		super.setApiVersion(apiVersion);
	}
	
	/**
	 * Unmarshall.
	 * 
	 * @param object the object
	 * 
	 * @return the t
	 */
	protected <T> T unmarshall(TypeToken<T> typeToken, JsonElement response) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(response, typeToken.getType());
	}

	/**
	 * Notify observers.
	 * 
	 * @param response the response
	 */
	protected void notifyObservers(List<? extends SchemaEntity> response) {
		for(AsyncResponseHandler<List<? extends SchemaEntity>> handler : handlers) {
			handler.handleResponse(response);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackExchangeApiQuery#addResonseHandler(com.google.code.stackexchange.client.AsyncResponseHandler)
	 */
	public void addResonseHandler(AsyncResponseHandler<List<? extends SchemaEntity>> handler) {
		handlers.add(handler);
	}
	
	/**
	 * Gets the gson builder.
	 * 
	 * @return the gson builder
	 */
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat(ApplicationConstants.DATE_FORMAT);
		builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		builder.registerTypeAdapter(Issue.State.class, new JsonDeserializer<Issue.State>() {
			@Override
			public Issue.State deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return Issue.State.fromValue(arg0.getAsString());
			}
		});
		builder.registerTypeAdapter(Repository.Visibility.class, new JsonDeserializer<Repository.Visibility>() {
			@Override
			public Repository.Visibility deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return Repository.Visibility.fromValue(arg0.getAsString());
			}
		});
		builder.registerTypeAdapter(Language.class, new JsonDeserializer<Language>() {
			@Override
			public Language deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return Language.fromValue(arg0.getAsString());
			}
		});
		return builder;
	}
    
	protected JsonElement unmarshall(InputStream jsonContent) {
        try {
        	return parser.parse(new InputStreamReader(jsonContent));
        } catch (Exception e) {
            throw new GitHubException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}
	
	/**
	 * Creates the google search api url builder.
	 * 
	 * @param urlFormat the url format
	 * 
	 * @return the google search api url builder
	 */
	protected GitHubApiUrlBuilder createGitHubApiUrlBuilder(String urlFormat) {
		return new GitHubApiUrlBuilder(urlFormat);
	}
}
