/**
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.”
*
**/
import { Component, OnInit } from "@angular/core";
import { IdprestapiService } from "../idprestapi.service";
import { Router } from "@angular/router";
import { IdpdataService } from "../idpdata.service";

@Component({
  selector: "app-success",
  templateUrl: "./success.component.html",
  styleUrls: ["./success.component.css"]
})


export class SuccessComponent implements OnInit {
  application: any;
  pipelineDetails: any;
  pipelineName: any;
  pipelineAdminName: any;
  workflowSequence: any;
  message = "created";
  ngOnInit() { }
  /* Constructor */
  constructor(
    public IdpdataService: IdpdataService,
    private IdprestapiService: IdprestapiService) {

    this.IdpdataService.freezeNavBars = false;
    this.pipelineDetails = IdpdataService.data.masterJson;
    this.pipelineAdminName = IdpdataService.idpUserName;
    this.pipelineName = this.pipelineDetails.basicInfo.pipelineName;
    this.application = this.IdpdataService.application;

  }

  /* Gets App details for Displaying in success page */
  getAppDetails(appName) {
    this.IdprestapiService.getApplicationDetails(appName)
        .then(response => {
        if (response) {
            const resp = response.json().resource;
            let parsed;
            try {
            parsed = JSON.parse(resp);
            if (parsed) {
                this.IdpdataService.application = parsed.appJson;
                console.log(this.IdpdataService.application);
                console.log(this.IdpdataService.data);
                this.application = this.IdpdataService.application;
            }
            } catch (e) {
            alert("Failed to get Application Details");
            console.log(e);
            }
        }
        });
  }
}
