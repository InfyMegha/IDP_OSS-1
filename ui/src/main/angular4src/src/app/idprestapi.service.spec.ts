import { TestBed, inject } from '@angular/core/testing';

import { IdprestapiService } from './idprestapi.service';
import {
    MockBackend,
    MockConnection
} from '@angular/http/testing';
import {  HttpModule,  XHRBackend,  ResponseOptions,  Response,  RequestMethod} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { IdpdataService } from './idpdata.service';
import { CookieService } from 'ngx-cookie';
import { Router } from '@angular/router';
import { environment } from '../environments/environment';
import { Adal4Service } from 'adal-angular4';
import { StartupService } from './startup.service';
import { KeycloakService } from './keycloak/keycloak.service';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { asyncData, asyncError } from './testing/async-observables-helpers';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs';

describe('IdprestapiService', () => {
	
	let httpTestingController : HttpTestingController;
	 class  IdpdataServiceStub {


	constructor() {}
  template: any = {
    'grantAccess': {
      'applicationName': '',
      'developers': [],
      'pipelineAdmins': [],
      'releaseManager': [],
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
      'buildScript':  [{'tool':''}, {'tool':''},{}]
    },
    'buildInfo': {
      'buildtool': '',
      'castAnalysis': {},
      'artifactToStage': {},
      'modules': [],
	  'postBuildScript': {}
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
        'ibmsiTypeStatus':'0'
      },
      'deployInfo': '',
      'testInfo': '',
      'operation': ''
    },
    'checkboxStatus': {
      'basicInfo': {},
      'codeInfo':{},
      'buildInfo': {},
      'deployInfo': {},
      'testInfo': {},
      'others': {}
    },
    'backUp': {
      'deployInfo': {},
      'testInfo': {}
    },
    'masterJson': {}
  };
  data:any =  JSON.parse(JSON.stringify(this.template));


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
  refreshBuild:boolean=false;
  };
  
  class RouterStub {
    navigate(commands: any[], extras?: NavigationExtras) { };
  };
  
  class StartUpServiceStub{
	authmode = 'ldap';
    keycloakUrl = 'abc';
    keycloakRealm = 'aa';
    keycloakClientId = '';
    clouddeployurl = '';
	getData(){
		return 'data';
	}  
  };
	let idpdataserviceStub: IdpdataServiceStub=new IdpdataServiceStub();
	let routerStub: RouterStub=new RouterStub();
	let startupStub: StartUpServiceStub=new StartUpServiceStub();
  
  
	beforeEach(async(() => {
    TestBed.configureTestingModule({
      

	  imports: [FormsModule, TranslateModule, HttpModule],
	  providers: [{provide: IdprestapiService, useValue:idprestapiServiceStub},
					{provide: IdpService, useValue:idpServiceStub},
					{provide: IdpdataService, useValue:idpdataserviceStub},
					{provide: IDPEncryption, useValue:idpEncryptionStub},
                {provide: Router, useValue:routerStub},
				{
          provide: XHRBackend,
          useClass: MockBackend
        },
				IdprestapiService,TranslateService,TranslateLoader,TranslateParser
                ],
	  schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
	router = TestBed.get(Router);
	idpService = TestBed.get(IdpService);
	idpdataService = TestBed.get(IdpdataService);
	idprestapiService = TestBed.get(IdprestapiService);
	idpEncryption = TestBed.get(IDPEncryption);
    fixture = TestBed.createComponent(DependentPipelineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }); */
  function setup(){
	  
	const cookieServiceSpy =
    jasmine.createSpyObj('CookieService', ['get']);
  const stubValue = true;
  const stub = { id: 1, name: 'A' };
  const httpServiceSpy =
    jasmine.createSpyObj('Http', ['get']);
  /* const stubPromiseValue = Promise.resolve(new Response(
          new ResponseOptions({body: "Hello from the other side !!", "status": "SUCCESS", resource:"Hello from the other side !!" })
		)); */
		
	const adalServiceSpy =
    jasmine.createSpyObj('Adal4Service', ['get']);
	
	
	
	const keycloakServiceSpy =
    jasmine.createSpyObj('KeycloakService', ['get']);
	
  const idprestService = new IdprestapiService(httpServiceSpy, idpdataserviceStub, cookieServiceSpy, routerStub, adalServiceSpy, startupStub, keycloakServiceSpy);

  cookieServiceSpy.get.and.returnValue(stubValue);
  console.log(Observable.of(stub))
  httpServiceSpy.get.and.returnValue(Observable.of(stub)).and.callThrough();
  adalServiceSpy.get.and.returnValue(stubValue);
  
  keycloakServiceSpy.get.and.returnValue(stubValue);
  return { idprestService, stubValue, stub, cookieServiceSpy, httpServiceSpy, adalServiceSpy, startupStub, keycloakServiceSpy };
  }

 
 fit('#getValue should return stubbed value from a spy', () => {
    // create `getValue` spy on an object representing the ValueService
    
	const { idprestService, stubValue, stub, cookieServiceSpy, httpServiceSpy, adalServiceSpy, startupStub, keycloakServiceSpy } = setup();
	var response;
	
	idprestService.getNotification().then(res => {response=res;})
	
    expect(response)
      .toBe(stub, 'service returned stub value');
	  
    expect(httpServiceSpy.getValue.calls.count())
      .toBe(1, 'spy method was called once');
    expect(httpServiceSpy.getValue.calls.mostRecent().returnValue)
      .toBe(stubPromiseValue);
  });
  
});

