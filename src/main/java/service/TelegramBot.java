package service;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import pro.sky.telegrambot.configuration.TelegramBotConfiguration;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    final TelegramBotConfiguration telegramBotConfiguration;


    public TelegramBot(TelegramBotConfiguration telegramBotConfiguration) {
        this.telegramBotConfiguration = telegramBotConfiguration;
    }
    @Override
    public String getBotUsername() {
        return telegramBotConfiguration.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramBotConfiguration.getToken();
    }

    @Override
    @Import(value = TelegramBotConfiguration.class )
    public void onUpdateReceived(Update update) {
         bot.setUpdateListener(this::handleUpdate)

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messegeText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messegeText) {
                case "/start":

                        startCommandReceived(chatId,update.getMessage().getChat().getFirstName());
                break;
                default:sendMessage(chatId,"Sorry, command was not recognized");
            }
        }

    }

    private void startCommandReceived(long chatId,String name) {
        String answer = "Hi," + name + ", nice to meet you";
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) {
       SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
