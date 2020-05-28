package com.masil.myjeonjutour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        Button btn_kakao_map = findViewById(R.id.btn_kakao_map);
        Button btn_google_logout = findViewById(R.id.btn_google_logout);
        Button btn_myroute = findViewById(R.id.btn_myroute);

        btn_kakao_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapActivity.class));
            }
        });

        btn_google_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });

        btn_myroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CheckRouteListActivity.class));
            }
        });

        Button btn_ask = findViewById(R.id.btn_ask);
            startActivity(new Intent(MainActivity.this, mypage.class));

    }


}
