package com.h33kz.APIConnectionDemo;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;

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
		FileSaveHandler fileSaveHandler = new FileSaveHandler();
		CommandLinePrompter menus = new CommandLinePrompter(scanner, requestHandler, fileSaveHandler, gson);

		menus.appLoop();

		scanner.close();
	}

}
