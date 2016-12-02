package models;

public class Message {
    private int messageId;
    private String messageText;
    private int userId;
    private int chatId;

    public Message() {
    }

    public Message(String messageText, int userId, int chatId) {
        this.messageText = messageText;
        this.userId = userId;
        this.chatId = chatId;
    }

    public Message(int messageId, String messageText, int userId, int chatId) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.userId = userId;
        this.chatId = chatId;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public int getUserId() {
        return userId;
    }

    public int getChatId() {
        return chatId;
    }
}
