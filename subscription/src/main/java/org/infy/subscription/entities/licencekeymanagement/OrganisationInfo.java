/*******************************************************************************
createApplication * © 2018 Infosys Limited, Bangalore, India. All Rights Reserved. 
 * IDP_PaaS
 * 
 * Except for any free or open source software components embedded in this 
 * Infosys proprietary software program, this Program is protected 
 * by copyright laws, international treaties and other pending or existing 
 * intellectual property rights in India, the United States and other countries. 
 * Except as expressly permitted, any unauthorized reproduction, storage, 
 * transmission in any form or by any means (including without limitation 
 * electronic, mechanical, printing, photocopying, recording or otherwise), 
 * or any distribution of this Program, or any portion of it, may result in 
 * severe civil and criminal penalties, and will be prosecuted to the maximum 
 * extent possible under the law.
 ******************************************************************************/
package org.infy.subscription.entities.licencekeymanagement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author akash.nsoni
 *
 */

public class OrganisationInfo {

	
	@SerializedName("orgId")
	@Expose
	private long orgId;
	

	@SerializedName("orgName")
	@Expose
	private String orgName;
	
	
	@SerializedName("orgAdmin")
	@Expose
	private String orgAdmin;
	
	
	@SerializedName("domain")
	@Expose
	private String domain;
	
	@SerializedName("userName")
	@Expose
	private String userName;
	
	@SerializedName("method")
	@Expose
	private String method;
	
	@SerializedName("mailBody")
	@Expose
	private String mailBody;
	
	@SerializedName("licenseServices")
	@Expose
	private String licenseServices;
	
	@SerializedName("licenseExpirydate")
	@Expose
	private String licenseExpiryDate;
	
	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName.toUpperCase();
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName.toUpperCase();
	}

	public String getOrgAdmin() {
		return orgAdmin;
	}

	public void setOrgAdmin(String orgAdmin) {
		this.orgAdmin = orgAdmin;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getLicenseServices() {
		return licenseServices;
	}

	public void setLicenseServices(String licenseServices) {
		this.licenseServices = licenseServices;
	}

	public String getLicenseExpiryDate() {
		return licenseExpiryDate;
	}

	public void setLicenseExpiryDate(String licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	
	
}