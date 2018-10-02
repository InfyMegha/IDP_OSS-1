/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
package com.infosys.tools.getreports;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetAllReportsTest {
	@Mock
	private CopyFolderUtility copyFolderUtility;
	@InjectMocks
	private GetAllReports getAllReports;

	@Test
	public void createChangeLogTest() {
		try {
			GetAllReports.makeDir("string");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void copyReportsTest() {
		try {
			Boolean temp = GetAllReports.copyReports("string", "string", "string", "string", "string", "string");
			assertNotNull(temp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void copyTest() {
		try {
			GetAllReports.copy("string", "string", "string", "string", "string", "string", "string");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void performTest() {
		try {
			String[] args = { "" };
			String[] extensions = { "" };
			File file = new File("test");
			GetAllReports.perform(args, "string", "string", "string", "string", file, extensions, "string");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
