package com.springboot.activiti.vo;

import java.io.Serializable;
import java.util.Date;

public class WorkflowActivitiInstVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long activityInsId;
	private String workflowDefId;
	private String workflowInsNo;
	private String workflowInstName;
	private String activitiDefId;
	private String activityInsName;
	private String actType;
	private String assigne;
	private Date createTime;
	private Date endTime;
	public Long getActivityInsId() {
		return activityInsId;
	}
	public void setActivityInsId(Long activityInsId) {
		this.activityInsId = activityInsId;
	}
	public String getWorkflowDefId() {
		return workflowDefId;
	}
	public void setWorkflowDefId(String workflowDefId) {
		this.workflowDefId = workflowDefId;
	}
	public String getWorkflowInsNo() {
		return workflowInsNo;
	}
	public void setWorkflowInsNo(String workflowInsNo) {
		this.workflowInsNo = workflowInsNo;
	}
	public String getWorkflowInstName() {
		return workflowInstName;
	}
	public void setWorkflowInstName(String workflowInstName) {
		this.workflowInstName = workflowInstName;
	}
	public String getActivitiDefId() {
		return activitiDefId;
	}
	public void setActivitiDefId(String activitiDefId) {
		this.activitiDefId = activitiDefId;
	}
	public String getActivityInsName() {
		return activityInsName;
	}
	public void setActivityInsName(String activityInsName) {
		this.activityInsName = activityInsName;
	}
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	public String getAssigne() {
		return assigne;
	}
	public void setAssigne(String assigne) {
		this.assigne = assigne;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
