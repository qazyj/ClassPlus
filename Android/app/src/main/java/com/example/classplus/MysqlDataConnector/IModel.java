package com.example.classplus.MysqlDataConnector;


import com.example.classplus.Constant;

import com.example.classplus.Constant.*;
import com.example.classplus.DTO.ChatRoomToUser;
import com.example.classplus.DTO.User;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface IModel {

    User login(String email, String password) throws ExecutionException, InterruptedException; //login 못하면 User = NULL 반환

    User getUserinfo(String email) throws ExecutionException, InterruptedException, JSONException;

    String getChattingName(int uuid) throws JSONException, ExecutionException, InterruptedException; // 없는 uui == null 반환

    // email에 따라서 email에 맞는 uuid 가져옴
    ArrayList<ChatRoomToUser> getChattingRoomToUser(String user_email) throws ExecutionException, InterruptedException, JSONException;

    int createChattingRoom(String roomName, String admin_email) throws ExecutionException, InterruptedException; // 채팅방 이름 후 uuid 반환

    void setChattingRoomAdmin(int chattingRoomUUID, String userEmail);

    int enterChattingRoom(int uuid, String email); // 성공 SUCCESS 반환, 실패 FAILURE

    int exitChattingRoom(int uuid, String email); // 성공 SUCCESS 반환, 실패 FAILURE

}
