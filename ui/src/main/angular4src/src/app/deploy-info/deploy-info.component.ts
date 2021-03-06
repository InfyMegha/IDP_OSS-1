/**
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.”
*
**/
import { Component, OnInit } from "@angular/core";
import { IdprestapiService } from "../idprestapi.service";
import { IdpService } from "../idp-service.service";
import { IdpdataService } from "../idpdata.service";
import { Router } from "@angular/router";
import { Validators } from "@angular/forms";
import { Renderer } from "@angular/core";
import { ViewChild } from "@angular/core";
import { IDPEncryption } from "../idpencryption.service";
import { IdpSubmitService } from "../idpsubmit.service";
import { ParentFormConnectComponent } from "../parent-form-connect/parent-form-connect.component";

@Component({
  selector: "app-deploy-info",
  templateUrl: "./deploy-info.component.html",
  styleUrls: ["./deploy-info.component.css"]
})
export class DeployInfoComponent implements OnInit {

  env: any = {};
  scriptList: any = [];
  deploymentList: any = [];
  data: any = {};
  testInfo: any = this.IdpdataService.data.testInfo;
  deployInfo: any = this.IdpService.copy(this.IdpdataService.data.deployInfo);
  buildInfo: any = this.IdpdataService.data.buildInfo;
  code: any = this.IdpdataService.data.code;
  list: any = [];
  radio: any = "";
  runScriptFlag: any = "off";
  deployContainerFlag: any = "off";
  deployDBFlag: any = "off";
  deployDb: any = "off";
  tempObject: any = this.IdpdataService.data.checkboxStatus.deployInfo;
  p: boolean;
  dbList: any;
  geFlag: boolean;
  containerList: any;
  deployToContainer: any = {};
  deployDatabase: any = {};
  formStatusObject = this.IdpdataService.data.formStatus;
  ssoId: any;
  ssoName: any;
  serverIndex: any;
  srfServerIndex: any;
  module: String;
  s: any;
  outerIndex: any;
  innerIndex: any;
  msg: any;
  loc: any;
  passphrasefrombuild: any;
  Artifactvalue: any;
  buildTool: any;
  importexporttype: any;
  administrator: any;
  password: any;
  fileName: "";
  pairName: "";
  srcEnvName: "";
  port: any;
  hostName: any;
  userName: any;
  sourceFolder: any;
  sourceRepo: any;
  targetFolder: any;
  targetFolderShared;
  artifactIndex: any;
  targetRepo: any;
  platform: any;
  sourceFolderShared: any;
  checkStepAdd = false;
  dbDeployRollbackTypeList: any;
  server: any;
  listToFillFields: any = [];
  index: any;
  indexI: any = -1;
  indexJ: any = -1;
  deployOperations = [
    { "name": "EAR Deploy", "value": "earDeploy" },
    { "name": "Start Weblogic", "value": "startWeb" },
    { "name": "Stop Weblogic", "value": "stopWeb" },
    { "name": "Update DBC", "value": "updateDBC" },
    { "name": "XML Deploy", "value": "xmlDeploy" },
  ];
  @ViewChild("modalforAlert") button;
  @ViewChild("modalforAlertDeploy") button1;
  @ViewChild("modalforDel") DelScm;
  @ViewChild("modalforDelField") DelField;
  @ViewChild("modalforDelAllField") DelAllField;
  @ViewChild("modalforAlertDataMiss") missData;
  @ViewChild("modalforDelAntProperties") DelAntProp;
  @ViewChild("modalforDotNet") dotNetButton;
  @ViewChild("modalformandatoryFieldsDeployAlert") mandatoryFieldsAlert;
  @ViewChild("modalforconfirmDeployAlert") confirmationAlert;


  public rapidPage: any = {
    "pageRows": [{
        "sections": [{
        "sectionRows": [{ "secRowColumns": [] }, { "secRowColumns": [{ "colName": "users" }] },
        { "secRowColumns": [{ "colName": "sample" }] }], "width": 0
        }]
    }], "pageName": "DefaultPage", "pageLayout": "DEFAULT_LAYOUT", "editMode": true
  };
  ngOnInit() {
    if (this.IdpdataService.data.formStatus.basicInfo.appNameStatus === "0") {
        this.msg = "Application Name";
        this.loc = "/createConfig/basicInfo";
        this.TriggerAlert();
    } else {
        if (this.IdpdataService.data.formStatus.buildInfo.buildToolStatus === "0") {
        console.log(1);
        this.msg = "Technology Type";
        this.loc = "/createConfig/codeInfo";
        // this.IdpdataService.data.p=true;
        this.TriggerAlert();

        }
    }
    if (this.buildInfo.buildtool === "maximo" && this.IdpdataService.data.basicInfo.buildServerOS !== "windows") {
        this.dotNetButton.nativeElement.click();
    }
    const applName = this.IdpdataService.data.basicInfo.applicationName;

  }

  /* Constructor */
  constructor(
    public IdpdataService: IdpdataService,
    private IdpService: IdpService,
    private IdpSubmitService: IdpSubmitService,
    private IdprestapiService: IdprestapiService,
    private idpencryption: IDPEncryption,
    private router: Router) {
    this.IdpdataService.data.deployInfo = this.deployInfo;
    this.IdpdataService.data.buildInfo = this.buildInfo;
    this.init();
    this.scriptList = [{ "name": "ANT Script", "value": "ant" },
    { "name": "Shell Script", "value": "shellScript" },
    { "name": "Batch Script", "value": "batchScript" },
    { "name": "Powershell Script", "value": "powerShell" }, { "name": "SSH Execution", "value": "sshExecution" }];
    this.deploymentList = [{ "name": "MMC", "value": "MMC" }];
    if (this.buildInfo.buildtool === "maven" || this.buildInfo.buildtool === "ant" || this.buildInfo.buildtool === "catalog") {
        this.containerList = this.IdprestapiService.getIDPDropdownProperties().containerList;
    }
    if (this.buildInfo.buildtool === "general") {
        this.scriptList = [{ "name": "ANT Script", "value": "ant" },
        { "name": "Shell Script", "value": "shellScript" },
        { "name": "Batch Script", "value": "batchScript" }, { "name": "Powershell Script", "value": "powerShell" }];
    }

    if (this.buildInfo.buildtool === "msBuild") {
        this.containerList = [{
        "name": "IIS",
        "value": "iis"
        }];
    }
    if (this.buildInfo !== undefined && this.buildInfo !== "" && this.buildInfo != null) {
        if (this.buildInfo.buildtool === "reactjs") {
        this.server = {
            "osserver": ""
        };
        this.server.osserver = this.IdpdataService.data.basicInfo.buildServerOS;
        }
    }
    if (this.formStatusObject.operation === "copy" || this.formStatusObject.operation === "edit") {
        this.buildTool = this.buildInfo.buildtool;
        this.checkCheckBox();

    }
  }
  setFormStatus(data) {
    this.IdpdataService.allFormStatus.deployInfo = data;
  }

  get rapidPageValue() {
    return JSON.stringify(this.rapidPage, null, 2);
  }
  set rapidPageValue(v) {
    try {
        this.rapidPage = JSON.parse(v);
    } catch (e) {
        console.log("error occored while you were typing the JSON");
    }
  }

  TriggerAlert() {
    this.button1.nativeElement.click();
  }

  redirectTo() {
    if (this.loc) {
        this.router.navigate([this.loc]);
    }
  }

  redirectToBasicInfo() {
    this.router.navigate(["/createConfig/basicInfo"]);
  }

  init() {
  }

  checkStep(envIndex) {
    return "on";
  }

  clearStep(envIndex) {
    return "off";
  }

  /* To check if Deploy step is added or not */
  checkDeployOperation(i, j) {
    if (this.deployInfo.deployEnv[i].deploySteps[j].deployOperation === undefined) {
        this.deployInfo.deployEnv[i].deploySteps[j].deployOperation = "";
    }
    this.deployInfo.deployEnv[i].deploySteps[j].deployFuntion = "";
  }
  /* Checks for duplication of step name
   * and alerts
   */
  checkStepName(i, j) {
    for (let x = 0; x < this.deployInfo.deployEnv.length; x++) {
        if (this.deployInfo.deployEnv[x] !== undefined && this.deployInfo.deployEnv[x].deploySteps !== undefined) {
        for (let y = 0; y < this.deployInfo.deployEnv[x].deploySteps.length; y++) {
            console.log(this.deployInfo.deployEnv[x].deploySteps[y].stepName);
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
            this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            if (j !== y && this.deployInfo.deployEnv[x].deploySteps[y].stepName !== undefined &&
            this.deployInfo.deployEnv[i].deploySteps[j].stepName !== undefined &&
            this.deployInfo.deployEnv[x].deploySteps[y].stepName === this.deployInfo.deployEnv[i].deploySteps[j].stepName) {
            this.tempObject.deployEnv[i].deploySteps[j].msgStep = "Step Name must be unique.";
            break;
            } else {
            this.tempObject.deployEnv[i].deploySteps[j].msgStep = "";
            }
        }
        }
    }
  }

  /* Options for Java packaging */
  optionList() {
    if (this.tempObject.warList === undefined) {
        this.tempObject.warList = [];
    }
    for (let i = 0; i < this.buildInfo.modules.length; i++) {
        if (this.buildInfo.modules[i].moduleName !== undefined &&
        this.buildInfo.modules[i].moduleName != null &&
        this.buildInfo.modules[i].moduleName !== "" &&
        this.buildInfo.modules[i].warPackaging !== "" &&
        this.buildInfo.modules[i].warPackaging !== null &&
        this.buildInfo.modules[i].warPackaging !== undefined) {
        if (this.tempObject.warList.indexOf(this.buildInfo.modules[i].moduleName) === -1) {
            this.tempObject.warList.push(this.buildInfo.modules[i].moduleName);
        }
        }
    }
    return true;
  }
  clearTempObject(envIndex) {
    if (this.deployInfo.deployEnv[envIndex].envFlag === "off") {
        if (this.tempObject.deployEnv !== undefined && this.tempObject.deployEnv[envIndex] !== undefined) {
        this.tempObject.deployEnv[envIndex].deploySteps = [];
        }
    }
  }
  clearObjFlag(i, j) {
    this.deployInfo.deployEnv[i].deploySteps[j].dbName = "";
    this.deployInfo.deployEnv[i].deploySteps[j].dbServName = "";
    this.tempObject.deployEnv[i].deploySteps[j].deployObjFlag = "off";
    this.clearIntFlag(i, j);
    return "off";
  }
  clearIntFlag(i, j) {
    this.deployInfo.deployEnv[i].deploySteps[j].dbUName = "";
    this.deployInfo.deployEnv[i].deploySteps[j].dbPwd = "";
    this.tempObject.deployEnv[i].deploySteps[j].isInternetFlag = "off";
    return "off";
  }

  tomcatRestartoff(i, j) {
    this.deployInfo.deployEnv[i].deploySteps[j].tomUname = "";
    this.deployInfo.deployEnv[i].deploySteps[j].tomPwd = "";
    this.deployInfo.deployEnv[i].deploySteps[j].tomHost = "";
    this.deployInfo.deployEnv[i].deploySteps[j].tomPort = "";
    this.deployInfo.deployEnv[i].deploySteps[j].appName = "";
    return "off";
  }
  tomcatRestarton(i, j) {
    this.tempObject.deployEnv[i].deploySteps[j].tomcatRestart = "on";
    return "on";
  }
  /* Addition of deploy step */
  addDeployStep(key) {
    if (this.deployInfo.deployEnv === undefined) {
        this.deployInfo.deployEnv = [];
        console.log("chck");
    }
    if (this.tempObject.deployEnv === undefined) {
        this.tempObject.deployEnv = [];
    }
    if (this.deployInfo.deployEnv[key] === undefined) {
        this.deployInfo.deployEnv[key] = {};
    }
    if (this.tempObject.deployEnv[key] === undefined) {
        this.tempObject.deployEnv[key] = {};
    }
    if (this.deployInfo.deployEnv[key].deploySteps === undefined) {
        this.deployInfo.deployEnv[key].deploySteps = [];
    }
    if (this.tempObject.deployEnv[key].deploySteps === undefined) {
        this.tempObject.deployEnv[key].deploySteps = [];
    }

    if (this.tempObject.deployEnv === undefined) {
        console.log(1);
        this.tempObject.deployEnv = [];
    }
    this.deployToContainer = {
        "containerName": "",
        "updateDB": "",
        "rollbackStrategy": "",
        "fileName": "",
        "pairName": "",
        "srcEnvName": "",
        "userName": "",
        "password": ""
    };
    this.deployDatabase = {
        "restorusername": "",
        "restorpassword": "",
        "dbusername": "",
        "dbpassword": "",
        "script": ""
    };
    this.deployInfo.deployEnv[key].deploySteps.push({
        "deployToContainer": this.deployToContainer,
        "deployDatabase": this.deployDatabase,
        "deploymentOption": "",
        "runScript": {
        "scriptType": "",
        "scriptFilePath": "",
        "targets": ""
        },
        "cloudDeployment": {

        },
        "proxy": {
        "username": "",
        "password": "",
        "host": "",
        "enabled": "",
        "port": ""

        },
        "deployOS": "",
        "abortScript": { "scriptType": "" },
        "platform": "",
        "deployOperation": ""

    });

    this.tempObject.deployEnv[key].deploySteps.push({});
  }


  /* Removal of deploy step */
  removeDeployStep(outerIndex, innerIndex) {
    this.innerIndex = innerIndex;
    this.outerIndex = outerIndex;
    this.DelScm.nativeElement.click();
  }

  /* Clears environment config */
  clearcfg(i, j) {
    this.tempObject.deployEnv[i].deploySteps[j].envconfigNameCheckBox = [];
    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails = [];
    return "off";
  }
  clearconfig(i, j, k) {
    const idx =
        this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.indexOf(this.IdpdataService.application.environmentProvDetails[k]);
    if (idx > -1) {
        this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.splice(idx, 1);
    } else {
        this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.push(this.IdpdataService.application.environmentProvDetails[k]);
    }
    console.log(this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails);

    return "off";
  }

  inscfgMain(i, j) {

    this.tempObject.deployEnv[i].deploySteps[j].envconfigNameCheckBox = [];
    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails = [];
    return "on";
  }

  insconfig(i, j, k) {
    const idx =
        this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.indexOf(this.IdpdataService.application.environmentProvDetails[k]);
    if (idx > -1) {
        this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.splice(idx, 1);
    } else {
        this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.push(this.IdpdataService.application.environmentProvDetails[k]);
    }
    console.log(this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails);

    return "on";
  }
  deleteItemCofirm() {
    this.deployInfo.deployEnv[this.outerIndex].deploySteps.splice(this.innerIndex, 1);
    this.tempObject.deployEnv[this.outerIndex].deploySteps.splice(this.innerIndex, 1);
  }
  checkCheckBox() {
    if (this.IdpdataService.data.buildInfo !== undefined &&
        this.IdpdataService.data.buildInfo.modules !== undefined &&
        this.IdpdataService.data.buildInfo.modules[0] !== undefined && this.IdpdataService.data.buildInfo.modules[0].unitTesting === "on") {
        this.IdpdataService.unitTest = true;
    }


    if (this.tempObject.deployEnv === undefined) {
        this.tempObject.deployEnv = [];
    }
    if (this.tempObject.deployEnv.deploySteps === undefined) {
        this.tempObject.deployEnv.push({});
        this.tempObject.deployEnv.deploySteps = [];
    }
    for (let i = 0; i < this.deployInfo.deployEnv.length; i++) {
        const envFlag = "off";
        if (this.tempObject.deployEnv[i] === undefined) {
        this.tempObject.deployEnv[i] = {};
        }

        if (this.tempObject.deployEnv[i].deploySteps === undefined) {
        this.tempObject.deployEnv[i].deploySteps = [];
        }
        if (this.deployInfo.deployEnv[i].deploySteps !== undefined) {
        if (this.deployInfo.deployEnv[i].deploySteps.length !== 0) {
            this.deployInfo.deployEnv[i].envFlag = "on";
        }
        for (let j = 0; j < this.deployInfo.deployEnv[i].deploySteps.length; j++) {
            const runScriptFlag = "off";
            const deployContainerFlag = "off";
            if (this.deployInfo.deployEnv[i].deploySteps[j].s3location !== undefined &&
            this.deployInfo.deployEnv[i].deploySteps[j].s3location !== "") {
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            this.tempObject.deployEnv[i].deploySteps[j].s3Loc = "on";
            } else {
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            this.tempObject.deployEnv[i].deploySteps[j].s3Loc = "off";
            }
            const deployDBFlag = "off";
            if (this.deployInfo.deployEnv[i].deploySteps[j].runScript !== "" &&
            this.deployInfo.deployEnv[i].deploySteps[j].runScript !== undefined) {
            if (this.deployInfo.deployEnv[i].deploySteps[j].runScript.scriptType !== "" &&
                this.deployInfo.deployEnv[i].deploySteps[j].runScript.scriptType !== undefined) {
                if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                console.log(this.tempObject.deployEnv[i].deploySteps[j]);
                this.tempObject.deployEnv[i].deploySteps[j] = {};
                }
                console.log(this.tempObject.deployEnv[i].deploySteps[j]);
                this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag = "on";
                /* setting SSH on, if inputs are provided */
                if (this.deployInfo.deployEnv[i].deploySteps[j].runScript.scriptType === "sshExecution") {
                if (this.deployInfo.deployEnv[i].deploySteps[j].runScript.pathToFiles !== "" &&
                    this.deployInfo.deployEnv[i].deploySteps[j].runScript.pathToFiles !== undefined) {
                    this.tempObject.deployEnv[i].deploySteps[j].transferFilesFlag = "on";
                }
                }

                /* Setting Ant execution on, if ant targets, xml file are provided */
                if (this.deployInfo.deployEnv[i].deploySteps[j].runScript.scriptType === "ant") {
                if (this.deployInfo.deployEnv[i].deploySteps[j].runScript &&
                    this.deployInfo.deployEnv[i].deploySteps[j].runScript.antPropertiesArr &&
                    this.deployInfo.deployEnv[i].deploySteps[j].runScript.antPropertiesArr[0].antKey !== undefined &&
                    this.deployInfo.deployEnv[i].deploySteps[j].runScript.antPropertiesArr[0].antValue !== undefined) {
                    this.deployInfo.deployEnv[i].deploySteps[j].runScript.antProperty1 = "on";
                }
                if (this.deployInfo.deployEnv[i].deploySteps[j].runScript &&
                    this.deployInfo.deployEnv[i].deploySteps[j].runScript.javaOptions !== undefined) {
                    this.deployInfo.deployEnv[i].deploySteps[j].runScript.antJavaOption1 = "on";
                }
                }

            } else {
                if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                this.tempObject.deployEnv[i].deploySteps[j] = {};
                }
                this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag = "off";
            }
            } else {
            this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag = "off";
            }

            if (this.buildInfo.buildtool === "reactjs" && this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].hostName !== "") {
            this.tempObject.deployEnv[i].deploySteps[j].folderCopyFlag = "on";

            }
            if (this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails !== undefined &&
            this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.length > 0) {
            this.tempObject.deployEnv[i].deploySteps[j].envconfigAbortCheckBox = "on";
            this.tempObject.deployEnv[i].deploySteps[j].envconfigNameCheckBox = [];
            for (let s = 0; s < this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.length; s++) {
                for (let f = 0; f < this.IdpdataService.application.environmentProvDetails.length; f++) {
                if (this.IdpdataService.application.environmentProvDetails[f].environmentProvName ===
                    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails[s].environmentProvName) {
                    this.tempObject.deployEnv[i].deploySteps[j].envconfigNameCheckBox[f] = "on";
                    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails[s] =
                    this.IdpdataService.application.environmentProvDetails[f];
                    break;
                }
                }
            }
            }
            if (this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag !== undefined &&
            this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === "on") {
            console.log(this.IdpdataService.data.deployInfo);
            const deployData1 = this.IdpdataService.data.basicInfo.deployData1;
            console.log(this.IdpdataService.data.deployInfo.deployEnv[i]);
            if (deployData1 !== undefined) {
                const deployData = JSON.parse(deployData1);
                for (let l = 0; l < deployData.env.length; l++) {
                if (deployData.env[l].name === this.IdpdataService.data.deployInfo.deployEnv[i].envName) {
                    for (let k = 0; k < deployData.env[l].step.length; k++) {
                    if (deployData.env[l].step[k].index - 1 === j) {
                        this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].dataRight =
                        JSON.parse(this.idpencryption.decryptAES(deployData.env[l].step[k].pipelineInfo));
                        console.log(this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].dataRight + "  " +
                        this.idpencryption.decryptAES(deployData.env[l].step[k].pipelineInfo));
                    }
                    }
                }
                }
            }
            }
            /* MSBUILD Deployment */
            if (this.buildInfo.buildtool === "msBuild" &&
            (this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].appPackName !== "" &&
                this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].appPackName !== undefined)) {
            this.tempObject.deployEnv[i].deploySteps[j].deployFabFlag = "on";

            }
            if (this.buildInfo.buildtool === "msBuild" &&
            (this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].dbServName !== "" &&
                this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].dbServName !== undefined)) {
            this.tempObject.deployEnv[i].deploySteps[j].deployObjFlag = "on";

            }
            if (this.buildInfo.buildtool === "msBuild" &&
            (this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].dbUName !== "" &&
                this.IdpdataService.data.deployInfo.deployEnv[i].deploySteps[j].dbUName !== undefined)) {
            this.tempObject.deployEnv[i].deploySteps[j].isInternetFlag = "on";

            }

            if (this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer !== "" &&
            this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer !== undefined) {
            if (this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.containerName !== "" &&
                this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.containerName !== undefined) {
                this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag = "on";
            } else {
                this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag = "off";
            }

            } else {
            this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag = "off";
            }
            if ((this.buildTool === "ant" || this.buildTool === "maven") &&
            this.deployInfo.deployEnv[i].deploySteps[j].pathToFiles !== undefined &&
            this.deployInfo.deployEnv[i].deploySteps[j].pathToFiles !== null &&
            this.deployInfo.deployEnv[i].deploySteps[j].pathToFiles !== "") {

            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            this.tempObject.deployEnv[i].deploySteps[j].scriptType = "on";
            } else {
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            this.tempObject.deployEnv[i].deploySteps[j].scriptType = "off";
            }
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
            this.tempObject.deployEnv[i].deploySteps[j] = {};
            }

            if (this.deployInfo.deployEnv[i].deploySteps[j].dockerFilePath !== undefined &&
            this.deployInfo.deployEnv[i].deploySteps[j].dockerFilePath !== "") {
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                console.log(this.tempObject.deployEnv[i].deploySteps[j]);
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }

            this.tempObject.deployEnv[i].deploySteps[j].dockerContainerFlag = "on";

            } else {
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                console.log(this.tempObject.deployEnv[i].deploySteps[j]);
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            this.tempObject.deployEnv[i].deploySteps[j].dockerContainerFlag = "off";
            }
            if (this.deployInfo.deployEnv[i].deploySteps[j].bizScriptPath !== undefined &&
            this.deployInfo.deployEnv[i].deploySteps[j].bizScriptPath !== "") {
            this.tempObject.deployEnv[i].deploySteps[j].deployBizFlag = "on";
            }

            if (this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer !== "" &&
            this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer !== undefined) {
            if (this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.updateDB !== "" &&
                this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.updateDB !== undefined) {
                if (this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.rollbackStrategy !== "" &&
                this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.rollbackStrategy !== undefined) {
                this.tempObject.deployEnv[i].deploySteps[j].rollbackOnFailFlag = "on";
                } else {
                this.tempObject.deployEnv[i].deploySteps[j].rollbackOnFailFlag = "off";
                }
                this.tempObject.deployEnv[i].deploySteps[j].dbDeployFlag = "on";
            } else {
                this.tempObject.deployEnv[i].deploySteps[j].dbDeployFlag = "off";
            }
            } else {
            this.tempObject.deployEnv[i].deploySteps[j].dbDeployFlag = "off";
            }

            // dbDeployDBOwners
            if (this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer !== "" &&
            this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer !== undefined) {
            if (this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.dbDeployPipelineList !== undefined &&
                this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.dbDeployPipelineList !== ""
                && this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.dbDeployDBOwners !== undefined &&
                this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.dbDeployDBOwners !== "") {
                this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag = "on";
                if (this.tempObject.deployEnv[i].deploySteps[j].dependentDBDeployPipelineList === undefined) {
                this.tempObject.deployEnv[i].deploySteps[j].dependentDBDeployPipelineList = [];
                }
                if (this.tempObject.deployEnv[i].deploySteps[j].dependentDBDeployPipelineList.length === 0) {
                for (const name of this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.dbDeployPipelineList) {
                    let itemIndex;
                    itemIndex = this.IdpdataService.data.DBDeploypipelineList.map(function (e) { return e.itemName; }).indexOf(name);
                    if (itemIndex !== undefined) {
                    this.tempObject.deployEnv[i].deploySteps[j].dependentDBDeployPipelineList.
                        push(this.IdpdataService.data.DBDeploypipelineList[itemIndex]);
                    }
                }
                }

            } else {
                this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag = "off";
                this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.dbDeployPipelineList = [];
            }
            } else {
            this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag = "off";
            this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.dbDeployPipelineList = [];
            }
            if (this.deployInfo.deployEnv[i].deploySteps[j].deploymentOption !== undefined &&
            this.deployInfo.deployEnv[i].deploySteps[j].deploymentOption !== "") {


            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }

            this.tempObject.deployEnv[i].deploySteps[j].muleESBDeployFlag = "on";

            } else {
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                console.log(this.tempObject.deployEnv[i].deploySteps[j]);
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            this.deployInfo.deployEnv[i].deploySteps[j].deploymentOption = "";
            this.tempObject.deployEnv[i].deploySteps[j].muleESBDeployFlag = "off";
            }

            if (this.deployInfo.deployEnv[i].deploySteps[j].timeout !== undefined &&
            this.deployInfo.deployEnv[i].deploySteps[j].timeout !== null && this.deployInfo.deployEnv[i].deploySteps[j].timeout !== "") {
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                console.log(this.tempObject.deployEnv[i].deploySteps[j]);
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            this.tempObject.deployEnv[i].deploySteps[j].approvalCheckBox = "on";
            } else {
            if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                console.log(this.tempObject.deployEnv[i].deploySteps[j]);
                this.tempObject.deployEnv[i].deploySteps[j] = {};
            }
            this.tempObject.deployEnv[i].deploySteps[j].approvalCheckBox = "off";
            }

            // general Deploy Steps
            if (this.deployInfo.deployEnv[i].deploySteps[j].abortScript !== "" &&
            this.deployInfo.deployEnv[i].deploySteps[j].abortScript !== undefined) {
            if (this.deployInfo.deployEnv[i].deploySteps[j].abortScript.scriptType !== "" &&
                this.deployInfo.deployEnv[i].deploySteps[j].abortScript.scriptType !== undefined) {
                if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {

                this.tempObject.deployEnv[i].deploySteps[j] = {};
                }

                this.tempObject.deployEnv[i].deploySteps[j].runScriptAbortCheckBox = "on";
                if (this.deployInfo.deployEnv[i].deploySteps[j].abortScript.scriptType === "ant") {
                if (this.deployInfo.deployEnv[i].deploySteps[j].abortScript &&
                    this.deployInfo.deployEnv[i].deploySteps[j].abortScript.antPropertiesArr &&
                    this.deployInfo.deployEnv[i].deploySteps[j].abortScript.antPropertiesArr[0].antKey !== undefined &&
                    this.deployInfo.deployEnv[i].deploySteps[j].abortScript.antPropertiesArr[0].antValue !== undefined) {
                    this.deployInfo.deployEnv[i].deploySteps[j].abortScript.antProperty1 = "on";
                }
                if (this.deployInfo.deployEnv[i].deploySteps[j].abortScript &&
                    this.deployInfo.deployEnv[i].deploySteps[j].abortScript.javaOptions !== undefined) {
                    this.deployInfo.deployEnv[i].deploySteps[j].abortScript.antJavaOption1 = "on";
                }
                }

            } else {
                if (this.tempObject.deployEnv[i].deploySteps[j] === undefined) {
                this.tempObject.deployEnv[i].deploySteps[j] = {};
                }
                this.tempObject.deployEnv[i].deploySteps[j].runScriptAbortCheckBox = "off";
            }
            } else {
            this.tempObject.deployEnv[i].deploySteps[j].runScriptAbortCheckBox = "off";
            }
            this.IdpdataService.data.checkboxStatus.deployInfo = this.tempObject;
        }
        } else {
        continue;
        }

    }
  }

  /* Resets data */
  resetData() {
    const x = confirm("Are you sure to Reset ?");
    if (x) {
        const val = this.deployInfo.deployEnv;
        this.deployInfo = {
        "deployEnv": []
        };
        for (let i = 0; i < val.length; i++) {

        this.deployInfo.deployEnv.push({
            "envName": val[i].envName,
            "envFlag": "off",
        });
        }
        this.IdpdataService.data.deployInfo = this.deployInfo;
        this.IdpdataService.data.checkboxStatus.deployInfo = {};
    }

  }

  /* validation of deploy Steps
   * for each tech stack
   */
  validatePage() {
    let f = true;
    for (let i = 0; i < this.deployInfo.deployEnv.length; i++) {
        if (this.deployInfo.deployEnv[i].envFlag === "on" && this.deployInfo.deployEnv[i].deploySteps[0].pairName === "") {
        f = false;
        break;
        } else if (this.deployInfo.deployEnv[i].envFlag === "on" &&
        this.deployInfo.deployEnv[i].deploySteps[0].pairName === "" &&
        (this.deployInfo.deployEnv[i].deploySteps === undefined ||
            (this.deployInfo.deployEnv[i].deploySteps !== undefined && this.deployInfo.deployEnv[i].deploySteps.length === 0))) {
        f = false;
        break;
        } else if (this.deployInfo.deployEnv[i].envFlag === "on" &&
        this.deployInfo.deployEnv[i].deploySteps !== undefined &&
        this.deployInfo.deployEnv[i].deploySteps.length !== 0) {
        for (let j = 0; j < this.deployInfo.deployEnv[i].deploySteps.length; j++) {
            switch (this.buildInfo.buildtool) {
            /* Validation of Ant Deploy Steps */
            case "ant": {
                if ((this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === undefined ||
                this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].scriptType === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].scriptType === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === "off")
                && (this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.length <= 0)
                && (this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === "off")
                ) {
                f = false;
                break;
                }
                break;
            }
            /* Validation of Maven Deploy Steps */
            case "maven": {
                if ((this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === undefined ||
                this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].scriptType === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].scriptType === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].dockerContainerFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].dockerContainerFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === "off")
                && (this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.length <= 0)
                && (this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === "off")
                ) {
                f = false;
                break;
                }
                break;
            }
            /* validation of Angular Deploy Steps */
            case "angular": {
                if ((this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === undefined ||
                this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === "off")
                && (this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.length <= 0)
                && (this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === "off")
                ) {
                f = false;
                break;
                }
                break;
            }
            /* Validation of .Net Deploy step */
            case "msBuild": {
                if ((this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === undefined ||
                this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].deployBizFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].deployBizFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === "off") &&
                (this.tempObject.deployEnv[i].deploySteps[j].deployFabFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].deployFabFlag === "off") &&
                (this.tempObject.deployEnv[i].deploySteps[j].deployObjFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].deployObjFlag === "off")
                && (this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.length <= 0)
                && (this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === "off")) {
                f = false;
                break;
                }
                break;
            }
            /* Validation of NodeJS Deploy Step */
            case "nodeJs": {
                if ((this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === undefined ||
                this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === "off")
                && (this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.length <= 0) &&
                (this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].cloudDeploymentFlag === "off")) {
                f = false;
                break;
                }
                break;
            }
            /* validation of Python Deploy step */
            case "python": {
                if ((this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === undefined ||
                this.tempObject.deployEnv[i].deploySteps[j].runScriptFlag === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].s3Loc === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].s3Loc === "off")
                && (this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === undefined ||
                    this.tempObject.deployEnv[i].deploySteps[j].dbDeployPipelineFlag === "off")
                && (this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails === undefined ||
                    this.deployInfo.deployEnv[i].deploySteps[j].environmentProvDetails.length <= 0)) {
                f = false;
                break;
                }
                break;
            }
            default: {
            }

            }
        }

        } else if (this.deployInfo.deployEnv[i].envFlag === "off") {
        continue;
        } else {
        console.log(i);
        continue;
        }
    }

    if (f === true) {
        console.log(f);
        return true;
    } else {
        console.log(f);
        return false;
    }
  }
  /* Submitting Deploy job
   * With the details provided
   */
  go() {
    if (this.validatePage()) {
        this.IdpdataService.data.deployInfo = this.deployInfo;
        this.IdpdataService.data.masterJson["deployInfo"] = this.deployInfo;
        if (this.IdpdataService.testSubscription === true) {
        this.router.navigate(["/createConfig/testInfo"]);
        } else {
        if (this.IdpdataService.allFormStatus.basicInfo &&
            this.IdpdataService.allFormStatus.codeInfo &&
            this.IdpdataService.allFormStatus.buildInfo &&
            this.IdpdataService.allFormStatus.deployInfo) {
            this.confirmationAlert.nativeElement.click();
        } else {
            if (!this.IdpdataService.allFormStatus.basicInfo && this.listToFillFields.indexOf("BasicInfo") === -1) {
            this.listToFillFields.push("BasicInfo");
            }
            if (!this.IdpdataService.allFormStatus.codeInfo && this.listToFillFields.indexOf("CodeInfo") === -1) {
            this.listToFillFields.push("CodeInfo");
            }
            if (!this.IdpdataService.allFormStatus.buildInfo && this.listToFillFields.indexOf("BuildInfo") === -1) {
            this.listToFillFields.push("BuildInfo");
            }
            if (!this.IdpdataService.allFormStatus.deployInfo && this.listToFillFields.indexOf("DeployInfo") === -1) {
            this.listToFillFields.push("DeployInfo");
            }
            this.mandatoryFieldsAlert.nativeElement.click();
        }
        }
        return true;
    } else {
        this.missData.nativeElement.click();
    }
  }
  clearDeploySteps(envIndex) {
    this.deployInfo.deployEnv[envIndex].deploySteps = [];
    console.log(this.tempObject);
    if (this.tempObject !== undefined && this.tempObject.deployEnv !== undefined && this.tempObject.deployEnv[envIndex] !== undefined) {
        this.tempObject.deployEnv[envIndex].deploySteps = [];
    }
    return false;
  }

  clearScriptType(envIndex) {
    this.deployInfo.deployEnv[envIndex].scriptType = "";
    return false;
  }


  changeRunScript(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.scriptFilePath = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.targets = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.host = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.userName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.password = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.script = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.pathToFiles = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.destinationDir = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.flattenFilePath = "off";
    this.tempObject.deployEnv[outerIndex].deploySteps[innerIndex].transferFilesFlag = "off";
  }

  clearApproval(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].timeout = "";
    this.tempObject.deployEnv[outerIndex].deploySteps[innerIndex].runScriptAbortCheckBox =
        this.clearRunScriptOnAbort(outerIndex, innerIndex);
    return "off";
  }

  clearRunScriptOnAbort(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.scriptType = "";
    this.changeAbortRunScript(outerIndex, innerIndex);
    return "off";
  }

  changeDeploymentOption(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].muleConsoleURL = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].userName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].password = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].muleServerGroup = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].hostName = "";
  }

  changeAbortRunScript(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.scriptFilePath = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.targets = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.host = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.userName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.password = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.script = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.pathToFiles = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].abortScript.destinationDir = "";
    this.tempObject.deployEnv[outerIndex].deploySteps[innerIndex].transferFilesFlag = "off";

  }

  /* addition of Run script */
  addRunScript(outerIndex, innerIndex) {
    if (this.tempObject.deployEnv[outerIndex].deploySteps[innerIndex].runScript === undefined) {
        this.tempObject.deployEnv[outerIndex].deploySteps[innerIndex].runScript = "";
    }
    return "on";
  }

  /* Clearing the values of runscript */
  clearRunScript(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.scriptType = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.scriptFilePath = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.targets = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.host = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.userName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.password = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.script = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.pathToFiles = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.destinationDir = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.sshKey = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.sshPathToKey = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.flattenFilePath = "off";
    this.tempObject.deployEnv[outerIndex].deploySteps[innerIndex].transferFilesFlag = "off";
    return "off";

  }

  cleartransferFilesFlag(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.pathToFiles = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.destinationDir = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].runScript.flattenFilePath = "off";
    return "off";
  }


  /* Deletion of Deploy step */
  removeDeploySteps(envIndex) {
    this.deployInfo.deployEnv[envIndex].deploySteps = [];
    this.tempObject.deployEnv[envIndex].deploySteps = [];
    return false;
  }

  /* Clearing the container values */
  clearContainerValues(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.containerName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.serverManagerURL = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.warPath = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.resourceToBeDeployed = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.userName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.password = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.narOS = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.hostName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.resourceToBeDeployed = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.port = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.targetCellName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.targetServerName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.ipOrDns = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.targetServerName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.targetNodeName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.deployedFolder = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.contextPath = "";
    return "off";
  }

  changeContainerValues(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.serverManagerURL = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.warPath = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.resourceToBeDeployed = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.userName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.password = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.narOS = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.hostName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.resourceToBeDeployed = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.port = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.targetCellName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.targetServerName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.ipOrDns = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.targetServerName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.targetNodeName = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.contextPath = "";
    if (this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.containerName === "nifi") {
        this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.deployedFolder = "lib";
    } else {
        this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].deployToContainer.deployedFolder = "";
    }


  }

  clearSpringBoot(outerIndex, innerIndex) {
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].pathToFiles = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].port = "";
    this.deployInfo.deployEnv[outerIndex].deploySteps[innerIndex].parameters = "";
    return "off";
  }

  setServerIndex(stepIndex) {
    this.serverIndex = stepIndex;
    return false;
  }

  checkVal(envIndex, stepIndex) {

  }

  dockerContainerOff(envIndex, stepIndex) {
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].dockerFilePath = "";
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].tagName = "";
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].dockerPort = 80;
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].applicationPort = 80;
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].userName = "";
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].password = "";
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].repoUrl = "";
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].pullFromRepo = "off";
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].pushToRepo = "off";
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].artifact = "";
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].artifactsToBeDeployed = [];

    return false;
  }

  addArtifactField(key1, key2) {
    if (this.tempObject.deployEnv[key1].deploySteps[key2].dockerContainerFlag === "on") {
        console.log("here");
        this.deployInfo.deployEnv[key1].deploySteps[key2].artifactsToBeDeployed = [];
        this.deployInfo.deployEnv[key1].deploySteps[key2].artifactsToBeDeployed.push("");

    }
  }

  clearS3Values(i, j) {
    this.deployInfo.deployEnv[i].deploySteps[j].s3location = "";
    return "off";
  }

  checkDis(envIndex) {
    let f = false;
    for (let j = 0; j < this.tempObject.deployEnv[envIndex].deploySteps.length; j++) {
        if (this.tempObject.deployEnv[envIndex].deploySteps[j].tibcoDeploy === "on") {
        f = true;
        break;
        }

    }
    return f;
  }

  addField(key1, key2) {
    if (this.deployInfo.deployEnv[key1].deploySteps[key2].artifactsToBeDeployed === undefined ||
        this.deployInfo.deployEnv[key1].deploySteps[key2].artifactsToBeDeployed == null) {
        this.deployInfo.deployEnv[key1].deploySteps[key2].artifactsToBeDeployed = [];
    }
    this.deployInfo.deployEnv[key1].deploySteps[key2].artifactsToBeDeployed.push("");
  }
  removeField(key1, key2, index) {
    this.innerIndex = key2;
    this.outerIndex = key1;
    this.artifactIndex = index;
    this.DelField.nativeElement.click();
  }

  confirmRemoveField() {
    this.deployInfo.deployEnv[this.outerIndex].deploySteps[this.innerIndex].artifactsToBeDeployed.splice(this.artifactIndex, 1);

  }

  removeAllFields(key1, key2, index) {
    this.innerIndex = key2;
    this.outerIndex = key1;
    this.artifactIndex = index;
    this.DelAllField.nativeElement.click();
  }

  confirmRemoveAllFields() {
    this.deployInfo.deployEnv[this.outerIndex].deploySteps[this.innerIndex].artifactsToBeDeployed = [];
  }

  trackById(index, field) {
    return field.id;
  }

  /* clearing Weblogic Details */
  clearWeblogic(i, j) {
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.hostName = "";
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.port = "";
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.userName = "";
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.password = "";
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.contextPath = "";
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.resourceToBeDeployed = "";
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.targetServerName = "";
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.targetServerName = "";
    this.deployInfo.deployEnv[i].deploySteps[j].deployToContainer.targetServerName = "";
    this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag = "off";
    this.tempObject.deployEnv[i].deploySteps[j].maximoDisable = false;

  }
  enableWebLogic(i, j) {
    if (this.deployInfo.deployEnv[i].deploySteps[j].deployOperation === "earDeploy") {
        if (this.tempObject.deployEnv === undefined) {
        this.tempObject.deployEnv = [{}];
        }
        if (this.tempObject.deployEnv[i] === undefined) {
        this.tempObject.deployEnv[i] = { "deploySteps": [{}] };
        }
        this.tempObject.deployEnv[i].deploySteps[j].deployContainerFlag = "on";
        this.tempObject.deployEnv[i].deploySteps[j].maximoDisable = true;
    }
  }

  /* Ant java Options */
  openAntPropertiesField(i, j) {
    this.deployInfo.deployEnv[i].deploySteps[j].runScript.antPropertiesArr = [];
    this.addAntProperties(i, j);
    console.log("inside 1");
    return "on";
  }
  /* Addfing Ant properties for each deploy step */
  addAntProperties(i, j) {
    console.log("qwerty");
    this.deployInfo.deployEnv[i].deploySteps[j].runScript.antPropertiesArr.push({
    });
    console.log(this.deployInfo.deployEnv[i].deploySteps[j].runScript.antPropertiesArr);
  }
  clearAntPropertisField(i, j) {
    this.deployInfo.deployEnv[i].deploySteps[j].runScript.antPropertiesArr = [];
    console.log("inside 1");
    return false;
  }
  /* Removal of Ant module */
  deleteAntProp(index, i, j) {
    this.index = index;
    this.indexI = i;
    this.indexJ = j;
    this.DelAntProp.nativeElement.click();
  }

  deleteAntPropConfirm() {
    this.deployInfo.deployEnv[this.indexI].deploySteps[this.indexJ].runScript.antPropertiesArr.splice(this.index, 1);
    this.indexI = -1;
    this.indexJ = -1;
  }

  resetProxyFields(envIndex, stepIndex) {
    this.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].proxy = {
        "username": "",
        "password": "",
        "host": "",
        "port": ""

    };
    return "false";
  }

  submitData() {
    this.IdpSubmitService.submitData();
  }

  checkMsgSuccess() {
    if (this.IdpSubmitService.message === "success") {
        return true;
    } else {
        return false;
    }
  }

  checkMsgError() {
    if (this.IdpSubmitService.message === "error") {
        return true;
    } else {
        return false;
    }
  }

  freezeNavBarsCheck() {
    if (this.IdpdataService.freezeNavBars === true) {
        return true;
    } else {
        return false;
    }
  }
  deploySubscriptionNotSubmitCheck() {
    if (this.IdpdataService.deploySubscriptionSubmit !== true) {
        return true;
    } else {
        return false;
    }
  }

  deploySubscriptionSubmitCheck() {
    if (this.IdpdataService.deploySubscriptionSubmit === true) {
        return true;
    } else {
        return false;
    }
  }

  checkLoaderOn() {
    if (this.IdpSubmitService.loader === "on") {
        return true;
    } else {
        return false;
    }
  }

  checkLoaderOff() {
    if (this.IdpSubmitService.loader === "off") {
        return true;
    } else {
        return false;
    }
  }
}
