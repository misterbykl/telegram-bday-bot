package bday;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.io.InvalidObjectException;

/**
 * bday.TelegramBdayBotHandler.java
 * <p>
 * <b>created at</b> 29 Mar 2016 14 07
 *
 * @author emreb
 * @since 1.0.0
 */

public class TelegramBdayBotHandler extends TelegramLongPollingBot {

    public static final String INEK_OBASI_BOT = "InekObasiBot";
    public static final String TOKEN_INEK_OBASI_BOT = "211293657:AAGumQvPrPMqpvdP-0I5BluEjDzxHP0IL48";

    private static SendMessage getMessage(Message message) {
        System.out.println(
                "first name: " + message.getChat().getFirstName() + " - " +
                        "last name: " + message.getChat().getLastName() + " - " +
                        "message: " + message.getText() +
                        " userId: " + message.getFrom().getId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());

        String replyText = null;

        if ("/dg_emre".equals(message.getText())) {
            replyText = BDayList.EMRE;
        } else if ("/dg_seda".equals(message.getText())) {
            replyText = BDayList.SEDA;
        } else if ("/dg_ersen".equals(message.getText())) {
            replyText = BDayList.ERSEN;
        } else if ("/dg_basak".equals(message.getText())) {
            replyText = BDayList.BASAK;
        } else if ("/dg_murat".equals(message.getText())) {
            replyText = BDayList.MURAT;
        } else if ("/dg_senem".equals(message.getText())) {
            replyText = BDayList.SENEM;
        } else if ("/dg_isil".equals(message.getText())) {
            replyText = BDayList.ISIL;
        } else if ("/dg_caglar".equals(message.getText())) {
            replyText = BDayList.CAGLAR;
        } else if ("/dg_begum".equals(message.getText())) {
            replyText = BDayList.BEGUM;
        } else if ("/dg_suhan".equals(message.getText())) {
            replyText = BDayList.SUHAN;
        } else if ("/dg_sinan".equals(message.getText())) {
            replyText = BDayList.SINAN;
        } else if ("/dg_mert".equals(message.getText())) {
            replyText = BDayList.MERT;
        }

        sendMessage.setText(replyText);
        sendMessage.enableMarkdown(true);
        return sendMessage;
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            try {
                handleIncomingMessage(message);
            } catch (InvalidObjectException argE) {
                argE.printStackTrace();
            }
        }
    }

    @Override
    public String getBotToken() {
        return TelegramBdayBotHandler.TOKEN_INEK_OBASI_BOT;
    }

    public String getBotUsername() {
        return TelegramBdayBotHandler.INEK_OBASI_BOT;
    }

    private void handleIncomingMessage(Message message) throws InvalidObjectException {
        try {
            sendMessage(getMessage(message));
        } catch (TelegramApiException argE) {
            argE.printStackTrace();
        }
    }
}