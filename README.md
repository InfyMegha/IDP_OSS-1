<div align="center"><img src="/Images Folder/idplogo1 (2).png" align="top" />
</div>
<br/>
<div align="center"
<p><strong><em>Jump start the DevOps Adoption </em></span></strong></p>
<!--IDP Release --> 
</div>
<div align="center">
<img src="/Images Folder/captcha1.PNG"/>
<hr/>
</div>
<div align="center">
<img src="/Images Folder/paas1.PNG" alt="IDP"/>
<br/>
<img src="/Images Folder/idp2.gif" alt="IDP" />
<br/>
<h6>For more information, check out below links</h6>
<h6><a href="https://www.youtube.com/watch?v=8V0OKlB-d2I" target="_blank">https://www.youtube.com/watch?v=8V0OKlB-d2I</a></h6>
<h6><a href="https://www.youtube.com/watch?time_continue=1&v=t8cuE3Jog2U" target="_blank">https://www.youtube.com/watch?time_continue=1&v=t8cuE3Jog2U</a></h6>
</div>
<hr/>

# About the repository

This repository is intended to hold the code base along with the required dependencies for the Infosys DevOps Platform.

## Getting Started

Below instructions will help the user to get the project up and running on their local machine for development and testing purposes. See [WIKI](/wiki) for notes on how to deploy the platform on a live system.

## Details on project modules

<table>
<colgroup>
<col width="150" />
<col width="250" />
<col width="200" />
</colgroup>

<tbody>
<tr>
  <th align="center">Module/File</th>
  <th align="center">Description</th>
  <th align="center">Tech-stack details</th>
</tr>
<tr>
  <td align="center"><b>Dashboard</b></td>
  <td>This module is dedicated for collecting relevant data duing pipeline execution in Jenkins with the help of custom utilities. The data is then stored in Postgres and fed to Grafana dashboard, which is being used as a Metrics Dashboard for providing Trends/Insights from application DevOps cycle.Dashboard information population does not impacts the pipeline execution duration in Jenkins as it is done as a separate activity. 

</td>
  <td>
    <ol>
    <li><b>Programming Language :</b> Java, for custom utilities</li>
    <li><b>Dependency Management:</b> Maven</li>
    <li><b>Database :</b> InFlux DB</li>
    <li><b>Metrics Dashboard :</b> Grafana</li>
    </ol>
  </td>
</tr>
<tr>
  <td align="center"><b>DSL</b></td>
  <td>This module allows the developer to describe Jenkins jobs using Groovy-based language. The module communicates with <a href="https://wiki.jenkins.io/display/JENKINS/Job+DSL+Plugin">Jenkins Job DSL Plugin</a> which creates, updates and manages the Jenkins jobs. This allows to embrace the concept of "Configuration as a Code", thereby reducing MTTR of CICD Server (Jenkins)</td>
  <td>
    <ol>
    <li><b>Programming Language :</b> Groovy</li>
    <li><b>Dependency Management:</b> Gradle</li>
    </ol>
  </td>
</tr>
<tr>
  <td align="center"><b>UI</b></td>
  <td>This module holds all the IDP user interface code and its related dependencies</td>
  <td>
    <ol>
    <li><b>Framework :</b> Angular4</li>
    <li><b>Dependency Management:</b> NPM</li>
    </ol>
  </td>
</tr>
<tr>
  <td align="center"><b>Services</b></td>
  <td>This module is divided into number of sub-parts.
     <ol>
    <li>Spring RESTful service module for creating stateless services for implementing business logic. These services can be independently deployed and scaled up using an Load Balancer</li>
    <li>OAuth2 authorization module for enhanced security</li>
    <li>Module implementing Zuul Proxy to be used as an edge gateway which would route the request through Authorization Server (if Access token is not available/expired)</li>
     <li>Database layer for performing CRUD operations on backend database with respect to the operation being performed</li>
     <li>Swagger for automatic Documentation of Services</li>
    </ol>
    
 </td>
  <td>
    <ol>
    <li><b>Framework :</b> Spring Boot, Spring MVC, OAUth2.0</li>
    <li><b>Dependency Management:</b> Maven</li>
    <li><b>Database:</b> Postgres</li>
    </ol>
  </td>
</tr>
<tr>
  <td align="center"><b>Scheduler</b></td>
  <td></td>
  <td></td>
</tr>
<tr>
  <td align="center"><b>Jenkins</b></td>
  <td>This folder contains the necessary configuration files and plugins for Jenkins to make it work smoothly with IDP. It also holds the custom tools being used by IDP for performing various operations. These custom tools are placed in Jenkins custom tools directory, from where they can be copied to any of the build agents for running some specific errands, for instance, pushing the analysis results to dashboard while the build is still running.</td>
  <td align="center">-</td>
</tr>
<tr>
  <td align="center"><b>Docs</b></td>
  <td>This folder contains the necessary documents required by the user for understanding and using IDP.</td>
  <td align="center">-</td>
</tr>
<tr>
  <td align="center"><b>Data Files</b></td>
  <td>This folder contains the database initialization scripts for both Postgres. It also consists of the Grafana configuration file (grafana.ini) with all the necessary configurations for integrating Grafana dashboard with IDP</td>
  <td align="center">-</td>
</tr>
<tr>
  <td><b>build.sh</b></td>
  <td></td>
  <td align="center">-</td>
</tr>
</tbody>
</table>


Please read [WIKI](/wiki) for detailed documentation.


