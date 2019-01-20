package com.springboot.sys.mapper;

import java.util.HashMap;
import java.util.Map;

public interface BaseMapper<T> {

	public int insert(T t);

    public HashMap<Object, Object> query(long id, T t);

    public int update(T t);

    public int delete(T t);

	public HashMap<String, Object> queryForObject(Map<String, Object> params);
    
}
