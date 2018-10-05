package com.mcuadrada.viewpagerexample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import com.mcuadrada.viewpagerexample.Fragments.FirstFragment;
import com.mcuadrada.viewpagerexample.Fragments.SecondFragment;
import com.mcuadrada.viewpagerexample.Fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 3;
    PagerAdapter adapter;
    ViewPager viewPager;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;

        adapter = new PagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.vpr);
        viewPager.setAdapter(adapter);
    }

    public static class PagerAdapter extends FragmentPagerAdapter {
        private static int NUM_PAGES = 3;
        Drawable myDrawable;

        public PagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FirstFragment.newInstance(0, "Page #1");
                case 1:
                    return SecondFragment.newInstance(1, "Page #2");
                case 2:
                    return ThirdFragment.newInstance(2, "Page #3");
                default:
                    return null;
            }
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            SpannableStringBuilder sb = new SpannableStringBuilder(" Page #"
                    + position);
            switch (position){
                case 0:
                    myDrawable = mContext.getResources().getDrawable(R.drawable.ic_action_one);
                    break;
                case 1:
                    myDrawable = mContext.getResources().getDrawable(R.drawable.ic_action_two);
                    break;
                case 2:
                    myDrawable = mContext.getResources().getDrawable(R.drawable.ic_action_three);
                    break;
            }
            try {
                myDrawable.setBounds(1, 1, myDrawable.getIntrinsicWidth(),
                        myDrawable.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(myDrawable, DynamicDrawableSpan.ALIGN_BASELINE);
                sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } catch (Exception e) {

            }
            return sb;
        }
    }
}
