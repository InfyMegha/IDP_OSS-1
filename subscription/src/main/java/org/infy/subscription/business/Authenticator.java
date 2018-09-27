package org.infy.subscription.business;

import javax.mail.PasswordAuthentication;

/**
 * 
 * @author Chidambaram_GS
 *
 */

class Authenticator extends javax.mail.Authenticator {

	private PasswordAuthentication authentication;

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public Authenticator(String username, String password) {

		authentication = new PasswordAuthentication(username, password);
	}

	/**
	 * @return PasswordAuthentication
	 */

	protected PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}