package com.masil.myjeonjutour;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;


import java.util.ArrayList;

public class CheckRouteListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Activity m_activity;
    private ArrayList<String> arr;

    public CheckRouteListAdapter(Activity act, ArrayList<String> arr_item) {
        this.m_activity = act;
        arr = arr_item;
        mInflater = (LayoutInflater) m_activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    //position은 arraylist에 들어갈 아이템의 위치
    //
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            int res = 0;
            res = com.masil.myjeonjutour.R.layout.list_item;
            convertView = mInflater.inflate(res, parent, false);
        }

        LinearLayout layout_view = (LinearLayout) convertView.findViewById(R.id.vi_view);

        Button check = (Button) convertView.findViewById(R.id.checkroute);

        check.setText(arr.get(position));

        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoIntent(position);
            }
        });

        return convertView;
    }

    public void GoIntent(int a) {
        Intent intent = new Intent(m_activity, CheckRouteActivity.class);
        //putExtra 로 선택한 아이템의 정보를 인텐트로 넘겨 줄 수 있다.
        intent.putExtra("routename", arr.get(a));
        m_activity.startActivity(intent);
    }
}