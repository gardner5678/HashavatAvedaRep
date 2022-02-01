package com.example.demo;

import javax.activation.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@EnableJpaRepositories(basePackages = "com.example.demo.repositories")

@SpringBootApplication
//@ComponentScan(value = "org.hibernate.Transaction")
//@Configuration
//@EnableAutoConfiguration
public class main  {
	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
//		Categories c = Categories.builder().CategoryId(1L).CategoryName("newC").build();
//		CategoriesService cr = new CategoriesService(categoriesRepository);
//		cr.save(c);
	}
//	@Bean
//	@ConfigurationProperties("app.datasource")
//	public DataSource dataSource() {
//		return (DataSource) DataSourceBuilder.create().build();
//	}

}
