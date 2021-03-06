/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
package com.infosys.json;

import org.junit.Test;

import junit.framework.Assert;


/*This class is for testing sonar*/
public class SonarTest {

	@Test
	public void blockertest(){
		Sonar s  = new Sonar();
		
		s.setBlocker(0);
		
		Assert.assertEquals((Integer)0, s.getBlocker());
	}
	
	@Test
	public void criticaltest(){
		Sonar s  = new Sonar();
		
		s.setCritical(0);;
		
		Assert.assertEquals((Integer)0, s.getCritical());
	}
	
	@Test
	public void infotest(){
		Sonar s  = new Sonar();
		
		s.setInfo(0);
		
		Assert.assertEquals((Integer)0, s.getInfo());
	}
	
	@Test
	public void majortest(){
		Sonar s  = new Sonar();
		
		s.setMajor(0);
		
		Assert.assertEquals((Integer)0, s.getMajor());
	}
	
	@Test
	public void minortest(){
		Sonar s  = new Sonar();
		
		s.setMinor(0);
		
		Assert.assertEquals((Integer)0, s.getMinor());
	}
}
