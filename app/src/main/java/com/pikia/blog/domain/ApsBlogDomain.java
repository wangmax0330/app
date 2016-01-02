package com.pikia.blog.domain;

import java.util.Date;

import javax.annotation.Resource;

import com.pikia.blog.repository.ApsLazyLoadRole;
import com.pikia.component.base.BaseDomain;
import com.pikia.system.domain.SystemUserDomain;

public class ApsBlogDomain extends BaseDomain {
	private String title;
	private String simpleContent;// 文摘内容
	private String content;
	private Date createTime;
	private Date lastModifyTime; // 上一次修改的时间
	private String version; // blog的版本
	private Long versionId; // blog的历史版本关联表ID
	private Integer modifyTimes;// 修改次数
	private Integer publishState; // 是否已经出版或者在草稿箱中
	private SystemUserDomain author; // 作者
	private Integer viewNum;
	private String tags; // 标签

	@Resource
	private ApsLazyLoadRole apsLazyLoadRole; // 懒加载器

	public ApsBlogDomain() {

	}

	public ApsBlogDomain(Long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public Integer getPublishState() {
		return publishState;
	}

	public void setPublishState(Integer publishState) {
		this.publishState = publishState;
	}

	public SystemUserDomain getAuthor() {
		// if (this.author != null && !this.author.isInitialized() &&
		// apsLazyLoadRole != null) {
		// this.author = (ApsUserDomain)
		// apsLazyLoadRole.apsLazyLoadUserEventMessage(author
		// .getId());
		// } else if (this.author != null && this.author.isInitialized()) {
		// return this.author;
		// } else {
		// this.author = new ApsUserDomain();
		// }
		if (author != null)
			return author;
		else
			this.author = new SystemUserDomain();
		return author;
	}

	public void setAuthor(SystemUserDomain author) {
		this.author = author;
	}

	public Integer getModifyTimes() {
		return modifyTimes;
	}

	public void setModifyTimes(Integer modifyTimes) {
		this.modifyTimes = modifyTimes;
	}

	public Integer getViewNum() {
		return viewNum;
	}

	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	public String getSimpleContent() {
		return simpleContent;
	}

	public void setSimpleContent(String simpleContent) {
		this.simpleContent = simpleContent;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
