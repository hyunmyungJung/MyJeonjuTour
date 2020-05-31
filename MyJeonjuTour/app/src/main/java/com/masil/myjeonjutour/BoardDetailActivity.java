package com.masil.myjeonjutour;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.firestore.FirebaseFirestore;
import com.masil.myjeonjutour.model.BoardListItem;

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class BoardDetailActivity extends AppCompatActivity {
    private BoardListItem m_arr;
    private Activity m_activity;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TextView mcontent, mtitle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mtitle = (TextView) findViewById((R.id.Title));
        mcontent = (TextView) findViewById((R.id.Content));
        m_arr = new BoardListItem();

        setting();


    }

    private void setting() {
        Bundle b = getIntent().getExtras();
        m_arr.setTitle(b.getString("TITLE"));
        m_arr.setDate(b.getLong("DATE"));
        m_arr.setWriter(b.getString("WRITER"));
        m_arr.setDetail(b.getString("DETAIL"));
        mtitle.setText(m_arr.getTitle());
        mcontent.setText(m_arr.getDetail());

    }

}
