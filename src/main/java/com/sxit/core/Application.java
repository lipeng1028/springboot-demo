package com.sxit.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类，启动SpringBoot项目，自动扫描同包或者子包下的注解（@Controller,@Service...）
 * 
 * @author 鹏少
 *
 */
@SpringBootApplication
//不在启动类的同级目录的代码需要引入
@ComponentScan(basePackages = { "com.sxit.controller", "com.sxit.service", "com.sxit.config" })
@MapperScan("com.sxit.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
