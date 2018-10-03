//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.11 at 11:19:10 AM IST 
//
package com.infosys.utilities.findbugs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "project", "bugInstance", "bugCategory", "bugPattern", "bugCode", "errors",
		"findBugsSummary", "classFeatures", "history" })
@XmlRootElement(name = "BugCollection")
public class BugCollection {
	@XmlElement(name = "Project", required = true)
	protected BugCollection.Project project;
	@XmlElement(name = "BugInstance")
	protected List<BugInstance> bugInstance;
	@XmlElement(name = "BugCategory")
	protected List<BugCollection.BugCategory> bugCategory;
	@XmlElement(name = "BugPattern")
	protected List<BugCollection.BugPattern> bugPattern;
	@XmlElement(name = "BugCode")
	protected List<BugCollection.BugCode> bugCode;
	@XmlElement(name = "Errors", required = true)
	protected BugCollection.Errors errors;
	@XmlElement(name = "FindBugsSummary", required = true)
	protected BugCollection.FindBugsSummary findBugsSummary;
	@XmlElement(name = "ClassFeatures", required = true)
	protected java.lang.String classFeatures;
	@XmlElement(name = "History", required = true)
	protected java.lang.String history;
	@XmlAttribute(name = "version")
	protected java.lang.String version;
	@XmlAttribute(name = "sequence")
	protected Byte sequence;
	@XmlAttribute(name = "timestamp")
	protected Long timestamp;
	@XmlAttribute(name = "analysisTimestamp")
	protected Long analysisTimestamp;
	@XmlAttribute(name = "release")
	protected java.lang.String release;

	public BugCollection.Project getProject() {
		return project;
	}

	public void setProject(BugCollection.Project value) {
		this.project = value;
	}

	public List<BugInstance> getBugInstance() {
		if (bugInstance == null) {
			bugInstance = new ArrayList<BugInstance>();
		}
		return this.bugInstance;
	}

	public List<BugCollection.BugCategory> getBugCategory() {
		if (bugCategory == null) {
			bugCategory = new ArrayList<BugCollection.BugCategory>();
		}
		return this.bugCategory;
	}

	public List<BugCollection.BugPattern> getBugPattern() {
		if (bugPattern == null) {
			bugPattern = new ArrayList<BugCollection.BugPattern>();
		}
		return this.bugPattern;
	}

	public List<BugCollection.BugCode> getBugCode() {
		if (bugCode == null) {
			bugCode = new ArrayList<BugCollection.BugCode>();
		}
		return this.bugCode;
	}

	public BugCollection.Errors getErrors() {
		return errors;
	}

	public void setErrors(BugCollection.Errors value) {
		this.errors = value;
	}

	public BugCollection.FindBugsSummary getFindBugsSummary() {
		return findBugsSummary;
	}

	public void setFindBugsSummary(BugCollection.FindBugsSummary value) {
		this.findBugsSummary = value;
	}

	public java.lang.String getClassFeatures() {
		return classFeatures;
	}

	public void setClassFeatures(java.lang.String value) {
		this.classFeatures = value;
	}

	public java.lang.String getHistory() {
		return history;
	}

	public void setHistory(java.lang.String value) {
		this.history = value;
	}

	public java.lang.String getVersion() {
		return version;
	}

	public void setVersion(java.lang.String value) {
		this.version = value;
	}

	public Byte getSequence() {
		return sequence;
	}

	public void setSequence(Byte value) {
		this.sequence = value;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long value) {
		this.timestamp = value;
	}

	public Long getAnalysisTimestamp() {
		return analysisTimestamp;
	}

	public void setAnalysisTimestamp(Long value) {
		this.analysisTimestamp = value;
	}

	public java.lang.String getRelease() {
		return release;
	}

	public void setRelease(java.lang.String value) {
		this.release = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "description" })
	public static class BugCategory {
		@XmlElement(name = "Description", required = true)
		protected java.lang.String description;
		@XmlAttribute(name = "category")
		protected java.lang.String category;

		public java.lang.String getDescription() {
			return description;
		}

		public void setDescription(java.lang.String value) {
			this.description = value;
		}

		public java.lang.String getCategory() {
			return category;
		}

		public void setCategory(java.lang.String value) {
			this.category = value;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "description" })
	public static class BugCode {
		@XmlElement(name = "Description", required = true)
		protected java.lang.String description;
		@XmlAttribute(name = "abbrev")
		protected java.lang.String abbrev;
		@XmlAttribute(name = "cweid")
		protected Short cweid;

		public java.lang.String getDescription() {
			return description;
		}

		public void setDescription(java.lang.String value) {
			this.description = value;
		}

		public java.lang.String getAbbrev() {
			return abbrev;
		}

		public void setAbbrev(java.lang.String value) {
			this.abbrev = value;
		}

		public Short getCweid() {
			return cweid;
		}

		public void setCweid(Short value) {
			this.cweid = value;
		}
	}



	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "shortDescription", "details" })
	public static class BugPattern {
		@XmlElement(name = "ShortDescription", required = true)
		protected java.lang.String shortDescription;
		@XmlElement(name = "Details", required = true)
		protected java.lang.String details;
		@XmlAttribute(name = "type")
		protected java.lang.String type;
		@XmlAttribute(name = "abbrev")
		protected java.lang.String abbrev;
		@XmlAttribute(name = "category")
		protected java.lang.String category;
		@XmlAttribute(name = "cweid")
		protected Short cweid;

		public java.lang.String getShortDescription() {
			return shortDescription;
		}

		public void setShortDescription(java.lang.String value) {
			this.shortDescription = value;
		}

		public java.lang.String getDetails() {
			return details;
		}

		public void setDetails(java.lang.String value) {
			this.details = value;
		}

		public java.lang.String getType() {
			return type;
		}

		public void setType(java.lang.String value) {
			this.type = value;
		}

		public java.lang.String getAbbrev() {
			return abbrev;
		}

		public void setAbbrev(java.lang.String value) {
			this.abbrev = value;
		}

		public java.lang.String getCategory() {
			return category;
		}

		public void setCategory(java.lang.String value) {
			this.category = value;
		}

		public Short getCweid() {
			return cweid;
		}

		public void setCweid(Short value) {
			this.cweid = value;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "missingClass" })
	public static class Errors {
		@XmlElement(name = "MissingClass")
		protected List<java.lang.String> missingClass;
		@XmlAttribute(name = "errors")
		protected Byte errors;
		@XmlAttribute(name = "missingClasses")
		protected Byte missingClasses;

		public List<java.lang.String> getMissingClass() {
			if (missingClass == null) {
				missingClass = new ArrayList<java.lang.String>();
			}
			return this.missingClass;
		}

		public void setMissingClass(List<java.lang.String> list) {
			this.missingClass = list;
		}

		public Byte getErrors() {
			return errors;
		}

		public void setErrors(Byte value) {
			this.errors = value;
		}

		public Byte getMissingClasses() {
			return missingClasses;
		}

		public void setMissingClasses(Byte value) {
			this.missingClasses = value;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "fileStats", "packageStats", "findBugsProfile" })
	public static class FindBugsSummary {
		@XmlElement(name = "FileStats")
		protected List<BugCollection.FindBugsSummary.FileStats> fileStats;
		@XmlElement(name = "PackageStats")
		protected List<BugCollection.FindBugsSummary.PackageStats> packageStats;
		@XmlElement(name = "FindBugsProfile", required = true)
		protected BugCollection.FindBugsSummary.FindBugsProfile findBugsProfile;
		@XmlAttribute(name = "timestamp")
		protected java.lang.String timestamp;
		@XmlAttribute(name = "total_classes")
		protected Byte totalClasses;
		@XmlAttribute(name = "referenced_classes")
		protected Byte referencedClasses;
		@XmlAttribute(name = "total_bugs")
		protected Byte totalBugs;
		@XmlAttribute(name = "total_size")
		protected Short totalSize;
		@XmlAttribute(name = "num_packages")
		protected Byte numPackages;
		@XmlAttribute(name = "java_version")
		protected java.lang.String javaVersion;
		@XmlAttribute(name = "vm_version")
		protected java.lang.String vmVersion;
		@XmlAttribute(name = "cpu_seconds")
		protected Float cpuSeconds;
		@XmlAttribute(name = "clock_seconds")
		protected Float clockSeconds;
		@XmlAttribute(name = "peak_mbytes")
		protected Float peakMbytes;
		@XmlAttribute(name = "alloc_mbytes")
		protected Float allocMbytes;
		@XmlAttribute(name = "gc_seconds")
		protected Float gcSeconds;
		@XmlAttribute(name = "priority_2")
		protected Byte priority2;
		@XmlAttribute(name = "priority_1")
		protected Byte priority1;

		public List<BugCollection.FindBugsSummary.FileStats> getFileStats() {
			if (fileStats == null) {
				fileStats = new ArrayList<BugCollection.FindBugsSummary.FileStats>();
			}
			return this.fileStats;
		}

		public List<BugCollection.FindBugsSummary.PackageStats> getPackageStats() {
			if (packageStats == null) {
				packageStats = new ArrayList<BugCollection.FindBugsSummary.PackageStats>();
			}
			return this.packageStats;
		}

		public BugCollection.FindBugsSummary.FindBugsProfile getFindBugsProfile() {
			return findBugsProfile;
		}

		public void setFindBugsProfile(BugCollection.FindBugsSummary.FindBugsProfile value) {
			this.findBugsProfile = value;
		}

		public java.lang.String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(java.lang.String value) {
			this.timestamp = value;
		}

		public Byte getTotalClasses() {
			return totalClasses;
		}

		public void setTotalClasses(Byte value) {
			this.totalClasses = value;
		}

		public Byte getReferencedClasses() {
			return referencedClasses;
		}

		public void setReferencedClasses(Byte value) {
			this.referencedClasses = value;
		}

		public Byte getTotalBugs() {
			return totalBugs;
		}

		public void setTotalBugs(Byte value) {
			this.totalBugs = value;
		}

		public Short getTotalSize() {
			return totalSize;
		}

		public void setTotalSize(Short value) {
			this.totalSize = value;
		}

		public Byte getNumPackages() {
			return numPackages;
		}

		public void setNumPackages(Byte value) {
			this.numPackages = value;
		}

		public java.lang.String getJavaVersion() {
			return javaVersion;
		}

		public void setJavaVersion(java.lang.String value) {
			this.javaVersion = value;
		}

		public java.lang.String getVmVersion() {
			return vmVersion;
		}

		public void setVmVersion(java.lang.String value) {
			this.vmVersion = value;
		}

		public Float getCpuSeconds() {
			return cpuSeconds;
		}

		public void setCpuSeconds(Float value) {
			this.cpuSeconds = value;
		}

		public Float getClockSeconds() {
			return clockSeconds;
		}

		public void setClockSeconds(Float value) {
			this.clockSeconds = value;
		}

		public Float getPeakMbytes() {
			return peakMbytes;
		}

		public void setPeakMbytes(Float value) {
			this.peakMbytes = value;
		}

		public Float getAllocMbytes() {
			return allocMbytes;
		}

		public void setAllocMbytes(Float value) {
			this.allocMbytes = value;
		}

		public Float getGcSeconds() {
			return gcSeconds;
		}

		public void setGcSeconds(Float value) {
			this.gcSeconds = value;
		}

		public Byte getPriority2() {
			return priority2;
		}

		public void setPriority2(Byte value) {
			this.priority2 = value;
		}

		public Byte getPriority1() {
			return priority1;
		}

		public void setPriority1(Byte value) {
			this.priority1 = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "value" })
		public static class FileStats {
			@XmlValue
			protected java.lang.String value;
			@XmlAttribute(name = "path")
			protected java.lang.String path;
			@XmlAttribute(name = "bugCount")
			protected Byte bugCount;
			@XmlAttribute(name = "size")
			protected Short size;
			@XmlAttribute(name = "bugHash")
			protected java.lang.String bugHash;

			public java.lang.String getValue() {
				return value;
			}

			public void setValue(java.lang.String value) {
				this.value = value;
			}

			public java.lang.String getPath() {
				return path;
			}

			public void setPath(java.lang.String value) {
				this.path = value;
			}

			public Byte getBugCount() {
				return bugCount;
			}

			public void setBugCount(Byte value) {
				this.bugCount = value;
			}

			public Short getSize() {
				return size;
			}

			public void setSize(Short value) {
				this.size = value;
			}

			public java.lang.String getBugHash() {
				return bugHash;
			}

			public void setBugHash(java.lang.String value) {
				this.bugHash = value;
			}
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "classProfile" })
		public static class FindBugsProfile {
			@XmlElement(name = "ClassProfile")
			protected List<BugCollection.FindBugsSummary.FindBugsProfile.ClassProfile> classProfile;

			public List<BugCollection.FindBugsSummary.FindBugsProfile.ClassProfile> getClassProfile() {
				if (classProfile == null) {
					classProfile = new ArrayList<BugCollection.FindBugsSummary.FindBugsProfile.ClassProfile>();
				}
				return this.classProfile;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "value" })
			public static class ClassProfile {
				@XmlValue
				protected java.lang.String value;
				@XmlAttribute(name = "name")
				protected java.lang.String name;
				@XmlAttribute(name = "totalMilliseconds")
				protected Short totalMilliseconds;
				@XmlAttribute(name = "invocations")
				protected Short invocations;
				@XmlAttribute(name = "avgMicrosecondsPerInvocation")
				protected Short avgMicrosecondsPerInvocation;
				@XmlAttribute(name = "maxMicrosecondsPerInvocation")
				protected Integer maxMicrosecondsPerInvocation;
				@XmlAttribute(name = "standardDeviationMircosecondsPerInvocation")
				protected Integer standardDeviationMircosecondsPerInvocation;

				public java.lang.String getValue() {
					return value;
				}

				public void setValue(java.lang.String value) {
					this.value = value;
				}

				public java.lang.String getName() {
					return name;
				}

				public void setName(java.lang.String value) {
					this.name = value;
				}

				public Short getTotalMilliseconds() {
					return totalMilliseconds;
				}

				public void setTotalMilliseconds(Short value) {
					this.totalMilliseconds = value;
				}

				public Short getInvocations() {
					return invocations;
				}

				public void setInvocations(Short value) {
					this.invocations = value;
				}

				public Short getAvgMicrosecondsPerInvocation() {
					return avgMicrosecondsPerInvocation;
				}

				public void setAvgMicrosecondsPerInvocation(Short value) {
					this.avgMicrosecondsPerInvocation = value;
				}

				public Integer getMaxMicrosecondsPerInvocation() {
					return maxMicrosecondsPerInvocation;
				}

				public void setMaxMicrosecondsPerInvocation(Integer value) {
					this.maxMicrosecondsPerInvocation = value;
				}

				public Integer getStandardDeviationMircosecondsPerInvocation() {
					return standardDeviationMircosecondsPerInvocation;
				}

				public void setStandardDeviationMircosecondsPerInvocation(Integer value) {
					this.standardDeviationMircosecondsPerInvocation = value;
				}
			}
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "classStats" })
		public static class PackageStats {
			@XmlElement(name = "ClassStats")
			protected List<BugCollection.FindBugsSummary.PackageStats.ClassStats> classStats;
			@XmlAttribute(name = "package")
			protected java.lang.String _package;
			@XmlAttribute(name = "total_bugs")
			protected Byte totalBugs;
			@XmlAttribute(name = "total_types")
			protected Byte totalTypes;
			@XmlAttribute(name = "total_size")
			protected Short totalSize;
			@XmlAttribute(name = "priority_2")
			protected Byte priority2;
			@XmlAttribute(name = "priority_1")
			protected Byte priority1;

			public List<BugCollection.FindBugsSummary.PackageStats.ClassStats> getClassStats() {
				if (classStats == null) {
					classStats = new ArrayList<BugCollection.FindBugsSummary.PackageStats.ClassStats>();
				}
				return this.classStats;
			}

			public java.lang.String getPackage() {
				return _package;
			}

			public void setPackage(java.lang.String value) {
				this._package = value;
			}

			public Byte getTotalBugs() {
				return totalBugs;
			}

			public void setTotalBugs(Byte value) {
				this.totalBugs = value;
			}

			public Byte getTotalTypes() {
				return totalTypes;
			}

			public void setTotalTypes(Byte value) {
				this.totalTypes = value;
			}

			public Short getTotalSize() {
				return totalSize;
			}

			public void setTotalSize(Short value) {
				this.totalSize = value;
			}

			public Byte getPriority2() {
				return priority2;
			}

			public void setPriority2(Byte value) {
				this.priority2 = value;
			}

			public Byte getPriority1() {
				return priority1;
			}

			public void setPriority1(Byte value) {
				this.priority1 = value;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "value" })
			public static class ClassStats {
				@XmlValue
				protected java.lang.String value;
				@XmlAttribute(name = "class")
				protected java.lang.String clazz;
				@XmlAttribute(name = "sourceFile")
				protected java.lang.String sourceFile;
				@XmlAttribute(name = "interface")
				protected java.lang.String _interface;
				@XmlAttribute(name = "size")
				protected Short size;
				@XmlAttribute(name = "bugs")
				protected Byte bugs;
				@XmlAttribute(name = "priority_2")
				protected Byte priority2;
				@XmlAttribute(name = "priority_1")
				protected Byte priority1;

				public java.lang.String getValue() {
					return value;
				}

				public void setValue(java.lang.String value) {
					this.value = value;
				}

				public java.lang.String getClazz() {
					return clazz;
				}

				public void setClazz(java.lang.String value) {
					this.clazz = value;
				}

				public java.lang.String getSourceFile() {
					return sourceFile;
				}

				public void setSourceFile(java.lang.String value) {
					this.sourceFile = value;
				}

				public java.lang.String getInterface() {
					return _interface;
				}

				public void setInterface(java.lang.String value) {
					this._interface = value;
				}

				public Short getSize() {
					return size;
				}

				public void setSize(Short value) {
					this.size = value;
				}

				public Byte getBugs() {
					return bugs;
				}

				public void setBugs(Byte value) {
					this.bugs = value;
				}

				public Byte getPriority2() {
					return priority2;
				}

				public void setPriority2(Byte value) {
					this.priority2 = value;
				}

				public Byte getPriority1() {
					return priority1;
				}

				public void setPriority1(Byte value) {
					this.priority1 = value;
				}
			}
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "jar" })
	public static class Project {
		@XmlElement(name = "Jar", required = true)
		protected java.lang.String jar;
		@XmlAttribute(name = "projectName")
		protected java.lang.String projectName;

		public java.lang.String getJar() {
			return jar;
		}

		public void setJar(java.lang.String value) {
			this.jar = value;
		}

		public java.lang.String getProjectName() {
			return projectName;
		}

		public void setProjectName(java.lang.String value) {
			this.projectName = value;
		}
	}
}
