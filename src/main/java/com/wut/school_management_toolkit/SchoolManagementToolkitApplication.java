package com.wut.school_management_toolkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SchoolManagementToolkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementToolkitApplication.class, args);
	}

}
