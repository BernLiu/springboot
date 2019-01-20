package com.springboot.sys.base.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springboot.sys.atinterface.Column;
import com.springboot.sys.atinterface.Id;
import com.springboot.sys.atinterface.Table;
import com.springboot.sys.base.BaseService;
import com.springboot.sys.mapper.BaseMapper;
import com.springboot.sys.util.ReflectionUtils;

@Service
public  class BaseServiceImpl<T> implements BaseService{
	 //分批保存阀值
    private int count = 1000;

    private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    private BaseMapper<T> baseMapper;
    
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
	public HashMap queryForObject(Object obj) {	
    	Map<String, Object> map =new HashMap<String, Object>();
    	String tableName = obj.getClass().getAnnotation(Table.class).value();
    	map.put("TABLE_NAME",tableName);
    	String[] columnsNameArray = ReflectionUtils.getAllColumnsName(obj);
    	map.put("COLUMNS",columnsNameArray);
    	Map<String, Object> allColumnsValue = ReflectionUtils.getAllColumnsValue(obj);
    	map.put("COLUMNS_VALUES", allColumnsValue);
		return baseMapper.queryForObject(map);
	}

	private Map<String, Object> transformObj(Object t, String type) {
        //获取表名
        if (null == t.getClass().getAnnotation(Table.class)) {
            throw new RuntimeException("Error Input Object! Error @Table Annotation.");
        }
        Map<String, Object> re = new HashMap<String, Object>();
        re.put("TABLE_NAME", t.getClass().getAnnotation(Table.class).value());
        
        //获取所有的私有属性名
        Field[] fields = t.getClass().getFields();
        if(null ==fields || fields.length ==0) {
        	System.out.println("没有列明");
        }
        for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String value = field.getAnnotation(Column.class).value();
		}
       
        
        return re;
    }

	
}
