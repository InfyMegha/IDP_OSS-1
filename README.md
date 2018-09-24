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
<img src="/Images Folder/paas2.PNG" alt="IDP"/>
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

Below instructions will help the user to get the project up and running on their local machine for development and testing purposes. See [WIKI](https://github.com/krishnakanthbn/IDP_OSS/wiki) for notes on how to deploy the platform on a live system.

## Details on project modules

<table>
<tbody>
<tr>
  <th align="center">Module/File <img width=300/></th>
  <th align="center">Description <img width=900/></th>
  <th align="center">Tech-stack details <img width=800/></th>
</tr>
<tr>
  <td align="center"><sup><b>Dashboard</b></sup></td>
  <td><sup>This module is dedicated for collecting relevant data duing pipeline execution in Jenkins with the help of custom utilities. The data is then stored in Postgres and fed to Grafana dashboard, which is being used as a Metrics Dashboard for providing Trends/Insights from application DevOps cycle.Dashboard information population does not impacts the pipeline execution duration in Jenkins as it is done as a separate activity. </sup>

</td>
  <td>
   <ul>
   <li><sup><b>Programming Language :</b> Java, for custom utilities</sup></li>
    <li><sup><b>Dependency Management:</b> Maven</sup></li>
    <li><sup><b>Database :</b> InFlux DB</sup></li>
   <li><sup><b>Metrics Dashboard :</b> Grafana</sup></li>
  </ul>


  </td>
</tr>
<tr>
  <td align="center"><sup><b>DSL</b></sup></td>
  <td><sup>This module allows the developer to describe Jenkins jobs using Groovy-based language. The module communicates with <a href="https://wiki.jenkins.io/display/JENKINS/Job+DSL+Plugin">Jenkins Job DSL Plugin</a> which creates, updates and manages the Jenkins jobs. This allows to embrace the concept of "Configuration as a Code", thereby reducing MTTR of CICD Server (Jenkins)</sup></td>
  <td>
    <ul>
    <li><sup><b>Programming Language :</b> Groovy</sup></li>
    <li><sup><b>Dependency Management:</b> Gradle</sup></li>
    </ul>
  </td>
</tr>
<tr>
  <td align="center"><sup><b>UI</b></sup></td>
  <td><sup>This module holds all the IDP user interface code and its related dependencies</sup></td>
  <td>
    <ul>
    <li><sup><b>Framework :</b> Angular4</sup></li>
    <li><sup><b>Dependency Management:</b> NPM</sup></li>
    </ul>
  </td>
</tr>
<tr>
  <td align="center"><sup><b>Services</b></sup></td>
  <td><sup>This module is divided into number of sub-parts.</sup>
     <ul>
    <li><sup>Spring RESTful service module for creating stateless services for implementing business logic. These services can be independently deployed and scaled up using an Load Balancer</sup></li>
       <li><sup>OAuth2 authorization module for enhanced security</sup></li>
    <li><sup>Module implementing Zuul Proxy to be used as an edge gateway which would route the request through Authorization Server (if Access token is not available/expired)</sup></li>
     <li><sup>Database layer for performing CRUD operations on backend database with respect to the operation being performed</sup></li>
     <li><sup>Swagger for automatic Documentation of Services</sup></li>
    </ul>
    
 </td>
  <td>
    <ul>
    <li><sup><b>Framework :</b> Spring Boot, Spring MVC, OAUth2.0</sup></li>
    <li><sup><b>Dependency Management:</b> Maven</sup></li>
    <li><sup><b>Database:</b> Postgres</sup></li>
    </ul>
  </td>
</tr>
<tr>
  <td align="center"><sup><b>Scheduler</b></sup></td>
  <td></td>
  <td></td>
</tr>
<tr>
  <td align="center"><sup><b>Jenkins</b></sup></td>
  <td><sup>This folder contains the necessary configuration files and plugins for Jenkins to make it work smoothly with IDP. It also holds the custom tools being used by IDP for performing various operations. These custom tools are placed in Jenkins custom tools directory, from where they can be copied to any of the build agents for running some specific errands, for instance, pushing the analysis results to dashboard while the build is still running.</sup></td>
  <td align="center">-</td>
</tr>
<tr>
  <td align="center"><sup><b>Docs</b></sup></td>
  <td><sup>This folder contains the necessary documents required by the user for understanding and using IDP.</sup></td>
  <td align="center">-</td>
</tr>
<tr>
  <td align="center"><sup><b>Data Files</b></sup></td>
  <td><sup>This folder contains the database initialization scripts for both Postgres. It also consists of the Grafana configuration file (grafana.ini) with all the necessary configurations for integrating Grafana dashboard with IDP</sup></td>
  <td align="center">-</td>
</tr>
<tr>
  <td align="center"><sup><b>build.sh</b></sup></td>
  <td></td>
  <td align="center">-</td>
</tr>
</tbody>
</table>


Please read [WIKI](https://github.com/krishnakanthbn/IDP_OSS/wiki) for detailed documentation.


