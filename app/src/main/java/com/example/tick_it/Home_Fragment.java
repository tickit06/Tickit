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

    List<MovieItem> lstBook ;


public Home_Fragment(){}



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tab);

        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstBook = new ArrayList<>();
        lstBook.add(new MovieItem("The Vegitarian","Categorie Book","Description book",R.drawable.ic_checkered_flags_psd_icon));
        lstBook.add(new MovieItem("The Wild Robot","Categorie Book","Description book",R.drawable.ic_event_seat_black_24dp));
        lstBook.add(new MovieItem("Maria Semples","Categorie Book","Description book",R.drawable.ic_favorite_border_black_24dp));
        lstBook.add(new MovieItem("The Martian","Categorie Book","Description book",R.drawable.ic_local_movies_black_24dp));
        lstBook.add(new MovieItem("He Died with...","Categorie Book","Description book",R.drawable.ic_shopping_cart_black_24dp));
        lstBook.add(new MovieItem("The Vegitarian","Categorie Book","Description book",R.drawable.ic_favorite_border_black_24dp));

        RecyclerView myrv = (RecyclerView) getActivity().findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstBook);
        //myrv.setLayoutManager(new GridLayoutManager(this,2));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        myrv.setAdapter(myAdapter);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
    }
}
