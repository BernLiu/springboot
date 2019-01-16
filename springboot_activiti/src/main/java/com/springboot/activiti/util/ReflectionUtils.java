package com.springboot.activiti.util;

public class ReflectionUtils {

	public static Class<?> forName(String name) throws ClassNotFoundException {
		return getClassLoader().loadClass(name);
	}

	private static ClassLoader getClassLoader() {
		
		return Thread.currentThread().getContextClassLoader();
	}
	
	
}
