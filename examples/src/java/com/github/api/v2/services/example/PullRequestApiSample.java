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
package com.github.api.v2.services.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.PullRequestService;

/**
 * The Class ObjectApiSample.
 */
public class PullRequestApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		PullRequestService service = factory.createPullRequestService();
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
    
	/**
	 * Prints the result.
	 * 
	 * @param blob
	 *            the blob
	 */
	private static void printResult(Blob blob) {
		System.out.println(blob);
	}

	/**
	 * Prints the result.
	 * 
	 * @param tree
	 *            the tree
	 */
	private static void printResult(Tree tree) {
		System.out.println(tree);
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
