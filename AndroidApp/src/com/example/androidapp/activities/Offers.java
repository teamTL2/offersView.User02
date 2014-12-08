package com.example.androidapp.activities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Offers extends Activity {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offers_tmp);

		lv = (ListView) findViewById(R.id.listView1);
		new task().execute();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.offers, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class task extends AsyncTask<String, String, Void>
	{

		InputStream is = null ;
		String result = "";
		@Override
		protected Void doInBackground(String... params) {
			String url_select = "http://prekreich.byethost5.com/demo.php";

			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url_select);

			ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();

			try {
				httpPost.setEntity(new UrlEncodedFormEntity(param));

				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();

				//read content
				is =  httpEntity.getContent();					

			} catch (Exception e) {

				Log.e("log_tag", "Error in http connection "+e.toString());
				//Toast.makeText(MainActivity.this, "Please Try Again", Toast.LENGTH_LONG).show();
			}
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				StringBuilder sb = new StringBuilder();
				String line = "";
				while((line=br.readLine())!=null)
				{
					sb.append(line+"\n");
				}
				is.close();
				result=sb.toString();
				Log.e("log_tag", sb.toString());

			} catch (Exception e) {
				// TODO: handle exception
				Log.e("log_tag", "Error converting result "+e.toString());
			}

			return null;

		}
		@SuppressLint("NewApi")
		protected void onPostExecute(Void v) {

			//Log.v("result",result);

			try {
				List<String> offersList = new ArrayList();
				JSONArray Jarray = new JSONArray(result);
				for(int i=0;i<Jarray.length();i++)
				{
					JSONObject Jasonobject = null;
					//text_1 = (TextView)findViewById(R.id.txt1);
					Jasonobject = Jarray.getJSONObject(i);

					//get an output on the screen
					String name = Jasonobject.getString("name");
					//Log.e("log_tag", name);
					offersList.add(name);
				}
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(Offers.this, R.layout.list_view, R.id.textView2, offersList);
				adapter.notifyDataSetChanged();
	            lv.setAdapter(adapter);

				//Log.e("list", offersList.toString());
			} catch (Exception e) {
				// TODO: handle exception
				Log.e("log_tag", "Error parsing data "+e.toString());
			}
		}
	}
}






