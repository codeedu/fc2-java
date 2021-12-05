package com.fullcycle.FCCatalogo;

import com.fullcycle.FCCatalogo.infrastructure.mysql.MySQLCategoryRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FcCatalogoApplication implements CommandLineRunner {

	@Autowired
	private MySQLCategoryRepositoryImpl mySQLCategoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FcCatalogoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mySQLCategoryRepository.findAllCategories();
	}
}
