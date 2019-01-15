package com.springboot.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyJobListener implements JobListener{

	 private static Logger logger = LoggerFactory.getLogger(MyJobListener.class);
	    
	    @Override
	    public String getName() {
	        String name = getClass().getSimpleName();
	        logger.info(" listener name is:"+name);
	        return name;
	    }

	    /**
	     * Scheduler 在 JobDetail 将要被执行时调用这个方法。
	     */
	    @Override
	    public void jobToBeExecuted(JobExecutionContext context) {
	        String jobName = context.getJobDetail().getKey().getName();
	        logger.info(jobName + " is going to be executed");
	    }

	    /**
	     * Scheduler 在 JobDetail 即将被执行，但又被 TriggerListener 否决了时调用这个方法。
	     */
	    @Override
	    public void jobExecutionVetoed(JobExecutionContext context) {
	        String jobName = context.getJobDetail().getKey().getName();
	        logger.info(jobName + " was vetoed and not executed");
	    }

	    /**
	     * Scheduler 在 JobDetail 被执行之后调用这个方法。
	     */
	    @Override
	    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
	        String jobName = context.getJobDetail().getKey().getName();
	        logger.info(jobName + " was executed");

	    }
}
