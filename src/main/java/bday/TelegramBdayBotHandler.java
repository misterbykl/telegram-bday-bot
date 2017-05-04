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

    private String INEK_OBASI_BOT;
    private String TOKEN_INEK_OBASI_BOT;
    private final String DG_QUERY_HEADER = "/dg";
    private final String DG_TODAY = "/dgbugun";
    private final String DG_NOT_TODAY = "Bugün kimsenin doğum günü değil :(";
    private final String HAPPY_BDAY = ". İyi ki doğdun :)";
    private List<String> config;

    /**
     *
     * @param argTelegramConfig
     *
     * @author misterbykl
     * @since 1.0.0
     */
    public TelegramBdayBotHandler(List<String> argTelegramConfig) {
        this.INEK_OBASI_BOT = argTelegramConfig.get(0);
        this.TOKEN_INEK_OBASI_BOT = argTelegramConfig.get(1);
    }

    /**
     *
     * @param argMessage
     * @return
     *
     * @author misterbykl
     * @since 1.0.0
     */
    private SendMessage getMessage(Message argMessage) {
        System.out.println(
                "first name: " + argMessage.getChat().getFirstName() + " - " +
                        "last name: " + argMessage.getChat().getLastName() + " - " +
                        "message: " + argMessage.getText() +
                        " userId: " + argMessage.getFrom().getId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(argMessage.getChatId().toString());

        sendMessage.setText(this.bdayBotLogic(argMessage));
        sendMessage.enableMarkdown(true);
        return sendMessage;
    }

    /**
     * @param argMessage
     * @return
     *
     * @author misterbykl
     * @since 1.0.0
     */
    private String bdayBotLogic(Message argMessage) {
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
     *
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
     *
     * @author misterbykl
     * @since 1.0.0
     */
    @Override
    public String getBotToken() {
        return this.TOKEN_INEK_OBASI_BOT;
    }

    /**
     * @return
     *
     * @author misterbykl
     * @since 1.0.0
     */
    public String getBotUsername() {
        return this.INEK_OBASI_BOT;
    }

    /**
     * @param argMessage
     * @throws InvalidObjectException
     *
     * @author misterbykl
     * @since 1.0.0
     */
    private void handleIncomingMessage(Message argMessage) throws InvalidObjectException {
        try {
            sendMessage(this.getMessage(argMessage));
        } catch (TelegramApiException argE) {
            argE.printStackTrace();
        }
    }
}
