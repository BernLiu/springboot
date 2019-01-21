package com.springboot.sys.util;

public class BuildWhereSql {

	public static String buildWhereCondition(String field,String searchType,String value) {
		StringBuffer sb = new StringBuffer();
		sb.append("AND ");
		sb.append(field);
		sb.append(searchType );
		sb.append("'"+value+"'");
		return sb.toString();
	}
}
