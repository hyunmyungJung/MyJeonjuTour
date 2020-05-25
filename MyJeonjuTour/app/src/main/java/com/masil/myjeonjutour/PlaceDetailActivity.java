package com.masil.myjeonjutour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.masil.myjeonjutour.model.category_search.Document;


public class PlaceDetailActivity extends AppCompatActivity {

    TextView placeNameText;
    TextView addressText;
    TextView categoryText;
    TextView urlText;
    TextView phoneText;
    Button btn_good;
    Button btn_mytour;
    int good=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        placeNameText = findViewById(R.id.placedetail_tv_name);
        addressText = findViewById(R.id.placedetail_tv_address);
        categoryText = findViewById(R.id.placedetail_tv_category);
        urlText = findViewById(R.id.placedetail_tv_url);
        phoneText = findViewById(R.id.placedetail_tv_phone);
        btn_good=findViewById(R.id.btn_good);
        btn_mytour=findViewById(R.id.btn_mytour);
        processIntent();

        btn_good.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                good++;
                btn_good.setText("good"+good);
            }


        });

        btn_mytour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(PlaceDetailActivity.this,"add mytour",Toast.LENGTH_SHORT);
            }


        });
    }



    private void processIntent(){
        Intent processIntent = getIntent();
        Document document = processIntent.getParcelableExtra("PLACE_SEARCH_DETAIL_EXTRA");
        placeNameText.setText(document.getPlaceName());
        addressText.setText(document.getAddressName());
        categoryText.setText(document.getCategoryName());
        urlText.setText(document.getPlaceUrl());
        phoneText.setText(document.getPhone());
    }
}
