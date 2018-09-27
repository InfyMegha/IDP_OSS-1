/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.InvalidCredentialsException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * The class IBMRestUtil contains methods related to SSL and HTTP requests and repsonse
 *
 */
public class IBMRestUtil {

	private static boolean DEBUG = true;

	private static String AUTHREQUIRED = "X-com-ibm-team-repository-web-auth-msg";
	// name of custom header that authentication messages are stored in
	private static final String FORM_AUTH_HEADER = "X-com-ibm-team-repository-web-auth-msg"; //$NON-NLS-1$
	// auth header value when authentication is required
	private static final String FORM_AUTH_REQUIRED_MSG = "authrequired"; //$NON-NLS-1$
	// auth header value when authentication failed
	private static final String FORM_AUTH_FAILED_MSG = "authfailed"; //$NON-NLS-1$
	// URI the server redirects to when authentication fails
	public static final String FORM_AUTH_FAILED_URI = "/auth/authfailed"; //$NON-NLS-1$

	private static final Logger logger = LoggerFactory.getLogger(IBMRestUtil.class);

	/**
	 * constructor
	 */
	private IBMRestUtil() {
		// constructor
	}

	/**
	 * 
	 * @param httpClient
	 */
	public static  void setupLazySSLSupport(HttpClient httpClient) {
		ClientConnectionManager connManager = httpClient.getConnectionManager();
		SchemeRegistry schemeRegistry = connManager.getSchemeRegistry();
		schemeRegistry.unregister("https");
		/** Create a trust manager that does not validate certificate chains */
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				/** Ignore Method Call */
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				/** Ignore Method Call */
			}

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		} };

		SSLContext sc = null;
		try {
			// changed from SSL to TLSv1 to work with CLM 5.0.x
			sc = SSLContext.getInstance("TLSv1"); //$NON-NLS-1$
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
		} catch (NoSuchAlgorithmException ex) {
			logger.error(ex.getMessage(), ex);
			/* Fail Silently */
		} catch (KeyManagementException ex) {
			logger.error(ex.getMessage(), ex);
			/* Fail Silently */
		}

		SSLSocketFactory sf = new SSLSocketFactory(sc);
		sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		Scheme https = new Scheme("https", sf, 443);

		schemeRegistry.register(https);
	}

	/**
	 * Print out the HTTP Response body
	 * 
	 * @param response
	 */
	public static void printResponseBody(HttpResponse response) {
		HttpEntity entity = response.getEntity();
		if (entity == null)
			return;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(entity.getContent()));
			String line = reader.readLine();
			while (line != null) {
				logger.info(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IllegalStateException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 * Get the HTTP Response body
	 * 
	 * @param response
	 * @return StringBuilder
	 */
	public static StringBuilder getResponseBody(HttpResponse response) {
		HttpEntity entity = response.getEntity();
		StringBuilder str = new StringBuilder();
		if (entity == null)
			return str;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(entity.getContent()));
			String line = reader.readLine();
			while (line != null) {
				str.append(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IllegalStateException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		return str;

	}

	/**
	 * Print out the HTTPResponse headers
	 * 
	 * @param response
	 */
	public static void printResponseHeaders(HttpResponse response) {
		Header[] headers = response.getAllHeaders();
		for (int i = 0; i < headers.length; i++) {
			logger.info("\t- " + headers[i].getName() + ": " + headers[i].getValue());
		}
	}

	/**
	 * Access to a Document protected by a Form based authentication
	 * 
	 * @param serverURI  - Server URI
	 * @param request    - HttpGet request
	 * @param login      - Server login
	 * @param password   - Server password
	 * @param httpClient - HttpClient used for the connection
	 * @param verbose    - if true, trace all server interactions
	 * @return - HttpResponse
	 * 
	 * @throws IOException
	 * @throws InvalidCredentialsException
	 */
	public static HttpResponse sendGetForSecureDocument(String serverURI, HttpGet request, String login,
			String password, HttpClient httpClient, String jtsURI) throws IOException, InvalidCredentialsException {

		// Step (1): Request the protected resource
		if (DEBUG)
			logger.info(">> GET(1) " + request.getURI());
		HttpResponse documentResponse = httpClient.execute(request);
		if (DEBUG) {
			logger.info(">> Response Headers:");
			IBMRestUtil.printResponseHeaders(documentResponse);
		}

		boolean loginWasRequired = doRRCOAuth(documentResponse, login, password, httpClient, jtsURI);
		// If we were not authenticated, we need to retry our request
		if (loginWasRequired) {
			HttpGet documentGet2;
			try {
				documentGet2 = (HttpGet) (request.clone());
				return httpClient.execute(documentGet2);
			} catch (CloneNotSupportedException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return documentResponse;
	}

	/**
	 * Access to a Document protected by a Form based authentication
	 * 
	 * @param serverURI  - Server URI
	 * @param request    - HttpGet request
	 * @param login      - Server login
	 * @param password   - Server password
	 * @param httpClient - HttpClient used for the connection
	 * @param verbose    - if true, trace all server interactions
	 * @return - HttpResponse
	 * 
	 * @throws IOException
	 * @throws InvalidCredentialsException
	 */
	public static HttpResponse sendGetForSecureDocument(String serverURI, HttpGet request, String login,
			String password, HttpClient httpClient)

			throws IOException, InvalidCredentialsException {

		// Step (1): Request the protected resource
		if (DEBUG)
			logger.info(">> GET(1) " + request.getURI());
		HttpResponse documentResponse = httpClient.execute(request);
		if (DEBUG) {
			logger.info(">> Response Headers:");
			IBMRestUtil.printResponseHeaders(documentResponse);
		}

		if (documentResponse.getStatusLine().getStatusCode() == 200) {
			Header header = documentResponse.getFirstHeader(AUTHREQUIRED);
			if ((header != null) && ("authrequired".equals(header.getValue()))) {
				documentResponse.getEntity().consumeContent();
				// The server requires an authentication: Create the login form
				HttpPost formPost = new HttpPost(serverURI + "/j_security_check");
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				nvps.add(new BasicNameValuePair("j_username", login));
				nvps.add(new BasicNameValuePair("j_password", password));
				formPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

				// Step (2): The client submits the login form
				if (DEBUG)
					logger.info(">> POST " + formPost.getURI());
				HttpResponse formResponse = httpClient.execute(formPost);
				if (DEBUG)
					IBMRestUtil.printResponseHeaders(formResponse);

				header = formResponse.getFirstHeader(AUTHREQUIRED);
				if ((header != null) && ("authfailed".equals(header.getValue()))) {
					// The login failed
					throw new InvalidCredentialsException("Authentication failed");
				} else {
					formResponse.getEntity().consumeContent();
					// The login succeed
					// Step (3): Request again the protected resource
					if (DEBUG)
						logger.info(">> GET(2) " + request.getURI());
					HttpGet documentGet2;
					try {
						documentGet2 = (HttpGet) (request.clone());
						return httpClient.execute(documentGet2);
					} catch (CloneNotSupportedException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return documentResponse;
	}

	/**
	 * Returns true if authentication was required, false otherwise
	 * 
	 * @param documentResponse
	 * @param login
	 * @param password
	 * @param httpClient
	 * @param jtsURI
	 * @return boolean
	 * @throws IOException
	 * @throws InvalidCredentialsException
	 */
	private static boolean doRRCOAuth(HttpResponse documentResponse, String login, String password,
			HttpClient httpClient, String jtsURI) throws IOException, InvalidCredentialsException {
		if (documentResponse.getStatusLine().getStatusCode() == 200
				|| documentResponse.getStatusLine().getStatusCode() == 401) {
			Header header = documentResponse.getFirstHeader(FORM_AUTH_HEADER);
			if (header != null && header.getValue().equals(FORM_AUTH_REQUIRED_MSG)) {
				documentResponse.getEntity().consumeContent(); // closes the connection

				// First GET
				/*
				 * HttpGet request2 = new HttpGet(header.getValue());
				 * HttpClientParams.setRedirecting(request2.getParams(), false);
				 * documentResponse = httpClient.execute(request2);
				 * documentResponse.getEntity().consumeContent(); if (DEBUG) {
				 * logger.info(">> Response Headers:");
				 * HttpUtils.printResponseHeaders(documentResponse); }
				 * 
				 * //Second GET Header location = documentResponse.getFirstHeader("Location");
				 * HttpGet request3 = new HttpGet(location.getValue());
				 * HttpClientParams.setRedirecting(request3.getParams(), false);
				 * documentResponse = httpClient.execute(request3);
				 * documentResponse.getEntity().consumeContent(); if (DEBUG) {
				 * logger.info(">> Response Headers:");
				 * HttpUtils.printResponseHeaders(documentResponse); }
				 */

				// POST to login form
				// The server requires an authentication: Create the login form
				HttpPost formPost = new HttpPost(jtsURI + "/j_security_check");
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				nvps.add(new BasicNameValuePair("j_username", login));
				nvps.add(new BasicNameValuePair("j_password", password));
				formPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

				// Step (2): The client submits the login form
				if (DEBUG)
					logger.info(">> POST " + formPost.getURI());
				HttpResponse formResponse = httpClient.execute(formPost);
				formResponse.getEntity().consumeContent();
				if (DEBUG)
					IBMRestUtil.printResponseHeaders(formResponse);

				int formSc = formResponse.getStatusLine().getStatusCode();
				if (formSc == 200 || formSc == 302) {
					header = formResponse.getFirstHeader(FORM_AUTH_HEADER);
					String redirectURI = formResponse.getFirstHeader("Location").getValue();
					if ((header != null) && (header.getValue().equals(FORM_AUTH_FAILED_MSG))) {
						// The login failed
						throw new InvalidCredentialsException("Authentication failed");
					} else if (formSc == 302 && redirectURI.contains(FORM_AUTH_FAILED_URI)) {
						throw new InvalidCredentialsException("Authentication failed");
					} else {
						// The login succeed
						try {
							formPost.setURI(new URI(redirectURI));
							formResponse = httpClient.execute(formPost);
						} catch (URISyntaxException e) {
							logger.error(e.getMessage(), e);
						}
						// Step (3): Request again the protected resource
						formResponse.getEntity().consumeContent();
						return true; // REDO YOUR REQUEST
					}
				} else {
					throw new InvalidCredentialsException("Authentication failed");
				}
			}
		}
		return false;
	}

}
