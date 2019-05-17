import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) throws TelegramApiRequestException {

        //Ставим прокси через порт Tor
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("socksProxyHost", "localhost");
        System.getProperties().put("socksProxyPort", "9150");

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new Bot());

    }

    public void sendMsg(Message message, String text) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        setButtons(sendMessage);
        execute(sendMessage);

    }

    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowsList = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Сегодня"));
        keyboardFirstRow.add(new KeyboardButton("Завтра"));

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton("На этой неделе"));
        keyboardSecondRow.add(new KeyboardButton("На следующей неделе"));

        keyboardRowsList.add(keyboardFirstRow);
        keyboardRowsList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowsList);


    }

    public void onUpdateReceived(Update update) {
        int dayOfWeek = Logic.getDayOfWeek();
        int days = 0;
        try {
            days = Logic.getDays();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "Сегодня":
                    try {
                        sendMsg(message, Logic.condition(days, dayOfWeek));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Завтра":
                    try {
                        sendMsg(message, "завтра");
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "На этой неделе":
                    try {
                        sendMsg(message, "на эту неделю");
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "На следующей неделе":
                    try {
                        sendMsg(message, "на следующую неделю");
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        sendMsg(message, "Я вас не понимаю");
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    public String getBotUsername() {
        return "Расписание группы ТСО-304Б-16";
    }

    public String getBotToken() {
        return null;
    }
}





