package com.springboot.quartz.util;

import java.util.List;
import java.util.Map;

public class GetParamUtils {

	//获取Map参数值
    public static String getMapString(Map<String, String> map) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            result.append(entry.getValue()).append(" ");
        }
        return result.toString();
    }

    //获取List参数值
    public static String getListString(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s).append(" ");
        }
        return result.toString();
    }

}
