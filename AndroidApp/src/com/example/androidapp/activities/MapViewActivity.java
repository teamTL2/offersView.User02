package com.example.androidapp.activities;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.androidapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//οθόνη χάρτη
public class MapViewActivity extends ActionBarActivity implements LocationListener {

	private GoogleMap map;
	private LocationManager locationManager;
	private SupportMapFragment mapFragment;
	private Marker myLocation;
	private boolean firstLaunch;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_view);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("");

		mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		map = mapFragment.getMap();
		// Φόρτωση χάρτη που δείχνει δρόμους
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		locationManager = (LocationManager) getSystemService(getApplicationContext().LOCATION_SERVICE);
		// Τελευταία τοποθεσία απο το GPS αν υπάρχει
		// Location location =
		// locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		// Τελευταία τοποθεσία απο το NETWORK αν υπάρχει
		// Location location2 =
		// locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

		// GPS is ON?
		boolean enabledGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		// NETWORK PROVIDER is ON?
		boolean enabledNetwork = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

		if (!enabledGPS && !enabledNetwork) {
			Toast.makeText(getApplicationContext(), "Ανοίξτε τις ρυθμίσεις και ενεργοποιήστε κάποιον provider", Toast.LENGTH_LONG).show();
		}

		map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.465401, 22.804357), 6));

	}

	@Override
	protected void onResume() {
		// GPS is ON?
		boolean enabledGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		// NETWORK PROVIDER is ON?
		boolean enabledNetwork = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

		if (enabledGPS) {

			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 500, this);
		}

		if (enabledNetwork) {

			locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60000, 500, this);
		}

		super.onResume();
	}

	private boolean onlyOneTime = true;

	@Override
	public void onLocationChanged(Location location) {
		Log.e("","find "+location.getProvider());
		if (myLocation != null) {
			myLocation.remove();
		}
		myLocation = map.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Βρίσκεστε εδώ"));
		if (onlyOneTime) {
			map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 15));
			onlyOneTime = false;
		
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
