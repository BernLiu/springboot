package com.springboot.quartz.service;

import java.util.ArrayList;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.quartz.dao.JobEntityRepository;
import com.springboot.quartz.entity.JobEntity;
import com.springboot.quartz.job.DynamicJob;

@Service
public class DynamicJobService {

	@Autowired
	private JobEntityRepository repository;
	
	public JobEntity getJobEntityById(Integer id) {
		return repository.getById(id);
	}
	
	public List<JobEntity> loadJobs(){
		List<JobEntity> list = new ArrayList<JobEntity>();
		repository.findAll().forEach(list::add);
		return list;
	}
	
	//获取JobDataMap.(Job参数对象)
	public JobDataMap getJobDataMap(JobEntity job) {
		JobDataMap map = new JobDataMap();
		map.put("name",job.getName());
		map.put("group", job.getGroup());
		map.put("cronExpression", job.getCron());
		map.put("parameter", job.getParameter());
		map.put("JobDescription", job.getDescription());
		map.put("vmParam", job.getVmParam());
		map.put("jarPath", job.getJarPath());
		map.put("status", job.getStatus());
		return map;
	}
	
	 //获取JobDetail,JobDetail是任务的定义,而Job是任务的执行逻辑,JobDetail里会引用一个Job Class来定义
	public JobDetail getJobDetail(JobKey jobKey, String description,JobDataMap map) {
		return JobBuilder.newJob(DynamicJob.class)
				.withIdentity(jobKey)
				.withDescription(description)
				.setJobData(map)
				.storeDurably()
				.build();
	}
	
	//获取Trigger (Job的触发器,执行规则)
	public Trigger getTrigger(JobEntity job) {
		 return TriggerBuilder.newTrigger()
	                .withIdentity(job.getName(), job.getGroup())
	                .withSchedule(CronScheduleBuilder.cronSchedule(job.getCron()))
	                .build();
	}
	
	//获取JobKey, 包含Name和Group
	public JobKey getJobKey(JobEntity job) {
		return JobKey.jobKey(job.getName(),job.getGroup());
	}
}
