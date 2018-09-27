/*******************************************************************************
createApplication * � 2018 Infosys Limited, Bangalore, India. All Rights Reserved. 
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

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author kruti.vyas
 *
 */

@Entity
@Table(name = "tservices")
public class Service {

	@EmbeddedId
	private ServiceIdentity serviceIdentity;
	
	@Column(name = "expiry_date")
	@SerializedName("expiryDate")
	@Expose
	private Date expiryDate;

	@Column(name = "org_name")
	@SerializedName("orgName")
	@Expose
	private String orgName;
	
	public String getOrgName() {
		return orgName.toUpperCase();
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName.toUpperCase();
	}

	public ServiceIdentity getServiceIdentity() {
		return serviceIdentity;
	}

	public void setServiceIdentity(ServiceIdentity serviceIdentity) {
		this.serviceIdentity = serviceIdentity;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	

}
