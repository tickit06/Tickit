package com.example.tick_it;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Fragment_Adapter extends ViewPagerAdapter {
    Context ctxt=null;

    public Fragment_Adapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
        this.ctxt=ctxt;
    }



    @Override
    public int getCount() {
        return(10);
    }

   // @Override
//    public Fragment getItem(int position) {
//        return(Home_Fragment.newInstance(position));
//    }
//
//    @Override
//    public String getPageTitle(int position) {
//        return(EditorFragment.getTitle(ctxt, position));
//    }
}