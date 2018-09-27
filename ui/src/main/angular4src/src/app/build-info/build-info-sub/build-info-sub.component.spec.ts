/**
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.”
*
**/
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { BuildInfoSubComponent } from './build-info-sub.component';
import { FormsModule } from '@angular/forms';
import { IdpService } from '../../idp-service.service';
import { IdpdataService } from '../../idpdata.service';
import { IdprestapiService } from '../../idprestapi.service';
import { Router, NavigationExtras } from '@angular/router';
import { ParentFormConnectComponent } from '../../parent-form-connect/parent-form-connect.component';
import { TranslateModule, TranslateStaticLoader, TranslateLoader } from "ng2-translate";
import { HttpModule, Http } from '@angular/http';
describe('BuildInfoSubComponent', () => {
  let component: BuildInfoSubComponent;
  let fixture: ComponentFixture<BuildInfoSubComponent>;
  let idpService: IdpService;
  let idpdataService: IdpdataService;
  let idprestapiService: IdprestapiService;
  let router: Router;

  class  IdpdataServiceStub {

    constructor() {}
    template: any = {
    'artifactVariable':false,
    'artifactAppVariable':false,
      'grantAccess': {
        'applicationName': '',
        'developers': [],
        'pipelineAdmins': [],
        'releaseManager': [],
        'artifactToStage':{},
        'environmentOwnerDetails': [{
          'environmentName': '',
          'environmentOwners': [],
          'dbOwners': []
        }],
        'slaveDetails': [
          {
            'slaveName': '',
            'buildServerOS': '',
            'workspacePath': '',
            'createNewSlave': '',
            'labels': '',
            'sshKeyPath': '',
            'slaveUsage': 'both'
          }
        ]
      },
      'basicInfo': {
        'additionalMailRecipients': {
          'applicationTeam': '',
          'emailIds': ''
        },
        'applicationName': '',
        'buildInterval': {
          'buildInterval': '',
          'buildIntervalValue': 0,
          'pollSCM': 'off'
        },
        'buildServerOS': '',
        'engine': '',
        'pipelineName': ''
      },
      'code': {
        'category': '',
        'technology': '',
        'scm': [],
        'buildScript': [{ 'tool': '' }, { 'tool': '' }, {}]
      },
      'buildInfo': {
        'buildtool': '',
        'castAnalysis': {},
        'artifactToStage': {},
        'modules': []
      },
      'deployInfo': {
        'deployEnv': []
      },
      'testInfo': {
        'testEnv': []
      },
      'formStatus': {
        'basicInfo': {
          'appNameStatus': '0',
          'formStatus': '0'
        },
        'codeInfo': '',
        'buildInfo': {
          'buildToolStatus': '0',
          'formStatus': '0',
          'ibmsiTypeStatus': '0'
        },
        'deployInfo': '',
        'testInfo': '',
        'operation': ''
      },
      'checkboxStatus': {
        'basicInfo': {},
        'codeInfo': {},
        'buildInfo': {},
        'deployInfo': {},
        'testInfo': {},
        'others': {}
      },
      'backUp': {
        'deployInfo': {},
        'testInfo': {}
      },
      'masterJson': {},
      'pipelineList':[]
    };
    data: any = JSON.parse(JSON.stringify(this.template));

  language = 'english';
  idpUserName = '';
  roles = [];
  access_token:any;
  permissions = [];
  createAppflag = false;
  createPipelineflag = false;
  copyPipelineflag = false;
  editPipelineflag = false;
  deletePipelineflag = false;
  test = false;
  devServerURL: any='';
  IDPDashboardURL = '';
  IDPLink = '';
  geUrl = '';
  role = '';
  IDPDropdownProperties: any = {};
  showConfig:any;
  pa:boolean=true;
  continuecontrol:any;
  geFlag:any;
  p:any=false;
  ejbVal:any;
  warVal:any;
  jarVal:any;
  pipelineData:any;
  triggerJobData:any;
  application:any;
  freezeNavBars:boolean=false;
  osFlag:any;
  op:any;
  operation:any;
  initMain:any=false;
  RestApiDetails:any=false;
  buildInfoReset=false;
  compMove:any;
  unit:any;
  code:any;
  artifactVariable:any=false;
 artifactAppVariable:any=false;
  refreshBuild:boolean=false;
  };

  class  IdpServiceStub {

  };
  class  IdprestapiServiceStub {

  };

  class RouterStub {
    navigate(commands: any[], extras?: NavigationExtras) { };
  };

  let idpdataserviceStub: IdpdataServiceStub=new IdpdataServiceStub();
  let routerStub: RouterStub=new RouterStub();
  let idpServiceStub:IdpServiceStub = new IdpServiceStub();
  let idprestapiServiceStub: IdprestapiServiceStub=new IdprestapiServiceStub();

  beforeEach(async(() => {
      TestBed.configureTestingModule({
      declarations: [ BuildInfoSubComponent,ParentFormConnectComponent ],
      imports: [FormsModule,TranslateModule.forRoot({
            provide: TranslateLoader,
            useFactory: (http: Http) => new TranslateStaticLoader(http, 'public/assets/i18n', '.json'),
            deps: [Http]
        })],
      providers: [{provide: IdprestapiService, useValue:idprestapiServiceStub},
            {provide: IdpService, useValue:idpServiceStub},
            {provide: IdpdataService, useValue:idpdataserviceStub},
                  {provide: Router, useValue:routerStub}
                  ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    router = TestBed.get(Router);
    idpService = TestBed.get(IdpService);
    idpdataService = TestBed.get(IdpdataService);
    idprestapiService = TestBed.get(IdprestapiService);
    fixture = TestBed.createComponent(BuildInfoSubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('Artifact for Nexus', () => {
    component.buildInfo.artifactToStage.artifactRepoName='nexus';
    component.naArtifact();
    expect(component.IdpdataService.artifactVariable).toBeTruthy();
  });

  it('Artifact for NA', () => {
    component.buildInfo.artifactToStage.artifactRepoName='na';
    component.buildInfo.artifactToStage.artifactRepo={};
    component.buildInfo.artifactToStage.artifact='';
    component.naArtifact();
    expect(component.IdpdataService.artifactVariable).toBeFalsy();
  });

  it('Clear RunScripts', () => {

	var a=  component.clearRunScripts();
     expect(component.buildInfo.postBuildScript.tool).toBe('');
	 	 expect(component.checkBoxObject.transferFilesFlag).toBe('off');
    expect(component.buildInfo.postBuildScript.host).toBe('');
    expect(component.buildInfo.postBuildScript.userName).toBe('');
	expect(component.buildInfo.postBuildScript.password).toBe('');
    expect(component.buildInfo.postBuildScript.sshKey ).toBe('');
expect(component.buildInfo.postBuildScript.sshPathToKey).toBe('');
    expect(component.buildInfo.postBuildScript.script).toBe('');


    expect(a).toBe("off");
  });

  
   it('clearPostbuild', () => {

	var a=  component.clearPostbuild();
     expect(component.buildInfo.postBuildScript.tool).toBe('');
	  expect(component.buildInfo.postBuildScript.archiveLogs).toBe('');
	   expect(component.checkBoxObject.postBuildRunScript).toBe('off');
	 	 expect(component.checkBoxObject.transferFilesFlag).toBe('off');
    expect(component.buildInfo.postBuildScript.host).toBe('');
    expect(component.buildInfo.postBuildScript.userName).toBe('');
	expect(component.buildInfo.postBuildScript.password).toBe('');
    expect(component.buildInfo.postBuildScript.sshKey ).toBe('');
expect(component.buildInfo.postBuildScript.sshPathToKey).toBe('');
    expect(component.buildInfo.postBuildScript.script).toBe('');


    expect(a).toBe("off");
  });
  
  
 it('openAntPropertiesField', () => {

	var a=  component.openAntPropertiesField();
     expect(component.buildInfo.postBuildScript.antPropertiesArr).toBe([]);	  
	

    expect(a).toBe("on");
  });

  
     it('clearAntPropertisField', () => {

	var a=  component.clearAntPropertisField();
     expect(component.buildInfo.postBuildScript.antPropertiesArr).toBe({});	  
     expect(component.buildInfo.postBuildScript.antPropertiesArr).toBe({});	  

    expect(a).toBeFalsy();
  });

   it('clearAntPropertisField', () => {

	var a=  component.clearAntPropertisField();
     expect(component.buildInfo.postBuildScript.antPropertiesArr).toBe({});	  
     expect(component.buildInfo.postBuildScript.antPropertiesArr).toBe({});	  

    expect(a).toBeFalsy();
  });

  it('Clear Artifact', () => {
    expect(component.buildInfo.artifactToStage.artifactRepoName).toBe('');
    expect(component.buildInfo.artifactToStage.artifactRepo).toBe({});
    expect(component.buildInfo.artifactToStage.artifact).toBe('');
	 expect(component.checkBoxObject.nugetPackage).toBe('off');
    //component.clearRunScripts();
    expect(component.clearArtifact()).toBe("off");
  });
  
  
 it('openPostBuild()', () => {
      var a=component.openPostBuild();

      expect(a).toBe('on');
  });
  
  
  it('clearBuild()', () => {
      var a=component.clearBuild();
	   expect(component.buildInfo.postBuildScript.scriptFilePath).toBe('');
	  expect(component.buildInfo.postBuildScript.targets).toBe('');

  });
  
  
    it('clearNugetDetails()', () => {
      var a=component.clearNugetDetails();
	   expect(component.buildInfo.artifactToStage.nuspecFilePath).toBe('');
	  expect(component.buildInfo.artifactToStage.nexusAPIKey).toBe('');
	expect(a).toBe('off');
  });
  
  

  
  it('checkCheckBox', () => {
	  component.buildInfo.postBuildScript =undefined;
	  
	  component.checkCheckBox();
    expect(component.buildInfo.postBuildScript).toBe([]);
  });
  
  

  });


