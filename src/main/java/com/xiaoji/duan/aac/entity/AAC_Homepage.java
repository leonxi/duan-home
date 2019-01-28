package com.xiaoji.duan.aac.entity;

import java.io.Serializable;

public class AAC_Homepage implements Serializable {

	private static final long serialVersionUID = -4989160776500278815L;

	private String unionId;
	private String homeSubdomain;
	private String homePrefix;
	private String homePath;
	private String createTime;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getHomeSubdomain() {
		return homeSubdomain;
	}

	public void setHomeSubdomain(String homeSubdomain) {
		this.homeSubdomain = homeSubdomain;
	}

	public String getHomePrefix() {
		return homePrefix;
	}

	public void setHomePrefix(String homePrefix) {
		this.homePrefix = homePrefix;
	}

	public String getHomePath() {
		return homePath;
	}

	public void setHomePath(String homePath) {
		this.homePath = homePath;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AAC_Homepage [unionId=" + unionId + ", homeSubdomain=" + homeSubdomain + ", homePrefix=" + homePrefix
				+ ", homePath=" + homePath + ", createTime=" + createTime + "]";
	}
	
}
