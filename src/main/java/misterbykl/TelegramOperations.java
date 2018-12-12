package misterbykl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

class TelegramOperations {

    TelegramOperations() {
        try {
//            JsonParser jsonParser = new JsonParser();
//            JsonElement jsonElement = jsonParser.parse(new FileReader("./config/dg.json"));
//            jsonElement.getAsJsonArray().get();
//            ArrayList<String> kisiList = Arrays.asList(dgProperties.get("kisi").toString().split(","));
//            ArrayList<String> dgList = Arrays.asList(dgProperties.get("dg").toString().split(","));
//            ArrayList<String> dgtList = Arrays.asList(dgProperties.get("dgt").toString().split(","));
//
//            Properties telegramConfigProperties = new Properties();
//            telegramConfigProperties.load(new FileReader(new File("./conf/config.txt")));
//            List<String> telegramConfig = Arrays.asList(telegramConfigProperties.get("bot.info").toString().split(","));
//
//            DGList.setDates(kisiList, dgList, dgtList);
//            DGList.setDateFormat();
//
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//            telegramBotsApi.registerBot(new BirthdayBot(telegramConfig));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
