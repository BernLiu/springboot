package com.springboot.quartz.text;

import java.util.Date;
import java.util.Properties;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class RAMJobTest {

	@Test
	public void textExecute() throws SchedulerException, InterruptedException {
		// 1.创建Scheduler的工厂
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		// 2.从工厂中获得调度的实例对象
		Scheduler scheduler = schedulerFactory.getScheduler();
		// 3.创建JobDetail
		JobDetail jobDetail = JobBuilder.newJob(RAMJob.class).withDescription("this is a ram job") // job的描述
				.withIdentity("ramJob", "ramGroup") // job的name 和 group
				.build();
		// 4.创建Trigger
		Trigger trigger = TriggerBuilder.newTrigger().withDescription("").withIdentity("ramTrigger", "ramTriggerGroup")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * * ?")) // 两秒执行一次
				.build();
		// 5.注册任务和定时器
		scheduler.scheduleJob(jobDetail, trigger);
		// 6.启动调度器
		scheduler.start();
		System.out.println("启动时间 ： " + new Date() + " " + Thread.currentThread().getName());
		Thread.sleep(60000);
		System.out.println("done");
	}
}
