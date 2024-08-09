package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		//Create SQL tables if they don't exist
		String sql = "create table if not exists user (user_id int primary key auto_increment, name varchar(255), username varchar(255), password varchar(255))";
		jdbcTemplate.execute(sql);

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
