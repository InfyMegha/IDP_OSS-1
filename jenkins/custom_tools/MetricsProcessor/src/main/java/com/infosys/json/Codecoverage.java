/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
package com.infosys.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Codecoverage {
	

	@SerializedName("cobertura")
	@Expose 
	private Cobertura cobertura;
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	public Cobertura getCobertura() {
		return cobertura;
	}
	@SerializedName("jacoco")
	@Expose
	private Jacoco jacoco;

	public Jacoco getJacoco() {
		return jacoco;
	}

	public void setJacoco(Jacoco jacoco) {
		this.jacoco = jacoco;
	}
	@SerializedName("istanbul")
	@Expose
	private Istanbul istanbul;
	public Istanbul getIstanbul() {
		return istanbul;
	}
	public void setIstanbul(Istanbul istanbul) {
		this.istanbul = istanbul;
	}
}
