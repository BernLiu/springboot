package com.springboot.sys.bean;

import java.io.Serializable;
import java.util.Date;

import com.springboot.sys.atinterface.Column;
import com.springboot.sys.atinterface.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(value = "sys_user")
@Data
@EqualsAndHashCode(callSuper=false)
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(value="id")
	private String id;
	@Column(value = "username")
	private String username;
	@Column(value = "password")
	private String password;
	@Column(value = "email")
	private String email;
	@Column(value = "status")
	private String status;
	@Column(value = "create_time")
	private Date createTime;
	
}
