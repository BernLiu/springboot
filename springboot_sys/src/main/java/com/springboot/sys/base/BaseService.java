package com.springboot.sys.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BaseService<T> {
	
    public HashMap<String, Object> queryForObject(Object obj);

}
