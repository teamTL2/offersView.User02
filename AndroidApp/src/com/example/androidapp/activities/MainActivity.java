package com.example.androidapp.activities;

import java.util.ArrayList;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.example.androidapp.R;
import com.example.androidapp.adapters.MyPagerAdapter;
import com.example.androidapp.fragments.BaseFragment;
import com.example.androidapp.fragments.FavoritesFragment;
import com.example.androidapp.fragments.GpsFragment;
import com.example.androidapp.fragments.HistoryFragment;
import com.example.androidapp.fragments.ShopFragment;
import com.example.androidapp.pojos.ShopPojo;
import com.example.androidapp.widget.PagerSlidingTabStrip;

public class MainActivity extends ActionBarActivity{
	
	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private MyPagerAdapter adapter;
	public ArrayList<ShopPojo> shops;
	public Location currentLocation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		ActionBar actionbar = getSupportActionBar();
		actionbar.setTitle("OffersView");
		
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.viewPager);
		
		ArrayList<BaseFragment> list = new ArrayList<BaseFragment>();
		
		list.add(new GpsFragment());
		list.add(new ShopFragment());
		list.add(new FavoritesFragment());
		list.add(new HistoryFragment());
		
		pager = (ViewPager) findViewById(R.id.viewPager);
		adapter = new MyPagerAdapter(getSupportFragmentManager(), list);
		
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);
		tabs.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				adapter.display(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		adapter.display(0);
		
	}

}
