package bday;

import org.joda.time.LocalDateTime;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.Map;

/**
 * bday.TelegramBdayBotHandler.java
 * <p>
 * <b>created at</b> 29 Mar 2016 14 07
 *
 * @author misterbykl
 * @since 1.0.0
 */

public class TelegramBdayBotHandler extends TelegramLongPollingBot {

    public static final String INEK_OBASI_BOT = "InekObasiBot";
    public static final String TOKEN_INEK_OBASI_BOT = "211293657:AAGumQvPrPMqpvdP-0I5BluEjDzxHP0IL48";
    public static final String DG_QUERY_HEADER = "/dg";
    public static final String DG_TODAY = "/dgbugun";
    public static final String DG_NOT_TODAY = "Bugün kimsenin doğum günü değil :(";
    public static final String HAPPY_BDAY = ". İyiki doğdun :)";

    private static SendMessage getMessage(Message argMessage) {
        System.out.println(
                "first name: " + argMessage.getChat().getFirstName() + " - " +
                        "last name: " + argMessage.getChat().getLastName() + " - " +
                        "message: " + argMessage.getText() +
                        " userId: " + argMessage.getFrom().getId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(argMessage.getChatId().toString());

        sendMessage.setText(TelegramBdayBotHandler.bdayBotLogic(argMessage));
        sendMessage.enableMarkdown(true);
        return sendMessage;
    }

    /**
     * @param argMessage
     * @return
     * @author misterbykl
     * @since 1.0.0
     */
    private static String bdayBotLogic(Message argMessage) {
        StringBuilder replyTextForList = new StringBuilder();
        String replyText = null;
        Map map = DGList.getDgListesi();
        List<String> list = DGList.getKisiListesi();
        if (DG_QUERY_HEADER.equals(argMessage.getText())) {
            map.forEach((k, v) -> replyTextForList.append(k).append(" - ").append(v).append("\n"));
            replyText = replyTextForList.toString();
        } else if (DG_TODAY.equals(argMessage.getText())) {
            String dgKisi = null;
            LocalDateTime localDateTime = new LocalDateTime();
            String currentDate = DGList.getDateFormat().print(localDateTime);
            Map mapDgt = DGList.getDgtListesi();
            for (int i = 0; i < list.size(); i++) {
                if (currentDate.equals(mapDgt.get(list.get(i)))) {
                    dgKisi = list.get(i);
                    break;
                }
            }
            replyText = dgKisi == null ? DG_NOT_TODAY : dgKisi + HAPPY_BDAY;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if ((DG_QUERY_HEADER + list.get(i)).equals(argMessage.getText())) {
                    replyText = map.get(list.get(i)).toString();
                }
            }
        }

        return replyText;
    }

    /**
     * @param argUpdate
     * @author misterbykl
     * @since 1.0.0
     */
    public void onUpdateReceived(Update argUpdate) {
        Message message = argUpdate.getMessage();
        if (message != null && message.hasText()) {
            try {
                handleIncomingMessage(message);
            } catch (InvalidObjectException argE) {
                argE.printStackTrace();
            }
        }
    }

    /**
     * @return
     * @author misterbykl
     * @since 1.0.0
     */
    @Override
    public String getBotToken() {
        return TelegramBdayBotHandler.TOKEN_INEK_OBASI_BOT;
    }

    /**
     * @return
     * @author misterbykl
     * @since 1.0.0
     */
    public String getBotUsername() {
        return TelegramBdayBotHandler.INEK_OBASI_BOT;
    }

    /**
     * @param argMessage
     * @throws InvalidObjectException
     * @author misterbykl
     * @since 1.0.0
     */
    private void handleIncomingMessage(Message argMessage) throws InvalidObjectException {
        try {
            sendMessage(getMessage(argMessage));
        } catch (TelegramApiException argE) {
            argE.printStackTrace();
        }
    }
}
