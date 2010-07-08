package com.github.api.v2.services.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.api.v2.schema.SchemaEntity;
import com.github.api.v2.services.AsyncResponseHandler;
import com.github.api.v2.services.GitHubException;
import com.github.api.v2.services.GitHubService;
import com.github.api.v2.services.constant.ApplicationConstants;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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
	 * Unmarshall list.
	 * 
	 * @param response the response
	 * 
	 * @return the paged list< t>
	 */
	protected <T> List<T> unmarshallList(Class<T> clazz, JsonElement response) {
		Gson gson = getGsonBuilder().create();
		Type collectionType = new TypeToken<List<T>>(){}.getType();
		return gson.fromJson(response, collectionType);
	}
	
	/**
	 * Unmarshall.
	 * 
	 * @param object the object
	 * 
	 * @return the t
	 */
	protected <T> T unmarshall(Class<T> clazz, JsonElement response) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(response, clazz);
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
		builder.setDateFormat(ApplicationConstants.RFC822DATEFORMAT);
//		builder.registerTypeAdapter(ListingType.class, new JsonDeserializer<ListingType>() {
//
//			@Override
//			public ListingType deserialize(JsonElement arg0, Type arg1,
//					JsonDeserializationContext arg2) throws JsonParseException {
//				return ListingType.fromValue(arg0.getAsString());
//			}
//			
//		});
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
