package com.junkit.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {

    @JsonProperty("senderId")
    private Long senderId;

    @JsonProperty("messageText")
    private String messageText;

    @JsonProperty("receiver")
    private Long receiverId;

    @JsonProperty("messageId")
    private Long messageId;

    @JsonProperty("replyingToId")
    private Long replyingToId;



    public Long getReplyingToId() {
        return replyingToId;
    }

    public void setReplyingToId(Long replyingToId) {
        this.replyingToId = replyingToId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
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