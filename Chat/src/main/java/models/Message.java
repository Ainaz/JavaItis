package models;

public class Message {
    private int messageId;
    private String messageText;
    private User user;

    public Message(){
    }

    public Message(int messageId, String messageText, User user) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.user = user;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}