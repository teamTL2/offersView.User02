package com.example.androidapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidapp.R;

public class FavoritesFragment extends BaseFragment{

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_favorites, container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		Log.e("","FavoritesFragment");
		super.display();
	}
}
