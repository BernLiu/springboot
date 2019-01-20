package com.springboot.sys.bean;

import java.io.Serializable;

import com.springboot.sys.atinterface.Id;

import lombok.Data;

@Data
public class BaseBean implements Serializable{
	
	@Id(value = "id")
	private Integer id;
}
