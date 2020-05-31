package com.masil.myjeonjutour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class BoardListWrite extends Activity implements View.OnClickListener {
    EditText mcontent, mnum, mtitle;
    String  tcontent, ttitle, tname;
    int tcount;

    //Bundle b = getIntent().getExtras();
    //String userid = b.getString("userid");

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String user_id = user.getUid();

    //private ServiceApi service;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardwrite);
        mtitle = (EditText) findViewById((R.id.InputTitle));
        mcontent = (EditText) findViewById(R.id.InputContent);

        Button write = (Button) findViewById(R.id.Writebtn); // 회원가입
        write.setOnClickListener(this);

        db.collection("users").document(user_id)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                //닉네임 받아오기
                                tname = document.getString("NickName");
                                tcount = Integer.valueOf(document.getString("BoardCount"));
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }
                });

    } //onCreate() 종료

    @Override
    public void onClick(View v) {
        long curtime = System.currentTimeMillis();
        switch (v.getId()) {
            case R.id.Writebtn: // 글 작성
                ttitle = mtitle.getText().toString();
                tcontent = mcontent.getText().toString();

                if (ttitle.trim().length() == 0 || tcontent.trim().length() == 0) {
                    Toast.makeText(this, "제목과 내용은 빠짐없이 입력하세요!", Toast.LENGTH_SHORT).show();
                    Log.d("board", "공백 발생");
                    return;
                }
                else {
                    Map<String, Object> user = new HashMap<>();
                    user.put("ttitle", ttitle);
                    user.put("tname", tname);
                    user.put("tdate", curtime);
                    user.put("tcontent", tcontent);

                    // Add a new document with a generated ID
                    db.collection("board").document(user_id + tcount)
                            .set(user)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "DocumentSnapshot successfully written!");
                                    db.collection("users").document(user_id).update("BoardCount",Integer.toString(++tcount));
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error writing document", e);
                                }
                            });

                    Intent intent = new Intent(this, BoardListActivity.class);
                    startActivity(intent);

                    finish();
                }
        }
    }
}
