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
 * @author nmukhtar
 *
 */
public class OAuthExample {
	private static final String CLIENT_ID = "92059e7b6b302d6b8c41";
	private static final String CLIENT_SECRET = "b232d74b6b7d5627577d61ffb61644d8108697ec";
	private static final String CALLBACK_URL = "http://waveclipse.appspot.com/Main";

	/**
	 * @param args
	 * @throws IOException 
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
