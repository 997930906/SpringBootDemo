package cn.whu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("cn.whu.controller")
//@EnableAutoConfiguration
@MapperScan(basePackages=("cn.whu.mapper"))

public class APP {

	public static void main(String[] args) {
		SpringApplication.run(APP.class, args); 
	}
}
