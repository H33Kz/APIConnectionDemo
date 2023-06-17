package com.h33kz.APIConnectionDemo;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.h33kz.APIConnectionDemo.connection.RequestHandler;
import com.h33kz.APIConnectionDemo.io.CommandLinePrompter;

@SpringBootApplication
public class APIConnectionDemo implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(APIConnectionDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Gson gson = new Gson();
		Scanner scanner = new Scanner(System.in);
		RequestHandler requestHandler = new RequestHandler();
		CommandLinePrompter menus = new CommandLinePrompter(scanner, requestHandler, gson);

		menus.appLoop();

		scanner.close();
	}

}
