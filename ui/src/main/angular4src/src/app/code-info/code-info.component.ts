/**
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.”
*
**/
import { Component, OnInit, } from "@angular/core";
import { IdprestapiService } from "../idprestapi.service";
import { IdpService } from "../idp-service.service";
import { IdpdataService } from "../idpdata.service";
import { Router } from "@angular/router";
import { ViewChild } from "@angular/core";

@Component({
  selector: "app-code-info",
  templateUrl: "./code-info.component.html",
  styleUrls: ["./code-info.component.css"]
})

export class CodeInfoComponent implements OnInit {
  @ViewChild("modalforAlert") button;
  @ViewChild("modalforDel") DelScm;
  @ViewChild("modalforreset") resetCodeInfo;
  @ViewChild("modalforRepos") missRepo;
  @ViewChild("codeInfoForm") codeInfoForm;
  @ViewChild("modalforDelParam") DelJobParam;
  @ViewChild("modalforDelAntPreProperties") DelAntPreProp;
  @ViewChild("modalforDelAntPostProperties") DelAntPostProp;
  @ViewChild("modalforDotNet") dotNetButton;

  categoryList: any;
  SCMList: any;
  repoList: any;
  buildConfList: any;
  codeScriptList: any;
  reposValid = false;
  tempObjectcode: any = this.IdpdataService.data.checkboxStatus.codeInfo;
  technologyData: any;
  shellScript: any = [];
  batchScript: any = [];
  antScript: any = [];
  SCMListAndroid: any = [];
  SCMData: any = [
    { "value": "GIT", "tech": ["JAVA/J2EE(Maven based)", ".Net(C# based)"] },
    { "value": "SVN", "tech": ["PEGA", "NET1"] },
    { "value": "TFS", "tech": ["PEGA", ".Net(C# based)"] }
  ];
  // keys for technologyData object
  technologyDatakeys: any = [];
  index: any;
  getList: any;
  jobParamType: any = [];
  subApps: any;
  subAppNames: any;
  operation: any;
  basicInfo: any = this.IdpdataService.data.basicInfo;
  antPropertis: any;
  /*constructor start*/
  constructor(
    public IdpdataService: IdpdataService,
    private IdpService: IdpService,
    private IdprestapiService: IdprestapiService,
    private router: Router
  ) {
    this.checkTempObjectCreation();
    this.codeInfo.category = "Standard";
    if (this.IdpdataService.data.basicInfo.engine !== "urbanCode") {
        this.technologyData = {
        "Standard": {
            "JAVA/J2EE(Ant based)": "J2EE/Ant",
            "JAVA/J2EE(Maven based)": "J2EE/Maven",
            ".Net(C# based)": "dotNetCsharp",
            /* OSS Milestone 2 Feature
          "Angular": "angular",
          "Generic Pipeline": "general",
          "Go": "go",
          "Node JS": "nodeJs",
          "Python": "python",
          OSS MileStone 2 Feature*/
        },
        };
    }
    if (this.codeInfo.scm.length === 0) {
        this.addItem();
    }

    this.jobParamType = [{
        "name": "String",
        "value": "string"
    },
    {
        "name": "Password",
        "value": "pwd"
    },
    ];
    this.getList = this.IdprestapiService.getIDPDropdownProperties();
    this.SCMList = this.getList.SCMList;

    this.SCMListAndroid = [
        { "name": "GIT", "value": "git" },
        {
        "name": "MS TFS",
        "value": "tfs",
        }
    ];
    this.categoryList = this.getList.categoryList;
    this.buildConfList = this.getList.buildConfList;
    this.codeScriptList = this.getList.codeScriptList;
    this.repoList = this.getList.repoList;

    if (this.formStatusObject.operation === "copy"
        || this.formStatusObject.operation === "edit") {
        this.checkCheckBox();
    }
    if (this.codeInfo.category !== undefined && this.codeInfo.category !== "") {
        this.setDataKeys();
    }
  }
  /*constructor end*/
  formStatusObject = this.IdpdataService.data.formStatus;
  codeInfo: any = this.IdpdataService.data.code;
  buildInfo: any = this.IdpdataService.data.buildInfo;
  deployInfo: any = this.IdpdataService.data.deployInfo;
  checkTempObjectCreation() {
    if (this.tempObjectcode.buildScript === undefined) {
        this.tempObjectcode.buildScript = [{}, {}];
    }
  }

  getSubApplication(data) {
    this.IdprestapiService.checkSubApplication(data)
        .then(response => {
        if (response) {
            const resp = response.json().resource;
            let parsed;
            try {
            parsed = JSON.parse(resp);
            if (parsed) {
                this.subAppNames = parsed.subApplication;
            }
            } catch (e) {
            console.log(e);
            alert("Failed while getting sub applications names");
            }
        }
        });

    if (typeof (Storage) !== undefined) {
        this.operation = this.IdpdataService.operation;
        if (this.operation === "copy" || this.operation === "edit") {
        const data = localStorage.getItem("subAppNames");
        } else {
        localStorage.clear();
        this.operation = "off";
        this.IdpdataService.operation = "off";
        }
    }
  }

  setDataKeys() {
    this.technologyDatakeys = Object.keys(this.technologyData[this.codeInfo.category]);
  }

  /* Clearing Tech stack and SCM details */
  clearTech() {
    this.codeInfo.technology = "";
    this.codeInfo.scm = [{}];
  }
  clearTransferFilesFlag(index) {
    this.codeInfo.buildScript[index].pathToFiles = "";
    this.codeInfo.buildScript[index].destinationDir = "";
    this.codeInfo.buildScript[index].flattenFilePath = "off";
    return "off";
  }

  checkFileFormat() {
    for (let i = 0; i < this.deployInfo.deployEnv.length; i++) {
        this.deployInfo.deployEnv[i].envFlag = "off";
        if (this.deployInfo.deployEnv[i].deploySteps !== undefined) {
        this.deployInfo.deployEnv[i].deploySteps = [];
        }
    }
  }
  checkCheckBox() {
    if (this.tempObjectcode.buildScript === undefined) {
        this.tempObjectcode.buildScript = [];
    }

    if (this.tempObjectcode.buildScript[0] === undefined) {
        this.tempObjectcode.buildScript[0] = {};
    }

    if (this.tempObjectcode.buildScript[1] === undefined) {
        this.tempObjectcode.buildScript[1] = {};
    }
    if (this.tempObjectcode.scm === undefined) {
        this.tempObjectcode.scm = [];
    }

    for (let i = 0; i < this.codeInfo.scm.length; i++) {
        if (this.tempObjectcode.scm[i] === undefined) {
        this.tempObjectcode.scm[i] = {};
        }

        if (this.codeInfo.scm[i].type !== undefined && this.codeInfo.scm[i].type !== "") {
        if (this.codeInfo.scm[i].appRepo === undefined) {
            this.codeInfo.scm[i].appRepo = "on";
        }
        }
        if (this.codeInfo.scm[i].exclude !== undefined
        && this.codeInfo.scm[i].exclude !== null
        && this.codeInfo.scm[i].exclude !== "") {
        this.tempObjectcode.scm[i].directory = "on";
        } else {
        this.tempObjectcode.scm[i].directory = "off";
        }
    }

    if (this.codeInfo.jobParam !== undefined && this.codeInfo.jobParam.length !== 0) {
        this.tempObjectcode.jobParams = "on";
    }

    if (this.codeInfo.jobParam === undefined) {
        this.codeInfo.jobParam = [];
    }

    if (this.tempObjectcode.paramDetails === undefined
        || this.tempObjectcode.paramDetails === null) {
        this.tempObjectcode["paramDetails"] = [
        {
            "messageSlvName": ""
        }
        ];
    }

    if (this.codeInfo.buildScript && this.codeInfo.buildScript[1]
        && this.codeInfo.buildScript[1].antPropertiesArr
        && this.codeInfo.buildScript[1].antPropertiesArr[0]
        && this.codeInfo.buildScript[1].antPropertiesArr[0].antKey !== undefined
        && this.codeInfo.buildScript[1].antPropertiesArr[0].antValue !== undefined) {
        this.codeInfo.antProperty1 = "on";
    }
    if (this.codeInfo.buildScript && this.codeInfo.buildScript[0]
        && this.codeInfo.buildScript[0].antPropertiesArr &&
        this.codeInfo.buildScript[0].antPropertiesArr[0] &&
        this.codeInfo.buildScript[0].antPropertiesArr[0].antKey !== undefined
        && this.codeInfo.buildScript[0].antPropertiesArr[0].antValue !== undefined) {
        this.codeInfo.antProperty = "on";
    }
    if (this.codeInfo.buildScript && this.codeInfo.buildScript[0]
        && this.codeInfo.buildScript[0].javaOptions !== undefined) {
        this.codeInfo.antJavaOption = "on";
    }
    if (this.codeInfo.buildScript && this.codeInfo.buildScript[1]
        && this.codeInfo.buildScript[1].javaOptions !== undefined) {
        this.codeInfo.antJavaOption1 = "on";
    }

    if (this.codeInfo.buildScript && this.codeInfo.buildScript[0]
        && this.codeInfo.buildScript[0].pathToFiles !== undefined) {
        this.tempObjectcode.buildScript[0].transferFilesFlag = "on";
    }

    if (this.codeInfo.buildScript && this.codeInfo.buildScript[1]
        && this.codeInfo.buildScript[1].pathToFiles !== undefined) {
        this.tempObjectcode.buildScript[1].transferFilesFlag = "on";
    }
  }

  clearDir(i) {
    this.codeInfo.scm[i].exclude = "";
    return "off";
  }

  setRepositoryBrowser(data, i) {
    if (!data) {
        this.codeInfo.scm[i].repositoryBrowser = "";
        return false;
    }
    return false;
  }

  setScmType(data, i) {
    if (!data) {
        this.codeInfo.scm[i].type = "";
        return false;
    } else {
        return false;
    }
  }

  clearJobParamField() {
    this.codeInfo.jobParam = [];
    return false;
  }

  openJobParamField() {
    this.codeInfo.jobParam = [];
    this.addJobParam();
    return "on";
  }

  /* Adding Job Param */
  addJobParam() {
    this.codeInfo.jobParam.push({
        "jobType": ""
    });
    if (this.tempObjectcode.paramDetails === undefined
        || this.tempObjectcode.paramDetails === null) {
        this.tempObjectcode["paramDetails"] = [
        {
            "messageSlvName": ""
        }
        ];
    } else {
        this.tempObjectcode.paramDetails.push({
        "messageSlvName": ""
        });
    }
  }

  /* Deleting Job Pram Details */
  deleteJobParam(index) {
    this.index = index;
    this.DelJobParam.nativeElement.click();
  }

  deleteJobParamConfirm() {
    this.codeInfo.jobParam.splice(this.index, 1);
  }

  /* Deleing Ant pre-build */
  deleteAntPreProp(index) {
    this.index = index;
    this.DelAntPreProp.nativeElement.click();
  }

  deleteAntPrePropConfirm() {
    this.codeInfo.buildScript[0].antPropertiesArr.splice(this.index, 1);
  }

  /* Deleting Ant post build */
  deleteAntPostProp(index) {
    this.index = index;
    this.DelAntPostProp.nativeElement.click();
  }

  deleteAntPostPropConfirm() {
    this.codeInfo.buildScript[1].antPropertiesArr.splice(this.index, 1);
  }

  /* Checking for unique Job Param Details */
  checkJobParamName(index) {
    for (let i = 0; i < this.codeInfo.jobParam.length; i++) {
        if (i !== index && this.codeInfo.jobParam[i].jobParamName !== undefined &&
        this.codeInfo.jobParam[index].jobParamName !== undefined &&
        this.codeInfo.jobParam[i].jobParamName.toLowerCase() === this.codeInfo.jobParam[index].jobParamName.toLowerCase()) {
        this.tempObjectcode.paramDetails[index].messageSlvName = "Pipeline Param Name should be unique.";
        break;
        } else {
        this.tempObjectcode.paramDetails[index].messageSlvName = "";
        }
    }
  }
  // Ant custom Job properties
  openAntPropertiesField() {
    this.codeInfo.buildScript[0].antPropertiesArr = [];
    this.addAntProperties();
    return "on";
  }

  addAntProperties() {
    this.codeInfo.buildScript[0].antPropertiesArr.push({
    });
  }

  clearAntPropertisField() {
    this.codeInfo.buildScript[0].antPropertiesArr = [];
    return false;
  }

  openAntPostPropertiesField() {
    this.codeInfo.buildScript[1].antPropertiesArr = [];
    this.addAntpostProperties();
    return "on";
  }

  /* adding Ant post build */
  addAntpostProperties() {
    this.codeInfo.buildScript[1].antPropertiesArr.push({
    });
  }

  clearAntPostPropertisField() {
    this.codeInfo.buildScript[1].antPropertiesArr = [];
    return false;
  }

  /* Clearing An post build Java Options */
  clearAntPostBuildJavaOpts() {
    this.codeInfo.buildScript[1].antJavaOption1 = "";
    return false;
  }

  /* Clearing Ant pre build Java Options */
  clearAntPreBuildJavaOpts() {
    this.codeInfo.buildScript[0].antJavaOption = "";
    return false;
  }

  setbuidScirptvalueZero() {
    this.codeInfo.buildScript[0].tool = "";
    this.codeInfo.buildScript[0].scriptFilePath = "";
    this.codeInfo.buildScript[0].targets = "";
    return null;
  }

  /* SSH build script for an index */
  setbuidScirptvalueOne(index) {
    this.codeInfo.buildScript[index].tool = "";
    this.codeInfo.buildScript[index].scriptFilePath = "";
    this.codeInfo.buildScript[index].targets = "";
    this.codeInfo.buildScript[index].host = "";
    this.codeInfo.buildScript[index].userName = "";
    this.codeInfo.buildScript[index].password = "";
    this.codeInfo.buildScript[index].sshKey = "";
    this.codeInfo.buildScript[index].sshPathToKey = "";
    this.codeInfo.buildScript[index].script = "";
    this.tempObjectcode.buildScript[index].transferFilesFlag = "off";
    this.clearTransferFilesFlag(index);
    return null;
  }
  setbJobparmvaluetoNull() {
    return null;
  }

  cleanPathchg(runtype, index) {
    if (runtype === null) {
        this.codeInfo.buildScript[index].scriptFilePath = null;
    } else if (runtype === "shellScript") {
        this.codeInfo.buildScript[index].scriptFilePath = this.shellScript[index];
    } else if (runtype === "batchScript") {
        this.codeInfo.buildScript[index].scriptFilePath = this.batchScript[index];
    } else if (runtype === "ant") {
        this.codeInfo.buildScript[index].scriptFilePath = this.antScript[index];
    }
  }

  cleanPath(runtype, index) {
    if (runtype === null) {
        this.codeInfo.buildScript[index].scriptFilePath = null;
    } else if (runtype === "shellScript") {
        this.shellScript[index] = this.codeInfo.buildScript[index].scriptFilePath;
    } else if (runtype === "batchScript") {
        this.batchScript[index] = this.codeInfo.buildScript[index].scriptFilePath;
    } else if (runtype === "ant") {
        this.antScript[index] = this.codeInfo.buildScript[index].scriptFilePath;
    }
  }

  selectedSCM() {
    this.codeInfo.scm = [{}];
    return "off";
  }

  /* Depending on selected Tech,
    * setting build tool
    */
  selectedTech() {
    this.codeInfo.scm = [{}];
    if (this.codeInfo.technology !== undefined && this.codeInfo.technology !== null) {
        if (this.codeInfo.technology === "dotNetCsharp"
        || this.codeInfo.technology === "dotNetVb") {
        this.buildInfo.buildtool = "msBuild";
        this.IdpdataService.data.buildInfo.buildtool = this.buildInfo.buildtool;
        this.IdpdataService.data.formStatus.buildInfo.buildToolStatus = "1";
        }
        if (this.codeInfo.technology === "J2EE/Ant") {
        this.buildInfo.buildtool = "ant";
        this.IdpdataService.data.buildInfo.buildtool = this.buildInfo.buildtool;
        this.IdpdataService.data.formStatus.buildInfo.buildToolStatus = "1";
        }
        if (this.codeInfo.technology === "J2EE/Maven") {
        this.buildInfo.buildtool = "maven";
        this.IdpdataService.data.buildInfo.buildtool = this.buildInfo.buildtool;
        this.IdpdataService.data.formStatus.buildInfo.buildToolStatus = "1";
        }
        if (this.codeInfo.technology !== "dotNetCsharp"
        && this.codeInfo.technology !== "dotNetVb"
        && this.codeInfo.technology !== "J2EE/Ant"
        && this.codeInfo.technology !== "J2EE/Maven") {
        this.buildInfo.buildtool = this.codeInfo.technology;
        this.IdpdataService.data.buildInfo.buildtool = this.buildInfo.buildtool;
        this.IdpdataService.data.formStatus.buildInfo.buildToolStatus = "1";
        }
        if (this.codeInfo.technology === "") {
        this.IdpdataService.data.formStatus.buildInfo.buildToolStatus = "0";
        }

        if (this.IdpdataService.data.formStatus.operation !== "copy"
        && this.IdpdataService.data.formStatus.operation !== "edit") {
        this.clearViews();
        }

        if ((this.codeInfo.technology === "dotNetCsharp"
        || this.codeInfo.technology === "dotNetVb")
        && this.basicInfo.buildServerOS !== "windows") {
        this.dotNetButton.nativeElement.click();
        this.codeInfo.technology = "";
        }
    }
  }

  clearBroserFields(i) {
    this.codeInfo.scm[i].browserUrl = "";
    this.codeInfo.scm[i].projectName = "";
    this.codeInfo.scm[i].version = "";
  }

  /* Addition of SCM
   * for multi SCM support
   */
  addItem() {
    this.codeInfo.scm.push({
    });
    if (this.tempObjectcode.scm === undefined) {
        this.tempObjectcode.scm = [];
    }
    this.tempObjectcode.scm.push({});
  }
  /* Deletion of SCM */
  deleteItem(index) {
    this.index = index;
    this.DelScm.nativeElement.click();
  }
  deleteItemConfirm() {
    this.codeInfo.scm.splice(this.index, 1);
  }
  clearViews() {
    this.IdpdataService.data.buildInfo = {
        "buildtool": this.buildInfo.buildtool,
        "castAnalysis": {},
        "artifactToStage": {},
        "modules": []
    };
    this.IdpdataService.data.checkboxStatus.buildInfo = {};
    this.IdpdataService.data.checkboxStatus.deployInfo = {};
    this.IdpdataService.data.checkboxStatus.testInfo = {};
    this.IdpdataService.data.checkboxStatus.others = {};
    this.IdpdataService.data.deployInfo = this.IdpService.copy(this.IdpdataService.data.backUp.deployInfo);
    this.IdpdataService.data.testInfo = this.IdpService.copy(this.IdpdataService.data.backUp.testInfo);
  }
  /* Resetting code section */
  resetCodeInfoConfirm() {
    const tech = this.codeInfo.technology;
    const cat = this.codeInfo.category;
    if (this.IdpdataService.data.formStatus.operation !== "edit"
        && this.IdpdataService.data.formStatus.operation !== "copy") {
        this.codeInfo = {
        "category": "",
        "technology": "",
        "scm": [],
        "buildScript": [{ "tool": "" }, { "tool": "" }, {}]
        };
        this.IdpdataService.data.formStatus.buildInfo.buildToolStatus = "0";
    } else {
        this.codeInfo = {
        "category": cat,
        "technology": tech,
        "scm": [],
        "buildScript": [{ "tool": "" }, { "tool": "" }, {}]
        };
    }
    this.IdpdataService.data.code = this.codeInfo;
    this.IdpdataService.data.checkboxStatus.codeInfo = {};
    this.addItem();
    this.tempObjectcode = this.IdpdataService.data.checkboxStatus.codeInfo;
  }
  resetData() {
    this.resetCodeInfo.nativeElement.click();
  }
  /* Getting all data
   * and saving in Idpdata and sending it to backend
   */
  go() {
    if (this.validateReposCheckBox()) {
        this.IdpdataService.data.code = this.codeInfo;
        this.IdpdataService.data.masterJson["code"] = this.codeInfo;
        this.router.navigate(["/createConfig/buildInfo"]);
    } else {
        this.missRepo.nativeElement.click();
    }
  }
  ngOnInit() {
    if (this.IdpdataService.data.formStatus.basicInfo.appNameStatus === "0") {
        this.button.nativeElement.click();
    }
  }
  redirectToBasicInfo() {
    this.router.navigate(["/createConfig/basicInfo"]);
  }

  setFormStatus(data) {
    this.IdpdataService.allFormStatus.codeInfo = data;
  }

  /* Clearing SCM fields */
  clearSCMFields(i) {
    this.codeInfo.scm[i].serverHost = "";
    this.codeInfo.scm[i].port = "";
    this.codeInfo.scm[i].OffServerName = "";
    this.codeInfo.scm[i].processName = "";
    this.codeInfo.scm[i].snapshotName = "";
    this.codeInfo.scm[i].PSusername = "";
    this.codeInfo.scm[i].PSpassword = "";
    this.codeInfo.scm[i].fsdirPath = "";
    this.codeInfo.scm[i].fsProcessName = "";
    this.codeInfo.scm[i].fsSnapshotName = "";
    this.codeInfo.scm[i].url = "";
    this.codeInfo.scm[i].password = "";
    this.codeInfo.scm[i].repositoryWorkspace = "";
    this.codeInfo.scm[i].branch = "";
    this.codeInfo.scm[i].userName = "";
    this.codeInfo.scm[i].projPath = "";
    this.codeInfo.scm[i].proxy = "";
    this.codeInfo.scm[i].proxyPort = "";
    this.codeInfo.scm[i].exclude = "";
    this.codeInfo.scm[i].repositoryBrowser = "";
    this.codeInfo.scm[i].browserUrl = "";
    this.codeInfo.scm[i].projectName = "";
    this.codeInfo.scm[i].version = "";
    this.codeInfo.scm[i].moduleName = "";
    this.codeInfo.scm[i].clearcaseType = "";
    this.codeInfo.scm[i].snapshotViewName = "";
    this.codeInfo.scm[i].configSpec = "";
    this.codeInfo.scm[i].vobName = "";
    this.codeInfo.scm[i].developmentStreamName = "";
    this.codeInfo.scm[i].buildConfiguration = "";
    this.codeInfo.scm[i].buildDefinition = "";
    this.codeInfo.scm[i].projArea = "";
    this.codeInfo.scm[i].buildDefinition = "";
    this.codeInfo.scm[i].buildDefinition = "";
    this.codeInfo.scm[i].buildDefinition = "";
    this.codeInfo.scm[i].appRepo = "";
    this.codeInfo.scm[i].testRepo = "";
    this.codeInfo.scm[i].deployRepo = "";
  }
  initAppCode(i) {
    this.codeInfo.scm[i].appRepo = "on";
  }
  validateReposCheckBox() {
    for (let i = 0; i < this.codeInfo.scm.length; i++) {
        if (((this.codeInfo.scm[i].appRepo === "on")
        || (this.codeInfo.scm[i].deployRepo === "on")
        || (this.codeInfo.scm[i].testRepo === "on"))) {
        this.reposValid = true;
        } else {
        this.reposValid = false;
        this.setFormStatus(false);
        return this.reposValid;
        }
    }
    return this.reposValid;
  }
}
