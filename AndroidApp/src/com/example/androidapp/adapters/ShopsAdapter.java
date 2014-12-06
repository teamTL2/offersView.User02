package com.example.androidapp.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidapp.R;
import com.example.androidapp.pojos.ShopPojo;

public class ShopsAdapter extends ArrayAdapter<ShopPojo> {

	private Context context;
	ArrayList<ShopPojo> items;
	
	public ShopsAdapter(Context context,ArrayList<ShopPojo> items) {
		super(context, 0,0,items);
		this.context = context;
		this.items = items;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public int getItemViewType(int position) {
		
		return 	0;
	}

	@Override
	public int getCount() {

		return items.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ShopPojo item = items.get(position);
		convertView = View.inflate(context, R.layout.listview_shop, null);
		TextView textview1 = (TextView) convertView.findViewById(R.id.textview_name);
		textview1.setText(item.getName());
		
		return convertView;
	}
	
}
