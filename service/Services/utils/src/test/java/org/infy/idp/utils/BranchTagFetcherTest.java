/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.utils;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.models.GitHubBrachModel;
import org.junit.Assert;
import org.junit.Test;

public class BranchTagFetcherTest {

	@Test
	public void gitHubTest() throws Exception {

		GitHubBranchTagFetcher fetch = new GitHubBranchTagFetcher();

		List<ArrayList<String>> branchTag = fetch
				.getBranchList(new GitHubBrachModel("https://github.com", "aishwarya-chauhan6", "ilovemaths1",
						"https://github.com/aishwarya-chauhan6/myProject.git", "10.219.2.220", "80"));

		Assert.assertEquals(1, branchTag.get(0).size());
		Assert.assertEquals(0, branchTag.get(1).size());
	}

	@Test
	public void bitBucketTest() throws Exception {

		BitBucketBranchTagFetcher fetch = new BitBucketBranchTagFetcher();

		List<ArrayList<String>> branchTag = fetch.getBranchList("https://bitbucket.org",
				"aishwarya.chauhan@infosys.com", "Adi19931", "https://aishwarya6@bitbucket.org/aishwarya6/test1.git",
				"10.219.2.220", "80");

		Assert.assertEquals(2, branchTag.get(0).size());
		Assert.assertEquals(0, branchTag.get(1).size());
	}

	@Test
	public void tFSTest() throws Exception {

		TFSBranchFetcher fetch = new TFSBranchFetcher();

		ArrayList<String> branch = fetch.getAllBranches("http://tfs2013-farm01.ad.infosys.com:8080/tfs/QTOOLS",
				"$/QTOOLSTRACKER/024-JUnitRules", "1.0", "itlinfosys\\apurva.mehta", "qazwsxQAZ!@#");

		Assert.assertEquals(2, branch.size());

	}

}
