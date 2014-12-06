package com.example.androidapp.fragments;

import java.util.ArrayList;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.androidapp.R;
import com.example.androidapp.activities.ShopDetailsActivity;
import com.example.androidapp.adapters.ShopsAdapter;
import com.example.androidapp.pojos.OfferPojo;
import com.example.androidapp.pojos.ShopPojo;

public class ShopFragment extends BaseFragment{

	private ListView listview;
	private ArrayList<ShopPojo> adapterItems;
	private ShopsAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_shop, container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		listview = (ListView) getView().findViewById(R.id.listview_shop);
		//when a shop was clicked
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//create intent and declare which activity will open
				Intent intent = new Intent(getApplicationContext(),ShopDetailsActivity.class);
				//pass data to intent (data = shop which was clicked
				intent.putExtra("shop", adapterItems.get(position));
				//open the new activity
				startActivity(intent);
			
			}
		});
		
	}
	
	private class LoadShops extends AsyncTask<String, Void, ArrayList<ShopPojo>> {

		@Override
        protected void onPreExecute() {
        
//			showProgressDialog("Downloading Shops...");
        }
		
        @Override
        protected ArrayList<ShopPojo> doInBackground(String... params) {
        	ArrayList<ShopPojo> items = new ArrayList<ShopPojo>();
        	
        		for(int i = 0;i<45;i++)
        		{
        			ShopPojo item = new ShopPojo();
        			item.setName("Shop "+i);
        			item.setStreet("King Street "+i);
        			item.setZipCode("57001");
        			item.setPhone("6999999999");
        			item.setRegion("Serres");
        			item.setLatitude(40.576454+(0.000010*i));
        			item.setLongitude(22.994972+(0.000010*i));
        			
        			for(int k=0;k<i;k++)
        			{
        				item.addOffer(new OfferPojo("offer "+k,"-0."+k));
        			}
        			
        			items.add(item);
        		}
        	
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
                
            return items;
        }

        @Override
        protected void onPostExecute(ArrayList<ShopPojo> result) {
//        	dismissProgressDialog();
        	if(isVisible())
        	{
	        	adapterItems = result;
	        	adapter = new ShopsAdapter(getApplicationContext(), adapterItems);
	        	listview.setAdapter(adapter);
	        	getView().findViewById(R.id.progressBar).setVisibility(View.GONE);
        	}
        }

    }
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		Log.e("","ShopFragment");
		
		if(PARENT_ACTIVITY.shops==null)
		{
			new LoadShops().execute();
		}
		else
		{
			if(isVisible())
        	{
	        	adapterItems = PARENT_ACTIVITY.shops;
	        	adapter = new ShopsAdapter(getApplicationContext(), adapterItems);
	        	listview.setAdapter(adapter);
	        	getView().findViewById(R.id.progressBar).setVisibility(View.GONE);
        	}
		}
		super.display();
	}
}
