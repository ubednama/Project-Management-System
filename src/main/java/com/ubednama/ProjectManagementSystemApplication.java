package com.ubednama;

import io.github.cdimascio.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ubednama.model")
public class ProjectManagementSystemApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
		System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));
		System.setProperty("RAZORPAY_KEY", dotenv.get("RAZORPAY_KEY"));
		System.setProperty("RAZORPAY_SECRET", dotenv.get("RAZORPAY_SECRET"));
		SpringApplication.run(ProjectManagementSystemApplication.class, args);
	}
}