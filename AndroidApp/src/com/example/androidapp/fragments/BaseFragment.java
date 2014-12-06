package com.example.androidapp.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidapp.R;
import com.example.androidapp.activities.MainActivity;

public class BaseFragment extends Fragment{

	protected View action_bar_view;
	protected MainActivity PARENT_ACTIVITY;
	protected ProgressDialog progressDialog;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		//if (getActivity() instanceof BaseActivity) {
		if(getActivity() instanceof MainActivity)
			PARENT_ACTIVITY = (MainActivity) getActivity();
		//}
		progressDialog = new ProgressDialog(getActivity());
		action_bar_view = PARENT_ACTIVITY.getSupportActionBar().getCustomView();
	
	}
	
	
	
	public boolean onCustomOptionsItemSelected(View view) {


		return true;
	}
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		PARENT_ACTIVITY=null;
		super.onDetach();
	}
	

	
	public Context getApplicationContext()
	{
		
		return getActivity().getApplicationContext();
	}
	
	
	public void showProgressDialog(String title)
	{
		
		progressDialog.setMessage(title);
		progressDialog.setIndeterminate(false);
		progressDialog.setCancelable(false);
		progressDialog.show();
	}
	
	public void dismissProgressDialog()
	{
		progressDialog.dismiss();
	}
	
	public void display()
	{
		
	}
	
	public boolean onBackPressed() { return true;}
}
