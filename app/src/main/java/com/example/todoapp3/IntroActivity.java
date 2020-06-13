package com.example.todoapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class IntroActivity extends AppCompatActivity {
    WormDotsIndicator wormDotsIndicator;
    public int pos;
    public  ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        final TextView btnSkip=findViewById(R.id.skipButton);
        final TextView btnNext=findViewById(R.id.nextButton);
        wormDotsIndicator =  findViewById(R.id.worm_dots_indicator);
         viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagersAdapter(getSupportFragmentManager()));
        wormDotsIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                if(pos==0){
                    btnNext.setVisibility(View.VISIBLE);
                    btnSkip.setVisibility(View.VISIBLE);
                    btnNext.setText("NEXT");
                }
                if(pos==1){
                    btnNext.setVisibility(View.VISIBLE);
                    btnSkip.setVisibility(View.VISIBLE);
                    btnNext.setText("NEXT");
                }
              if(pos==2){
                    btnSkip.setVisibility(View.GONE);
                    btnNext.setText("START");
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onSkipButton(v);
                        }
                    });
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void onSkipButton(View view) {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    public void onNextButton(View view) {
        viewPager.setCurrentItem(getItem(+1),true);
    }
    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    public class  ViewPagersAdapter extends FragmentPagerAdapter{

        public ViewPagersAdapter(@NonNull FragmentManager fm) {
            super(fm,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Bundle bundle=new Bundle();
            bundle.putInt("pos",position);
            ViewPagerFragment fragment=new ViewPagerFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}