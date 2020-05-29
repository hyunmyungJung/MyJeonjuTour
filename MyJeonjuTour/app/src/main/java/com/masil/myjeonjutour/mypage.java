package com.masil.myjeonjutour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class mypage extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        // 로그아웃
        mAuth = FirebaseAuth.getInstance();
        Button btn_google_logout = findViewById(R.id.btn_google_logout);

        btn_google_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

        // 내가 짜고 저장한 루트 확인하기
        Button btn_myroute = findViewById(R.id.btn_myroute);

        btn_myroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CheckRouteListActivity.class));
            }
        });

    }
}
