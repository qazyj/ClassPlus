package com.example.classplus.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classplus.R;

public class LogInActivity extends AppCompatActivity {


    private TextView logInButton;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setStatusBar();
        setUnderLine();

        logInButton = findViewById(R.id.btn_login_activity);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent); //다음화면으로 넘어감
                finish();
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