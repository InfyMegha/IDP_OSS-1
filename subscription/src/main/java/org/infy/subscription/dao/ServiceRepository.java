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

import org.infy.subscription.entities.licencekeymanagement.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * 
 * @author kruti.vyas
 *
 */
public interface ServiceRepository extends JpaRepository<Service, String> {
	/**
	 * 
	 * @return List<Object []>
	 */
	//@Query(nativeQuery = true, value="SELECT service_name,MAX(expiry_date) FROM tservices WHERE expiry_date>=current_date GROUP BY service_name")
	@Query(nativeQuery = true, value="SELECT service_name,MAX(expiry_date) FROM tservices WHERE expiry_date>=current_date AND org_name like :orgName GROUP BY service_name")
	List<Object[]> getAllActiveServices(@Param("orgName") String orgName);
	

}
