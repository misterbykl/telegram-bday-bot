package bday;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

/**
 * bday.Main.java
 * <p>
 * <b>created at</b> 29 Mar 2016 13 37
 *
 * @author emreb
 * @since 1.0.0
 */

public class Main {
    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramBdayBotHandler());
        } catch (TelegramApiException argE) {
            argE.printStackTrace();
        }
    }
}
