package com.springboot.activiti.vo;

import java.io.Serializable;
import java.util.Map;

public class WorkflowContext implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String processDefId;
	private String processInsId;
	private String executionNo;
	private String processInsName;
	private String prevTaskAssigneId;
	private String prevTaskAssigneName;
	private Map<String, Object> varables;
	private WorkflowActivitiInstVO WorkflowActivitiInstVO;
	private WorkItemVO workItemVO;
	
	public String getProcessDefId() {
		return processDefId;
	}
	public void setProcessDefId(String processDefId) {
		this.processDefId = processDefId;
	}
	public String getProcessInsId() {
		return processInsId;
	}
	public void setProcessInsId(String processInsId) {
		this.processInsId = processInsId;
	}
	public String getExecutionNo() {
		return executionNo;
	}
	public void setExecutionNo(String executionNo) {
		this.executionNo = executionNo;
	}
	public String getProcessInsName() {
		return processInsName;
	}
	public void setProcessInsName(String processInsName) {
		this.processInsName = processInsName;
	}
	public String getPrevTaskAssigneId() {
		return prevTaskAssigneId;
	}
	public void setPrevTaskAssigneId(String prevTaskAssigneId) {
		this.prevTaskAssigneId = prevTaskAssigneId;
	}
	public String getPrevTaskAssigneName() {
		return prevTaskAssigneName;
	}
	public void setPrevTaskAssigneName(String prevTaskAssigneName) {
		this.prevTaskAssigneName = prevTaskAssigneName;
	}
	public Map<String, Object> getVarables() {
		return varables;
	}
	public void setVarables(Map<String, Object> varables) {
		this.varables = varables;
	}
	public WorkflowActivitiInstVO getWorkflowActivitiInstVO() {
		return WorkflowActivitiInstVO;
	}
	public void setWorkflowActivitiInstVO(WorkflowActivitiInstVO workflowActivitiInstVO) {
		WorkflowActivitiInstVO = workflowActivitiInstVO;
	}
	public WorkItemVO getWorkItemVO() {
		return workItemVO;
	}
	public void setWorkItemVO(WorkItemVO workItemVO) {
		this.workItemVO = workItemVO;
	}
}
