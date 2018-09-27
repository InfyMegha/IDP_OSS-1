package com.infosys.json;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VirtualServiceServerDetails {
	
	@SerializedName("serverUrl")
    @Expose
    private String serverUrl;
	
	@SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("password")
    @Expose
    private String password;
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	


}
