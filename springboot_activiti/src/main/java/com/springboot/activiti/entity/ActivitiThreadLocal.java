package com.springboot.activiti.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取工作流接口内的流程和任务信息
 * @author Bern_Liu
 *
 */
public class ActivitiThreadLocal {
	private static ThreadLocal<List<TaskExt>> activitiThreadLocalData = new ThreadLocal<List<TaskExt>>();

    public static void bindData(List<TaskExt> threadLocalData) {
        activitiThreadLocalData.set(threadLocalData);
    }

    public static void bindData() {
        activitiThreadLocalData.set(new ArrayList<TaskExt>());
    }

    public static void unBindData() {
        activitiThreadLocalData.set(null);
    }

    public static void clear() {
        List<TaskExt> threadLocalData = getThreadLocalDataAll();
        if (threadLocalData != null) {
            threadLocalData.clear();
        }
    }

    public static List<TaskExt> getThreadLocalDataAll() {
        return activitiThreadLocalData.get();
    }

    public static void addThreadLocalData(TaskExt taskExt) {
        List<TaskExt> threadLocalData = activitiThreadLocalData.get();
        if (threadLocalData != null) {
            // 修改流程图重新编译后actClmThreadLocalData.get()获取处理的对象是null 特需要重新绑定下变量信息
            threadLocalData.add(taskExt);
        } else {
            threadLocalData = new ArrayList<TaskExt>();
            threadLocalData.add(taskExt);
            bindData(threadLocalData);
        }
    }
}