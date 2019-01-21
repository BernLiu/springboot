package com.springboot.sys.util;

import java.util.Map;
import com.google.gson.Gson;

public class JsonUtils {

	public static String MapToJson(Map<String, Object> map) {
		Gson gson = new Gson();
		return gson.toJson(map);
	}
}
