package com.springboot.sys.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysMenuEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long menuId;
	private Long parentId;
	private Long resId;  //所属资源
	private String code;  //菜单编码
	private String menuName;  //菜单名称
	private Long systemId; //系统ID
	private int isLeaf;   //是否末级
	private String viewPath; //页面路径
	private String icon;
	private String reqUrl;
	private String syspertag; //是否系统设项
	private int menuorder;    //顺序
	private int isused;      //是否启用
	private int moduleType;  //菜单类型
	private String remark;  //备注
	private String sort;	//排序
	private String wholeName;    //全名
	
}
