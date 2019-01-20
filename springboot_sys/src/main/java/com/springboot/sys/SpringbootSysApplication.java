package com.springboot.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.sys.mapper")
public class SpringbootSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSysApplication.class, args);
	}
}
