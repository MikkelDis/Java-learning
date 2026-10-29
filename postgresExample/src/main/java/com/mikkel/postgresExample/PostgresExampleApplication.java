package com.mikkel.postgresExample;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class PostgresExampleApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public PostgresExampleApplication(DataSource dataSource){
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(PostgresExampleApplication.class, args);
	}

	@Override
	public void run(final String... args){
		log.info("Datasource: " + dataSource);
		final JdbcTemplate template = new JdbcTemplate(dataSource);
		template.execute("select 1");
	}
}
