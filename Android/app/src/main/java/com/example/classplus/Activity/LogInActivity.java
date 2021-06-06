package com.example.classplus.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classplus.AppManager;
import com.example.classplus.CSVReader.FileExplorer;

import com.example.classplus.ChattingRoomManagement.ClassNameGetterDialog;
import com.example.classplus.Constant;
import com.example.classplus.DTO.ChatRoomInfo;
import com.example.classplus.DTO.ChatRoomToUser;
import com.example.classplus.DTO.User;
import com.example.classplus.MysqlDataConnector.FakeModel;
import com.example.classplus.MysqlDataConnector.IModel;
import com.example.classplus.MysqlDataConnector.MysqlImpl;
import com.example.classplus.R;
import com.example.classplus.firebase.FirebaseConnector;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class LogInActivity extends AppCompatActivity {

    private EditText idEditText;
    private EditText pwEditText;
    private TextView logInButton;
    private char result2;
    private String email;

    IModel model = new FakeModel();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            AppManager.getInstance().setLoginUser(model.login("sawon49@naver.com", "ssss"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FirebaseConnector.getInstance(this);

        setContentView(R.layout.activity_login);

        setStatusBar();
        setUnderLine();

        idEditText = findViewById(R.id.et_login_id);
        pwEditText = findViewById(R.id.et_login_pw);
        logInButton = findViewById(R.id.btn_login_activity);

        ClassNameGetterDialog classNameGetterDialog = new ClassNameGetterDialog();
        classNameGetterDialog.showDialog(this);


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = idEditText.getText().toString();
                String password = pwEditText.getText().toString();

                IModel model = new MysqlImpl();     // IModel 생성
                User user = null;

                try {
                    user = (User) model.login(email, password);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if(user == null) {
                    Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 다릅니다. ", Toast.LENGTH_LONG).show();
                }
                else {
                    AppManager.getInstance().setLoginUser(user);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    // 상태바 색 바꾸기
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setStatusBar() {
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.parseColor("#00000000"));//색 지정
    }

    private void setUnderLine(){

        TextView signUpBnt = findViewById(R.id.tv_loggin_sigupbnt);
        TextView findIdBnt = findViewById(R.id.tv_loggin_findidbnt);

        String signUpString = (String) signUpBnt.getText();
        String findIdString = (String) findIdBnt.getText();

        signUpBnt.setText(Html.fromHtml("<u>" + signUpString + "</u>"));
        findIdBnt.setText(Html.fromHtml("<u>" + findIdString + "</u>"));

    }
}
