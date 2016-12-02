package dto;


public class MessageDto {
    private String messageName;
    private Integer chatId;
    private String messageText;

    public MessageDto(){
    }

    public MessageDto(String messageName, Integer chatId, String messageText) {
        this.messageName = messageName;
        this.chatId = chatId;
        this.messageText = messageText;
    }

    public String getMessageName() {
        return messageName;
    }

    public Integer getChatId() {
        return chatId;
    }

    public String getMessageText() {
        return messageText;
    }
}
