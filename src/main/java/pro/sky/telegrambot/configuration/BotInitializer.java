package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@Component
public class TelegramBotUpdateListener {
    @Autowired
    TelegramBot telegramBot;

    public  TelegramBotUpdateListener(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
        this.telegramBot.setUpdatesListener(this);
    }

   /*@EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot( bot);
        } catch (TelegramApiException e) {

        }
    }*/

}
