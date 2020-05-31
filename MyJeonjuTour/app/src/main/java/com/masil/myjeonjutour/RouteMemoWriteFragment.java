package com.masil.myjeonjutour;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class RouteMemoWriteFragment extends Fragment {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CheckRouteActivity checkRouteActivity;
    EditText editText;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        checkRouteActivity = (CheckRouteActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        checkRouteActivity= null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        String rname = null;
        String user_id = null;
        String getmemo=null;
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_memowrite,container,false);
        Button button = (Button)rootview.findViewById(R.id.Writebtn);
        editText=(EditText)rootview.findViewById(R.id.InputContent);
        if(getArguments() != null) {
            rname = getArguments().getString("routename");
            user_id = getArguments().getString("user_id");
            getmemo=getArguments().getString("memo");
        }
        editText.setText(getmemo);
        //editText.setTextIsSelectable(true);
        final String finalUser_id = user_id;
        final String finalRname = rname;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRouteActivity.onChangeFragment(1);
                String memo=editText.getText().toString();
                System.out.println(memo+"적힌내용!!!!!!!!!!!!!");
                db.collection("users").document(finalUser_id).collection("routename").document(finalRname).update("memo",memo);
            }
        });


        return rootview;
    }
}