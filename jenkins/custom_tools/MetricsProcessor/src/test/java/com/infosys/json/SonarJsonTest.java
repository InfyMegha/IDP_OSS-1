
package com.infosys.json;

import org.junit.Test;

import junit.framework.Assert;


public class SonarJsonTest {

	@Test
	public void test(){
		SonarJson sj = new SonarJson();
		
		sj.setP("none");
		
		Assert.assertEquals("none", sj.getP());		
		
	}
	
	@Test
	public void pstest(){
		SonarJson sj = new SonarJson();
		
		sj.setPs("none");
		
		Assert.assertEquals("none", sj.getPs());		
		
	}
	
	@Test
	public void totaltest(){
		SonarJson sj = new SonarJson();
		
		sj.setTotal("none");
		
		Assert.assertEquals("none", sj.getTotal());		
		
	}
}
