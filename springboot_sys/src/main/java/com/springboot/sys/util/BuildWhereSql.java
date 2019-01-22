package com.springboot.sys.util;

public class BuildWhereSql {

	public static String buildWhereCondition(String field,String searchType,String value) {
		StringBuffer sb = new StringBuffer();
		sb.append("AND ");
		sb.append(field);
		sb.append(searchType );
		if(value instanceof String) { 
			sb.append("'"+value+"'");
		}else {
			sb.append(value);
		}
		return sb.toString();
	}
}
