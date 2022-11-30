package pro.sky.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.generics.TelegramBot;

@SpringBootApplication
@EnableScheduling
public class TelegramBotApplication {

	public static void main(String[] args) {

		SpringApplication.run(TelegramBotApplication.class, args);
		TelegramBot bot = new service.TelegramBot("BOT_TOKEN","5626266775:AAGgr9zRRc6cQcv4_SJtQNAyn9QS9pRSKdk");
	}

}
