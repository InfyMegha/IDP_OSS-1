/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
package com.infosys.json;

public class TSLint {
private Integer highViolations;
private Integer lowViolations;
private Integer mediumViolations;
public void setHighViolations(Integer highViolations) {
	this.highViolations = highViolations;
}
public Integer getHighViolations() {
	return highViolations;
}
public void setLowViolations(Integer lowViolations) {
	this.lowViolations = lowViolations;
}
public Integer getLowViolations() {
	return lowViolations;
}
public void setMediumViolations(Integer mediumViolations) {
	this.mediumViolations = mediumViolations;
}
public Integer getMediumViolations() {
	return mediumViolations;
}
}
