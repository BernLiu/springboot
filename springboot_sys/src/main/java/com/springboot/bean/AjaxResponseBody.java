package com.springboot.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class AjaxResponseBody implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String msg;
	private Object result;
	private String jwtToken;
}
