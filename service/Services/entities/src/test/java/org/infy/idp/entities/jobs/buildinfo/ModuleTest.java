/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.buildinfo;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.jobs.buildinfo.Module;
import org.infy.idp.entities.jobs.common.AbortScript;
import org.infy.idp.entities.jobs.common.Proxy;
import org.infy.idp.entities.jobs.common.RunScript;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ModuleTest is a test class for Module
 *
 * @see org.infy.idp.entities.jobs.buildinfo.Module
 * 
 */
public class ModuleTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public ModuleTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method Module().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Module#Module()
	 * 
	 * 
	 */
	@Test
	public void testModule0() throws Throwable {
		Module testedObject = new Module();
		testedObject.setExcludeFolders("excludeFolders22");
		testedObject.setInstallGrunt("installGrunt22");
		testedObject.setMultiModule("multiModule22");
		testedObject.setExclude("exclude22");
		testedObject.setIncrementalScan("incrementalScan22");
		testedObject.setInterval("interval22");
		testedObject.setTeam("team22");
		testedObject.setPreset("preset22");
		testedObject.setServerUrl("serverUrl22");
		testedObject.setCheckmarxProjName("checkmarxProjName22");
		testedObject.setUnitTestDir("unitTestDir22");
		testedObject.setPafFilePath("pafFilePath22");
		testedObject.setOssMailRecipients("mailRecipients22");
		testedObject.setOssDistributionType("distributionType22");
		testedObject.setNexusType("analysisType22");
		testedObject.setRenaming("renaming22");
		testedObject.setControlFlow("controlFlow22");
		testedObject.setEncryption("encryption22");

		testedObject.setAppPort("app_port22");
		testedObject.setAppServ("app_server_domain22");
		testedObject.setArchName("arch_name22");
		testedObject.setBuildproperties("buildproperties_path22");
		testedObject.setCodeAna("code_analysis22");
		testedObject.setCodeAnalysisTarget("codeAnalysisTarget22");
		testedObject.setDllName("dllName");
		testedObject.setFixPath("fixPath");
		testedObject.setSonarUrl("sonar_url");
		testedObject.setSonarPassword("sonar_password");
		testedObject.setSonarUserName("sonar_user");
		testedObject.setSrcSchName("srcSchName");
		testedObject.setTarSchName("tarSchName");
		testedObject.setUnitTestingTarget("unitTestingTarget");
		
		testedObject.setUiEarFileName("uiEarFileName22");
		testedObject.setIntegrationFileName("integrationFileName22");
		List reportMigration = new ArrayList();
		testedObject.setReportMigration(reportMigration);
		List publishForms = new ArrayList();
		testedObject.setPublishForms(publishForms);
		List hostCTLMigration = new ArrayList();
		testedObject.setHostCTLMigration(hostCTLMigration);
		List oaFileMigration = new ArrayList();
		testedObject.setOaFileMigration(oaFileMigration);
		List workFlowPublish = new ArrayList();
		testedObject.setWorkFlowPublish(workFlowPublish);
		testedObject.setDbType("dbType22");
		testedObject.setProjectName("projectName22");
		testedObject.setCodeFormatting("codeFormatting22");
		testedObject.setCustomScript("customScript22");
		testedObject.setBuildType("buildType22");
		testedObject.setTransfer("transfer22");
		testedObject.setHostName("hostName22");
		testedObject.setUserName("userName22");
		testedObject.setPassword("password22");
		testedObject.setExecute("execute22");
		testedObject.setLocalmachineExecution("localmachineExecution22");
		testedObject.setDependencyFile("dependencyFile22");
		testedObject.setMasterMachineName("masterMachineName22");
		testedObject.setClassFileName("classFileName22");
		testedObject.setOutputFolder("outputFolder22");
		testedObject.setVersion("version22");
		testedObject.setCodeAnalysisTragets("codeAnalysisTragets22");
		testedObject.setUnitTestTargets("unitTestTargets22");
		testedObject.setSecurityProjName("securityProjName22");
		testedObject.setAvdName("avdName22");
		testedObject.setEnvName("envName22");
		testedObject.setDbName("dbName22");
		// Integer port = new Integer(-2147483648);
		String port = "-2147483648";
		testedObject.setPort(port.toString());
		testedObject.setProductKey("productKey22");
		testedObject.setMessageFlows("messageFlows22");
		testedObject.setNexusType("nexusType22");
		testedObject.setNexusUrl("nexusUrl22");
		testedObject.setHome("home22");
		testedObject.setThirdPartyJar("thirdPartyJar22");
		testedObject.setCdtIn("cdtIn22");
		testedObject.setCdtOut("cdtOut22");
		testedObject.setDestDB("destDB22");
		testedObject.setDestPassword("destPassword22");
		testedObject.setRepository("repository22");
		RunScript runScript = new RunScript();
		testedObject.setRunScript(runScript);
		testedObject.setmVNOPTS("mVNOPTS43");
		testedObject.setJsonPath("jsonPath22");
		testedObject.setGroupId("groupId22");
		testedObject.setModuleName("moduleName22");
		testedObject.setRelativePath("relativePath22");
		testedObject.setSecurityAnalysis("securityAnalysis22");
		List codeAnalysis = new ArrayList();
		testedObject.setCodeAnalysis(codeAnalysis);
		testedObject.setUnitTesting("unitTesting22");
		testedObject.setUnitTestProjectName("unitTestProjectName22");
		testedObject.setUnitTestCategory("unitTestCategory22");
		testedObject.setCodeCoverage("codeCoverage22");
		testedObject.setTestSettingFilePath("testSettingFilePath22");
		testedObject.setServerMachine("serverMachine22");
		testedObject.setCustomBuildXml("customBuildXml22");
		testedObject.setArgs("args22");
		testedObject.setCompile("compile22");
		testedObject.setJarPackaging("jarPackaging22");
		testedObject.setEjbDescriptor("ejbDescriptor22");
		testedObject.setJavaMainClass("javaMainClass22");
		testedObject.setWarPackaging("warPackaging22");
		testedObject.setGlobalGoals("globalGoals22");
		testedObject.setClean("clean22");
		testedObject.setInstall("install22");
		testedObject.setmVNOPTS("mVNOPTS44");
		testedObject.setAuthenticationMode("authenticationMode");
		testedObject.setRollbackScript("rollbackScript");
		testedObject.setAllUnitTestPass("allUnitTestPass");
		testedObject.setNoViolations("noViolations");
		testedObject.setNpmProxy("npmProxy");
		List<String> unitTestTool = new ArrayList<String>();
		testedObject.setUnitTestTool(unitTestTool);
		List<String> codeCoverageTool = new ArrayList<String>();
		testedObject.setCodeCoverageTool(codeCoverageTool);
		testedObject.setBuildValue("buildValue");
		testedObject.setRemoteDir("remoteDir");
		testedObject.setPrivateKey("privateKey");
		testedObject.setReport("report");
		Proxy proxy = new Proxy();
		proxy.setEnabled("enabled");
		proxy.setHost("host");
		proxy.setPassword("pwd");
		proxy.setPort("8085");
		proxy.setUsername("ciplatform");

		testedObject.setProxy(proxy);
		testedObject.setServMachine("machine");
		testedObject.setPigProjectName("pig");
		testedObject.setPigPomPath("pom.xml");
		testedObject.setPigUT("ut");
		testedObject.setHiveProjectPath("hive");
		AbortScript abortScript = new AbortScript();
		abortScript.setArchiveLogs("**/*.*");
		abortScript.setFlattenFilePath("**/*.*");
		testedObject.setAbortScript(abortScript);
		testedObject.setHivePomPath("pom.xml");
		testedObject.setHiveUT("ut");
		testedObject.setScalaProjectName("scala");
		testedObject.setScalaPomPath("pom.xml");
		testedObject.setScalaCC("cc");
		testedObject.setFolder("folder");
		testedObject.setFilePath("path");
		testedObject.setToolsRoot("root");
		testedObject.setToolsCfg("cfg");
		testedObject.setDataSource("source");
		testedObject.setSiebelUserName("ciplatform");
		testedObject.setSiebelPassword("infy1234+");
		testedObject.setSiebelRepo("repo");
		testedObject.setSifImport("import");
		testedObject.setSibcompile("compile");
		testedObject.setDefaultModule("module");
		testedObject.setSqlFilesPackage("sql");
		testedObject.setConnectionName("conn");
		testedObject.setTestSuite("suite");
		testedObject.setNpmProxyUserName("admin");
		testedObject.setNpmProxyPassword("admin123");
		testedObject.setSourceRepo("repo");
		testedObject.setAngularBuildCommand("ng");
		testedObject.setSourceFolder("folder");
		testedObject.setTargetFolder("target");
		testedObject.setTargetFolderShared("folder");
		testedObject.setExportObjSharedXml("xml");
		testedObject.setExportObjXml("xml");
		testedObject.setDatabase("database");
		testedObject.setVarient("var");
		testedObject.setInspectionName("inspection");
		testedObject.setBuildTool("angular");
		testedObject.setOssAnalysisType("analysisType22");
		testedObject.setSourceFolderShared("shared");
		testedObject.setTargetRepo("repo");
		testedObject.setIpcHostName("host");
		testedObject.setIpcPassword("pwd");
		testedObject.setIpcUserName("admin");
		testedObject.setLogFilePath("log");
		testedObject.setSourceUsername("ciplatform");
		testedObject.setSourcePassword("infy1234+");
		testedObject.setSourceUrl("url");
		testedObject.setTimeout("timeout");
		assertEquals(proxy, testedObject.getProxy());
		assertEquals("serverMachine22", testedObject.getServerMachine());
		assertEquals("pig", testedObject.getPigProjectName());
		assertEquals("pom.xml", testedObject.getPigPomPath());
		
		
		
		assertEquals("app_port22",testedObject.getAppPort());
		assertEquals("app_server_domain22",testedObject.getAppServ());
		assertEquals("arch_name22",testedObject.getArchName());
		assertEquals("buildproperties_path22",testedObject.getBuildproperties());
		assertEquals("code_analysis22",testedObject.getCodeAna());
		assertEquals("codeAnalysisTarget22",testedObject.getCodeAnalysisTarget());
		assertEquals("dllName",testedObject.getDllName());
		assertEquals("fixPath",testedObject.getFixPath());
		assertEquals("sonar_url",testedObject.getSonarUrl());
		assertEquals("sonar_password",testedObject.getSonarPassword());
		assertEquals("sonar_user",testedObject.getSonarUserName());
		assertEquals("srcSchName",testedObject.getSrcSchName());
		assertEquals("tarSchName",testedObject.getTarSchName());
		assertEquals("unitTestingTarget",testedObject.getUnitTestingTarget());
		/////////////////////////////////
		assertEquals("ut", testedObject.getPigUT());
		assertEquals("hive", testedObject.getHiveProjectPath());
		assertEquals("pom.xml", testedObject.getHivePomPath());
		assertEquals(abortScript, testedObject.getAbortScript());
		assertEquals("scala", testedObject.getScalaProjectName());
		assertEquals("pom.xml", testedObject.getScalaPomPath());
		assertEquals("cc", testedObject.getScalaCC());
		assertEquals("folder", testedObject.getFolder());
		assertEquals("path", testedObject.getFilePath());
		assertEquals("root", testedObject.getToolsRoot());
		assertEquals("cfg", testedObject.getToolsCfg());
		assertEquals("source", testedObject.getDataSource());
		assertEquals("ut", testedObject.getHiveUT());
		assertEquals("machine", testedObject.getServMachine());

		assertEquals("ciplatform", testedObject.getSiebelUserName());
		assertEquals("infy1234+", testedObject.getSiebelPassword());
		assertEquals("repo", testedObject.getSiebelRepo());
		assertEquals("import", testedObject.getSifImport());
		assertEquals("compile", testedObject.getSibcompile());
		assertEquals("module", testedObject.getDefaultModule());
		assertEquals("sql", testedObject.getSqlFilesPackage());
		assertEquals("conn", testedObject.getConnectionName());
		assertEquals("suite", testedObject.getTestSuite());
		assertEquals("admin", testedObject.getNpmProxyUserName());
		assertEquals("admin123", testedObject.getNpmProxyPassword());
		assertEquals("repo", testedObject.getSourceRepo());

		assertEquals("ng", testedObject.getAngularBuildCommand());
		assertEquals("folder", testedObject.getSourceFolder());
		assertEquals("folder", testedObject.getTargetFolderShared());
		assertEquals("target", testedObject.getTargetFolder());
		assertEquals("xml", testedObject.getExportObjSharedXml());
		assertEquals("xml", testedObject.getExportObjXml());
		assertEquals("database", testedObject.getDatabase());
		assertEquals("var", testedObject.getVarient());
		assertEquals("inspection", testedObject.getInspectionName());
		assertEquals("angular", testedObject.getBuildTool());
		assertEquals("shared", testedObject.getSourceFolderShared());
		assertEquals("repo", testedObject.getTargetRepo());

		assertEquals("host", testedObject.getIpcHostName());
		assertEquals("pwd", testedObject.getIpcPassword());
		assertEquals("admin", testedObject.getIpcUserName());
		assertEquals("log", testedObject.getLogFilePath());
		assertEquals("ciplatform", testedObject.getSourceUsername());
		assertEquals("infy1234+", testedObject.getSourcePassword());
		assertEquals("url", testedObject.getSourceUrl());
		assertEquals("timeout", testedObject.getTimeout());

		assertEquals("authenticationMode", testedObject.getAuthenticationMode());
		assertEquals("rollbackScript", testedObject.getRollbackScript());
		assertEquals("allUnitTestPass", testedObject.getAllUnitTestPass());
		assertEquals("noViolations", testedObject.getNoViolations());
		assertEquals("npmProxy", testedObject.getNpmProxy());
		assertEquals(unitTestTool, testedObject.getUnitTestTool());
		assertEquals(codeCoverageTool, testedObject.getCodeCoverageTool());
		assertEquals("buildValue", testedObject.getBuildValue());
		assertEquals("remoteDir", testedObject.getRemoteDir());
		assertEquals("privateKey", testedObject.getPrivateKey());
		assertEquals("report", testedObject.getReport());

		assertEquals("hostName22", testedObject.getHostName()); // jtest_unverified
		assertEquals(port, testedObject.getPort()); // jtest_unverified
		assertEquals("installGrunt22", testedObject.getInstallGrunt()); // jtest_unverified
		assertEquals("multiModule22", testedObject.getMultiModule()); // jtest_unverified
		assertEquals("exclude22", testedObject.getExclude()); // jtest_unverified
		assertEquals("interval22", testedObject.getInterval()); // jtest_unverified
		assertEquals("team22", testedObject.getTeam()); // jtest_unverified
		assertEquals("preset22", testedObject.getPreset()); // jtest_unverified
		assertEquals("serverUrl22", testedObject.getServerUrl()); // jtest_unverified
		assertEquals("unitTestDir22", testedObject.getUnitTestDir()); // jtest_unverified
		assertEquals("pafFilePath22", testedObject.getPafFilePath()); // jtest_unverified
		assertEquals("analysisType22", testedObject.getOssAnalysisType()); // jtest_unverified
		assertEquals("messageFlows22", testedObject.getMessageFlows()); // jtest_unverified
		assertEquals("install22", testedObject.getInstall()); // jtest_unverified
		assertEquals("relativePath22", testedObject.getRelativePath()); // jtest_unverified
		assertEquals("avdName22", testedObject.getAvdName()); // jtest_unverified
		assertEquals("destDB22", testedObject.getDestDB()); // jtest_unverified
		assertEquals("mVNOPTS44", testedObject.getmVNOPTS()); // jtest_unverified
		assertEquals("codeCoverage22", testedObject.getCodeCoverage()); // jtest_unverified
		assertEquals("warPackaging22", testedObject.getWarPackaging()); // jtest_unverified
		assertEquals("cdtOut22", testedObject.getCdtOut()); // jtest_unverified
		
		assertEquals(reportMigration, testedObject.getPublishForms()); // jtest_unverified
		assertEquals("execute22", testedObject.getExecute()); // jtest_unverified
		assertEquals("repository22", testedObject.getRepository()); // jtest_unverified
		assertEquals("ejbDescriptor22", testedObject.getEjbDescriptor()); // jtest_unverified
		assertEquals("dbName22", testedObject.getDbName()); // jtest_unverified
		assertEquals("transfer22", testedObject.getTransfer()); // jtest_unverified
		assertEquals("moduleName22", testedObject.getModuleName()); // jtest_unverified
		assertEquals("outputFolder22", testedObject.getOutputFolder()); // jtest_unverified
		assertEquals("jarPackaging22", testedObject.getJarPackaging()); // jtest_unverified
		assertEquals("mVNOPTS44", testedObject.getmVNOPTS()); // jtest_unverified
		assertEquals("home22", testedObject.getHome()); // jtest_unverified
		assertEquals("args22", testedObject.getArgs()); // jtest_unverified
		assertEquals("globalGoals22", testedObject.getGlobalGoals()); // jtest_unverified
		assertEquals(runScript, testedObject.getRunScript()); // jtest_unverified
		assertEquals("groupId22", testedObject.getGroupId()); // jtest_unverified
		assertEquals("customScript22", testedObject.getCustomScript()); // jtest_unverified
		assertEquals("buildType22", testedObject.getBuildType()); // jtest_unverified
		assertEquals("javaMainClass22", testedObject.getJavaMainClass()); // jtest_unverified
		assertEquals("projectName22", testedObject.getProjectName()); // jtest_unverified
		assertEquals("thirdPartyJar22", testedObject.getThirdPartyJar()); // jtest_unverified
		assertEquals("jsonPath22", testedObject.getJsonPath()); // jtest_unverified
		assertEquals("nexusUrl22", testedObject.getNexusUrl()); // jtest_unverified
		assertEquals("password22", testedObject.getPassword()); // jtest_unverified
		assertEquals("controlFlow22", testedObject.getControlFlow()); // jtest_unverified
		assertEquals("dbType22", testedObject.getDbType()); // jtest_unverified
		assertEquals("uiEarFileName22", testedObject.getUiEarFileName()); // jtest_unverified
		assertEquals("envName22", testedObject.getEnvName()); // jtest_unverified
		assertEquals("productKey22", testedObject.getProductKey()); // jtest_unverified
		assertEquals("renaming22", testedObject.getRenaming()); // jtest_unverified
		assertEquals("nexusType22", testedObject.getNexusType()); // jtest_unverified
		assertEquals("userName22", testedObject.getUserName()); // jtest_unverified
		assertEquals("cdtIn22", testedObject.getCdtIn()); // jtest_unverified
		assertEquals("classFileName22", testedObject.getClassFileName()); // jtest_unverified
		assertEquals("destPassword22", testedObject.getDestPassword()); // jtest_unverified
		assertEquals(reportMigration, testedObject.getCodeAnalysis()); // jtest_unverified
		assertEquals("unitTesting22", testedObject.getUnitTesting()); // jtest_unverified
		assertEquals("serverMachine22", testedObject.getServerMachine()); // jtest_unverified
		assertEquals("version22", testedObject.getVersion()); // jtest_unverified
		assertEquals("compile22", testedObject.getCompile()); // jtest_unverified
		assertEquals("clean22", testedObject.getClean()); // jtest_unverified
		assertEquals("encryption22", testedObject.getEncryption()); // jtest_unverified
		assertEquals(reportMigration, testedObject.getHostCTLMigration()); // jtest_unverified
		assertEquals("codeFormatting22", testedObject.getCodeFormatting()); // jtest_unverified
		assertEquals("codeAnalysisTragets22", testedObject.getCodeAnalysisTargets()); // jtest_unverified
		assertEquals("unitTestTargets22", testedObject.getUnitTestTargets()); // jtest_unverified
		assertEquals(reportMigration, testedObject.getWorkFlowPublish()); // jtest_unverified
		assertEquals("customBuildXml22", testedObject.getCustomBuildXml()); // jtest_unverified
		assertEquals(reportMigration, testedObject.getOaFileMigration()); // jtest_unverified
		assertEquals("masterMachineName22", testedObject.getMasterMachineName()); // jtest_unverified
		assertEquals("securityProjName22", testedObject.getSecurityProjName()); // jtest_unverified
		assertEquals("unitTestCategory22", testedObject.getUnitTestCategory()); // jtest_unverified
		assertEquals("testSettingFilePath22", testedObject.getTestSettingFilePath()); // jtest_unverified
		assertEquals("dependencyFile22", testedObject.getDependencyFile()); // jtest_unverified
		assertEquals("unitTestProjectName22", testedObject.getUnitTestProjectName()); // jtest_unverified
		assertEquals("localmachineExecution22", testedObject.getLocalmachineExecution()); // jtest_unverified
		assertEquals(reportMigration, testedObject.getReportMigration()); // jtest_unverified
		assertEquals("securityAnalysis22", testedObject.getSecurityAnalysis()); // jtest_unverified
		assertEquals("mailRecipients22", testedObject.getOssMailRecipients()); // jtest_unverified
		assertEquals("distributionType22", testedObject.getOssDistributionType()); // jtest_unverified
		assertEquals("checkmarxProjName22", testedObject.getCheckmarxProjName()); // jtest_unverified
		assertEquals("integrationFileName22", testedObject.getIntegrationFileName()); // jtest_unverified
		assertEquals("excludeFolders22", testedObject.getExcludeFolders()); // jtest_unverified
		assertEquals("incrementalScan22", testedObject.getIncrementalScan()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method Module().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Module#Module()
	 * 
	 * 
	 */
	@Test
	public void testModule11() throws Throwable {
		Module testedObject = new Module();
		testedObject.setExcludeFolders("excludeFolders1");
		testedObject.setInstallGrunt("installGrunt1");
		testedObject.setMultiModule("multiModule1");
		testedObject.setExclude("exclude1");
		testedObject.setIncrementalScan("incrementalScan1");
		testedObject.setInterval("interval1");
		testedObject.setTeam("team1");
		testedObject.setPreset("preset1");
		testedObject.setServerUrl("serverUrl1");
		testedObject.setCheckmarxProjName("checkmarxProjName1");
		testedObject.setUnitTestDir("unitTestDir1");
		testedObject.setPafFilePath("pafFilePath1");
		testedObject.setOssMailRecipients("mailRecipients1");
		testedObject.setOssDistributionType("distributionType1");
		testedObject.setNexusType("analysisType1");
		testedObject.setRenaming("renaming1");
		testedObject.setControlFlow("controlFlow1");
		testedObject.setEncryption("encryption1");
		/*
		 * Remove Jira ALM testedObject.setRaiseJiraBug("raiseJiraBug1");
		 */
		testedObject.setUiEarFileName("uiEarFileName1");
		testedObject.setIntegrationFileName("integrationFileName1");
		testedObject.setReportMigration((List) null);
		testedObject.setPublishForms((List) null);
		testedObject.setHostCTLMigration((List) null);
		testedObject.setOaFileMigration((List) null);
		testedObject.setWorkFlowPublish((List) null);
		testedObject.setDbType("dbType1");
		testedObject.setProjectName("projectName1");
		testedObject.setCodeFormatting("codeFormatting1");
		testedObject.setCustomScript("customScript1");
		testedObject.setBuildType("buildType1");
		testedObject.setTransfer("transfer1");
		testedObject.setHostName("hostName1");
		testedObject.setUserName("userName1");
		testedObject.setPassword("password1");
		testedObject.setExecute("execute1");
		testedObject.setLocalmachineExecution("localmachineExecution1");
		testedObject.setDependencyFile("dependencyFile1");
		testedObject.setMasterMachineName("masterMachineName1");
		testedObject.setClassFileName("classFileName1");
		testedObject.setOutputFolder("outputFolder1");
		testedObject.setVersion("version1");
		testedObject.setCodeAnalysisTragets("codeAnalysisTragets1");
		testedObject.setUnitTestTargets("unitTestTargets1");
		testedObject.setSecurityProjName("securityProjName1");
		testedObject.setAvdName("avdName1");
		testedObject.setEnvName("envName1");
		testedObject.setDbName("dbName1");
		testedObject.setOssAnalysisType("analysisType1");
		testedObject.setPort(null);
		testedObject.setProductKey("productKey1");
		testedObject.setMessageFlows("messageFlows1");
		testedObject.setNexusType("nexusType1");
		testedObject.setNexusUrl("nexusUrl1");
		testedObject.setHome("home1");
		testedObject.setThirdPartyJar("thirdPartyJar1");
		testedObject.setCdtIn("cdtIn1");
		testedObject.setCdtOut("cdtOut1");
		testedObject.setDestDB("destDB1");
		testedObject.setDestPassword("destPassword1");
		testedObject.setRepository("repository1");
		testedObject.setRunScript((RunScript) null);
		testedObject.setmVNOPTS("mVNOPTS1");
		testedObject.setJsonPath("jsonPath1");
		testedObject.setGroupId("groupId1");
		testedObject.setModuleName("moduleName1");
		testedObject.setRelativePath("relativePath1");
		testedObject.setSecurityAnalysis("securityAnalysis1");
		testedObject.setCodeAnalysis((List) null);
		testedObject.setUnitTesting("unitTesting1");
		testedObject.setUnitTestProjectName("unitTestProjectName1");
		testedObject.setUnitTestCategory("unitTestCategory1");
		testedObject.setCodeCoverage("codeCoverage1");
		testedObject.setTestSettingFilePath("testSettingFilePath1");
		testedObject.setServerMachine("serverMachine1");
		testedObject.setCustomBuildXml("customBuildXml1");
		testedObject.setArgs("args1");
		testedObject.setCompile("compile1");
		testedObject.setJarPackaging("jarPackaging1");
		testedObject.setEjbDescriptor("ejbDescriptor1");
		testedObject.setJavaMainClass("javaMainClass1");
		testedObject.setWarPackaging("warPackaging1");
		testedObject.setGlobalGoals("globalGoals1");
		testedObject.setClean("clean1");
		testedObject.setInstall("install1");
		testedObject.setmVNOPTS("mVNOPTS2");
		assertEquals("hostName1", testedObject.getHostName()); // jtest_unverified
		assertEquals(null, testedObject.getPort()); // jtest_unverified
		assertEquals("installGrunt1", testedObject.getInstallGrunt()); // jtest_unverified
		assertEquals("multiModule1", testedObject.getMultiModule()); // jtest_unverified
		assertEquals("exclude1", testedObject.getExclude()); // jtest_unverified
		assertEquals("interval1", testedObject.getInterval()); // jtest_unverified
		assertEquals("team1", testedObject.getTeam()); // jtest_unverified
		assertEquals("preset1", testedObject.getPreset()); // jtest_unverified
		assertEquals("serverUrl1", testedObject.getServerUrl()); // jtest_unverified
		assertEquals("unitTestDir1", testedObject.getUnitTestDir()); // jtest_unverified
		assertEquals("pafFilePath1", testedObject.getPafFilePath()); // jtest_unverified
		assertEquals("analysisType1", testedObject.getOssAnalysisType()); // jtest_unverified
		assertEquals("messageFlows1", testedObject.getMessageFlows()); // jtest_unverified
		assertEquals("install1", testedObject.getInstall()); // jtest_unverified
		assertEquals("relativePath1", testedObject.getRelativePath()); // jtest_unverified
		assertEquals("avdName1", testedObject.getAvdName()); // jtest_unverified
		assertEquals("destDB1", testedObject.getDestDB()); // jtest_unverified
		assertEquals("mVNOPTS2", testedObject.getmVNOPTS()); // jtest_unverified
		assertEquals("codeCoverage1", testedObject.getCodeCoverage()); // jtest_unverified
		assertEquals("warPackaging1", testedObject.getWarPackaging()); // jtest_unverified
		assertEquals("cdtOut1", testedObject.getCdtOut()); // jtest_unverified
		/*
		 * Remove Jira ALM assertEquals("raiseJiraBug1",
		 * testedObject.getRaiseJiraBug()); // jtest_unverified
		 */
		assertEquals(null, testedObject.getPublishForms()); // jtest_unverified
		assertEquals("execute1", testedObject.getExecute()); // jtest_unverified
		assertEquals("repository1", testedObject.getRepository()); // jtest_unverified
		assertEquals("ejbDescriptor1", testedObject.getEjbDescriptor()); // jtest_unverified
		assertEquals("dbName1", testedObject.getDbName()); // jtest_unverified
		assertEquals("transfer1", testedObject.getTransfer()); // jtest_unverified
		assertEquals("moduleName1", testedObject.getModuleName()); // jtest_unverified
		assertEquals("outputFolder1", testedObject.getOutputFolder()); // jtest_unverified
		assertEquals("jarPackaging1", testedObject.getJarPackaging()); // jtest_unverified
		assertEquals("mVNOPTS2", testedObject.getmVNOPTS()); // jtest_unverified
		assertEquals("home1", testedObject.getHome()); // jtest_unverified
		assertEquals("args1", testedObject.getArgs()); // jtest_unverified
		assertEquals("globalGoals1", testedObject.getGlobalGoals()); // jtest_unverified
		assertEquals(null, testedObject.getRunScript()); // jtest_unverified
		assertEquals("groupId1", testedObject.getGroupId()); // jtest_unverified
		assertEquals("customScript1", testedObject.getCustomScript()); // jtest_unverified
		assertEquals("buildType1", testedObject.getBuildType()); // jtest_unverified
		assertEquals("javaMainClass1", testedObject.getJavaMainClass()); // jtest_unverified
		assertEquals("projectName1", testedObject.getProjectName()); // jtest_unverified
		assertEquals("thirdPartyJar1", testedObject.getThirdPartyJar()); // jtest_unverified
		assertEquals("jsonPath1", testedObject.getJsonPath()); // jtest_unverified
		assertEquals("nexusUrl1", testedObject.getNexusUrl()); // jtest_unverified
		assertEquals("password1", testedObject.getPassword()); // jtest_unverified
		assertEquals("controlFlow1", testedObject.getControlFlow()); // jtest_unverified
		assertEquals("dbType1", testedObject.getDbType()); // jtest_unverified
		assertEquals("uiEarFileName1", testedObject.getUiEarFileName()); // jtest_unverified
		assertEquals("envName1", testedObject.getEnvName()); // jtest_unverified
		assertEquals("productKey1", testedObject.getProductKey()); // jtest_unverified
		assertEquals("renaming1", testedObject.getRenaming()); // jtest_unverified
		assertEquals("nexusType1", testedObject.getNexusType()); // jtest_unverified
		assertEquals("userName1", testedObject.getUserName()); // jtest_unverified
		assertEquals("cdtIn1", testedObject.getCdtIn()); // jtest_unverified
		assertEquals("classFileName1", testedObject.getClassFileName()); // jtest_unverified
		assertEquals("destPassword1", testedObject.getDestPassword()); // jtest_unverified
		assertEquals(null, testedObject.getCodeAnalysis()); // jtest_unverified
		assertEquals("unitTesting1", testedObject.getUnitTesting()); // jtest_unverified
		assertEquals("serverMachine1", testedObject.getServerMachine()); // jtest_unverified
		assertEquals("version1", testedObject.getVersion()); // jtest_unverified
		assertEquals("compile1", testedObject.getCompile()); // jtest_unverified
		assertEquals("clean1", testedObject.getClean()); // jtest_unverified
		assertEquals("encryption1", testedObject.getEncryption()); // jtest_unverified
		assertEquals(null, testedObject.getHostCTLMigration()); // jtest_unverified
		assertEquals("codeFormatting1", testedObject.getCodeFormatting()); // jtest_unverified
		assertEquals("codeAnalysisTragets1", testedObject.getCodeAnalysisTargets()); // jtest_unverified
		assertEquals("unitTestTargets1", testedObject.getUnitTestTargets()); // jtest_unverified
		assertEquals(null, testedObject.getWorkFlowPublish()); // jtest_unverified
		assertEquals("customBuildXml1", testedObject.getCustomBuildXml()); // jtest_unverified
		assertEquals(null, testedObject.getOaFileMigration()); // jtest_unverified
		assertEquals("masterMachineName1", testedObject.getMasterMachineName()); // jtest_unverified
		assertEquals("securityProjName1", testedObject.getSecurityProjName()); // jtest_unverified
		assertEquals("unitTestCategory1", testedObject.getUnitTestCategory()); // jtest_unverified
		assertEquals("testSettingFilePath1", testedObject.getTestSettingFilePath()); // jtest_unverified
		assertEquals("dependencyFile1", testedObject.getDependencyFile()); // jtest_unverified
		assertEquals("unitTestProjectName1", testedObject.getUnitTestProjectName()); // jtest_unverified
		assertEquals("localmachineExecution1", testedObject.getLocalmachineExecution()); // jtest_unverified
		assertEquals(null, testedObject.getReportMigration()); // jtest_unverified
		assertEquals("securityAnalysis1", testedObject.getSecurityAnalysis()); // jtest_unverified
		assertEquals("mailRecipients1", testedObject.getOssMailRecipients()); // jtest_unverified
		assertEquals("distributionType1", testedObject.getOssDistributionType()); // jtest_unverified
		assertEquals("checkmarxProjName1", testedObject.getCheckmarxProjName()); // jtest_unverified
		assertEquals("integrationFileName1", testedObject.getIntegrationFileName()); // jtest_unverified
		assertEquals("excludeFolders1", testedObject.getExcludeFolders()); // jtest_unverified
		assertEquals("incrementalScan1", testedObject.getIncrementalScan()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method Module().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Module#Module()
	 * 
	 * 
	 */
	@Test
	public void testModule12() throws Throwable {
		Module testedObject = new Module();
		testedObject.setExcludeFolders("excludeFolders0");
		testedObject.setInstallGrunt("installGrunt0");
		testedObject.setMultiModule("multiModule0");
		testedObject.setExclude("exclude0");
		testedObject.setIncrementalScan("incrementalScan0");
		testedObject.setInterval("interval0");
		testedObject.setTeam("team0");
		testedObject.setPreset("preset0");
		testedObject.setServerUrl("serverUrl0");
		testedObject.setCheckmarxProjName("checkmarxProjName0");
		testedObject.setUnitTestDir("unitTestDir0");
		testedObject.setPafFilePath("pafFilePath0");
		testedObject.setOssMailRecipients("mailRecipients0");
		testedObject.setOssDistributionType("distributionType0");
		testedObject.setNexusType("analysisType0");
		testedObject.setRenaming("renaming0");
		testedObject.setControlFlow("controlFlow0");
		testedObject.setEncryption("encryption0");
		/*
		 * Remove Jira ALM testedObject.setRaiseJiraBug("raiseJiraBug0");
		 */
		testedObject.setUiEarFileName("uiEarFileName0");
		testedObject.setIntegrationFileName("integrationFileName0");
		testedObject.setReportMigration((List) null);
		testedObject.setPublishForms((List) null);
		testedObject.setHostCTLMigration((List) null);
		testedObject.setOaFileMigration((List) null);
		testedObject.setWorkFlowPublish((List) null);
		testedObject.setDbType("dbType0");
		testedObject.setProjectName("projectName0");
		testedObject.setCodeFormatting("codeFormatting0");
		testedObject.setCustomScript("customScript0");
		testedObject.setBuildType("buildType0");
		testedObject.setTransfer("transfer0");
		testedObject.setHostName("hostName0");
		testedObject.setUserName("userName0");
		testedObject.setPassword("password0");
		testedObject.setExecute("execute0");
		testedObject.setLocalmachineExecution("localmachineExecution0");
		testedObject.setDependencyFile("dependencyFile0");
		testedObject.setMasterMachineName("masterMachineName0");
		testedObject.setClassFileName("classFileName0");
		testedObject.setOutputFolder("outputFolder0");
		testedObject.setVersion("version0");
		testedObject.setCodeAnalysisTragets("codeAnalysisTragets0");
		testedObject.setUnitTestTargets("unitTestTargets0");
		testedObject.setSecurityProjName("securityProjName0");
		testedObject.setAvdName("avdName0");
		testedObject.setEnvName("envName0");
		testedObject.setDbName("dbName0");
		testedObject.setPort(null);
		testedObject.setProductKey("productKey0");
		testedObject.setMessageFlows("messageFlows0");
		testedObject.setNexusType("nexusType0");
		testedObject.setNexusUrl("nexusUrl0");
		testedObject.setHome("home0");
		testedObject.setThirdPartyJar("thirdPartyJar0");
		testedObject.setCdtIn("cdtIn0");
		testedObject.setCdtOut("cdtOut0");
		testedObject.setDestDB("destDB0");
		testedObject.setDestPassword("destPassword0");
		testedObject.setRepository("repository0");
		testedObject.setRunScript((RunScript) null);
		testedObject.setmVNOPTS("mVNOPTS0");
		testedObject.setJsonPath("jsonPath0");
		testedObject.setGroupId("groupId0");
		testedObject.setModuleName("moduleName0");
		testedObject.setRelativePath("relativePath0");
		testedObject.setSecurityAnalysis("securityAnalysis0");
		testedObject.setCodeAnalysis((List) null);
		testedObject.setUnitTesting("unitTesting0");
		testedObject.setUnitTestProjectName("unitTestProjectName0");
		testedObject.setUnitTestCategory("unitTestCategory0");
		testedObject.setCodeCoverage("codeCoverage0");
		testedObject.setTestSettingFilePath("testSettingFilePath0");
		testedObject.setServerMachine("serverMachine0");
		testedObject.setCustomBuildXml("customBuildXml0");
		testedObject.setArgs("args0");
		testedObject.setCompile("compile0");
		testedObject.setOssAnalysisType("analysisType0");
		testedObject.setJarPackaging("jarPackaging0");
		testedObject.setEjbDescriptor("ejbDescriptor0");
		testedObject.setJavaMainClass("javaMainClass0");
		testedObject.setWarPackaging("warPackaging0");
		testedObject.setGlobalGoals("globalGoals0");
		testedObject.setClean("clean0");
		testedObject.setInstall("install0");
		testedObject.setmVNOPTS((String) null);
		assertEquals("hostName0", testedObject.getHostName()); // jtest_unverified
		assertEquals(null, testedObject.getPort()); // jtest_unverified
		assertEquals("installGrunt0", testedObject.getInstallGrunt()); // jtest_unverified
		assertEquals("multiModule0", testedObject.getMultiModule()); // jtest_unverified
		assertEquals("exclude0", testedObject.getExclude()); // jtest_unverified
		assertEquals("interval0", testedObject.getInterval()); // jtest_unverified
		assertEquals("team0", testedObject.getTeam()); // jtest_unverified
		assertEquals("preset0", testedObject.getPreset()); // jtest_unverified
		assertEquals("serverUrl0", testedObject.getServerUrl()); // jtest_unverified
		assertEquals("unitTestDir0", testedObject.getUnitTestDir()); // jtest_unverified
		assertEquals("pafFilePath0", testedObject.getPafFilePath()); // jtest_unverified
		assertEquals("analysisType0", testedObject.getOssAnalysisType()); // jtest_unverified
		assertEquals("messageFlows0", testedObject.getMessageFlows()); // jtest_unverified
		assertEquals("install0", testedObject.getInstall()); // jtest_unverified
		assertEquals("relativePath0", testedObject.getRelativePath()); // jtest_unverified
		assertEquals("avdName0", testedObject.getAvdName()); // jtest_unverified
		assertEquals("destDB0", testedObject.getDestDB()); // jtest_unverified
		assertEquals(null, testedObject.getmVNOPTS()); // jtest_unverified
		assertEquals("codeCoverage0", testedObject.getCodeCoverage()); // jtest_unverified
		assertEquals("warPackaging0", testedObject.getWarPackaging()); // jtest_unverified
		assertEquals("cdtOut0", testedObject.getCdtOut()); // jtest_unverified
		/*
		 * Remove Jira ALM assertEquals("raiseJiraBug0",
		 * testedObject.getRaiseJiraBug()); // jtest_unverified
		 */
		assertEquals(null, testedObject.getPublishForms()); // jtest_unverified
		assertEquals("execute0", testedObject.getExecute()); // jtest_unverified
		assertEquals("repository0", testedObject.getRepository()); // jtest_unverified
		assertEquals("ejbDescriptor0", testedObject.getEjbDescriptor()); // jtest_unverified
		assertEquals("dbName0", testedObject.getDbName()); // jtest_unverified
		assertEquals("transfer0", testedObject.getTransfer()); // jtest_unverified
		assertEquals("moduleName0", testedObject.getModuleName()); // jtest_unverified
		assertEquals("outputFolder0", testedObject.getOutputFolder()); // jtest_unverified
		assertEquals("jarPackaging0", testedObject.getJarPackaging()); // jtest_unverified
		assertEquals(null, testedObject.getmVNOPTS()); // jtest_unverified
		assertEquals("home0", testedObject.getHome()); // jtest_unverified
		assertEquals("args0", testedObject.getArgs()); // jtest_unverified
		assertEquals("globalGoals0", testedObject.getGlobalGoals()); // jtest_unverified
		assertEquals(null, testedObject.getRunScript()); // jtest_unverified
		assertEquals("groupId0", testedObject.getGroupId()); // jtest_unverified
		assertEquals("customScript0", testedObject.getCustomScript()); // jtest_unverified
		assertEquals("buildType0", testedObject.getBuildType()); // jtest_unverified
		assertEquals("javaMainClass0", testedObject.getJavaMainClass()); // jtest_unverified
		assertEquals("projectName0", testedObject.getProjectName()); // jtest_unverified
		assertEquals("thirdPartyJar0", testedObject.getThirdPartyJar()); // jtest_unverified
		assertEquals("jsonPath0", testedObject.getJsonPath()); // jtest_unverified
		assertEquals("nexusUrl0", testedObject.getNexusUrl()); // jtest_unverified
		assertEquals("password0", testedObject.getPassword()); // jtest_unverified
		assertEquals("controlFlow0", testedObject.getControlFlow()); // jtest_unverified
		assertEquals("dbType0", testedObject.getDbType()); // jtest_unverified
		assertEquals("uiEarFileName0", testedObject.getUiEarFileName()); // jtest_unverified
		assertEquals("envName0", testedObject.getEnvName()); // jtest_unverified
		assertEquals("productKey0", testedObject.getProductKey()); // jtest_unverified
		assertEquals("renaming0", testedObject.getRenaming()); // jtest_unverified
		assertEquals("nexusType0", testedObject.getNexusType()); // jtest_unverified
		assertEquals("userName0", testedObject.getUserName()); // jtest_unverified
		assertEquals("cdtIn0", testedObject.getCdtIn()); // jtest_unverified
		assertEquals("classFileName0", testedObject.getClassFileName()); // jtest_unverified
		assertEquals("destPassword0", testedObject.getDestPassword()); // jtest_unverified
		assertEquals(null, testedObject.getCodeAnalysis()); // jtest_unverified
		assertEquals("unitTesting0", testedObject.getUnitTesting()); // jtest_unverified
		assertEquals("serverMachine0", testedObject.getServerMachine()); // jtest_unverified
		assertEquals("version0", testedObject.getVersion()); // jtest_unverified
		assertEquals("compile0", testedObject.getCompile()); // jtest_unverified
		assertEquals("clean0", testedObject.getClean()); // jtest_unverified
		assertEquals("encryption0", testedObject.getEncryption()); // jtest_unverified
		assertEquals(null, testedObject.getHostCTLMigration()); // jtest_unverified
		assertEquals("codeFormatting0", testedObject.getCodeFormatting()); // jtest_unverified
		assertEquals("codeAnalysisTragets0", testedObject.getCodeAnalysisTargets()); // jtest_unverified
		assertEquals("unitTestTargets0", testedObject.getUnitTestTargets()); // jtest_unverified
		assertEquals(null, testedObject.getWorkFlowPublish()); // jtest_unverified
		assertEquals("customBuildXml0", testedObject.getCustomBuildXml()); // jtest_unverified
		assertEquals(null, testedObject.getOaFileMigration()); // jtest_unverified
		assertEquals("masterMachineName0", testedObject.getMasterMachineName()); // jtest_unverified
		assertEquals("securityProjName0", testedObject.getSecurityProjName()); // jtest_unverified
		assertEquals("unitTestCategory0", testedObject.getUnitTestCategory()); // jtest_unverified
		assertEquals("testSettingFilePath0", testedObject.getTestSettingFilePath()); // jtest_unverified
		assertEquals("dependencyFile0", testedObject.getDependencyFile()); // jtest_unverified
		assertEquals("unitTestProjectName0", testedObject.getUnitTestProjectName()); // jtest_unverified
		assertEquals("localmachineExecution0", testedObject.getLocalmachineExecution()); // jtest_unverified
		assertEquals(null, testedObject.getReportMigration()); // jtest_unverified
		assertEquals("securityAnalysis0", testedObject.getSecurityAnalysis()); // jtest_unverified
		assertEquals("mailRecipients0", testedObject.getOssMailRecipients()); // jtest_unverified
		assertEquals("distributionType0", testedObject.getOssDistributionType()); // jtest_unverified
		assertEquals("checkmarxProjName0", testedObject.getCheckmarxProjName()); // jtest_unverified
		assertEquals("integrationFileName0", testedObject.getIntegrationFileName()); // jtest_unverified
		assertEquals("excludeFolders0", testedObject.getExcludeFolders()); // jtest_unverified
		assertEquals("incrementalScan0", testedObject.getIncrementalScan()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method Module().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Module#Module()
	 * 
	 * 
	 */
	@Test
	public void testModule13() throws Throwable {
		Module testedObject = new Module();
		assertEquals(null, testedObject.getHostName()); // jtest_unverified
		assertEquals(null, testedObject.getPort()); // jtest_unverified
		assertEquals(null, testedObject.getInstallGrunt()); // jtest_unverified
		assertEquals(null, testedObject.getMultiModule()); // jtest_unverified
		assertEquals(null, testedObject.getExclude()); // jtest_unverified
		assertEquals(null, testedObject.getInterval()); // jtest_unverified
		assertEquals(null, testedObject.getTeam()); // jtest_unverified
		assertEquals(null, testedObject.getPreset()); // jtest_unverified
		assertEquals(null, testedObject.getServerUrl()); // jtest_unverified
		assertEquals(null, testedObject.getUnitTestDir()); // jtest_unverified
		assertEquals(null, testedObject.getPafFilePath()); // jtest_unverified
		assertEquals(null, testedObject.getOssAnalysisType()); // jtest_unverified
		assertEquals(null, testedObject.getMessageFlows()); // jtest_unverified
		assertEquals(null, testedObject.getInstall()); // jtest_unverified
		assertEquals(null, testedObject.getRelativePath()); // jtest_unverified
		assertEquals(null, testedObject.getAvdName()); // jtest_unverified
		assertEquals(null, testedObject.getDestDB()); // jtest_unverified
		assertEquals(null, testedObject.getmVNOPTS()); // jtest_unverified
		assertEquals(null, testedObject.getCodeCoverage()); // jtest_unverified
		assertEquals(null, testedObject.getWarPackaging()); // jtest_unverified
		assertEquals(null, testedObject.getCdtOut()); // jtest_unverified
		/*
		 * Remove Jira ALM assertEquals(null, testedObject.getRaiseJiraBug()); //
		 * jtest_unverified
		 */
		assertEquals(null, testedObject.getPublishForms()); // jtest_unverified
		assertEquals(null, testedObject.getExecute()); // jtest_unverified
		assertEquals(null, testedObject.getRepository()); // jtest_unverified
		assertEquals(null, testedObject.getEjbDescriptor()); // jtest_unverified
		assertEquals(null, testedObject.getDbName()); // jtest_unverified
		assertEquals(null, testedObject.getTransfer()); // jtest_unverified
		assertEquals(null, testedObject.getModuleName()); // jtest_unverified
		assertEquals(null, testedObject.getOutputFolder()); // jtest_unverified
		assertEquals(null, testedObject.getJarPackaging()); // jtest_unverified
		assertEquals(null, testedObject.getmVNOPTS()); // jtest_unverified
		assertEquals(null, testedObject.getHome()); // jtest_unverified
		assertEquals(null, testedObject.getArgs()); // jtest_unverified
		assertEquals(null, testedObject.getGlobalGoals()); // jtest_unverified
		assertEquals(null, testedObject.getRunScript()); // jtest_unverified
		assertEquals(null, testedObject.getGroupId()); // jtest_unverified
		assertEquals(null, testedObject.getCustomScript()); // jtest_unverified
		assertEquals(null, testedObject.getBuildType()); // jtest_unverified
		assertEquals(null, testedObject.getJavaMainClass()); // jtest_unverified
		assertEquals(null, testedObject.getProjectName()); // jtest_unverified
		assertEquals(null, testedObject.getThirdPartyJar()); // jtest_unverified
		assertEquals(null, testedObject.getJsonPath()); // jtest_unverified
		assertEquals(null, testedObject.getNexusUrl()); // jtest_unverified
		assertEquals(null, testedObject.getPassword()); // jtest_unverified
		assertEquals(null, testedObject.getControlFlow()); // jtest_unverified
		assertEquals(null, testedObject.getDbType()); // jtest_unverified
		assertEquals(null, testedObject.getUiEarFileName()); // jtest_unverified
		assertEquals(null, testedObject.getEnvName()); // jtest_unverified
		assertEquals(null, testedObject.getProductKey()); // jtest_unverified
		assertEquals(null, testedObject.getRenaming()); // jtest_unverified
		assertEquals(null, testedObject.getNexusType()); // jtest_unverified
		assertEquals(null, testedObject.getUserName()); // jtest_unverified
		assertEquals(null, testedObject.getCdtIn()); // jtest_unverified
		assertEquals(null, testedObject.getClassFileName()); // jtest_unverified
		assertEquals(null, testedObject.getDestPassword()); // jtest_unverified
		assertEquals(null, testedObject.getCodeAnalysis()); // jtest_unverified
		assertEquals(null, testedObject.getUnitTesting()); // jtest_unverified
		assertEquals(null, testedObject.getServerMachine()); // jtest_unverified
		assertEquals(null, testedObject.getVersion()); // jtest_unverified
		assertEquals(null, testedObject.getCompile()); // jtest_unverified
		assertEquals(null, testedObject.getClean()); // jtest_unverified
		assertEquals(null, testedObject.getEncryption()); // jtest_unverified
		assertEquals(null, testedObject.getHostCTLMigration()); // jtest_unverified
		assertEquals(null, testedObject.getCodeFormatting()); // jtest_unverified
		assertEquals(null, testedObject.getCodeAnalysisTargets()); // jtest_unverified
		assertEquals(null, testedObject.getUnitTestTargets()); // jtest_unverified
		assertEquals(null, testedObject.getWorkFlowPublish()); // jtest_unverified
		assertEquals(null, testedObject.getCustomBuildXml()); // jtest_unverified
		assertEquals(null, testedObject.getOaFileMigration()); // jtest_unverified
		assertEquals(null, testedObject.getMasterMachineName()); // jtest_unverified
		assertEquals(null, testedObject.getSecurityProjName()); // jtest_unverified
		assertEquals(null, testedObject.getUnitTestCategory()); // jtest_unverified
		assertEquals(null, testedObject.getTestSettingFilePath()); // jtest_unverified
		assertEquals(null, testedObject.getDependencyFile()); // jtest_unverified
		assertEquals(null, testedObject.getUnitTestProjectName()); // jtest_unverified
		assertEquals(null, testedObject.getLocalmachineExecution()); // jtest_unverified
		assertEquals(null, testedObject.getReportMigration()); // jtest_unverified
		assertEquals(null, testedObject.getSecurityAnalysis()); // jtest_unverified
		assertEquals(null, testedObject.getOssMailRecipients()); // jtest_unverified
		assertEquals(null, testedObject.getOssDistributionType()); // jtest_unverified
		assertEquals(null, testedObject.getCheckmarxProjName()); // jtest_unverified
		assertEquals(null, testedObject.getIntegrationFileName()); // jtest_unverified
		assertEquals(null, testedObject.getExcludeFolders()); // jtest_unverified
		assertEquals(null, testedObject.getIncrementalScan()); // jtest_unverified
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
	 * Usage: java ModuleTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.buildInfo.ModuleTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return Module.class;
	}
}
// JTEST_CURRENT_ID=1360461667.