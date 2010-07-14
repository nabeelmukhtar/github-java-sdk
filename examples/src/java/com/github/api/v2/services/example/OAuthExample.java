/**
 * 
 */
package com.github.api.v2.services.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.OAuthService;

/**
 * The Class OAuthExample.
 */
public class OAuthExample {
	
	/** The Constant CLIENT_ID. */
	private static final String CLIENT_ID = "18790e7033ab0148f05c";
	
	/** The Constant CLIENT_SECRET. */
	private static final String CLIENT_SECRET = "52695c3febf1721b8bc6f569c5210d38d043696c";
	
	/** The Constant CALLBACK_URL. */
	private static final String CALLBACK_URL = "http://www.githubapitest.com";

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		OAuthService service = GitHubServiceFactory.newInstance().createOAuthService(CLIENT_ID, CLIENT_SECRET);
		String autorizationUrl = service.getAuthorizationUrl(CALLBACK_URL);
		System.out.println("Visit this url to get code and enter it.\n" + autorizationUrl);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
		String accessToken = service.getAccessToken(CALLBACK_URL, code);
		System.out.println("Access Token:" + accessToken);
	}

}
