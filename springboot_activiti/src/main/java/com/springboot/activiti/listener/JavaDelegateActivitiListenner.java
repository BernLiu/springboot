package com.springboot.activiti.listener;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.springboot.activiti.dao.Delegate;
import com.springboot.activiti.util.ReflectionUtils;


@Component
public class JavaDelegateActivitiListenner implements JavaDelegate{
	
	private Expression clazz;
	
	private static Map<String,Delegate> instances = new HashMap<>();
	
	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("JavaDelegateActivitiListenner >>>>>>>>"+execution.getEventName());
		String clazz ="com.springboot.activiti.demo.DemoListener";
		Delegate delegate = getInstance(clazz);
		try {
			Class<?> clazzInstance = ReflectionUtils.forName(clazz);
			if(Delegate.class.isAssignableFrom(clazzInstance)) {
				delegate =(Delegate) clazzInstance.newInstance();
				String execute = delegate.execute();
				System.out.println("JavaDelegateActivitiListenner>>>>>>"+execute);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Delegate getInstance(String clazz) {
		synchronized (instances) {
			return instances.get(clazz);
		}
	}
	
	private void setInstance(String clazz,Delegate delegate) {
		synchronized(instances) {
			instances.put(clazz, delegate);
		}
	}
}
