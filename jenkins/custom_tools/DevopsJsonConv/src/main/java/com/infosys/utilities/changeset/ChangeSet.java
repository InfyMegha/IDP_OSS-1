/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-146 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.19 at 07:11:52 PM IST 
//

package com.infosys.utilities.changeset;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "item", "buildId", "culprits", "appName", "buildStatus","scmurl","duration","timestamp"})
@XmlRootElement(name = "changeSet")
public class ChangeSet {

	public String getScmurl() {
		return scmurl;
	}

	public void setScmurl(String scmurl) {
		this.scmurl = scmurl;
	}

	protected List<ChangeSet.Item> item;
	private String buildId;
	private String buildStatus;
	protected List<ChangeSet.Culprits> culprits;
	private String appName;
	private String duration;
	private String timestamp;
	private String scmurl;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public List<ChangeSet.Item> getItem() {
		return this.item;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getBuildStatus() {
		return buildStatus;
	}

	public void setBuildStatus(String buildStatus) {
		this.buildStatus = buildStatus;
	}

	public List<ChangeSet.Culprits> getCulprits() {
		return culprits;
	}

	public void setCulprits(List<ChangeSet.Culprits> culprits) {
		this.culprits = culprits;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "name" })
	public static class Culprits {
		private List<String> name;

		public Culprits() {
			super();
		}

		public List<String> getName() {
			return name;
		}

		public void setName(List<String> name) {
			this.name = name;
		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "affectedPath", "author", "timestamp", "comment", "commitId", "user", "version" })
	public static class Item {

		protected List<String> affectedPath;
		public void setAffectedPath(List<String> affectedPath) {
			this.affectedPath = affectedPath;
		}

		protected ChangeSet.Item.Author author;
		protected Long timestamp;
		@XmlElement(required = true)
		protected String comment;
		protected String commitId;
		protected String user;
		protected String version;
		

		/**
		 * Gets the value of the affectedPath property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the affectedPath property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getAffectedPath().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link String }
		 * 
		 * 
		 */
		public List<String> getAffectedPath() {
			if (affectedPath == null) {
				affectedPath = new ArrayList<>();
			}
			return this.affectedPath;
		}




		/**
		 * Gets the value of the author property.
		 * 
		 * @return possible object is {@link ChangeSet.Item.Author }
		 * 
		 */
		public ChangeSet.Item.Author getAuthor() {
			return author;
		}

		/**
		 * Sets the value of the author property.
		 * 
		 * @param value
		 *            allowed object is {@link ChangeSet.Item.Author }
		 * 
		 */
		public void setAuthor(ChangeSet.Item.Author value) {
			this.author = value;
		}

		/**
		 * Gets the value of the msg property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */

		/**
		 * <p>
		 * Java class for anonymous complex type.
		 * 
		 * <p>
		 * The following schema fragment specifies the expected content
		 * contained within this class.
		 * 
		 * <pre>
		 * &lt;complexType&gt;
		 *   &lt;complexContent&gt;
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
		 *       &lt;sequence&gt;
		 *         &lt;element name="absoluteUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *       &lt;/sequence&gt;
		 *     &lt;/restriction&gt;
		 *   &lt;/complexContent&gt;
		 * &lt;/complexType&gt;
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "absoluteUrl", "fullName" })
		public static class Author {

			@XmlElement(required = true)
			protected String absoluteUrl;
			@XmlElement(required = true)
			protected String fullName;

			/**
			 * Gets the value of the absoluteUrl property.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getAbsoluteUrl() {
				return absoluteUrl;
			}

			/**
			 * Sets the value of the absoluteUrl property.
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setAbsoluteUrl(String value) {
				this.absoluteUrl = value;
			}

			/**
			 * Gets the value of the fullName property.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getFullName() {
				return fullName;
			}

			/**
			 * Sets the value of the fullName property.
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setFullName(String value) {
				this.fullName = value;
			}

		}

		/**
		 * Sets the value of the msg property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */

		/**
		 * Gets the value of the timestamp property.
		 * 
		 */
		public Long getTimestamp() {
			return timestamp;
		}

		/**
		 * Sets the value of the timestamp property.
		 * 
		 */
		public void setTimestamp(Long timestamp) {
			this.timestamp = timestamp;
		}

		/**
		 * Gets the value of the comment property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getComment() {
			return comment;
		}

		/**
		 * Sets the value of the comment property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setComment(String value) {
			this.comment = value;
		}

		/**
		 * Gets the value of the commitId property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCommitId() {
			return commitId;
		}

		/**
		 * Sets the value of the commitId property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCommitId(String value) {
			this.commitId = value;
		}

		/**
		 * Gets the value of the user property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getUser() {
			return user;
		}

		/**
		 * Sets the value of the user property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setUser(String value) {
			this.user = value;
		}

		/**
		 * Gets the value of the timestamp property.
		 * 
		 */

		public String getVersion() {
			return version;
		}

		/**
		 * Sets the value of the comment property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setVersion(String value) {
			this.version = value;
		}

	}
}
