/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.releasemanager;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slot {

	@SerializedName("slot")
	@Expose
	private List<SlotDetail> slot;

	public List<SlotDetail> getSlot() {
		return slot;
	}

	public void setSlot(List<SlotDetail> slot) {
		this.slot = slot;
	}

}
