package com.springboot.activiti.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class WorkItemVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long workItemId;
	private String activitiDefId;
	private String workItemName;
	private Long workflowInstId;
	private String workflowInstName;
	private String excutionNo;
	private String workflowInstNo;
	private String workflowDefName;
	private String workflowVersion;
	private String workflowStatus;
	private String workItemStatus;    
	private String participant;     //参与者
	private String createDateStr;  //任务创建时间
	private Date createDate;
	private String startDateStr;     //流程启动时间
	private String startDate;
	private Date workflowEndDate;   //任务结束时间
	private String receiveDateStr;
	private Date receiveDate;    //任务接受时间
	private String dueDateStr;
	private String dutDate;   //预期完成 时间
	private String endDateStr; //任务结束时间
	private Date endDate;
	private String requestUrl;  
	private String responceUrl;
	private String launcher;  //发起人
	private String lanuchOrgn;  //发起机构
	private String operateType;  //操作类型
	private String operateContent; //操作内容
	private Map<String,Object> variables;
	public Long getWorkItemId() {
		return workItemId;
	}
	public void setWorkItemId(Long workItemId) {
		this.workItemId = workItemId;
	}
	public String getActivitiDefId() {
		return activitiDefId;
	}
	public void setActivitiDefId(String activitiDefId) {
		this.activitiDefId = activitiDefId;
	}
	public String getWorkItemName() {
		return workItemName;
	}
	public void setWorkItemName(String workItemName) {
		this.workItemName = workItemName;
	}
	public Long getWorkflowInstId() {
		return workflowInstId;
	}
	public void setWorkflowInstId(Long workflowInstId) {
		this.workflowInstId = workflowInstId;
	}
	public String getWorkflowInstName() {
		return workflowInstName;
	}
	public void setWorkflowInstName(String workflowInstName) {
		this.workflowInstName = workflowInstName;
	}
	public String getExcutionNo() {
		return excutionNo;
	}
	public void setExcutionNo(String excutionNo) {
		this.excutionNo = excutionNo;
	}
	public String getWorkflowInstNo() {
		return workflowInstNo;
	}
	public void setWorkflowInstNo(String workflowInstNo) {
		this.workflowInstNo = workflowInstNo;
	}
	public String getWorkflowDefName() {
		return workflowDefName;
	}
	public void setWorkflowDefName(String workflowDefName) {
		this.workflowDefName = workflowDefName;
	}
	public String getWorkflowVersion() {
		return workflowVersion;
	}
	public void setWorkflowVersion(String workflowVersion) {
		this.workflowVersion = workflowVersion;
	}
	public String getWorkflowStatus() {
		return workflowStatus;
	}
	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}
	public String getWorkItemStatus() {
		return workItemStatus;
	}
	public void setWorkItemStatus(String workItemStatus) {
		this.workItemStatus = workItemStatus;
	}
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	public String getCreateDateStr() {
		return createDateStr;
	}
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStartDateStr() {
		return startDateStr;
	}
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public Date getWorkflowEndDate() {
		return workflowEndDate;
	}
	public void setWorkflowEndDate(Date workflowEndDate) {
		this.workflowEndDate = workflowEndDate;
	}
	public String getReceiveDateStr() {
		return receiveDateStr;
	}
	public void setReceiveDateStr(String receiveDateStr) {
		this.receiveDateStr = receiveDateStr;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getDueDateStr() {
		return dueDateStr;
	}
	public void setDueDateStr(String dueDateStr) {
		this.dueDateStr = dueDateStr;
	}
	public String getDutDate() {
		return dutDate;
	}
	public void setDutDate(String dutDate) {
		this.dutDate = dutDate;
	}
	public String getEndDateStr() {
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getResponceUrl() {
		return responceUrl;
	}
	public void setResponceUrl(String responceUrl) {
		this.responceUrl = responceUrl;
	}
	public String getLauncher() {
		return launcher;
	}
	public void setLauncher(String launcher) {
		this.launcher = launcher;
	}
	public String getLanuchOrgn() {
		return lanuchOrgn;
	}
	public void setLanuchOrgn(String lanuchOrgn) {
		this.lanuchOrgn = lanuchOrgn;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getOperateContent() {
		return operateContent;
	}
	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
	}
	public Map<String, Object> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}
}
