/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * OAuth2AuthorizationServerConfigTest is a test class for
 * OAuth2AuthorizationServerConfig
 *
 * @see org.infy.idp.config.OAuth2AuthorizationServerConfig
 *  
 */
public class OAuth2AuthorizationServerConfigTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public OAuth2AuthorizationServerConfigTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method accessTokenConverter().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#accessTokenConverter()
	 *  
	 * 
	 */
	@Test
	public void testAccessTokenConverter0() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		JwtAccessTokenConverter result = testedObject.accessTokenConverter();
		assertNotNull(result); // jtest_unverified
		assertNotNull(result.getKey()); // jtest_unverified
		assertEquals(2, result.getKey().size()); // jtest_unverified
		assertEquals(true, result.getKey().containsValue("SHA256withRSA")); // jtest_unverified
		assertEquals(true, result.getKey().containsValue(
				"-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgIK2Wt4x2EtDl41C7vfpOsMquZMyOyteO2RsVeMLF/hXIeYvicKr0SQzVkodHEBCMiGXQDz5prijTq3RHPy2/5WJBCYq7yHgTLvspMy6sivXN7NdYE7I5pXo/KHk4nz+Fa6P3L8+L90E/3qwf6j3DKWnAgJFRY8AbSYXt1d5ELiIG1/gEqzC0fZmNhhfrBtxwWXrlpUDT0Kfvf0QVmPRxxCLXT+tEe1seWGEqeOLL5vXRLqmzZcBe1RZ9kQQm43+a9Qn5icSRnDfTAesQ3CrlAWJKl2kcWU1HwJqw+dZRSZ1X4kEXNMyzPdPBbGmU6MHdhpywI7SKZT7mX4BDnUKeQIDAQAB\n-----END PUBLIC KEY-----")); // jtest_unverified
		assertEquals(true, result.isPublic()); // jtest_unverified
		assertNotNull(result.getAccessTokenConverter()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method
	 * configure(org.springframework.security.oauth2.config.annotation.web.
	 * configurers.AuthorizationServerSecurityConfigurer).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testConfigure0() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		testedObject.configure((AuthorizationServerSecurityConfigurer) null);
	}

	/**
	 * Test for method
	 * configure(org.springframework.security.oauth2.config.annotation.
	 * configurers.ClientDetailsServiceConfigurer).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testConfigure1() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		ClientDetailsServiceBuilder builder = new ClientDetailsServiceBuilder();
		ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer(builder);
		testedObject.configure(clients);

		// NullPointerException thrown
		// at
		// org.infy.idp.config.OAuth2AuthorizationServerConfig.configure(OAuth2AuthorizationServerConfig.java:92)
	}

	/**
	 * Test for method
	 * configure(org.springframework.security.oauth2.config.annotation.
	 * configurers.ClientDetailsServiceConfigurer).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
	 *  
	 * 
	 */
	@Test(expected = IllegalStateException.class)
	public void testConfigure3() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer((ClientDetailsServiceBuilder) null);
		testedObject.configure(clients);
		// IllegalStateException thrown
		// at
		// org.springframework.security.config.annotation.SecurityConfigurerAdapter.getBuilder(SecurityConfigurerAdapter.java:68)
		// at
		// org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer.inMemory(ClientDetailsServiceConfigurer.java:43)
		// at
		// org.infy.idp.config.OAuth2AuthorizationServerConfig.configure(OAuth2AuthorizationServerConfig.java:92)
	}

	/**
	 * Test for method
	 * configure(org.springframework.security.oauth2.config.annotation.
	 * configurers.ClientDetailsServiceConfigurer).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
	 *  
	 * 
	 */
	@Test(expected = Exception.class)
	public void testConfigure6() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer((ClientDetailsServiceBuilder) null);
		testedObject.configure(clients);

		// Exception thrown
		// at
		// org.infy.idp.config.OAuth2AuthorizationServerConfig.configure(OAuth2AuthorizationServerConfig.java:92)
	}


	/**
	 * Test for method
	 * configure(org.springframework.security.oauth2.config.annotation.web.
	 * configurers.AuthorizationServerEndpointsConfigurer).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer)
	 *  
	 * 
	 */
	@Test
	public void testConfigure7() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		AuthorizationServerEndpointsConfigurer endpoints = new AuthorizationServerEndpointsConfigurer();
		testedObject.configure(endpoints);
		assertNotNull(endpoints.getTokenServices()); // jtest_unverified
		assertNotNull(endpoints.getTokenEnhancer()); // jtest_unverified
		assertNotNull(endpoints.getTokenStore()); // jtest_unverified
		//assertNotNull(endpoints.getApprovalStore()); // Ignored by Jtest
		//assertNotNull(endpoints.getClientDetailsService()); 
		//assertNotNull(endpoints.getOAuth2RequestFactory()); 
		// No exception thrown
		// jtest_unverified
	
	}

	/**
	 * Test for method
	 * configure(org.springframework.security.oauth2.config.annotation.web.
	 * configurers.AuthorizationServerEndpointsConfigurer).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testConfigure8() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		testedObject.configure((AuthorizationServerEndpointsConfigurer) null);

		// NullPointerException thrown
		// at
		// org.infy.idp.config.OAuth2AuthorizationServerConfig.configure(OAuth2AuthorizationServerConfig.java:112)
	}

	/**
	 * Test for method OAuth2AuthorizationServerConfig().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#OAuth2AuthorizationServerConfig()
	 *  
	 * 
	 */
	@Test
	public void testOAuth2AuthorizationServerConfig0() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method tokenEnhancer().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#tokenEnhancer()
	 *  
	 * 
	 */
	@Test
	public void testTokenEnhancer0() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		TokenEnhancer result = testedObject.tokenEnhancer();
		assertNotNull(result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method tokenServices().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#tokenServices()
	 *  
	 * 
	 */
	@Test
	public void testTokenServices0() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		DefaultTokenServices result = testedObject.tokenServices();
		assertNotNull(result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method tokenStore().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see OAuth2AuthorizationServerConfig#tokenStore()
	 *  
	 * 
	 */
	@Test
	public void testTokenStore0() throws Throwable {
		OAuth2AuthorizationServerConfig testedObject = new OAuth2AuthorizationServerConfig();
		TokenStore result = testedObject.tokenStore();
		assertNotNull(result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of
	 * the tests are executed.
	 * 
	 *  
	 */
	@Before
	public void setUp() throws Exception {
		/*
		 * Add any necessary initialization code here (e.g., open a socket).
		 * Call Repository.putTemporary() to provide initialized instances of
		 * objects to be used when testing.
		 */
		super.setUp();
		// jtest.Repository.putTemporary("name", object);

	}

	/**
	 * Used to clean up after the test. This method is called by JUnit after
	 * each of the tests have been completed.
	 * 
	 *  
	 */
	@After
	public void tearDown() throws Exception {
		try {
			/*
			 * Add any necessary cleanup code here (e.g., close a socket).
			 */
		} finally {
			super.tearDown();
		}
	}

	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java OAuth2AuthorizationServerConfigTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.OAuth2AuthorizationServerConfigTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return OAuth2AuthorizationServerConfig.class;
	}
}
// JTEST_CURRENT_ID=90554106.