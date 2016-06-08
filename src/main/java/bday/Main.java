package bday;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * bday.Main.java
 * <p>
 * <b>created at</b> 29 Mar 2016 13 37
 *
 * @author misterbykl
 * @since 1.0.0
 */

public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        Properties properties = new Properties();
        properties.load(new FileReader(new File("./conf/dg.txt")));
        List<String> kisiList = Arrays.asList(properties.get("kisi").toString().split(","));
        List<String> dgList = Arrays.asList(properties.get("dg").toString().split(","));
        List<String> dgtList = Arrays.asList(properties.get("dgt").toString().split(","));

        DGList.setDates(kisiList, dgList, dgtList);
        DGList.setDateFormat();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramBdayBotHandler());
        } catch (TelegramApiException argE) {
            argE.printStackTrace();
        }
    }
}
