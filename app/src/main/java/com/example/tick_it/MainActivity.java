package com.example.tick_it;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
TabLayout tabLayout;
ViewPager viewPager;
TabItem tabMovies, tabEvents, tabSports, tabPopularEvents;
Fragment selectedFragment = null;
    List<MovieItem> lstBook ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        TabLayout tabLayout = findViewById(R.id.tablayout);
        TabItem tabMovies = findViewById(R.id.TabMovies);
        TabItem tabEvents = findViewById(R.id.TabEvents);
        TabItem tabSports = findViewById(R.id.TabSports);
        TabItem tabPopularEvents = findViewById(R.id.TabPopularevents);
        ViewPager viewPager = findViewById(R.id.viewPager);

        PagerAdapter pageAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




        lstBook = new ArrayList<>();
        lstBook.add(new MovieItem("The Vegitarian","Categorie Book","Description book",R.drawable.ic_checkered_flags_psd_icon));
        lstBook.add(new MovieItem("The Wild Robot","Categorie Book","Description book",R.drawable.ic_favorite_border_black_24dp));
        lstBook.add(new MovieItem("Maria Semples","Categorie Book","Description book",R.drawable.ic_profile_black_24dp));
        lstBook.add(new MovieItem("The Martian","Categorie Book","Description book",R.drawable.ic_favorite_border_black_24dp));
        lstBook.add(new MovieItem("He Died with...","Categorie Book","Description book",R.drawable.ic_favorite_border_black_24dp));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//                if (tab.getPosition() == 1) {
//                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            R.color.colorAccent));
//                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            R.color.colorAccent));
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
//                                R.color.colorAccent));
//                    }
//                } else if (tab.getPosition() == 2) {
//                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            android.R.color.darker_gray));
//                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            android.R.color.darker_gray));
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
//                                android.R.color.darker_gray));
//                    }
//                } else {
//                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            R.color.colorPrimary));
//                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            R.color.colorPrimary));
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
//                                R.color.colorPrimaryDark));
//                    }
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });




        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Movies_Fragment()).commit();
    }
}

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override



                public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new Movies_Fragment();
                            break;
                        case R.id.nav_favorites:
                            selectedFragment = new Favourites_Fragment();
                            showTopLevelFragment(selectedFragment);
                            break;
                        case R.id.nav_cart:
                            selectedFragment = new Cart_Fragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new Profile_Fragment();
                            break;
                    }


                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

     public void showTopLevelFragment(Fragment fragment) {
        // Use the fragment manager to dynamically change the fragment displayed in the FrameLayout.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}