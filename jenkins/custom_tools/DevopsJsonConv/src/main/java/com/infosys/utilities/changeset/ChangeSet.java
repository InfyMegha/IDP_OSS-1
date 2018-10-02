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
@XmlType(name = "", propOrder = { "item", "buildId", "culprits", "appName", "buildStatus", "scmurl", "duration",
		"timestamp" })
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

		public List<String> getAffectedPath() {
			if (affectedPath == null) {
				affectedPath = new ArrayList<>();
			}
			return this.affectedPath;
		}

		public ChangeSet.Item.Author getAuthor() {
			return author;
		}

		public void setAuthor(ChangeSet.Item.Author value) {
			this.author = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "absoluteUrl", "fullName" })
		public static class Author {
			@XmlElement(required = true)
			protected String absoluteUrl;
			@XmlElement(required = true)
			protected String fullName;

			public String getAbsoluteUrl() {
				return absoluteUrl;
			}

			public void setAbsoluteUrl(String value) {
				this.absoluteUrl = value;
			}

			public String getFullName() {
				return fullName;
			}

			public void setFullName(String value) {
				this.fullName = value;
			}
		}

		public Long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Long timestamp) {
			this.timestamp = timestamp;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String value) {
			this.comment = value;
		}

		public String getCommitId() {
			return commitId;
		}

		public void setCommitId(String value) {
			this.commitId = value;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String value) {
			this.user = value;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String value) {
			this.version = value;
		}
	}
}
