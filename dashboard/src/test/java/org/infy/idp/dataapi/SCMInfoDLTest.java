package org.infy.idp.dataapi;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.infy.idp.jsonschema.SCMInfo;
import org.infy.idp.utils.ConfigurationManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class SCMInfoDLTest {

	@Spy
	@InjectMocks
	@Autowired
	private PostGreSqlDbContext postGreSqlDbContext;
	
	@Spy
	@Autowired
	private ConfigurationManager configurationManager;
	
	@InjectMocks
	private SCMInfoDL scmInfoDL;
	
	@Before
	public void setUp() throws Exception {

		try {

			MockitoAnnotations.initMocks(this);
			Method postConstruct = PostGreSqlDbContext.class.getDeclaredMethod("init", null); // methodName,parameters
			postConstruct.setAccessible(true);
			postConstruct.invoke(postGreSqlDbContext);

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void insertSCMInfoTest() throws Throwable {
		try 
		{
			
			 List<SCMInfo> scminfolist=new ArrayList<>();
			Integer temp=scmInfoDL.insertSCMInfo(1, 1, scminfolist);
			assertEquals((Integer)1,temp);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
