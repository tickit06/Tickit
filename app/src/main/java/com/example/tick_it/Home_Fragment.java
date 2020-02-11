package com.example.tick_it;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabMovies, tabEvents, tabSports, tabPopularEvents;
    Fragment selectedFragment = null;

    List<MovieItem> lstBook;


    public Home_Fragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        viewPager = (ViewPager) view.findViewById(R.id.pager);
//        tabLayout = (TabLayout) view.findViewById(R.id.tab);

        return view;


    }

}