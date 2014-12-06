package com.example.androidapp.activities;

import java.util.ArrayList;

import com.example.androidapp.R;
import com.example.androidapp.adapters.OffersAdapter;
import com.example.androidapp.pojos.OfferPojo;
import com.example.androidapp.pojos.ShopPojo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.TextView;

public class OffersActivity extends ActionBarActivity{

	private ArrayList<OfferPojo> offers;
	private ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offers);
		
		getSupportActionBar().setTitle("Offers");
		
		offers = (ArrayList<OfferPojo>) getIntent().getExtras().get("offers");
		listview =  (ListView) findViewById(R.id.listview_offers);

		OffersAdapter adapter = new OffersAdapter(getApplicationContext(), offers);
		listview.setAdapter(adapter);
		
	}
	
}
