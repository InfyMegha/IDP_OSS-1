/**
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.”
*
**/
package org.infy.subscription.business;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.infy.subscription.entities.licencekeymanagement.OrganisationInfo;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class EmailSender.
 */
@Component
public class EmailSender {

	private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

	private static final String CREATE_ORG_MAIL_TEMPLATE_PATH = "CreateOrgMail.html";
	//private static final String CREATE_LICENSE_MAIL_TEMPLATE_PATH = "CreateLicenseMail.html";
	private static final String IDP_LINK = "IDP_LINK";
	private static final String USER = "USER";
	private static final String ORGANISATION = "ORGANIZATION";
	private static final String METHOD = "METHOD";
	private static final String LICENSE_SERVICES = "LICENSE_SERVICES";
	private static final String LICENSE_EXPIRY_DATE = "LICENSE_EXPIRY_DATE";

	@Value("${idplink}")
	private String idpLink;
	
	@Value("${emailserver}")
	private String emailServer;
	
	@Value("${emaildomain}")
	private String emailDomain;
	
	@Value("${emailusername}")
	private String emailUserName;
	
	@Value("${emailpassword}")
	private String emailPassword;
	
	@Value("${emailsmtphost}")
	private String emailSmtpHost;
	
	@Value("${emailsmtpport}")
	private String emailSmtpPort;

	@Value("${emailsenderid}")
	private String emailSenderId;
	
	@Autowired
	private OrgBL organisationBL;
	
	EmailSender() {
	}

	/**
	 * 
	 * jobCreationSuccessMail
	 * 
	 * @param triggerJobName
	 *            the TriggerJobName
	 * 
	 * @return boolean
	 * 
	 *         Method is used to send the org creation success mail
	 *
	 */
	public boolean orgCreationSuccessMail(OrganisationInfo orgInfo) {
		boolean status = true;
		String sub = "organisation";
		orgInfo.setMailBody(
				createOrgMailBody(orgInfo));
		String emailserver = this.emailServer;
		if (emailserver.equalsIgnoreCase("sendgrid")) {
			status = sendEmailSendGrid(sub, orgInfo);
		}
		else {
			status = sendEmail(sub, orgInfo);
		}
		return status;
	}
	
	
	/**
	 * 
	 * licenseCreationSuccessMail
	 * 
	 * @param triggerJobName
	 *            the TriggerJobName
	 * 
	 * @return boolean
	 * 
	 *         Method is used to send the org creation success mail
	 *
	 */
	public boolean licenseCreationSuccessMail(OrganisationInfo orgInfo) {
		boolean status = true;
		String sub = "License";
		orgInfo.setMailBody(
				createLicenseMailBody(orgInfo));
		String emailserver = this.emailServer;
		String orgDomain = organisationBL.findDomain(orgInfo.getOrgName());
		orgInfo.setDomain(orgDomain);
		if (emailserver.equalsIgnoreCase("sendgrid")) {
			status = sendEmailSendGrid(sub, orgInfo);
		}
		else {
			status = sendEmail(sub, orgInfo);
		}
		return status;
	}
	
	/**
	 * 
	 * sendEmail SendGrid
	 * 
	 * @param triggerJobName
	 *            the TriggerJobName
	 * @param user
	 *            the String
	 * @param email
	 *            the List
	 * 
	 * @return List<String>
	 * 
	 *         Method is used to send the job creation success mail through send grid in azure
	 *
	 */
	@SuppressWarnings("static-access")
	public boolean sendEmailSendGrid(String sub, OrganisationInfo orgInfo) {
		logger.info("Inside send mail");
		String to;		
		to = orgInfo.getUserName() + "@" + orgInfo.getDomain();
		String from = "";
		String username = this.emailUserName;
		String senderid = this.emailSenderId;
		if (senderid.contains("@")) {
			from = this.emailSenderId;
		} else {
			from = this.emailSenderId + this.emailDomain;
		}

		String host = this.emailSmtpHost;
		String port = this.emailSmtpPort;
		
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", host);
		Session session = null;
		if (!("".equals(this.emailPassword))) {
			logger.info("Tryiny to send email with Authentication... ");
			String password = this.emailPassword;
			Authenticator authenticator = new Authenticator(username, password);
			properties.setProperty("mail.smtp.port", port);
			properties.put("mail.transport.protocol", "smtp"); 
			properties.setProperty("mail.smtp.auth", "true");
			properties.put("mail.smtp.timeout", "60000");
	        properties.put("mail.smtp.connectiontimeout","60000"); 
			properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
			session = Session.getDefaultInstance(properties, authenticator);
		} else {
			logger.info("Tryiny to send email without Authentication...");
			session = Session.getDefaultInstance(properties);
		}
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("IDP: " + sub + " configuration details ");
			message.setContent(orgInfo.getMailBody(), "text/html");

			logger.info(orgInfo.getMailBody());
			logger.info(message.getContent().toString());
			
			Transport transport = session.getTransport();
			transport.connect();
			transport.send(message);
			transport.close();
			logger.info("Mail sent successfully");
		}

		catch (MessagingException | IOException e) {
			logger.info(orgInfo.getMailBody());

			logger.error("mail could not be sent", e);
			logger.debug(e.getMessage(), e);

		}

		return true;
	}


	/**
	 * 
	 * sendEmail
	 * 
	 * @param triggerJobName
	 *            the TriggerJobName
	 * @param user
	 *            the String
	 * @param email
	 *            the List
	 * 
	 * @return List<String>
	 * 
	 *         Method is used to send the job creation success mail
	 *
	 */

	public boolean sendEmail(String sub, OrganisationInfo orgInfo) {

		logger.info("Inside send mail");
		String to;
		to = orgInfo.getUserName() + "@" + orgInfo.getDomain();
//		String cc = getCC(emails);
		String from = "";
		String username = this.emailUserName;
		if (username.contains("@")) {
			from = this.emailUserName;
		} else {
			from = this.emailUserName + this.emailDomain;
		}

		String host = this.emailSmtpHost;
		String port = this.emailSmtpPort;
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = null;
		if (!("".equals(this.emailPassword))) {
			logger.info("Trying to send email with Authentication... ");

			String password = this.emailPassword;
			Authenticator authenticator = new Authenticator(username, password);
			properties.setProperty("mail.smtp.port", port);

			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
			session = Session.getInstance(properties, authenticator);
		} else {
			logger.info("Tryiny to send email without Authentication...");
			session = Session.getDefaultInstance(properties);
		}
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
			message.setSubject("IDP: " + sub + " configuration details ");
			message.setContent(orgInfo.getMailBody(), "text/html");

			logger.info(orgInfo.getMailBody());
			logger.info(message.getContent().toString());

			Transport.send(message);
			logger.info("Mail sent successfully");
		}

		catch (MessagingException | IOException e) {
			logger.info(orgInfo.getMailBody());

			logger.error("mail could not be sent", e);
			logger.debug(e.getMessage(), e);

		}

		return true;
	}

	/**
	 * 
	 * @param emails
	 * @return String
	 */
	public String getCC(List<String> emails) {
		StringBuilder cc = new StringBuilder();
		int emailsSize = emails.size();
		for (int i = 0; i < emailsSize; i++) {
			cc.append(emails.get(i));
			cc.append(",");
		}
		return cc.toString();
	}

	
	/**
	 * 
	 * getUsersFromApplication
	 * 
	 * @param triggerJobName
	 *            the TriggerJobName
	 * @param user
	 *            the String
	 * 
	 * @return List<String>
	 * 
	 *         Method is used to send the job creation success mail
	 *
	 */
	/*
	public List<String> getUsersFromApplication(String applicationName, String pipelineName, String user) {

		TriggerJobName triggerJobName = new TriggerJobName();
		triggerJobName.setApplicationName(applicationName);
		triggerJobName.setPipelineName(pipelineName);
		triggerJobName.setUserName(user);
		List<String> users = getUsersFromApplication(triggerJobName, user);
		return users;

	}*/

	/**
	 * 
	 * @param triggerJobName
	 * @param user
	 * @return List<String>
	 */
	/*public List<String> getUsersFromApplication(TriggerJobName triggerJobName, String user) {

		List<String> emails = new ArrayList<>();
		try {
			boolean team = true;

			ApplicationInfo app = getJobDetails.getApplication(triggerJobName.getApplicationName());
			IDPJob idp = getJobDetails.getPipelineInfo(triggerJobName.getApplicationName(),
					triggerJobName.getPipelineName());
			if (idp.getBasicInfo().getAdditionalMailRecipients() != null
					&& idp.getBasicInfo().getAdditionalMailRecipients().getApplicationTeam() != null
					&& idp.getBasicInfo().getAdditionalMailRecipients().getApplicationTeam().equalsIgnoreCase("On")) {
				emails = fetchJobDetails.getEmailRecipients(app);
				team = false;
			}
			if (team) {
				emails = fetchJobDetails.getPipelineAdmins(app);
			}
			if (idp.getBasicInfo().getAdditionalMailRecipients() != null
					&& idp.getBasicInfo().getAdditionalMailRecipients().getEmailIds() != null
					&& !("".equals(idp.getBasicInfo().getAdditionalMailRecipients().getEmailIds()))) {
				emails = fetchJobDetails.splitUsers(idp.getBasicInfo().getAdditionalMailRecipients().getEmailIds(),
						emails);
			}

			emails = getUserEmailIds(emails);

		} catch (SQLException e) {
			logger.error("Error in getting aplication", e);
			logger.debug("Error in getting application : " + triggerJobName.getApplicationName());
		}
		return emails;

	}*/

	/**
	 * 
	 * getUsersForApplication
	 * 
	 * @param triggerJobName
	 *            the TriggerJobName
	 * @param user
	 *            the String
	 * 
	 * @return List<String>
	 * 
	 *         Method is used to send the job creation success mail
	 *
	 */
	/*public List<String> getUsersForApplication(TriggerJobName triggerJobName, String user) {

		List<String> emails = new ArrayList<>();
		try {
			ApplicationInfo app = getJobDetails.getApplication(triggerJobName.getApplicationName());
			emails = fetchJobDetails.getEmailRecipients(app);
			emails = getUserEmailIds(emails);

		} catch (SQLException e) {
			logger.error("Error in getting aplication", e);
			logger.debug("Error in getting application : " + triggerJobName.getApplicationName());
		}
		return emails;

	}
*/
	/**
	 * 
	 * getUserEmailIds
	 * 
	 * @param users
	 *            the List<String>
	 * 
	 * @return List<String>
	 * 
	 *         Method is used to send the job creation success mail
	 *
	 */
/*
	public List<String> getUserEmailIds(List<String> users) {

		String domain = configmanager.getEmaildomain();
		List<String> emails = new ArrayList<>();
		int userSize = users.size();
		for (int i = 0; i < userSize; i++) {
			if (!users.get(i).contains(domain)) {

				emails.add(users.get(i) + domain);
			} else {

				emails.add(users.get(i));
			}
		}
		return emails;

	}
*/
	/**
	 * 
	 * createOrgMailBody
	 * 
	 * @param idp
	 *            the IDPJob>
	 * 
	 * @return String
	 * 
	 *         Method is used to create mail body
	 *
	 */

	public String createOrgMailBody(OrganisationInfo org) {

		String idpLink = this.idpLink;
		String method = "";
	
		if ("create".equalsIgnoreCase(org.getMethod())) {
			method = "created";
		} else if ("edit".equalsIgnoreCase(org.getMethod())) {
			method = "edited";
		}
		
		JtwigTemplate template = JtwigTemplate.classpathTemplate(CREATE_ORG_MAIL_TEMPLATE_PATH);
		JtwigModel model = JtwigModel.newModel().with(USER, org.getOrgAdmin()).with(ORGANISATION, org.getOrgName())
				.with(METHOD, method)
				.with(IDP_LINK, idpLink);
		return template.render(model);

	}
	
	
	/**
	 * 
	 * createOrgMailBody
	 * 
	 * @param idp
	 *            the IDPJob>
	 * 
	 * @return String
	 * 
	 *         Method is used to create mail body
	 *
	 */

	public String createLicenseMailBody(OrganisationInfo org) {

		String idpLink = this.idpLink;
	
		JtwigTemplate template = JtwigTemplate.classpathTemplate(CREATE_ORG_MAIL_TEMPLATE_PATH);
		JtwigModel model = JtwigModel.newModel().with(USER, org.getOrgAdmin()).with(LICENSE_SERVICES, org.getLicenseServices())
				.with(LICENSE_EXPIRY_DATE, org.getLicenseExpiryDate())
				.with(IDP_LINK, idpLink);
		return template.render(model);

	}

	/**
	 * 
	 * createMailBody
	 * 
	 * @param idp
	 *            the IDPJob>
	 * 
	 * @return String
	 * 
	 *         Method is used to create mail body
	 *
	 */

	/*public String createMailBody(String user, String pipeline, String applicationName, String methodType) {

		String idpLink = this..getIdplink();
		StringBuilder successPageLink = new StringBuilder();
		successPageLink.append(configmanager.getSuccesspage());
		successPageLink.append("/");
		successPageLink.append(applicationName);
		successPageLink.append("/");
		successPageLink.append(pipeline);
		String method = "";
		if ("create".equalsIgnoreCase(methodType)) {
			method = "created";
		} else if ("edit".equalsIgnoreCase(methodType)) {
			method = "edited";
		}

		String dashboardLink = configmanager.getDashboardurl();
		JtwigTemplate template = JtwigTemplate.classpathTemplate(MAIL_TEMPLATE_PATH);

		JtwigModel model = JtwigModel.newModel().with(USER, user).with(METHOD, method)
				.with(DASHBOARD_URL, dashboardLink).with(PIPELINE, pipeline).with(IDP_LINK, idpLink)
				.with(IDP_PIPELINE_CONFIGURATIONS, successPageLink);
		return template.render(model);

	}
*/
	/**
	 * 
	 * @param user
	 * @param pipeline
	 * @param applicationName
	 * @param method
	 * @param release
	 * @return String
	 */
/*
	public String createReleaseMailBody(String user, String pipeline, String applicationName, String methodType,
			String release) {

		String idpLink = configmanager.getIdplink();
		StringBuilder successPageLink = new StringBuilder();
		successPageLink.append(configmanager.getSuccesspage());
		successPageLink.append("/");
		successPageLink.append(applicationName);
		successPageLink.append("/");
		successPageLink.append(pipeline);
		String method = "";
		if ("add".equalsIgnoreCase(methodType)) {
			method = "Added";
		} else if ("update".equalsIgnoreCase(methodType)) {
			method = "Updated";
		}

		String dashboardLink = configmanager.getDashboardurl();
		JtwigTemplate template = JtwigTemplate.classpathTemplate(RELEASE_MAIL_TEMPLATE_PATH);

		JtwigModel model = JtwigModel.newModel().with(USER, user).with(METHOD, method)
				.with(DASHBOARD_URL, dashboardLink).with(PIPELINE, pipeline).with(IDP_LINK, idpLink)
				.with(RELEASE, release).with(APPLICATION, applicationName)
				.with(IDP_PIPELINE_CONFIGURATIONS, successPageLink);
		return template.render(model);

	}
*/
}
