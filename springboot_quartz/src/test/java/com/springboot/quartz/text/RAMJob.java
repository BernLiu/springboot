package com.springboot.quartz.text;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class RAMJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 System.out.println("Hello Quartz: " + new Date() + " " + Thread.currentThread().getName());
    
	}

}
