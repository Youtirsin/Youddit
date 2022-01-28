package com.fourzhang.youddit;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fourzhang.youddit.mapper")
public class YoudditApplication {
	public static void main(String[] args) {
		SpringApplication.run(YoudditApplication.class, args);
	}
}
