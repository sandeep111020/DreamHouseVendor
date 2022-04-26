package com.example.dreamhousevendor.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dreamhousevendor.Fragments.MaterialFragment;
import com.example.dreamhousevendor.Fragments.PaymentsFragment;
import com.example.dreamhousevendor.Fragments.PhotoFragment;
import com.example.dreamhousevendor.Fragments.TaskFragment;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MaterialFragment materialFragment = new MaterialFragment();
                return materialFragment;
            case 1:
                PaymentsFragment paymentsFragment = new PaymentsFragment();
                return paymentsFragment;
            case 2:
                TaskFragment taskFragment = new TaskFragment();
                return taskFragment;


            case 3:
                PhotoFragment photoFragment = new PhotoFragment();
                return photoFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
