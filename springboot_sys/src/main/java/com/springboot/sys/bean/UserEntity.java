package com.springboot.sys.bean;

import java.io.Serializable;
import java.util.Date;

import com.springboot.sys.atinterface.Column;
import com.springboot.sys.atinterface.Table;
import com.springboot.sys.enums.SearchType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(value = "sys_users")
@Data
@EqualsAndHashCode(callSuper=false)
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(value="USER_ID",searchType=SearchType.EQ)
	private String userId;
	@Column(value="USERNAME",searchType=SearchType.EQ)
	private String username;
	@Column(value="NAME",searchType=SearchType.EQ)
	private String name;
	@Column(value="PASSWORD",searchType=SearchType.EQ)
	private String password;
	@Column(value="DT_CREATE",searchType=SearchType.EQ)
	private Date dtCreate;
	@Column(value="LAST_LOGIN",searchType=SearchType.EQ)
	private Date lastLogin;
	@Column(value="DEADLINE",searchType=SearchType.EQ)
	private String deadline;
	@Column(value="LOGIN_IP",searchType=SearchType.EQ)
	private String loginIp;
	@Column(value="V_QZJGID",searchType=SearchType.EQ)
	private String vQzjgid;
	@Column(value="V_QZJGMC",searchType=SearchType.EQ)
	private String v_qzjgmc;
	@Column(value="DEP_ID",searchType=SearchType.EQ)
	private String depId;
	@Column(value="DEP_NAME",searchType=SearchType.EQ)
	private String depName;
	@Column(value="ENABLED",searchType=SearchType.EQ)
	private String enabled;
	@Column(value="ACCOUNT_NON_EXPIRED",searchType=SearchType.EQ)
	private Integer accountNonExpired;
	@Column(value="ACCOUNT_NON_LOCKED",searchType=SearchType.EQ)
	private Integer accountNonLocked;
	@Column(value="CREDENTIALS_NON_EXPIRED",searchType=SearchType.EQ)
	private Integer credentialsNonExpired;
}
