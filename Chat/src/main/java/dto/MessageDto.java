package dto;


public class MessageDto {
    private String messageName;
    private String messageText;

    public MessageDto(){
    }

    public MessageDto(String messageName, String messageText) {
        this.messageName = messageName;
        this.messageText = messageText;
    }

    public String getMessageName() {
        return messageName;
    }

    public String getMessageText() {
        return messageText;
    }
}
