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
package org.infy.subscription.dao;


import java.util.List;

import org.infy.subscription.entities.models.org.OrgInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author kruti.vyas
 *
 */
public interface OrgRegistrationRepository extends JpaRepository<OrgInfo, String> {

	
	 @Query("SELECT o FROM OrgInfo o")
	 public List<OrgInfo> findAllOrgList();
	 
	 @Transactional
	 @Modifying
	 @Query("UPDATE OrgInfo o set o.orgAdmin=:orgAdmin,o.domain=:domain where o.orgName=:orgName")
	 public int updateOrg(@Param("orgName") String orgName,@Param("orgAdmin") String orgAdmin,@Param("domain") String domain);
	 
	 
	 @Query("SELECT o.orgAdmin FROM OrgInfo o where o.orgName=:orgName")
	 public String findDomain(@Param("orgName") String orgName);
	
}
