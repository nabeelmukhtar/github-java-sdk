package com.github.api.v2.services.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.SchemaEntity;
import com.github.api.v2.services.AsyncResponseHandler;
import com.github.api.v2.services.GitHubException;
import com.github.api.v2.services.GitHubService;
import com.github.api.v2.services.constant.ApplicationConstants;
import com.github.api.v2.services.constant.GitHubApiUrls.GitHubApiUrlBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

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
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#list()
	 */
	@Override
	public PagedList<T> list() {
		InputStream jsonContent = null;
        try {
        	jsonContent = callApiMethod(apiUrlBuilder.buildUrl());
        	JsonElement response = parser.parse(new InputStreamReader(jsonContent));
        	if (response.isJsonObject()) {
        		PagedList<T> responseList = unmarshallList(response.getAsJsonObject());
        		notifyObservers(responseList);
    			return responseList;
        	}
        	throw new GitHubException("Unknown content found in response:" + response.toString());
        } catch (Exception e) {
            throw new GitHubException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}

	/**
	 * Unmarshall list.
	 * 
	 * @param response the response
	 * 
	 * @return the paged list< t>
	 */
	protected PagedList<T> unmarshallList(JsonObject response) {
		int status = response.get("responseStatus").getAsInt();
		if (status != 200) {
			throw new GitHubException(String.valueOf(response.get("responseDetails").getAsString()));
		}
		JsonObject data = response.get("responseData").getAsJsonObject();
		PagedArrayList<T> list = new PagedArrayList<T>();
		if (data != null) { 
			JsonArray results = data.get("results").getAsJsonArray();
			for (JsonElement object : results) {
				T element = unmarshall(object);
				list.add(element);
			}
			JsonElement cursor = data.get("cursor");
			if (cursor != null) {
				list.setCursor(new Gson().fromJson(cursor, PagedArrayList.Cursor.class));
			}
		} 
		return list;
	}

	/**
	 * Unmarshall.
	 * 
	 * @param object the object
	 * 
	 * @return the t
	 */
	protected abstract T unmarshall(JsonElement object);

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#singleResult()
	 */
	@Override
	public T singleResult() {
		InputStream jsonContent = null;
        try {
        	jsonContent = callApiMethod(apiUrlBuilder.buildUrl());
        	JsonElement response = parser.parse(new InputStreamReader(jsonContent));
        	if (response.isJsonObject()) {
        		JsonObject json = response.getAsJsonObject();
        		int status = json.get("responseStatus").getAsInt();
        		if (status != 200) {
        			throw new GitHubException(json.get("responseDetails").getAsString());
        		}
        		JsonElement data = json.get("responseData");
        		if (data != null) {
        			return unmarshall(data);
        		}
        	}
        	throw new GitHubException("Unknown content found in response:" + response.toString());
        } catch (Exception e) {
            throw new GitHubException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}
	
	/**
	 * Notify observers.
	 * 
	 * @param response the response
	 */
	protected void notifyObservers(PagedList<T> response) {
		for(AsyncResponseHandler<PagedList<T>> handler : handlers) {
			handler.handleResponse(response);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackExchangeApiQuery#addResonseHandler(com.google.code.stackexchange.client.AsyncResponseHandler)
	 */
	public void addResonseHandler(AsyncResponseHandler<PagedList<T>> handler) {
		handlers.add(handler);
	}
	
    /* (non-Javadoc)
     * @see com.google.code.stackexchange.client.impl.StackOverflowApiGateway#marshallObject(java.lang.Object)
     */
    protected String marshallObject(Object element) {
    	return null;
    }
    
	/**
	 * Gets the gson builder.
	 * 
	 * @return the gson builder
	 */
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat(ApplicationConstants.RFC822DATEFORMAT);
		builder.registerTypeAdapter(ListingType.class, new JsonDeserializer<ListingType>() {

			@Override
			public ListingType deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return ListingType.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(PatentStatus.class, new JsonDeserializer<PatentStatus>() {

			@Override
			public PatentStatus deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return PatentStatus.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(VideoType.class, new JsonDeserializer<VideoType>() {

			@Override
			public VideoType deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return VideoType.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(ViewPortMode.class, new JsonDeserializer<ViewPortMode>() {

			@Override
			public ViewPortMode deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return ViewPortMode.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(GsearchResultClass.class, new JsonDeserializer<GsearchResultClass>() {

			@Override
			public GsearchResultClass deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return GsearchResultClass.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(PhoneNumberType.class, new JsonDeserializer<PhoneNumberType>() {

			@Override
			public PhoneNumberType deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return PhoneNumberType.fromValue(arg0.getAsString());
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
    
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.impl.GoogleSearchApiGateway#unmarshallObject(java.lang.Class, java.io.InputStream)
	 */
	@Override
	protected <V> V unmarshallObject(Class<V> clazz, InputStream xmlContent) {
		return null;
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
