/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * JenkinsCLITest is a test class for JenkinsCLI
 *
 * @see org.infy.idp.utils.JenkinsCLI
 * 
 */

@RunWith(MockitoJUnitRunner.class)
public class JenkinsCLITest extends PackageTestCase {

	@InjectMocks
	private JenkinsCLI jenkinsCLI;

	@Spy
	private ConfigurationManager configmanager;

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public JenkinsCLITest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method addALMConfig(java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#addALMConfig(java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test(expected = Exception.class)
	public void testAddALMConfig1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		String result = jenkinsCLI.addALMConfig("almServerName", "almServerUrl");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Test for method
	 * addNexusRepoGlobConf(java.lang.String,java.lang.String,java.lang.String,
	 * java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#addNexusRepoGlobConf(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testAddNexusRepoGlobConf1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		int result = jenkinsCLI.addNexusRepoGlobConf("repoUrl", "user", "pwd", "repoName");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Test for method
	 * copySlave(java.lang.String,java.lang.String,java.lang.String,java.lang.
	 * String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#copySlave(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testCopySlave1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		int result = jenkinsCLI.copySlave("slaveName", "workspace", "slaveLabel", "sshKeyPath");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Test for method
	 * createRole(java.lang.String,java.lang.String,java.lang.String,java.lang.
	 * String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#createRole(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testCreateRole1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		int result = jenkinsCLI.createRole("roleName", "usersList", "pattern", "roleType", "permissions");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Test for method createSSHServer(java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#createSSHServer(java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test(expected = Exception.class)
	public void testCreateSSHServer1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		int result = jenkinsCLI.createSSHServer("hostName", "userName");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Test for method
	 * createUser(java.lang.String,java.lang.String,java.lang.String,java.lang.
	 * String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#createUser(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testCreateUser1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		int result = jenkinsCLI.createUser("userName", "password", "fullName", "email");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Test for method disableJob(java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#disableJob(java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testDisableJob1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		int result = jenkinsCLI.disableJob("jobName", "jobConfigFile");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Test for method init().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#init()
	 * 
	 * 
	 */
//	@Test
//	public void testInit1() throws Throwable {
//		//JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class, "jenkinscli");
//		JT.invoke(JenkinsCLI.class, jenkinsCLI, "init", new Object[] {}, new Class[] {});
//
//		// jtest.NoSuchValueException thrown
//	}

	/**
	 * Test for method
	 * persistCredentials(java.lang.String,java.lang.String,java.lang.String,
	 * java.lang.String,java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#persistCredentials(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testPersistCredentials1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		int result = jenkinsCLI.persistCredentials("scope", "credId", "userName", "pass", "description",
				"configFileName");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Test for method saveJob(java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsCLI#saveJob(java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testSaveJob1() throws Throwable {
		// JenkinsCLI testedObject = (JenkinsCLI) Repository.getObject(JenkinsCLI.class,
		// "jenkinscli");
		int result = jenkinsCLI.saveJob("jobName", "jobConfigFile");

		// jtest.NoSuchValueException thrown
	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of the
	 * tests are executed.
	 * 
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		/*
		 * Add any necessary initialization code here (e.g., open a socket). Call
		 * Repository.putTemporary() to provide initialized instances of objects to be
		 * used when testing.
		 */
		super.setUp();
		// jtest.Repository.putTemporary("name", object);

		configmanager.setJenkinsurl("http://idpwinv07:8085");
		configmanager.setJenkinsuserid("admin");
		configmanager.setJenkinspassword("admin123");
		configmanager.setSharePath("D:\\IDP\\IDP_Versions\\DSL");
		configmanager.setPipelineScriptPath("D:\\IDP\\IDP_Versions\\DSL\\src\\main\\groovy\\pipeline_sequence");

	}

	/**
	 * Used to clean up after the test. This method is called by JUnit after each of
	 * the tests have been completed.
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
	 * Usage: java JenkinsCLITest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.utils.JenkinsCLITest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return JenkinsCLI.class;
	}
}
// JTEST_CURRENT_ID=-1072143252.