package com.springboot.sys.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springboot.sys.atinterface.Column;

public class ReflectionUtils {

	/**
	 * 获取最简包名
	 * 
	 * @param className
	 * @return
	 */
	public static String getSimpleClassName(String className) {
		return className.substring(className.lastIndexOf(".") + 1);
	}

	public static String getSimpleFieldName(String fieldName) {
		return fieldName.substring(fieldName.lastIndexOf(".")+1,fieldName.length());
	}
	/**
	 * 获取对象所有属性名
	 * 
	 * @param clazz
	 * @return
	 */
	public static String[] getAllColumnsName(Object obj) {
		String[] fieldNames = null;
		try {
			Field[] fields = obj.getClass().getDeclaredFields();	
			List<Field> fieldsList = Arrays.asList(fields);
			//获取继承类
			Class<?> superClazz = obj.getClass().getSuperclass();
			if(superClazz!=null) {
	            Field[] superFields = superClazz.getDeclaredFields();
	            Arrays.asList(superFields).addAll(fieldsList);
			}
			fieldNames = new String[fieldsList.size()];
			for (int i = 0; i < fieldsList.size(); i++) {
				if ("serialVersionUID".equals(fields[i].getName()))
					continue;
				fieldNames[i] = fields[i].getAnnotation(Column.class).value();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fieldNames;
	}

	/**
	 * 获取非空的属性值
	 * 
	 * @param obj
	 * @param fields
	 * @return
	 */
	public static Map<String, Object> getAllColumnsValue(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			for (int i = 0; i < fields.length; i++) {
				if ("serialVersionUID".equals(fields[i].getName()))
					continue;
				fields[i].setAccessible(true);
				String fieldValue = (String) fields[i].get(obj);
				if (null != fieldValue) {
					String fieldName =String.valueOf(fields[i]);
					map.put(FieldUtils.humpToLine(getSimpleFieldName(fieldName)), fieldValue);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return map;
	}

	/**
	 * 根据属性名获取属性值
	 * 
	 * @param fieldName
	 * @param object
	 * @return
	 */
	public String getFieldValueByFieldName(String fieldName, Object object) {
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			// 设置对象的访问权限，保证对private的属性的访问
			field.setAccessible(true);
			return (String) field.get(object);
		} catch (Exception e) {

			return null;
		}
	}

	/**
	 * 根据属性，拿到set方法，并把值set到对象中
	 * 
	 * @param obj       对象
	 * @param clazz     对象的class
	 * @param fileName  需要设置值得属性
	 * @param typeClass
	 * @param value
	 */
	public static void setValue(Object obj, Class<?> clazz, String filedName, Class<?> typeClass, Object value) {
		filedName = removeLine(filedName);
		String methodName = "set" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
		try {
			Method method = clazz.getDeclaredMethod(methodName, new Class[] { typeClass });
			method.invoke(obj, new Object[] { getClassTypeValue(typeClass, value) });
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 处理字符串 如： abc_dex ---> abcDex
	 * 
	 * @param str
	 * @return
	 */
	public static String removeLine(String str) {
		if (null != str && str.contains("_")) {
			int i = str.indexOf("_");
			char ch = str.charAt(i + 1);
			char newCh = (ch + "").substring(0, 1).toUpperCase().toCharArray()[0];
			String newStr = str.replace(str.charAt(i + 1), newCh);
			String newStr2 = newStr.replace("_", "");
			return newStr2;
		}
		return str;
	}

	/**
	 * 通过class类型获取获取对应类型的值
	 * 
	 * @param typeClass class类型
	 * @param value     值
	 * @return Object
	 */
	private static Object getClassTypeValue(Class<?> typeClass, Object value) {
		if (typeClass == int.class || value instanceof Integer) {
			if (null == value) {
				return 0;
			}
			return value;
		} else if (typeClass == short.class) {
			if (null == value) {
				return 0;
			}
			return value;
		} else if (typeClass == byte.class) {
			if (null == value) {
				return 0;
			}
			return value;
		} else if (typeClass == double.class) {
			if (null == value) {
				return 0;
			}
			return value;
		} else if (typeClass == long.class) {
			if (null == value) {
				return 0;
			}
			return value;
		} else if (typeClass == String.class) {
			if (null == value) {
				return "";
			}
			return value;
		} else if (typeClass == boolean.class) {
			if (null == value) {
				return true;
			}
			return value;
		} else if (typeClass == BigDecimal.class) {
			if (null == value) {
				return new BigDecimal(0);
			}
			return new BigDecimal(value + "");
		} else {
			return typeClass.cast(value);
		}
	}
}
