/**
 * 
 */
package com.github.api.v2.services.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.github.api.v2.services.GitHubException;
import com.github.api.v2.services.constant.ApplicationConstants;

/**
 * The Class GoogleSearchApiGateway.
 */
public abstract class GitHubApiGateway {
	
    /** The LOG. */
    protected final Logger LOG = Logger.getLogger(getClass().getCanonicalName());
	
	/** The Constant GZIP_ENCODING. */
	private static final String GZIP_ENCODING = "gzip";
	
	/** The Constant REFERRER. */
	private static final String REFERRER = "Referer";
	
	/** The request headers. */
	protected Map<String, String> requestHeaders;
	
	/** The application key. */
	protected String applicationKey;
	
	/** The user ip address. */
	protected String userIpAddress;
	
	/** The api version. */
	protected String apiVersion = ApplicationConstants.DEFAULT_API_VERSION;
	
	/**
	 * Gets the api version.
	 * 
	 * @return the api version
	 */
	public String getApiVersion() {
		return apiVersion;
	}

	/**
	 * Sets the api version.
	 * 
	 * @param apiVersion the new api version
	 */
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	/**
	 * Sets the request headers.
	 * 
	 * @param requestHeaders the request headers
	 */
	public void setRequestHeaders(Map<String, String> requestHeaders) {
	    this.requestHeaders = requestHeaders;
	}

	/**
	 * Gets the request headers.
	 * 
	 * @return the request headers
	 */
	public Map<String, String> getRequestHeaders() {
	    return requestHeaders;
	}

	/**
	 * Adds the request header.
	 * 
	 * @param headerName the header name
	 * @param headerValue the header value
	 */
	public void addRequestHeader(String headerName, String headerValue) {
	    requestHeaders.put(headerName, headerValue);
	}

	/**
	 * Removes the request header.
	 * 
	 * @param headerName the header name
	 */
	public void removeRequestHeader(String headerName) {
	    requestHeaders.remove(headerName);
	}

	/**
	 * Gets the application key.
	 * 
	 * @return the application key
	 */
	public String getApplicationKey() {
		return applicationKey;
	}

	/**
	 * Sets the application key.
	 * 
	 * @param applicationKey the new application key
	 */
	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}
	
	/**
	 * Sets the referrer.
	 * 
	 * @param referrer the new referrer
	 */
	public void setReferrer(String referrer) {
		requestHeaders.put(REFERRER, referrer);
	}

	/**
	 * Sets the user ip address.
	 * 
	 * @param userIpAddress the new user ip address
	 */
	public void setUserIpAddress(String userIpAddress) {
		this.userIpAddress = userIpAddress;
	}
	
	/**
	 * Convert stream to string.
	 * 
	 * @param is the is
	 * 
	 * @return the string
	 */
	protected static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	
	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    return sb.toString();
	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl the api url
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiGet(String apiUrl) {
		return callApiGet(apiUrl, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl the api url
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiGet(String apiUrl, int expected) {
	    try {
	        URL               url     = new URL(apiUrl);
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();
	
	        if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
	            request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
	        }
	
	        if (ApplicationConstants.READ_TIMEOUT > -1) {
	            request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
	        }
	
	        for (String headerName : requestHeaders.keySet()) {
	            request.setRequestProperty(headerName, requestHeaders.get(headerName));
	        }
	        
	        request.connect();
	        
	        if (request.getResponseCode() != expected) {
	            throw new GitHubException(convertStreamToString(request.getErrorStream()));
	        } else {
	            return getWrappedInputStream(request.getInputStream(),
	                                         GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
	        }
	    } catch (IOException e) {
	        throw new GitHubException(e);
	    }
	}
	
	/**
	 * Call api post.
	 * 
	 * @param apiUrl the api url
	 * @param parameters the parameters
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiPost(String apiUrl, Map<String, String> parameters) {
		return callApiPost(apiUrl, parameters, HttpURLConnection.HTTP_OK);
	}
	
	/**
	 * Call api post.
	 * 
	 * @param apiUrl the api url
	 * @param parameters the parameters
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiPost(String apiUrl, Map<String, String> parameters, int expected) {
		try {
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }
            
            for (String headerName : requestHeaders.keySet()) {
                request.setRequestProperty(headerName, requestHeaders.get(headerName));
            }

            request.setRequestMethod("POST");
            request.setDoOutput(true);

            PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));
            
            out.print(getParametersString(parameters));
            out.flush();
            out.close();

            request.connect();
            
            if (request.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                return getWrappedInputStream(request.getErrorStream(),
                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            } else {
                return getWrappedInputStream(request.getInputStream(),
                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
		} catch (IOException e) {
			throw new GitHubException(e);
		} finally {
		}
	}
	
	protected String getParametersString(Map<String, String> parameters) {
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<String, String> entry : parameters.entrySet()) {
			builder.append(entry.getKey());
			builder.append("=");
			builder.append(encodeUrl(entry.getValue()));
		}
		
		return builder.toString();
	}
	
	/**
	 * Call api method.
	 * 
	 * @param apiUrl the api url
	 * @param xmlContent the xml content
	 * @param contentType the content type
	 * @param method the method
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiMethod(String apiUrl, String xmlContent, String contentType,
			String method, int expected) {
	    try {
	        URL               url     = new URL(apiUrl);
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();
	
	        if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
	            request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
	        }
	
	        if (ApplicationConstants.READ_TIMEOUT > -1) {
	            request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
	        }
	
	        for (String headerName : requestHeaders.keySet()) {
	            request.setRequestProperty(headerName, requestHeaders.get(headerName));
	        }
	
	        request.setRequestMethod(method);
	        request.setDoOutput(true);
	
	        if (contentType != null) {
	            request.setRequestProperty("Content-Type", contentType);
	        }
	
	        if (xmlContent != null) {
	            PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));
	
	            out.print(xmlContent);
	            out.flush();
	            out.close();
	        }
	
	        request.connect();
	        
	        if (request.getResponseCode() != expected) {
	            throw new GitHubException(convertStreamToString(request.getErrorStream()));
	        } else {
	            return getWrappedInputStream(request.getInputStream(),
	                                         GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
	        }
	    } catch (IOException e) {
	        throw new GitHubException(e);
	    }
	}

	/**
	 * Close stream.
	 * 
	 * @param is the is
	 */
	protected void closeStream(InputStream is) {
	    try {
	    	if (is != null) {
		        is.close();
	    	}
	    } catch (IOException e) {
	    	LOG.log(Level.SEVERE, "An error occurred while closing stream.", e);	
	    }
	}

	/**
	 * Close connection.
	 * 
	 * @param connection the connection
	 */
	protected void closeConnection(HttpURLConnection connection) {
	    try {
	    	if (connection != null) {
	    		connection.disconnect();
	    	}
	    } catch (Exception e) {
	    	LOG.log(Level.SEVERE, "An error occurred while disconnecting connection.", e);	
	    }
	}

	/**
	 * Gets the wrapped input stream.
	 * 
	 * @param is the is
	 * @param gzip the gzip
	 * 
	 * @return the wrapped input stream
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected InputStream getWrappedInputStream(InputStream is, boolean gzip)
			throws IOException {
			    if (gzip) {
			        return new BufferedInputStream(new GZIPInputStream(is));
			    } else {
			        return new BufferedInputStream(is);
			    }
			}

	/**
	 * Read response.
	 * 
	 * @param clazz the clazz
	 * @param is the is
	 * 
	 * @return the t
	 */
	protected <T> T readResponse(Class<T> clazz, InputStream is) {
	    try {
	        return unmarshallObject(clazz, is);
	    } finally {
	        closeStream(is);
	    }
	}
	

    /**
     * Unmarshall object.
     * 
     * @param clazz the clazz
     * @param xmlContent the xml content
     * 
     * @return the t
     */
    protected abstract <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent);

    /**
     * Marshall object.
     * 
     * @param element the element
     * 
     * @return the string
     */
    protected abstract String marshallObject(Object element);
    
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
