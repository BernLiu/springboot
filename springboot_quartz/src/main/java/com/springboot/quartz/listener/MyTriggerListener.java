package com.springboot.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener{

	 private static Logger logger = LoggerFactory.getLogger(MyJobListener.class);
	/**
	  * 定义并返回监听器的名字
	 */
	@Override
	public String getName() {
		String simpleName = getClass().getSimpleName();
		return simpleName;
	}

	/**
	 * 当与监听器相关联的 Trigger 被触发，Job 上的 execute() 方法将要被执行时，Scheduler 就调用这个方法。
	 *  在全局 TriggerListener 情况下，这个方法为所有 Trigger 被调用。
	 */
	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		 String jobName = context.getJobDetail().getKey().getName();
		 String calendarName = trigger.getCalendarName();
		 logger.info("【MyTriggerListener】 >>>>>>>>>>>>>>    triggerFired :  "+jobName + " is going to be executed");
		 logger.info("【MyTriggerListener】 >>>>>>>>>>>>>>    triggerFired :  "+calendarName + " is going to be executed");
	}

	/**
	 * 在 Trigger 触发后，Job 将要被执行时由 Scheduler 调用这个方法。TriggerListener 给了一个选择去否决 Job 的执行。
	 *   假如这个方法返回 true，这个 Job 将不会为此次 Trigger 触发而得到执行。
	 */
	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		 String jobName = context.getJobDetail().getKey().getName();
		 String calendarName = trigger.getCalendarName();
		 logger.info("【MyTriggerListener】>>>>>>> 【 vetoJobExecution】 : >>>>>>>>>>>>>>>>> "+jobName + " is going to be executed");
		 logger.info("【MyTriggerListener】 >>>>>>> 【 vetoJobExecution】 : >>>>>>>>>>>>>>>>> "+calendarName + " is going to be executed");
	//	 logger.info("发现此次Job的相关资源准备存在问题，不便展开任务，返回true表示否决此次任务执行");
		return false;
	}

	/**
	 * Scheduler 调用这个方法是在 Trigger 错过触发时。如这个方法的 JavaDoc 所指出的，你应该关注此方法中持续时间长的逻辑：
	 *   在出现许多错过触发的 Trigger 时，长逻辑会导致骨牌效应。你应当保持这上方法尽量的小。
	 */
	@Override
	public void triggerMisfired(Trigger trigger) {
		String calendarName = trigger.getCalendarName();
		logger.info("【   triggerMisfired  】当前触发错过的Trigger :>>>>>>>>>>>>>>>>>> "+ calendarName);
		
	}

	/**
	 * Trigger 被触发并且完成了 Job 的执行时，Scheduler 调用这个方法。这不是说这个 Trigger 将不再触发了，
	 * 而仅仅是当前 Trigger 的触发(并且紧接着的 Job 执行) 结束时。这个 Trigger 也许还要在将来触发多次的。
	 */
	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
		logger.info("【 triggerComplete 】>>>>>>>>>>>>>>>>>>>>>>>Trigger 被触发并且完成了 Job 的执行,此方法被调用");
		
	}

}
