package com.masil.myjeonjutour;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RouteMemoDetailFragment extends Fragment {

    CheckRouteActivity checkRouteActivity;

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
        String memo = null;
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_memodetail,container,false);
        Button button4 = (Button)rootview.findViewById(R.id.btn_update);
        if(getArguments() != null){ memo = getArguments().getString("memo"); }
        TextView text = (TextView)rootview.findViewById(R.id.Content);
        text.setText(memo);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRouteActivity.onChangeFragment(0);
            }
        });
        return rootview;
    }
}
