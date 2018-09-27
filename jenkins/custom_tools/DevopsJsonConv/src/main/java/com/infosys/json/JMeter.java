package com.infosys.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JMeter {

    @SerializedName("throughput")
    @Expose
    private double throughput;

    @SerializedName("responseTime")
    @Expose
    private double responseTime;
       
	public JMeter() {
		super();
		throughput = 0.0;
		responseTime = 0.0;
	}

	public double getThroughput() {
		return throughput;
	}

	public void setThroughput(double throughput) {
		this.throughput = throughput;
	}

	public double getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(double responseTime) {
		this.responseTime = responseTime;
	}    
}
