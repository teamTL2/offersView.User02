package com.example.androidapp.activities;

import com.example.androidapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//Οθόνη splash screen
public class SplashActivity extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
	
		//παράλληλο νήμα για να κατεβάσουμε δεδομένα (αν χρειάζονται)
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//Για να μην κλείσει γρήγορα η ιθόνη βάζουμε μία καθυστερηση
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Ανοίγουμε την οθονη συνδεσης
				//και σβήνουμε την παρών οθόνη
				Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
				startActivity(intent);
				finish();
			}
		}).start();
	
	}

}
