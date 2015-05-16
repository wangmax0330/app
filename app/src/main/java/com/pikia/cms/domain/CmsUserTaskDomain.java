package com.pikia.cms.domain;

import java.util.Date;

import com.pikia.aps.domain.ApsUserDomain;
import com.pikia.componet.base.BaseDomain;

public class CmsUserTaskDomain extends BaseDomain {
	public CmsUserTaskDomain() {
	}

	public CmsUserTaskDomain(Long id) {
		super(id);
	}

	private Date createTime; // 创建时间
	private ApsUserDomain approver; // 发起人
	private Integer status; // 完成状态
	private Date updateTime; // 更新时间
	private Date beginTime; // 执行时间
	private Date endTime; // 结束时间
	private Integer totalStep; // 包含步骤数
	private Integer taskType; // 任务类型

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getTotalStep() {
		return totalStep;
	}

	public void setTotalStep(Integer totalStep) {
		this.totalStep = totalStep;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public ApsUserDomain getApprover() {
		return approver;
	}

	public void setApprover(ApsUserDomain approver) {
		this.approver = approver;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
