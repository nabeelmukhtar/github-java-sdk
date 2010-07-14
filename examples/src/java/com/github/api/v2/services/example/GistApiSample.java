/**
 * 
 */
package com.github.api.v2.services.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.github.api.v2.schema.Gist;
import com.github.api.v2.services.GistService;
import com.github.api.v2.services.GitHubServiceFactory;

/**
 * The Class GistApiSample.
 */
public class GistApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		GistService service = factory.createGistService();
		Gist gist = service.getGist("289179");
		printResult(gist);
		System.out.println(convertStreamToString(service.getGistContent("289179", "TimeZoneDSTUtil.java")));
	}
    
	/**
	 * Prints the result.
	 * 
	 * @param gist
	 *            the gist
	 */
	private static void printResult(Gist gist) {
		System.out.println(gist);
	}

	/**
	 * Convert stream to string.
	 * 
	 * @param is
	 *            the is
	 * 
	 * @return the string
	 */
	private static String convertStreamToString(InputStream is) {
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
}
