package com.springboot.quartz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "JOB_ENTITY")
public class JobEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name; // job名称
	private String group; // job组名
	private String cron; // 执行的cron
	private String parameter; // job的参数
	private String description; // job描述信息
	@Column(name = "vm_param")
	private String vmParam; // vm参数
	@Column(name = "jar_path")
	private String jarPath; // job的jar路径
	private String status; // job的执行状态,这里我设置为OPEN/CLOSE且只有该值为OPEN才会执行该Job
	
	public JobEntity() {
		
	}
	
	@Override
    public String toString() {
        return "JobEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", cron='" + cron + '\'' +
                ", parameter='" + parameter + '\'' +
                ", description='" + description + '\'' +
                ", vmParam='" + vmParam + '\'' +
                ", jarPath='" + jarPath + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
	
	//新增Builder模式,可选,选择设置任意属性初始化对象
	public JobEntity(Builder builder) {
		id = builder.id;
        name = builder.name;
        group = builder.group;
        cron = builder.cron;
        parameter = builder.parameter;
        description = builder.description;
        vmParam = builder.vmParam;
        jarPath = builder.jarPath;
        status = builder.status;
	}
	
	@Data
	public static class Builder{
		private Integer id;
        private String name = "";          //job名称
        private String group = "";         //job组名
        private String cron = "";          //执行的cron
        private String parameter = "";     //job的参数
        private String description = "";   //job描述信息
        private String vmParam = "";       //vm参数
        private String jarPath = "";       //job的jar路径
        private String status = "";        //job的执行状态,只有该值为OPEN才会执行该Job
	}
}
