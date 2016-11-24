package dto;


public class ChatDto {
    private String chatName;
    private int chatId;

    public ChatDto(){
    }

    public ChatDto(String chatName, int chatId) {
        this.chatName = chatName;
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public int getChatId() {
        return chatId;
    }
}
