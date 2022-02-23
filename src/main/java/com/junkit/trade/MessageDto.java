package com.junkit.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {

    @JsonProperty("senderId")
    private Long senderId;

    @JsonProperty("messageText")
    private String messageText;

    @JsonProperty("receiver")
    private Long receiverId;



    public Long getSenderid() {
        return senderId;
    }

    public void setSenderId(Long senderid) {
        this.senderId = senderid;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiver) {
        this.receiverId = receiver;
    }
}