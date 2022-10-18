package com.crudexample.employeecrudoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
		//(exclude = {DataSourceAutoConfiguration.class})
        //It is added when we have no database
@EnableScheduling
public class EmployeecrudoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeecrudoperationApplication.class, args);
	}

}
