/**
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.”
*
**/
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";

@Injectable()
export class IdpdataService {

  constructor() { }
  template: any = {
    "artifactVariable": false,
    "artifactAppVariable": false,
    "grantAccess": {
        "applicationName": "",
        "developers": [],
        "pipelineAdmins": [],
        "releaseManager": [],
        "artifactToStage": {},
        "environmentOwnerDetails": [{
        "environmentName": "",
        "environmentOwners": [],
        "dBOwners": []
        }],
        "virtualServiceServerDetails": {},
        "slaveDetails": [
        {
            "slaveName": "",
            "buildServerOS": "",
            "workspacePath": "",
            "createNewSlave": "",
            "labels": "",
            "sshKeyPath": "",
            "slaveUsage": "both",
            "build": "off",
            "deploy": "off",
            "test": "off"
        }
        ]
    },
    "basicInfo": {
        "additionalMailRecipients": {
        "applicationTeam": "",
        "emailIds": "",
        "userName": ""

        },
        "pipelineStatus": "create",
        "applicationName": "",
        "buildInterval": {
        "buildInterval": "",
        "buildIntervalValue": 0,
        "pollSCM": "off"
        },
        "buildServerOS": "",
        "engine": "",
        "pipelineName": "",
        "customPipelineAdmins": [
        ]
    },
    "code": {
        "category": "",
        "technology": "",
        "subApplication": "",
        "scm": [],
        "jobParam" : [],
        "buildScript": [{ "tool": "" }, { "tool": "" }, {}]
    },
    "buildInfo": {
        "buildtool": "",
        "castAnalysis": {},
        "artifactToStage": {},
        "modules": []
    },
    "deployInfo": {
        "deployEnv": []
    },
    "testInfo": {
        "testEnv": []
    },
    "formStatus": {
        "basicInfo": {
        "appNameStatus": "0",
        "formStatus": "0"
        },
        "codeInfo": "",
        "buildInfo": {
        "buildToolStatus": "0",
        "formStatus": "0",
        "ibmsiTypeStatus": "0"
        },
        "deployInfo": "",
        "testInfo": "",
        "operation": ""
    },
    "checkboxStatus": {
        "basicInfo": {},
        "codeInfo": {},
        "buildInfo": {},
        "deployInfo": {},
        "testInfo": {},
        "others": {}
    },
    "backUp": {
        "deployInfo": {},
        "testInfo": {}
    },
    "masterJson": {},
    "pipelineList": []
  };
releaseManagerTemplate: any  = {
        "applicationName": "",
  "releasePipeline": [
    {
        "pipelineName": "",
        "release": [
        {
            "actualEndDate": "",
            "actualStartDate": "",
            "additionalMailRecipients": {
            "applicationTeam": "",
            "emailIds": ""
            },
            "branchList": [
            "na"
            ],
            "expectedEndDate": "",
            "expectedStartDate": "",
            "releaseNumber": "",
            "remarks": "",
            "status": "on",
            "vstsReleaseName": ""
        }
        ]
    }
  ]
  };

  passwordEncryptionList: any = {
    "code.scm": ["password", "PSpassword"],
    "code.buildScript": ["password"],
    "buildInfo": ["password", "artifactToStage.artifactRepo.repoPassword", "postBuildScript.password"],
    "buildInfo.modules": ["npmProxyPassword", "password", "pegaPassword", "destPassword", "siebelPassword", "ipcPassword",
        "servPass", "publishForms.password", "publishForms.dbPassword",
    "workFlowPublish.password", "workFlowPublish.dbPassword", "proxy.password", "sourcePassword"],

    "deployInfo.deployEnv.deploySteps": ["password", "ipcPassword", "dbPassword", "dbpasswordOTM",
    "dbPasswordOTM", "dbOwnerPassword", "bizPassword", "formsDbPass", "databasePassword", "ddltmpPassword",
    "datExportPassword", "workFlowDbPass", "deployPassword", "scalaPassword", "pigPassword", "hivePassword", "dbPwd", "staticPassword",
    "srfPassword", "admPassword", "adminPassword", "dbOwnerPassword", "appsPass", "tomPwd",
    "runScript.password", "deployToContainer.password", "deployToContainer.adminPassword",
    "deployToContainer.sshPassword", "deployToContainer.dbOwnerPassword",
    "deployToContainer.staticFiles.password", "deployDatabase.restorpassword",
    "deployDatabase.dbpassword", "targetPassword", "proxy.password"],

    "testInfo.testEnv.testSteps": ["runScript.password", "test.password"],

    "virtualServiceServerDetails": ["password"]
  };


  propertySCM: any = {

  };
  pipelineListRm= "";
  releaseManagerData= JSON.parse(JSON.stringify(this.releaseManagerTemplate));
  data: any = JSON.parse(JSON.stringify(this.template));
  language = "english";
  idpUserName = "";
  roles = [];
  azureadflag= false;
  expireTime: any;
  access_token: any;
  permissions = [];
  createAppflag = false;
  createOrganisationflag = false;
  createLicenseflag = false;
  createPipelineflag = false;
  copyPipelineflag = false;
  editPipelineflag = false;
  deletePipelineflag = false;
  test = false;
  loadReleasePage= false;
  devServerURL: any = "";
  subscriptionServerURL: any = "";
  IDPDashboardURL = "";
  IDPLink = "";
  geUrl = "";
  role = "";
  profile = "";
  pausedBuildsData: any= {};
  checkPausedBuilds: any= false;
  allFormStatus: any= {
    "basicInfo": false,
    "codeInfo": false,
    "buildInfo": false,
    "deployInfo": false,
    "testInfo": false,
    "workflowInfo": false
  };
  IDPDropdownProperties: any = {};
  showConfig: any;
  pa= true;
  continuecontrol: any;
  geFlag: any;
  p: any = false;
  ejbVal: any;
  warVal: any;
  jarVal: any;
  cloudDeployURL: any;
  pipelineData: any;
  triggerJobData: any;
  jobParamList: any;
  application: any;
  freezeNavBars= false;
  osFlag: any;
  op: any;
  operation: any;
  initMain: any = false;
  RestApiDetails: any = false;
  buildInfoReset = false;
  compMove: any;
  unit: any;
  uName: any= "";
  pass: any= "";
  code: any;
  serverUrl= "";


  authorization= "";
  unitTest: any= false;
  artifactVariable: any= false;
 artifactAppVariable: any= false;
  public loading =  false;
  refreshBuild= false;
     showRelease= false;
  isSAPApplication= false;
  checkpollALM: boolean ;
  SAPScmCheck: any ;
  authmode= "ldap";
  adalConfig: any=
    {"clientId": "",
    "tenate": "",
    "postLogoutRedirectUri": "",
    "endpoints": {},
  };
  pipelineName= "";
  appName= "";
  pipelineNames: any;
  releaseAddSuccess: boolean;
  releaseUpdateSuccess: boolean;
  releasePipelineName: "";
  activeReleasePipelineName: "";
  noPipelines: boolean;
  hideDashboard: boolean;
  sapNewFlag= false;
   buildSubscription= false;
  deploySubscription= false;
  testSubscription= false;
  buildSubscriptionSubmit= false;
  deploySubscriptionSubmit= false;
  noAccess: boolean;
  showService: boolean;
  flag: boolean;
  noAccessNavBars: boolean;
  scheduleJob: any;
  schedulePage: any= false;
  index: any;
  buildIntervalData: any= [];
  statusCheck: any= [];
  workflowData: any = [];
  workflowDataTemp: any = [];
  createWorkflowSequenceflag= false;
  workflowTrigger= false;
  triggerWorkflowJobData: any;
  approveBuildFlag: any= false;
  approveDeployFlag: any= false;
  keycloakToken: any;
  organization: any;
  keycloakUrl: any;
  keycloakRealm: any;
  keycloakClientId: any;

  hideApp= false;

  PagePersmission: any= {
    "basic" : false,
    "code" : false,
    "build" : false,
    "deploy": false,
    "test": false
   };
}
