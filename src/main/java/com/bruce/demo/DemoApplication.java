package com.bruce.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lyh
 */
@SpringBootApplication(scanBasePackages = {"com.bruce.**"})
@AutoConfiguration
@MapperScan("com.bruce.**.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
