package com.example.androidapp.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

import com.example.androidapp.R;


//Οθονη συνδεσης
public class LoginActivity extends Activity{
	
	private EditText email,password;
	private Button button;
	private ProgressDialog pDialog;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		email = (EditText) findViewById(R.id.login_email);
		password = (EditText) findViewById(R.id.login_edit_password);
		pDialog = new ProgressDialog(LoginActivity.this);
		password.setOnEditorActionListener(new OnEditorActionListener() {
		    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		        if (actionId == EditorInfo.IME_ACTION_GO) {
		        	button.performClick();
		            return true;
		        }
		        return false;
		    }
		});
		
		button = (Button) findViewById(R.id.btnLogin);
		
		
		
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (!email.getText().toString().equals("") && !password.getText().toString().equals("")) {
					
					new LoginOperation(email.getText().toString(),password.getText().toString()).execute();
					
					/*List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("security_code",
							MobileApplication.SECURITY_CODE));
					params.add(new BasicNameValuePair("Username", username.getText().toString()));
					params.add(new BasicNameValuePair("Password", password.getText().toString()));
					Bundle data=new Bundle();
					data.putSerializable(LoaderService.WITH_PARAMS, (Serializable)params);
					*/
					
					
				}

			}
		});
	
	}
	
	//Διαδικασία αυθεντικοποίησης
	//Χρησιμοποιούμε dummy data μεχρι να ολοκληρωθή το backend
	//username:test password:test
	private class LoginOperation extends AsyncTask<String, Void, Boolean> {

		String email,passwd;
		
		public LoginOperation(String email,String passwd)
		{
			this.email = email;
			this.passwd = passwd;
		}
		
		@Override
        protected void onPreExecute() {
        	pDialog.setMessage("Γίνετε ο έλεγχος των στοιχείων...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
        }
		
        @Override
        protected Boolean doInBackground(String... params) {
           
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
                
           //ελεγχουμε αμα τα στοιχεια του χρηστη είναι σωστα
            return (email.equalsIgnoreCase("test@test.com")) && (passwd.equalsIgnoreCase("test"));
        }

        @Override
        protected void onPostExecute(Boolean result) {
        	pDialog.dismiss();
        	//ελεγχος αυθεντικοποιησης
        	if(result)
        	{
        		Toast.makeText(getApplicationContext(), "Καλώς ήρθατε", Toast.LENGTH_SHORT).show();
        		
        		Intent intetn = new Intent(getApplicationContext(),MainActivity.class);
        		
        		startActivity(intetn);
        		finish();
        	}
        	else
        		Toast.makeText(getApplicationContext(), "Τα στοιχεία είναι λάθος", Toast.LENGTH_SHORT).show();
        }

    }

}
