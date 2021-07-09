package ru.keebi.TelegramBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.keebi.TelegramBot.Entity.Client;
import ru.keebi.TelegramBot.Repos.ClientRepo;

@SpringBootApplication
public class TelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramBotApplication.class, args);
	}

}
