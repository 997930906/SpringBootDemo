package cn.whu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("cn.whu.controller")
//@EnableAutoConfiguration
@MapperScan(basePackages=("Mapper"))

public class APP {

	public static void main(String[] args) {
		SpringApplication.run(APP.class, args); 
	}
}
