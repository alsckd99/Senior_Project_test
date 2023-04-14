package com.example.view_pager_test;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, fragments);
        viewPager2.setAdapter(myPagerAdapter);
    }

    private class MyPagerAdapter extends FragmentStateAdapter{

        private static final int num_pages = 3;

        public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
            super(fragmentActivity);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new View_Pager_1();
                case 1:
                    return new View_Pager_2();
                case 3:
                    return new View_Pager_3();
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return num_pages;
        }
    }
}