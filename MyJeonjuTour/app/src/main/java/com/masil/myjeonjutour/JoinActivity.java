package com.masil.myjeonjutour;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.masil.myjeonjutour.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class JoinActivity extends AppCompatActivity implements View.OnClickListener{
    EditText id, pwd, pwConfirm, name, nickname, phone;
    String tid, tpwd, tpwConfirm, tname, tnickname, tphone;
    CheckBox inform_check;
    private static final String TAG = "joinactivity";
    private FirebaseAuth mAuth;
    private User muser;
    boolean pwCheck;

    private final String closePopup_1 = "Close Popup_1"; // 이용약관 팝업
    private final String closePopup_2 = "Close Popup_2"; // 정보제공 팝업
    String result_1, result_2;

    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        id = (EditText) findViewById(R.id.InputId);
        pwd = (EditText) findViewById(R.id.InputPw);
        pwConfirm = (EditText) findViewById(R.id.InputConfirmPw);
        name = (EditText) findViewById(R.id.InputName);
        nickname = (EditText) findViewById(R.id.InputNum);
        phone = (EditText) findViewById(R.id.phone);


        Button joinBtn = (Button) findViewById(R.id.Joinbtn); // 회원가입
        joinBtn.setOnClickListener(this);

    } //onCreate() 종료

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // updateUI(currentUser);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                result_1 = data.getStringExtra("result_1"); // 이용약관
                result_1.toString();
            }
        }

        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                result_2 = data.getStringExtra("result_2");
                result_2.toString();
            }
        }

        if (result_1 != null && result_2 != null) {
            if (result_1.equals(closePopup_1) && result_2.equals(closePopup_2)) { // 정보 제공, 이용 약관 모두 확인 시
                inform_check.setChecked(true); // 체크 박스 체크
                inform_check.setEnabled(false); // 체크 박스 사용 불가 상태
            }

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Joinbtn: // 회원가입 버튼
                tid = id.getText().toString();
                tpwd = pwd.getText().toString();
                tname = name.getText().toString();
                tnickname = nickname.getText().toString();
                tphone = phone.getText().toString();
                tpwConfirm = pwConfirm.getText().toString();

                pwCheck = Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%^&*()-])(?=.*[a-zA-Z]).{6,16}$", tpwd);

                //유효성 검사
                if(tid.trim().length() == 0 || tpwd.trim().length() == 0 || tpwConfirm.trim().length() == 0 || tname.trim().length() == 0 || tphone.trim().length() == 0){
                    Toast.makeText(this, "빈칸 없이 모두 입력하세요!", Toast.LENGTH_SHORT).show();
                    Log.d("minsu", "공백 발생");
                    return;
                }

                else if(!tpwd.equals(tpwConfirm)){
                    Toast.makeText(this, "비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();


                }

                else if(!pwCheck){
                    Toast.makeText(this, "비밀번호는 6~16자 영문 대 소문자, 숫자, 특수문자의 조합을 사용하세요!", Toast.LENGTH_SHORT).show();

                }

                else if(spaceCheck(tpwd)){
                    Toast.makeText(this, "비밀번호에 공백을 사용할 수 없습니다!", Toast.LENGTH_SHORT).show();

                }

                else {
                    mAuth.createUserWithEmailAndPassword(tid, tpwd)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        muser=new User(tid,tname,tnickname,tphone);
                                        //  updateUI(user);
                                        setDocument();
                                        gotoNext();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(JoinActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                        //updateUI(null);
                                    }

                                    // ...
                                }
                            });

                }

        }


    }


    public boolean spaceCheck(String spaceCheck) // 문자열 안에 스페이스 체크
    {
        for(int i = 0; i < spaceCheck.length(); i++)
        {

            if(spaceCheck.charAt(i) == ' ')
                return true;

        }
        return false;
    }

    private void gotoNext() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    // 파이어스토어 데이터베이스 생성
    public void setDocument() {
        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();

        assert mUser != null;
        String userUID = mUser.getUid();

        Map<String, Object> user = new HashMap<>();
        user.put("Email", mUser.getEmail());
        user.put("UserName", muser.getUserName());
        user.put("NickName", muser.getNickName());
        user.put("PhoneNumber", muser.getPhoneNumber());
        user.put("MytourCount", "0");

        db.collection("users")
                .document(userUID)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }

}