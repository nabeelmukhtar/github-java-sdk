/**
 * 
 */
package com.github.api.v2.services.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.ObjectService;

/**
 * The Class WebSample.
 */
public class ObjectApiSample {

    /**
     * The main method.
     * 
     * @param args the arguments
     */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		ObjectService service = factory.createObjectService();
		List<Tree> trees = service.getTree("facebook", "tornado", "7b80c2f4db226d6fa3a7");
		for (Tree tree : trees) {
			printResult(tree);    			
		}
		List<Blob> blobs = service.getBlobs("facebook", "tornado", "7b80c2f4db226d6fa3a7");
		for (Blob blob : blobs) {
			printResult(blob);
		}
		System.out.println(convertStreamToString(service.getObjectContent("facebook", "tornado", "7b80c2f4db226d6fa3a7f3dfa59277da1d642f91")));
	}
    
	private static void printResult(Blob blob) {
		System.out.println(blob);
	}

	private static void printResult(Tree tree) {
		System.out.println(tree);
	}

	/**
	 * Convert stream to string.
	 * 
	 * @param is the is
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
