/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
package com.infosys.utilities.export;

import static org.junit.Assert.*;

import org.junit.Test;

import com.infosys.utilities.export.SavedManifest.ClassDefinitions;
import com.infosys.utilities.export.SavedManifest.Documents;
import com.infosys.utilities.export.SavedManifest.EventActions;
import com.infosys.utilities.export.SavedManifest.Folders;
import com.infosys.utilities.export.SavedManifest.LifeCycleActions;
import com.infosys.utilities.export.SavedManifest.LifeCyclePolicies;
import com.infosys.utilities.export.SavedManifest.Others;
import com.infosys.utilities.export.SavedManifest.PropertyTemplates;

public class SavedManifestTest {

	@Test
	public void testEquals()
	{
		SavedManifest savedManifest=new SavedManifest();
		
		
		savedManifest.setChoiceLists("choicelists");
		savedManifest.setFDMVersion("version");
		savedManifest.setPrimaryObjectStore("object");
		
		assertEquals("choicelists",savedManifest.getChoiceLists());
		assertEquals("version",savedManifest.getFDMVersion());
		assertEquals("object",savedManifest.getPrimaryObjectStore());
		assertEquals(0,savedManifest.getClassDefinitions().size());
		assertEquals(0,savedManifest.getDocuments().size());
		assertEquals(0,savedManifest.getEventActions().size());
		assertEquals(0,savedManifest.getFolders().size());
		assertEquals(0,savedManifest.getLifeCycleActions().size());
		assertEquals(0,savedManifest.getLifeCyclePolicies().size());
		assertEquals(0,savedManifest.getOthers().size());
		assertEquals(0,savedManifest.getPropertyTemplates().size());
		
		
		
	}
	
	@Test
	public void testNotEquals()
	{
		SavedManifest savedManifest=new SavedManifest();
		
		
		savedManifest.setChoiceLists("choicelists");
		savedManifest.setFDMVersion("version");
		savedManifest.setPrimaryObjectStore("object");
		
		assertNotEquals("choicelists",savedManifest.getChoiceLists());
		assertNotEquals("version",savedManifest.getFDMVersion());
		assertNotEquals("object",savedManifest.getPrimaryObjectStore());
		assertNotEquals(1,savedManifest.getClassDefinitions().size());
		assertNotEquals(1,savedManifest.getDocuments().size());
		assertNotEquals(1,savedManifest.getEventActions().size());
		assertNotEquals(1,savedManifest.getFolders().size());
		assertNotEquals(1,savedManifest.getLifeCycleActions().size());
		assertNotEquals(1,savedManifest.getLifeCyclePolicies().size());
		assertNotEquals(1,savedManifest.getOthers().size());
		assertNotEquals(1,savedManifest.getPropertyTemplates().size());
		
		
		
	}
}
