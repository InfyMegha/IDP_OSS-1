/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/


package org.infy.idp.controller.appservice;
import java.util.List;

import org.infy.idp.entities.BaseResponse;
import org.infy.idp.entities.DeployArtifact;
import org.infy.idp.entities.IDPInput;
import org.infy.idp.entities.IDPServer;
import org.infy.idp.entities.JobInfo;
import org.infy.idp.entities.ResourceResponse;
import org.infy.idp.entities.TriggerDeployArtifact;
import org.infy.idp.schedulerService.GetJobParameter;
import org.infy.idp.schedulerService.NexusDetails;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


@RestController
@RequestMapping("/schedulerService")
public class ApplicationServices  extends BaseResponse
{
	protected Logger logger= LoggerFactory.getLogger(ApplicationServices.class);

	@Autowired
	 private GetJobParameter getJobParameter;
	
	@Autowired
	private NexusDetails nexusDetails;
	/**
	 * getExistingApps.
	 *
	 * @param taskid
	 *            the taskid
	 * @param jobdetails
	 *            the jobdetails
	 *@param auth the OAuth2Authentication
	 * @return the resource response
	 */
	@RequestMapping(value = "/updateScheduleDataBase", method = RequestMethod.POST)
	public ResourceResponse<String> updateDatabase(@RequestBody IDPInput jsonInput) {
		ResourceResponse<String> resourceResponse = new ResourceResponse<>();
		System.out.println("inside");
		Gson gson=new Gson();
		
		//IDPServer jsonInput= gson.fromJson(jsonString,IDPServer.class);
		//System.out.println(jsonInput.getJsonObj());
		
		try {
			System.out.println("inside");
			//System.out.println("coming to json11"+jsonInput);
			System.out.println("inside"+jsonInput.getJsonObj());
			getJobParameter.getJobParameter(jsonInput.getJsonObj(),jsonInput.getBuildId());
				resourceResponse.setStatus("SUCCESS");
		} catch (Exception ex) {
			resourceResponse.setStatus("FAILURE");
			resourceResponse.setErrorMessage(ex.toString());
		}
		return resourceResponse;
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResourceResponse<String> test() {
		System.out.println("inside");
		ResourceResponse<String> resourceResponse = new ResourceResponse<>();
		
				resourceResponse.setStatus("SUCCESS");
		
		return resourceResponse;
	}
	
	@RequestMapping(value = "/getArtifactDetails", method = RequestMethod.POST)
	public ResourceResponse<String> getArtifactDetails(@RequestBody JobInfo jobInfo ) {
		ResourceResponse<String> resourceResponse = new ResourceResponse<>();
		
		try {
				logger.info("getting ReleaseNo for Pipeline");
			
				Gson gson = new Gson();
				
				
				List<DeployArtifact> deployartifact= nexusDetails.getArtifact(jobInfo.getApplicationName(),jobInfo.getPipelineName(),jobInfo.getReleaseNumber(),jobInfo.getEnvironmentName());
				DeployArtifact latestArtifact=null;
				if(deployartifact.size()>0){
					latestArtifact=deployartifact.get(0);
					String artifact[] =latestArtifact.getArtifactName().split("-");
					int index=Integer.parseInt(artifact[artifact.length-1]);
				for(DeployArtifact artifactName :deployartifact)
				{
					String new_artifact[] =artifactName.getArtifactName().split("-");
					int index_new=Integer.parseInt(new_artifact[new_artifact.length-1]);
					if(index_new>index)
					{
						latestArtifact=artifactName;
						index=index_new;
					}
				}}
			//	TriggerDeployArtifact triggerDeployArtifact =new TriggerDeployArtifact();
				resourceResponse.setStatus("SUCCESS");
			//	triggerDeployArtifact.setArtifactList(deployartifact);
				resourceResponse.setResource(gson.toJson(latestArtifact , DeployArtifact.class));
			
			
		} catch (Exception ex) {
			resourceResponse.setStatus("FAILURE");
			resourceResponse.setErrorMessage(ex.toString());
			this.logger.error(ex.toString(), ex);
		}
		return resourceResponse;
	}
	
	
	/**
	 * getExistingAppNames.
	 *
	 *@param auth the OAuth2Authentication
	 * @return the resource response
	 */
	
}
