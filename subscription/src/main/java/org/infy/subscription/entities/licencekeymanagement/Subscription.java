package org.infy.subscription.entities.licencekeymanagement;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * 
 * @author kruti.vyas
 *
 */
public class Subscription {
	@SerializedName("service")
    @Expose
	List<Service> subscriptionTypes;

	public List<Service> getSubscriptionTypes() {
		return subscriptionTypes;
	}

	public void setSubscriptionTypes(List<Service> subscriptionTypes) {
		this.subscriptionTypes = subscriptionTypes;
	}
	

}
