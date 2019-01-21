package com.springboot.sys.bean;

import java.io.Serializable;
import java.util.Date;

import com.springboot.sys.atinterface.Column;
import com.springboot.sys.atinterface.Table;
import com.springboot.sys.enums.SearchType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(value = "sys_user")
@Data
@EqualsAndHashCode(callSuper=false)
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(value="id",searchType = SearchType.EQ)
	private String id;
	@Column(value = "username",searchType=SearchType.EQ)
	private String username;
	@Column(value = "password",searchType=SearchType.EQ)
	private String password;
	@Column(value = "email",searchType=SearchType.EQ)
	private String email;
	@Column(value = "status",searchType=SearchType.EQ)
	private String status;
	@Column(value = "create_time",searchType=SearchType.EQ)
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
