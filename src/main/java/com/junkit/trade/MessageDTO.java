package com.junkit.trade;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {

    @JsonProperty("senderName")
    private String senderName;

    @JsonProperty("messageText")
    private String messageText;

    @JsonProperty("userId")
    private Long userId;


    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
