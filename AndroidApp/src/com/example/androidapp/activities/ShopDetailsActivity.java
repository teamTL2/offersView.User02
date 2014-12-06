package com.example.androidapp.activities;

import java.io.Serializable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidapp.R;
import com.example.androidapp.pojos.ShopPojo;

public class ShopDetailsActivity extends ActionBarActivity{

	private TextView textViewName, textViewStreet, textViewPhone, textViewZip, textViewRegion;
	private Button buttonoffers;
	private ShopPojo current;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop_details);
		
		getSupportActionBar().setTitle("Shop");
		textViewName = (TextView) findViewById(R.id.textview_name);
		textViewStreet = (TextView) findViewById(R.id.textview_street);
		textViewPhone = (TextView) findViewById(R.id.textview_phone);
		textViewZip = (TextView) findViewById(R.id.textview_zip);
		textViewRegion = (TextView) findViewById(R.id.textview_region);
		buttonoffers = (Button) findViewById(R.id.button_offers);
		
		current = (ShopPojo) getIntent().getExtras().get("shop");
		
		buttonoffers.setEnabled(current.getOffers().size()!=0);
		
		buttonoffers.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//create intent and declare which activity will open
				Intent intent = new Intent(getApplicationContext(),OffersActivity.class);
				//pass data to intent (data = oofers from shop which was clicked
				intent.putExtra("offers",(Serializable) current.getOffers());
				//open the new activity
				startActivity(intent);
				
			}
		});
		
		textViewName.setText(current.getName());
		textViewStreet.setText(current.getStreet());
		textViewRegion.setText(current.getRegion());
		textViewPhone.setText(current.getPhone());
		textViewZip.setText(current.getZipCode());
	}
	
}
