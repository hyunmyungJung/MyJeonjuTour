package com.masil.myjeonjutour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mAuth = FirebaseAuth.getInstance();

//        Button btn_kakao_map = findViewById(R.id.btn_kakao_map);
//        Button btn_google_logout = findViewById(R.id.btn_google_logout);
//        Button btn_myroute = findViewById(R.id.btn_myroute);



//        btn_kakao_map.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MapActivity.class));
//            }
//        });

//        btn_google_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAuth.signOut();
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                finish();
//            }
//        });
//
//        btn_myroute.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, CheckRouteListActivity.class));
//            }
//        });



        // 메뉴로 이동
        ImageButton btn_mypage = findViewById(R.id.mypage_icon);

        btn_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, mypage.class));
            }
        });


        // 카카오맵 가서 경로짜기
        ImageButton btn_kakao_map = findViewById(R.id.btn_kakao_map);

        btn_kakao_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapActivity.class));
            }
        });


        // viewpager
        ViewPager viewPager = findViewById(R.id.viewPager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        // ViewPager와  FragmentAdapter 연결
        viewPager.setAdapter(fragmentAdapter);

        // Fragment로 넘길 Image Resource
        ArrayList<Integer> listImage = new ArrayList<>();
        listImage.add(R.drawable.first);
        listImage.add(R.drawable.second);
        listImage.add(R.drawable.third);
        listImage.add(R.drawable.fourth);
        listImage.add(R.drawable.fifth);

//        // FragmentAdapter에 Fragment 추가, Image 개수만큼 추가
//        for (int i = 0; i < 4; i++) {
//            ImageFragment imageFragment = new ImageFragment();
//            fragmentAdapter.addItem(imageFragment);
//        }
//
//        fragmentAdapter.notifyDataSetChanged();


        viewPager.setClipToPadding(false);
        int dpValue = 16;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        // FragmentAdapter에 Fragment 추가, Image 개수만큼 추가
        for (int i = 0; i < listImage.size(); i++) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", listImage.get(i));
            imageFragment.setArguments(bundle);
            fragmentAdapter.addItem(imageFragment);
        }
        fragmentAdapter.notifyDataSetChanged();


    }

    class FragmentAdapter extends FragmentPagerAdapter {

        // ViewPager에 들어갈 Fragment들을 담을 리스트
        private ArrayList<Fragment> fragments = new ArrayList<>();

        // 필수 생성자
        FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        // List에 Fragment를 담을 함수
        void addItem(Fragment fragment) {
            fragments.add(fragment);
        }
    }


}
