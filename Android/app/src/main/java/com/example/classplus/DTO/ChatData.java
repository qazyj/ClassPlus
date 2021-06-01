package com.example.classplus.DTO;

import com.example.classplus.R;

public class ChatData {

    public enum MessageType {
        ENTER, TALK, EXIT, WORK_STACK
    }

    private String user_email;
    private String userName;
    private String message;
    private String time;
    private int userImg;


    private MessageType type;

    public ChatData(){}

    public ChatData(String user_email, String userName, String message, String time, int userImg) {
        this.user_email = user_email;
        this.userName = userName;
        this.message = message;
        this.time = time;
        this.userImg = userImg;
        type = MessageType.TALK;
    }


    public ChatData(String userName, String message, String time, int userImg, MessageType type) {
        this.userName = userName;
        this.message = message;
        this.time = time;
        this.userImg = userImg;
        this.type = type;
    }


    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUserImg() {
        return userImg;
    }

    public void setUserImg(int userImg) {
        this.userImg = userImg;
    }


    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
