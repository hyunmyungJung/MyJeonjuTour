package com.masil.myjeonjutour.youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.masil.myjeonjutour.R;

import java.io.IOException;
import java.util.Vector;

public class YoutubeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //AsyncTask 작동시킴
        new Description().execute();

    }

    private class Description extends AsyncTask<Void, Void, Void> {

        //진행바표시
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //진행다일로그 시작
            progressDialog = new ProgressDialog(YoutubeActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("잠시 기다려 주세요.");
            progressDialog.show();
            Log.v("result: ", "잠시 기달 ");

        }

        @Override
        protected Void doInBackground(Void... params) {

            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/1YWMH2Gk-pM\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/7TaRH3Kn7vo\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/iLsST6wiayM\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5CJxi3zF9tY\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_3QNTndeew0\" frameborder=\"0\" allowfullscreen></iframe>") );

            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RQqbXeQ-Mmo\" frameborder=\"0\" allowfullscreen></iframe>") );

            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/f5fw-MgoPN4\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FHSQkSSXGf4\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/6rcBBnNLUEM\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/aE69hWHxoZU\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/iX9tFIBaIJY\" frameborder=\"0\" allowfullscreen></iframe>") );

            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/6VHbKr2qb3k\" frameborder=\"0\" allowfullscreen></iframe>") );


            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/4F83vCYjwvQ\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zdJERR5k8IQ\" frameborder=\"0\" allowfullscreen></iframe>") );
            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/buv5knmuq44\" frameborder=\"0\" allowfullscreen></iframe>") );

            youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eDsy_9BoBqk\" frameborder=\"0\" allowfullscreen></iframe>") );


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //ArraList를 인자로 해서 어답터와 연결한다.

            VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(videoAdapter);
            progressDialog.dismiss();
            Log.v("result: ", "잠시기달 4");

        }
    }
}
