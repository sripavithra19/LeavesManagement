package com.ciberspring.api.leaves_mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ciberspring.api.leaves_mgmt")
public class LeavesManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeavesManagementApplication.class, args);
	}

}
