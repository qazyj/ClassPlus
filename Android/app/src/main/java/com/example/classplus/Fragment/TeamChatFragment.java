package com.example.classplus.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classplus.DTO.ChatRoomInfo;
import com.example.classplus.R;
import com.example.classplus.RecyclerviewController.ChatRVAdapter;

import java.util.ArrayList;
import java.util.Random;

public class TeamChatFragment extends Fragment {

    private RecyclerView recyclerviewTotalChat;
    private ChatRVAdapter totalChatRVAdapter;
    private View view;
    private ArrayList<ChatRoomInfo> chatRoomInfoList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_team_chat,container,false);

        recyclerviewTotalChat = view.findViewById(R.id.recyclerview_team_chat);

        testInit(); //테스트 데이터 삽입.

        totalChatRVAdapter = new ChatRVAdapter(getActivity(),chatRoomInfoList);
        recyclerviewTotalChat.setAdapter(totalChatRVAdapter);

        return view;
    }

    public void testInit(){
        // 랜덤 이미지 set
        Random random = new Random();
        chatRoomInfoList = new ArrayList<ChatRoomInfo>();
        chatRoomInfoList.add(new ChatRoomInfo("운영체제","12:12:12","안녕하세요",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("오픈소스","12:15:12","언제다하냐",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("사랑해요","12:12:30","헐헐헐",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("우아앙","12:12:12","ㅠㅡㅠㅡㅠ",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("운영체제","12:12:12","안녕하세요",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("오픈소스","12:15:12","언제다하냐",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("사랑해요","12:12:30","헐헐헐",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("우아앙","12:12:12","ㅠㅡㅠㅡㅠ",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("운영체제","12:12:12:","안녕하세요",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("오픈소스","12:15:12","언제다하냐",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("사랑해요","12:12:30","헐헐헐",random.nextInt(6)));
        chatRoomInfoList.add(new ChatRoomInfo("우아앙","12:12:12","ㅠㅡㅠㅡㅠ",random.nextInt(6)));


    }
}
