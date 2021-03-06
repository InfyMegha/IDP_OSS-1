/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
package com.infosys.jsonschema;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"id",
    "coverageMetric",
    "cyclomaticComplexity",
    "maintainabilityIndex",
    "changePronenessIndex",
    "defectPronenessIndex"
})
public class CodeMetric {
	 @JsonProperty("id")
	    private String id;
 /**
  * 
  * (Required)
  * 
  */

 /**
  * 
  * (Required)
  * 
  */
 @JsonProperty("coverageMetric")
 private double coverageMetric;
 /**
  * 
  * (Required)
  * 
  */
 @JsonProperty("cyclomaticComplexity")
 private String cyclomaticComplexity;
	
	@JsonProperty("maintainabilityIndex")
 private String maintainabilityIndex;
	
	@JsonProperty("changePronenessIndex")
 private String changePronenessIndex;

	@JsonProperty("defectPronenessIndex")
 private String defectPronenessIndex;


 /**
  * No args constructor for use in serialization
  * 
  */
 public CodeMetric() {
	 this.coverageMetric = 0.0;
     this.cyclomaticComplexity = "0.00(11)";
     this.maintainabilityIndex="0.00(5)";
     this.changePronenessIndex="0.00(0)";
     this.defectPronenessIndex="0.00(0)";
     
 }

 /**
  * 
  * @param packages
  * @param lineRate
  * @param branchRate
  */
 public CodeMetric(double lineRate, String cyclomaticComplexity, String id) {
     this.coverageMetric = lineRate;
     this.cyclomaticComplexity = cyclomaticComplexity;
     this.id=id;
 }
 @JsonProperty("id")
 public String getID() {
     return id;
 }

 /**
  * 
  * (Required)
  * 
  * @param branchRate
  *     The branch-rate
  */
 @JsonProperty("id")
 public void setID(String id) {
     this.id = id;
 }

 public CodeMetric withBranchRate(String id) {
     this.id = id;
     return this;
 }

 /**
  * 
  * (Required)
  * 
  * @param branchRate
  *     The branch-rate
  */


 /**
  * 
  * (Required)
  * 
  * @return
  *     The lineRate
  */
 @JsonProperty("coverageMetric")
 public double getcoverageMetric() {
     return coverageMetric;
 }

 /**
  * 
  * (Required)
  * 
  * @param lineRate
  *     The line-rate
  */
 @JsonProperty("coverageMetric")
 public void setcoverageMetric(double lineRate) {
     this.coverageMetric = lineRate;
 }

 public CodeMetric withcoverageMetric(double lineRate) {
     this.coverageMetric = lineRate;
     return this;
 }

 /**
  * 
  * (Required)
  * 
  * @return
  *     The packages
  */
 @JsonProperty("cyclomaticComplexity")
 public String getcyclomaticComplexity() {
     return cyclomaticComplexity;
 }

 /**
  * 
  * (Required)
  * 
  * @param string
  *     The packages
  */
 @JsonProperty("cyclomaticComplexity")
 public void setcyclomaticComplexity(String string) {
     this.cyclomaticComplexity = string;
 }

 public CodeMetric withcyclomaticComplexity(String packages) {
     this.cyclomaticComplexity = packages;
     return this;
 }
 @JsonProperty("maintainabilityIndex")
	public String getMaintainabilityIndex() {
		return maintainabilityIndex;
	}
	@JsonProperty("maintainabilityIndex")
	public void setMaintainabilityIndex(String maintainabilityIndex) {
		this.maintainabilityIndex = maintainabilityIndex;
	}
	@JsonProperty("changePronenessIndex")
	public String getChangePronenessIndex() {
		return changePronenessIndex;
	}
	@JsonProperty("changePronenessIndex")
	public void setChangePronenessIndex(String changePronenessIndex) {
		this.changePronenessIndex = changePronenessIndex;
	}
	@JsonProperty("defectPronenessIndex")
	public String getDefectPronenessIndex() {
		return defectPronenessIndex;
	}
	@JsonProperty("defectPronenessIndex")
	public void setDefectPronenessIndex(String defectPronenessIndex) {
		this.defectPronenessIndex = defectPronenessIndex;
	}

}
