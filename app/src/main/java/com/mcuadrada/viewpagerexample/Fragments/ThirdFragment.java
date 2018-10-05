package com.mcuadrada.viewpagerexample.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mcuadrada.viewpagerexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    private String title;
    private int page;

    public static ThirdFragment newInstance(int page, String title) {
        ThirdFragment thirdFragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        thirdFragment.setArguments(args);
        return thirdFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        return view;
    }

}
