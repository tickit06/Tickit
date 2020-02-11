package com.example.tick_it;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
TabLayout tabLayout;
ViewPager viewPager;
TabItem tabMovies, tabEvents, tabSports, tabPopularEvents;
Fragment selectedFragment = null;
    List<MovieItem> lstBook ;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl= (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();

        NavigationView nav_view1 = (NavigationView)findViewById(R.id.nav_view);
        nav_view1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                int id = item.getItemId();
                if (id == R.id.Events){
                    fragment = new Events_Fragment();
                    loadFragment(fragment);
                    return true;
//                    Intent i = new Intent(MainActivity.this, Events_Fragment.class);
//                    startActivity(i);
                } else if(id == R.id.Sports){
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    Intent i = new Intent(MainActivity.this,Sports_Fragment.class);
                    startActivity(i);
                }
                else if(id == R.id.PopularEvents){
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    Intent i = new Intent(MainActivity.this,PopularEvents_Fragment.class);
                    startActivity(i);
                }

                else if(id == R.id.Logout){
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    Intent i = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(i);
                }

                return false;
            }

        });

       // toolbar.setTitle(getResources().getString(R.string.app_name));
//       // TabLayout tabLayout = findViewById(R.id.tablayout);
//        TabItem tabMovies = findViewById(R.id.TabMovies);
//        TabItem tabEvents = findViewById(R.id.TabEvents);
//        TabItem tabSports = findViewById(R.id.TabSports);
//        TabItem tabPopularEvents = findViewById(R.id.TabPopularevents);
//        ViewPager viewPager = findViewById(R.id.viewPager);

//        PagerAdapter pageAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
 //       viewPager.setAdapter(pageAdapter);


   //     viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




        lstBook = new ArrayList<>();
        lstBook.add(new MovieItem("Dolittle","Categorie Movie","Description book",R.drawable.aladin));
        lstBook.add(new MovieItem("Little Mermaid","Categorie Movie","Description book",R.drawable.mermaid));
        lstBook.add(new MovieItem("Jumanji","Categorie Movie","Description book",R.drawable.jumanji));
        lstBook.add(new MovieItem("Aladin","Categorie Movie","Description book",R.drawable.aladin));
        lstBook.add(new MovieItem("The Kid King","Categorie Movie","Description book",R.drawable.kidking));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recycler_main);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);



        myrv.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                int action = e.getAction();
                switch (action) {
                    case MotionEvent.ACTION_MOVE:
                        rv.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

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
//                } else if (tab.getPosition() == 3) {
//                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            R.color.green));
//                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            R.color.green));
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
//                                R.color.green));
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



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            int id = item.getItemId();
            if (id == R.id.Events){
                fragment = new Events_Fragment();
                loadFragment(fragment);
                return true;
//                    Intent i = new Intent(MainActivity.this, Events_Fragment.class);
//                    startActivity(i);
            } else if(id == R.id.Sports){
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent i = new Intent(MainActivity.this,Sports_Fragment.class);
                startActivity(i);
            }
            else if(id == R.id.PopularEvents){
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent i = new Intent(MainActivity.this,PopularEvents_Fragment.class);
                startActivity(i);
            }

            else if(id == R.id.Logout){
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }

            return false;
        }
    };



    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
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




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);





    }





}