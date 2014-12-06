package com.example.androidapp.adapters;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.androidapp.fragments.BaseFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

	ArrayList<BaseFragment> listFragments;

	public MyPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> listFragments) {
		super(fm);
		this.listFragments = listFragments;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "";
	}

	@Override
	public int getCount() {
		return listFragments.size();
	}

	@Override
	public Fragment getItem(int position) {
		
		return listFragments.get(position);
	}
	
	public void display(int position)
	{
		listFragments.get(position).display();
	}
	
}
