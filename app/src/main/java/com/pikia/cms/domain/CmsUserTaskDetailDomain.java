package com.pikia.cms.domain;

import java.util.Date;

import com.pikia.component.base.BaseDomain;

public class CmsUserTaskDetailDomain extends BaseDomain {
    private Date createTime;
    private Integer step; // 当前步骤
    private Date beginTime;
    private Date endTime;
    private CmsUserTaskDomain task;
    private Integer status;// 状态
    private Integer taskType; // 任务类型

    public Date getCreateTime() {
	return createTime;
    }

    public void setCreateTime(Date createTime) {
	this.createTime = createTime;
    }

    public Integer getStep() {
	return step;
    }

    public void setStep(Integer step) {
	this.step = step;
    }

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

    public CmsUserTaskDomain getTask() {
	return task;
    }

    public void setTask(CmsUserTaskDomain task) {
	this.task = task;
    }

    public Integer getStatus() {
	return status;
    }

    public void setStatus(Integer status) {
	this.status = status;
    }

    public Integer getTaskType() {
	return taskType;
    }

    public void setTaskType(Integer taskType) {
	this.taskType = taskType;
    }

}
