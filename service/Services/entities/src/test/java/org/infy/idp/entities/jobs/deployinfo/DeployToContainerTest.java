/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.deployinfo;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.jobs.common.Migration;
import org.infy.idp.entities.jobs.deployinfo.DeployToContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DeployToContainerTest is a test class for DeployToContainer
 *
 * @see org.infy.idp.entities.jobs.deployinfo.DeployToContainer
 * 
 */
public class DeployToContainerTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public DeployToContainerTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method DeployToContainer().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see DeployToContainer#DeployToContainer()
	 * 
	 * 
	 */
	@Test
	public void testDeployToContainer0() throws Throwable {
		DeployToContainer testedObject = new DeployToContainer();
		testedObject.setApplicationName("applicationName22");
		testedObject.setNarOS("narOS22");
		testedObject.setDeployedFolder("deployedFolder22");
		testedObject.setProfilePath("profilePath22");
		testedObject.setDbcScriptName("dbcScriptName22");
		testedObject.setXmlScripts("xmlScripts22");
		testedObject.setImportReports("importReports22");
		testedObject.setSrcEnvName("dev");
		testedObject.setPairName("dev-sit");
		testedObject.setFileName("exportdata.xml");
		testedObject.setLauncherActivity("main");
		testedObject.setToken("token");
		testedObject.setDbDeployDBOwners("owner");
		ArrayList<String> dbDeployPipelineList = new ArrayList<>();
		dbDeployPipelineList.add("pipeline1");
		testedObject.setDbDeployPipelineList(dbDeployPipelineList);
		Migration sqlFilesAndPackages = new Migration();
		testedObject.setSqlFilesAndPackages(sqlFilesAndPackages);
		Migration reportMigration = new Migration();
		testedObject.setReportMigration(reportMigration);
		Migration publishForm = new Migration();
		testedObject.setPublishForm(publishForm);
		Migration ctlMigration = new Migration();
		testedObject.setCtlMigration(ctlMigration);
		Migration oaMedia = new Migration();
		testedObject.setOaMedia(oaMedia);
		Migration workflowMigration = new Migration();
		testedObject.setWorkflowMigration(workflowMigration);
		Migration aolScript = new Migration();
		testedObject.setAolScript(aolScript);
		List sqlDeploy = new ArrayList();
		testedObject.setSqlDeploy(sqlDeploy);
		List datExport = new ArrayList();
		testedObject.setDatExport(datExport);
		List datImport = new ArrayList();
		testedObject.setDatImport(datImport);
		List ddlSync = new ArrayList();
		testedObject.setDdlSync(ddlSync);
		testedObject.setPropertyFile("propertyFile22");
		testedObject.setBuildType("buildType22");
		testedObject.setBarFile("barFile22");
		// Integer port = new Integer(5);
		String port = "5";
		testedObject.setPort(port);
		testedObject.setDerivedDataPath("derivedDataPath22");
		testedObject.setAvdName("avdName22");
		testedObject.setSourcePath("sourcePath22");
		testedObject.setTargetPath("targetPath22");
		testedObject.setScriptPath("scriptPath22");
		testedObject.setDomain("domain22");
		testedObject.setMqManager("mqManager22");
		testedObject.setPlatform("platform22");
		testedObject.setAutomationScript("automationScript22");
		testedObject.setAdmin("admin22");
		testedObject.setAdminPassword("adminPassword22");
		testedObject.setDbOwner("dbOwner22");
		testedObject.setDbOwnerPassword("dbOwnerPassword22");
		List staticFiles = new ArrayList();
		testedObject.setStaticFiles(staticFiles);
		List srfServer = new ArrayList();
		testedObject.setSrfServer(srfServer);
		List admWorkflowServer = new ArrayList();
		testedObject.setAdmWorkflowServer(admWorkflowServer);
		testedObject.setSshExecution("sshExecution22");
		testedObject.setSshId("sshId22");
		testedObject.setSshPassword("sshPassword22");
		testedObject.setScript("script22");
		testedObject.setUpdateDB("updateDB22");
		testedObject.setRollBackDB("rollBackDB22");
		testedObject.setLogFilePath("logFilePath22");
		testedObject.setTagDB("tagDB22");
		testedObject.setTestRollback("testRollback22");
		testedObject.setApprover("approver22");
		testedObject.setRollbackStrategy("rollbackStrategy22");
		testedObject.setTagName("tagName22");
		Integer hrs = new Integer("0");
		testedObject.setHrs(hrs);
		testedObject.setIpOrDNS("ipOrDNS44");
		testedObject.setHostName("hostName22");
		testedObject.setContainerName("containerName22");
		testedObject.setServerManagerURL("serverManagerURL22");
		testedObject.setResourceToBeDeployed("resourceToBeDeployed22");
		testedObject.setWarPath("warPath22");
		testedObject.setContextPath("contextPath22");
		testedObject.setUserName("userName22");
		testedObject.setPassword("password22");
		testedObject.setIpDns("ipOrDNS45");
		testedObject.setTargetCellName("targetCellName22");
		testedObject.setTargetNodeName("targetNodeName22");
		testedObject.setTargetServerName("targetServerName21");
		testedObject.setDestServerPath("destServerPath");
		testedObject.setWebsiteName("websiteName");
		testedObject.setAppPoolName("appPoolName");

		assertEquals("dev", testedObject.getSrcEnvName());
		assertEquals("dev-sit", testedObject.getPairName());
		assertEquals("main", testedObject.getLauncherActivity());
		assertEquals("token", testedObject.getToken());
		assertEquals("owner", testedObject.getDbDeployDBOwners());
		assertEquals(dbDeployPipelineList, testedObject.getDbDeployPipelineList());
		assertEquals("destServerPath", testedObject.getDestServerPath());
		assertEquals("websiteName", testedObject.getWebsiteName());
		assertEquals("appPoolName", testedObject.getAppPoolName());
		assertEquals("hostName22", testedObject.getHostName()); // jtest_unverified
		assertEquals(port, testedObject.getPort()); // jtest_unverified
		assertEquals("script22", testedObject.getScript()); // jtest_unverified
		assertEquals(sqlFilesAndPackages, testedObject.getSqlFilesAndPackages()); // jtest_unverified
		assertEquals("targetNodeName22", testedObject.getTargetNodeName()); // jtest_unverified
		assertEquals(workflowMigration, testedObject.getWorkflowMigration()); // jtest_unverified
		assertEquals("deployedFolder22", testedObject.getDeployedFolder()); // jtest_unverified
		assertEquals("serverManagerURL22", testedObject.getServerManagerURL()); // jtest_unverified
		assertEquals(reportMigration, testedObject.getReportMigration()); // jtest_unverified
		assertEquals("resourceToBeDeployed22", testedObject.getResourceToBeDeployed()); // jtest_unverified
		assertEquals("targetServerName21", testedObject.getTargetServerName()); // jtest_unverified
		assertEquals("dbOwnerPassword22", testedObject.getDbOwnerPassword()); // jtest_unverified
		assertEquals("derivedDataPath22", testedObject.getDerivedDataPath()); // jtest_unverified
		assertEquals("automationScript22", testedObject.getAutomationScript()); // jtest_unverified
		assertEquals(sqlDeploy, testedObject.getAdmWorkflowServer()); // jtest_unverified
		assertEquals("rollbackStrategy22", testedObject.getRollbackStrategy()); // jtest_unverified
		assertEquals("targetCellName22", testedObject.getTargetCellName()); // jtest_unverified
		assertEquals("applicationName22", testedObject.getApplicationName()); // jtest_unverified
		assertEquals("admin22", testedObject.getAdmin()); // jtest_unverified
		assertEquals("warPath22", testedObject.getWarPath()); // jtest_unverified
		assertEquals(sqlDeploy, testedObject.getSrfServer()); // jtest_unverified
		assertEquals(sqlDeploy, testedObject.getStaticFiles()); // jtest_unverified
		assertEquals("testRollback22", testedObject.getTestRollback()); // jtest_unverified
		assertEquals("tagName22", testedObject.getTagName()); // jtest_unverified
		assertEquals("scriptPath22", testedObject.getScriptPath()); // jtest_unverified
		assertEquals("containerName22", testedObject.getContainerName()); // jtest_unverified
		assertEquals("logFilePath22", testedObject.getLogFilePath()); // jtest_unverified
		assertEquals("sshPassword22", testedObject.getSshPassword()); // jtest_unverified
		assertEquals("dbOwner22", testedObject.getDbOwner()); // jtest_unverified
		assertEquals("sshExecution22", testedObject.getSshExecution()); // jtest_unverified
		assertEquals("sshId22", testedObject.getSshId()); // jtest_unverified
		assertEquals("updateDB22", testedObject.getUpdateDB()); // jtest_unverified
		assertEquals("platform22", testedObject.getPlatform()); // jtest_unverified
		assertEquals(hrs, testedObject.getHrs()); // jtest_unverified
		assertEquals("ipOrDNS45", testedObject.getIpOrDNS()); // jtest_unverified
		assertEquals("approver22", testedObject.getApprover()); // jtest_unverified
		assertEquals("rollBackDB22", testedObject.getRollBackDB()); // jtest_unverified
		assertEquals("adminPassword22", testedObject.getAdminPassword()); // jtest_unverified
		assertEquals("mqManager22", testedObject.getMqManager()); // jtest_unverified
		assertEquals("domain22", testedObject.getDomain()); // jtest_unverified
		assertEquals("userName22", testedObject.getUserName()); // jtest_unverified
		assertEquals("password22", testedObject.getPassword()); // jtest_unverified
		assertEquals("contextPath22", testedObject.getContextPath()); // jtest_unverified
		assertEquals("targetPath22", testedObject.getTargetPath()); // jtest_unverified
		assertEquals("tagDB22", testedObject.getTagDB()); // jtest_unverified
		assertEquals("dbcScriptName22", testedObject.getDbcScriptName()); // jtest_unverified
		assertEquals("xmlScripts22", testedObject.getXmlScripts()); // jtest_unverified
		assertEquals("importReports22", testedObject.getImportReports()); // jtest_unverified
		assertEquals(publishForm, testedObject.getPublishForm()); // jtest_unverified
		assertEquals("profilePath22", testedObject.getProfilePath()); // jtest_unverified
		assertEquals(ctlMigration, testedObject.getCtlMigration()); // jtest_unverified
		assertEquals(oaMedia, testedObject.getOaMedia()); // jtest_unverified
		assertEquals(sqlDeploy, testedObject.getSqlDeploy()); // jtest_unverified
		assertEquals(sqlDeploy, testedObject.getDatExport()); // jtest_unverified
		assertEquals(sqlDeploy, testedObject.getDatImport()); // jtest_unverified
		assertEquals(sqlDeploy, testedObject.getDdlSync()); // jtest_unverified
		assertEquals("propertyFile22", testedObject.getPropertyFile()); // jtest_unverified
		assertEquals(aolScript, testedObject.getAolScript()); // jtest_unverified
		assertEquals("barFile22", testedObject.getBarFile()); // jtest_unverified
		assertEquals("buildType22", testedObject.getBuildType()); // jtest_unverified
		assertEquals("avdName22", testedObject.getAvdName()); // jtest_unverified
		assertEquals("sourcePath22", testedObject.getSourcePath()); // jtest_unverified
		assertEquals("narOS22", testedObject.getNarOS()); // jtest_unverified

		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method DeployToContainer().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see DeployToContainer#DeployToContainer()
	 * 
	 * 
	 */
	@Test
	public void testDeployToContainer11() throws Throwable {
		DeployToContainer testedObject = new DeployToContainer();
		testedObject.setApplicationName("applicationName1");
		testedObject.setNarOS("narOS1");
		testedObject.setDeployedFolder("deployedFolder1");
		testedObject.setProfilePath("profilePath1");
		testedObject.setDbcScriptName("dbcScriptName1");
		testedObject.setXmlScripts("xmlScripts1");
		testedObject.setImportReports("importReports1");
		testedObject.setSqlFilesAndPackages((Migration) null);
		testedObject.setReportMigration((Migration) null);
		testedObject.setPublishForm((Migration) null);
		testedObject.setCtlMigration((Migration) null);
		testedObject.setOaMedia((Migration) null);
		testedObject.setWorkflowMigration((Migration) null);
		testedObject.setAolScript((Migration) null);
		testedObject.setSqlDeploy((List) null);
		testedObject.setDatExport((List) null);
		testedObject.setDatImport((List) null);
		testedObject.setDdlSync((List) null);
		testedObject.setPropertyFile("propertyFile1");
		testedObject.setBuildType("buildType1");
		testedObject.setBarFile("barFile1");
		testedObject.setPort(null);
		testedObject.setDerivedDataPath("derivedDataPath1");
		testedObject.setAvdName("avdName1");
		testedObject.setSourcePath("sourcePath1");
		testedObject.setTargetPath("targetPath1");
		testedObject.setScriptPath("scriptPath1");
		testedObject.setDomain("domain1");
		testedObject.setMqManager("mqManager1");
		testedObject.setPlatform("platform1");
		testedObject.setAutomationScript("automationScript1");
		testedObject.setAdmin("admin1");
		testedObject.setAdminPassword("adminPassword1");
		testedObject.setDbOwner("dbOwner1");
		testedObject.setDbOwnerPassword("dbOwnerPassword1");
		testedObject.setStaticFiles((List) null);
		testedObject.setSrfServer((List) null);
		testedObject.setAdmWorkflowServer((List) null);
		testedObject.setSshExecution("sshExecution1");
		testedObject.setSshId("sshId1");
		testedObject.setSshPassword("sshPassword1");
		testedObject.setScript("script1");
		testedObject.setUpdateDB("updateDB1");
		testedObject.setRollBackDB("rollBackDB1");
		testedObject.setLogFilePath("logFilePath1");
		testedObject.setTagDB("tagDB1");
		testedObject.setTestRollback("testRollback1");
		testedObject.setApprover("approver1");
		testedObject.setRollbackStrategy("rollbackStrategy1");
		testedObject.setTagName("tagName1");
		testedObject.setHrs((Integer) null);
		testedObject.setIpOrDNS("ipOrDNS2");
		testedObject.setHostName("hostName1");
		testedObject.setContainerName("containerName1");
		testedObject.setServerManagerURL("serverManagerURL1");
		testedObject.setResourceToBeDeployed("resourceToBeDeployed1");
		testedObject.setWarPath("warPath1");
		testedObject.setContextPath("contextPath1");
		testedObject.setUserName("userName1");
		testedObject.setPassword("password1");
		testedObject.setIpDns("ipOrDNS3");
		testedObject.setTargetCellName("targetCellName1");
		testedObject.setTargetNodeName("targetNodeName1");
		testedObject.setTargetServerName("targetServerName0");
		assertEquals("hostName1", testedObject.getHostName()); // jtest_unverified
		assertEquals(null, testedObject.getPort()); // jtest_unverified
		assertEquals("script1", testedObject.getScript()); // jtest_unverified
		assertEquals(null, testedObject.getSqlFilesAndPackages()); // jtest_unverified
		assertEquals("targetNodeName1", testedObject.getTargetNodeName()); // jtest_unverified
		assertEquals(null, testedObject.getWorkflowMigration()); // jtest_unverified
		assertEquals("deployedFolder1", testedObject.getDeployedFolder()); // jtest_unverified
		assertEquals("serverManagerURL1", testedObject.getServerManagerURL()); // jtest_unverified
		assertEquals(null, testedObject.getReportMigration()); // jtest_unverified
		assertEquals("resourceToBeDeployed1", testedObject.getResourceToBeDeployed()); // jtest_unverified
		assertEquals("targetServerName0", testedObject.getTargetServerName()); // jtest_unverified
		assertEquals("dbOwnerPassword1", testedObject.getDbOwnerPassword()); // jtest_unverified
		assertEquals("derivedDataPath1", testedObject.getDerivedDataPath()); // jtest_unverified
		assertEquals("automationScript1", testedObject.getAutomationScript()); // jtest_unverified
		assertEquals(null, testedObject.getAdmWorkflowServer()); // jtest_unverified
		assertEquals("rollbackStrategy1", testedObject.getRollbackStrategy()); // jtest_unverified
		assertEquals("targetCellName1", testedObject.getTargetCellName()); // jtest_unverified
		assertEquals("applicationName1", testedObject.getApplicationName()); // jtest_unverified
		assertEquals("admin1", testedObject.getAdmin()); // jtest_unverified
		assertEquals("warPath1", testedObject.getWarPath()); // jtest_unverified
		assertEquals(null, testedObject.getSrfServer()); // jtest_unverified
		assertEquals(null, testedObject.getStaticFiles()); // jtest_unverified
		assertEquals("testRollback1", testedObject.getTestRollback()); // jtest_unverified
		assertEquals("tagName1", testedObject.getTagName()); // jtest_unverified
		assertEquals("scriptPath1", testedObject.getScriptPath()); // jtest_unverified
		assertEquals("containerName1", testedObject.getContainerName()); // jtest_unverified
		assertEquals("logFilePath1", testedObject.getLogFilePath()); // jtest_unverified
		assertEquals("sshPassword1", testedObject.getSshPassword()); // jtest_unverified
		assertEquals("dbOwner1", testedObject.getDbOwner()); // jtest_unverified
		assertEquals("sshExecution1", testedObject.getSshExecution()); // jtest_unverified
		assertEquals("sshId1", testedObject.getSshId()); // jtest_unverified
		assertEquals("updateDB1", testedObject.getUpdateDB()); // jtest_unverified
		assertEquals("platform1", testedObject.getPlatform()); // jtest_unverified
		assertEquals(null, testedObject.getHrs()); // jtest_unverified
		assertEquals("ipOrDNS3", testedObject.getIpOrDNS()); // jtest_unverified
		assertEquals("approver1", testedObject.getApprover()); // jtest_unverified
		assertEquals("rollBackDB1", testedObject.getRollBackDB()); // jtest_unverified
		assertEquals("adminPassword1", testedObject.getAdminPassword()); // jtest_unverified
		assertEquals("mqManager1", testedObject.getMqManager()); // jtest_unverified
		assertEquals("domain1", testedObject.getDomain()); // jtest_unverified
		assertEquals("userName1", testedObject.getUserName()); // jtest_unverified
		assertEquals("password1", testedObject.getPassword()); // jtest_unverified
		assertEquals("contextPath1", testedObject.getContextPath()); // jtest_unverified
		assertEquals("targetPath1", testedObject.getTargetPath()); // jtest_unverified
		assertEquals("tagDB1", testedObject.getTagDB()); // jtest_unverified
		assertEquals("dbcScriptName1", testedObject.getDbcScriptName()); // jtest_unverified
		assertEquals("xmlScripts1", testedObject.getXmlScripts()); // jtest_unverified
		assertEquals("importReports1", testedObject.getImportReports()); // jtest_unverified
		assertEquals(null, testedObject.getPublishForm()); // jtest_unverified
		assertEquals("profilePath1", testedObject.getProfilePath()); // jtest_unverified
		assertEquals(null, testedObject.getCtlMigration()); // jtest_unverified
		assertEquals(null, testedObject.getOaMedia()); // jtest_unverified
		assertEquals(null, testedObject.getSqlDeploy()); // jtest_unverified
		assertEquals(null, testedObject.getDatExport()); // jtest_unverified
		assertEquals(null, testedObject.getDatImport()); // jtest_unverified
		assertEquals(null, testedObject.getDdlSync()); // jtest_unverified
		assertEquals("propertyFile1", testedObject.getPropertyFile()); // jtest_unverified
		assertEquals(null, testedObject.getAolScript()); // jtest_unverified
		assertEquals("barFile1", testedObject.getBarFile()); // jtest_unverified
		assertEquals("buildType1", testedObject.getBuildType()); // jtest_unverified
		assertEquals("avdName1", testedObject.getAvdName()); // jtest_unverified
		assertEquals("sourcePath1", testedObject.getSourcePath()); // jtest_unverified
		assertEquals("narOS1", testedObject.getNarOS()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method DeployToContainer().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see DeployToContainer#DeployToContainer()
	 * 
	 * 
	 */
	@Test
	public void testDeployToContainer12() throws Throwable {
		DeployToContainer testedObject = new DeployToContainer();
		testedObject.setApplicationName("applicationName0");
		testedObject.setNarOS("narOS0");
		testedObject.setDeployedFolder("deployedFolder0");
		testedObject.setProfilePath("profilePath0");
		testedObject.setDbcScriptName("dbcScriptName0");
		testedObject.setXmlScripts("xmlScripts0");
		testedObject.setImportReports("importReports0");
		testedObject.setSqlFilesAndPackages((Migration) null);
		testedObject.setReportMigration((Migration) null);
		testedObject.setPublishForm((Migration) null);
		testedObject.setCtlMigration((Migration) null);
		testedObject.setOaMedia((Migration) null);
		testedObject.setWorkflowMigration((Migration) null);
		testedObject.setAolScript((Migration) null);
		testedObject.setSqlDeploy((List) null);
		testedObject.setDatExport((List) null);
		testedObject.setDatImport((List) null);
		testedObject.setDdlSync((List) null);
		testedObject.setPropertyFile("propertyFile0");
		testedObject.setBuildType("buildType0");
		testedObject.setBarFile("barFile0");
		testedObject.setPort(null);
		testedObject.setDerivedDataPath("derivedDataPath0");
		testedObject.setAvdName("avdName0");
		testedObject.setSourcePath("sourcePath0");
		testedObject.setTargetPath("targetPath0");
		testedObject.setScriptPath("scriptPath0");
		testedObject.setDomain("domain0");
		testedObject.setMqManager("mqManager0");
		testedObject.setPlatform("platform0");
		testedObject.setAutomationScript("automationScript0");
		testedObject.setAdmin("admin0");
		testedObject.setAdminPassword("adminPassword0");
		testedObject.setDbOwner("dbOwner0");
		testedObject.setDbOwnerPassword("dbOwnerPassword0");
		testedObject.setStaticFiles((List) null);
		testedObject.setSrfServer((List) null);
		testedObject.setAdmWorkflowServer((List) null);
		testedObject.setSshExecution("sshExecution0");
		testedObject.setSshId("sshId0");
		testedObject.setSshPassword("sshPassword0");
		testedObject.setScript("script0");
		testedObject.setUpdateDB("updateDB0");
		testedObject.setRollBackDB("rollBackDB0");
		testedObject.setLogFilePath("logFilePath0");
		testedObject.setTagDB("tagDB0");
		testedObject.setTestRollback("testRollback0");
		testedObject.setApprover("approver0");
		testedObject.setRollbackStrategy("rollbackStrategy0");
		testedObject.setTagName("tagName0");
		testedObject.setHrs((Integer) null);
		testedObject.setIpOrDNS("ipOrDNS0");
		testedObject.setHostName("hostName0");
		testedObject.setContainerName("containerName0");
		testedObject.setServerManagerURL("serverManagerURL0");
		testedObject.setResourceToBeDeployed("resourceToBeDeployed0");
		testedObject.setWarPath("warPath0");
		testedObject.setContextPath("contextPath0");
		testedObject.setUserName("userName0");
		testedObject.setPassword("password0");
		testedObject.setIpDns("ipOrDNS1");
		testedObject.setTargetCellName("targetCellName0");
		testedObject.setTargetNodeName("targetNodeName0");
		testedObject.setTargetServerName((String) null);
		assertEquals("hostName0", testedObject.getHostName()); // jtest_unverified
		assertEquals(null, testedObject.getPort()); // jtest_unverified
		assertEquals("script0", testedObject.getScript()); // jtest_unverified
		assertEquals(null, testedObject.getSqlFilesAndPackages()); // jtest_unverified
		assertEquals("targetNodeName0", testedObject.getTargetNodeName()); // jtest_unverified
		assertEquals(null, testedObject.getWorkflowMigration()); // jtest_unverified
		assertEquals("deployedFolder0", testedObject.getDeployedFolder()); // jtest_unverified
		assertEquals("serverManagerURL0", testedObject.getServerManagerURL()); // jtest_unverified
		assertEquals(null, testedObject.getReportMigration()); // jtest_unverified
		assertEquals("resourceToBeDeployed0", testedObject.getResourceToBeDeployed()); // jtest_unverified
		assertEquals(null, testedObject.getTargetServerName()); // jtest_unverified
		assertEquals("dbOwnerPassword0", testedObject.getDbOwnerPassword()); // jtest_unverified
		assertEquals("derivedDataPath0", testedObject.getDerivedDataPath()); // jtest_unverified
		assertEquals("automationScript0", testedObject.getAutomationScript()); // jtest_unverified
		assertEquals(null, testedObject.getAdmWorkflowServer()); // jtest_unverified
		assertEquals("rollbackStrategy0", testedObject.getRollbackStrategy()); // jtest_unverified
		assertEquals("targetCellName0", testedObject.getTargetCellName()); // jtest_unverified
		assertEquals("applicationName0", testedObject.getApplicationName()); // jtest_unverified
		assertEquals("admin0", testedObject.getAdmin()); // jtest_unverified
		assertEquals("warPath0", testedObject.getWarPath()); // jtest_unverified
		assertEquals(null, testedObject.getSrfServer()); // jtest_unverified
		assertEquals(null, testedObject.getStaticFiles()); // jtest_unverified
		assertEquals("testRollback0", testedObject.getTestRollback()); // jtest_unverified
		assertEquals("tagName0", testedObject.getTagName()); // jtest_unverified
		assertEquals("scriptPath0", testedObject.getScriptPath()); // jtest_unverified
		assertEquals("containerName0", testedObject.getContainerName()); // jtest_unverified
		assertEquals("logFilePath0", testedObject.getLogFilePath()); // jtest_unverified
		assertEquals("sshPassword0", testedObject.getSshPassword()); // jtest_unverified
		assertEquals("dbOwner0", testedObject.getDbOwner()); // jtest_unverified
		assertEquals("sshExecution0", testedObject.getSshExecution()); // jtest_unverified
		assertEquals("sshId0", testedObject.getSshId()); // jtest_unverified
		assertEquals("updateDB0", testedObject.getUpdateDB()); // jtest_unverified
		assertEquals("platform0", testedObject.getPlatform()); // jtest_unverified
		assertEquals(null, testedObject.getHrs()); // jtest_unverified
		assertEquals("ipOrDNS1", testedObject.getIpOrDNS()); // jtest_unverified
		assertEquals("approver0", testedObject.getApprover()); // jtest_unverified
		assertEquals("rollBackDB0", testedObject.getRollBackDB()); // jtest_unverified
		assertEquals("adminPassword0", testedObject.getAdminPassword()); // jtest_unverified
		assertEquals("mqManager0", testedObject.getMqManager()); // jtest_unverified
		assertEquals("domain0", testedObject.getDomain()); // jtest_unverified
		assertEquals("userName0", testedObject.getUserName()); // jtest_unverified
		assertEquals("password0", testedObject.getPassword()); // jtest_unverified
		assertEquals("contextPath0", testedObject.getContextPath()); // jtest_unverified
		assertEquals("targetPath0", testedObject.getTargetPath()); // jtest_unverified
		assertEquals("tagDB0", testedObject.getTagDB()); // jtest_unverified
		assertEquals("dbcScriptName0", testedObject.getDbcScriptName()); // jtest_unverified
		assertEquals("xmlScripts0", testedObject.getXmlScripts()); // jtest_unverified
		assertEquals("importReports0", testedObject.getImportReports()); // jtest_unverified
		assertEquals(null, testedObject.getPublishForm()); // jtest_unverified
		assertEquals("profilePath0", testedObject.getProfilePath()); // jtest_unverified
		assertEquals(null, testedObject.getCtlMigration()); // jtest_unverified
		assertEquals(null, testedObject.getOaMedia()); // jtest_unverified
		assertEquals(null, testedObject.getSqlDeploy()); // jtest_unverified
		assertEquals(null, testedObject.getDatExport()); // jtest_unverified
		assertEquals(null, testedObject.getDatImport()); // jtest_unverified
		assertEquals(null, testedObject.getDdlSync()); // jtest_unverified
		assertEquals("propertyFile0", testedObject.getPropertyFile()); // jtest_unverified
		assertEquals(null, testedObject.getAolScript()); // jtest_unverified
		assertEquals("barFile0", testedObject.getBarFile()); // jtest_unverified
		assertEquals("buildType0", testedObject.getBuildType()); // jtest_unverified
		assertEquals("avdName0", testedObject.getAvdName()); // jtest_unverified
		assertEquals("sourcePath0", testedObject.getSourcePath()); // jtest_unverified
		assertEquals("narOS0", testedObject.getNarOS()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method DeployToContainer().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see DeployToContainer#DeployToContainer()
	 * 
	 * 
	 */
	@Test
	public void testDeployToContainer13() throws Throwable {
		DeployToContainer testedObject = new DeployToContainer();
		assertEquals(null, testedObject.getHostName()); // jtest_unverified
		assertEquals(null, testedObject.getPort()); // jtest_unverified
		assertEquals(null, testedObject.getScript()); // jtest_unverified
		assertEquals(null, testedObject.getSqlFilesAndPackages()); // jtest_unverified
		assertEquals(null, testedObject.getTargetNodeName()); // jtest_unverified
		assertEquals(null, testedObject.getWorkflowMigration()); // jtest_unverified
		assertEquals(null, testedObject.getDeployedFolder()); // jtest_unverified
		assertEquals(null, testedObject.getServerManagerURL()); // jtest_unverified
		assertEquals(null, testedObject.getReportMigration()); // jtest_unverified
		assertEquals(null, testedObject.getResourceToBeDeployed()); // jtest_unverified
		assertEquals(null, testedObject.getTargetServerName()); // jtest_unverified
		assertEquals(null, testedObject.getDbOwnerPassword()); // jtest_unverified
		assertEquals(null, testedObject.getDerivedDataPath()); // jtest_unverified
		assertEquals(null, testedObject.getAutomationScript()); // jtest_unverified
		assertEquals(null, testedObject.getAdmWorkflowServer()); // jtest_unverified
		assertEquals(null, testedObject.getRollbackStrategy()); // jtest_unverified
		assertEquals(null, testedObject.getTargetCellName()); // jtest_unverified
		assertEquals(null, testedObject.getApplicationName()); // jtest_unverified
		assertEquals(null, testedObject.getAdmin()); // jtest_unverified
		assertEquals(null, testedObject.getWarPath()); // jtest_unverified
		assertEquals(null, testedObject.getSrfServer()); // jtest_unverified
		assertEquals(null, testedObject.getStaticFiles()); // jtest_unverified
		assertEquals(null, testedObject.getTestRollback()); // jtest_unverified
		assertEquals(null, testedObject.getTagName()); // jtest_unverified
		assertEquals(null, testedObject.getScriptPath()); // jtest_unverified
		assertEquals(null, testedObject.getContainerName()); // jtest_unverified
		assertEquals(null, testedObject.getLogFilePath()); // jtest_unverified
		assertEquals(null, testedObject.getSshPassword()); // jtest_unverified
		assertEquals(null, testedObject.getDbOwner()); // jtest_unverified
		assertEquals(null, testedObject.getSshExecution()); // jtest_unverified
		assertEquals(null, testedObject.getSshId()); // jtest_unverified
		assertEquals(null, testedObject.getUpdateDB()); // jtest_unverified
		assertEquals(null, testedObject.getPlatform()); // jtest_unverified
		assertEquals(null, testedObject.getHrs()); // jtest_unverified
		assertEquals(null, testedObject.getIpOrDNS()); // jtest_unverified
		assertEquals(null, testedObject.getApprover()); // jtest_unverified
		assertEquals(null, testedObject.getRollBackDB()); // jtest_unverified
		assertEquals(null, testedObject.getAdminPassword()); // jtest_unverified
		assertEquals(null, testedObject.getMqManager()); // jtest_unverified
		assertEquals(null, testedObject.getDomain()); // jtest_unverified
		assertEquals(null, testedObject.getUserName()); // jtest_unverified
		assertEquals(null, testedObject.getPassword()); // jtest_unverified
		assertEquals(null, testedObject.getContextPath()); // jtest_unverified
		assertEquals(null, testedObject.getTargetPath()); // jtest_unverified
		assertEquals(null, testedObject.getTagDB()); // jtest_unverified
		assertEquals(null, testedObject.getDbcScriptName()); // jtest_unverified
		assertEquals(null, testedObject.getXmlScripts()); // jtest_unverified
		assertEquals(null, testedObject.getImportReports()); // jtest_unverified
		assertEquals(null, testedObject.getPublishForm()); // jtest_unverified
		assertEquals(null, testedObject.getProfilePath()); // jtest_unverified
		assertEquals(null, testedObject.getCtlMigration()); // jtest_unverified
		assertEquals(null, testedObject.getOaMedia()); // jtest_unverified
		assertEquals(null, testedObject.getSqlDeploy()); // jtest_unverified
		assertEquals(null, testedObject.getDatExport()); // jtest_unverified
		assertEquals(null, testedObject.getDatImport()); // jtest_unverified
		assertEquals(null, testedObject.getDdlSync()); // jtest_unverified
		assertEquals(null, testedObject.getPropertyFile()); // jtest_unverified
		assertEquals(null, testedObject.getAolScript()); // jtest_unverified
		assertEquals(null, testedObject.getBarFile()); // jtest_unverified
		assertEquals(null, testedObject.getBuildType()); // jtest_unverified
		assertEquals(null, testedObject.getAvdName()); // jtest_unverified
		assertEquals(null, testedObject.getSourcePath()); // jtest_unverified
		assertEquals(null, testedObject.getNarOS()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
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

	}

	/**
	 * Used to clean up after the test. This method is called by JUnit after each of
	 * the tests have been completed.
	 * 
	 * 
	 */
	@After
	public void tearDown() throws Exception {
		/*
		 * Add any necessary cleanup code here (e.g., close a socket).
		 */
		super.tearDown();
	}

	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java DeployToContainerTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.deployInfo.DeployToContainerTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return DeployToContainer.class;
	}
}
// JTEST_CURRENT_ID=1306732295.