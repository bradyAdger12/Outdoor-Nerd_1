package edu.western.cs.outdoornerd;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.tasks.Task;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.western.cs.outdoornerd.globalVals.ConstUrl;
import edu.western.cs.outdoornerd.models.placeInfo;
import edu.western.cs.outdoornerd.util.NetworkUtil;
import edu.western.cs.outdoornerd.webservice.AddQueryAsyncTask;
import edu.western.cs.outdoornerd.webservice.HttpPostJson;

public class QueryActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleApiClient.OnConnectionFailedListener {

    public String response;
    public String triplet;
    public Toolbar toolbar;
    public Runnable nextAction;


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: map is ready");
        mMap = googleMap;

        if (mLocationPermissionGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.
                    checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            //GPS icon to drag back to current location set to false for search bar purposes
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);


            //Add Marker
            mMap.addMarker(new MarkerOptions().position(new LatLng(39.02, -107.5)).title("737:CO:SNTL"));
            mMap.addMarker(new MarkerOptions().position(new LatLng(38.89, -106.95)).title("380:CO:SNTL"));
            mMap.addMarker(new MarkerOptions().position(new LatLng(38.49, -106.34)).title("701:CO:SNTL"));
            mMap.addMarker(new MarkerOptions().position(new LatLng(38.7, -106.37)).title("1100:CO:SNTL"));
            mMap.addMarker(new MarkerOptions().position(new LatLng(38.82, -106.59)).title("680:CO:SNTL"));
            mMap.addMarker(new MarkerOptions().position(new LatLng(38.99, -106.75)).title("1141:CO:SNTL"));
            mMap.addMarker(new MarkerOptions().position(new LatLng(39.08, -107.14)).title("669:CO:SNTL"));
            mMap.addMarker(new MarkerOptions().position(new LatLng(39.13, -107.29)).title("618:CO:SNTL"));
            mMap.addMarker(new MarkerOptions().position(new LatLng(39.08, -106.61)).title("542:CO:SNTL"));
            //Marker Click Listener
            relativelayout = (RelativeLayout) findViewById(R.id.relative);

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    layoutinflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    //ViewGroup container = (ViewGroup) layoutinflater.inflate(R.layout.query_pop_up,null);


                    nextActivityButton.setVisibility(View.VISIBLE);

                    triplet = marker.getTitle();

                    Log.d("mMap", triplet);

                    //popupwindow = new PopupWindow(container, 600,1000,true);
                    //popupwindow.showAtLocation(relativelayout, Gravity.NO_GRAVITY,200,1000);


//                    container.setOnTouchListener(new View.OnTouchListener() {
//                       @Override
//                        public boolean onTouch(View v, MotionEvent event) {
//                            popupwindow.dismiss();
//                            return true;
//                        }
//                    });

                    System.out.println("Thats something");

                    return false;
                }
            });

            init();
        }
    }

    private static final String TAG = "query";

    private static final String FINE_LOCATION = android.Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = android.Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int locationPermissionRequestCode = 1234;
    private static final float default_zoom = 15;
    private static final LatLngBounds LAT_LNG_BOUNDS = new LatLngBounds(new LatLng(-40, -168), new LatLng(71,136) );

    //Widgets
    private AutoCompleteTextView mSearchText;
    private ImageView mGps;
    private ImageButton nextActivityButton;

    //variables
    private boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private PlaceAutocompleteAdapter mPlaceAutocompleteAdapter;
    private GoogleApiClient mGoogleApiClient;
    private placeInfo mPlace;
    private LayoutInflater layoutinflater;
    private RelativeLayout relativelayout;
    private PopupWindow popupwindow;


    //Locations
    //Marker Gunnison = mMap.addMarker(new MarkerOptions()
    //      .position(new LatLng(38.5458, 106.9253))
    //    .title("Gunnison"));



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        getLocationPermission();
        mSearchText = (AutoCompleteTextView) findViewById(R.id.inputSearch);
        mGps = (ImageView) findViewById(R.id.ic_gps);


        //Next Activity Button
        nextActivityButton = (ImageButton) findViewById(R.id.nextActivityButton);

        nextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(QueryActivity.this, "Loading...", Toast.LENGTH_SHORT).show();

                AddQueryAsyncTask addQueryAsyncTask = new AddQueryAsyncTask(triplet);
                addQueryAsyncTask.execute();
                Runnable nextAction;
                nextAction=new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(QueryActivity.this, ResultActivity.class);
                        intent.putExtra("triplet", triplet);
                        startActivity(intent);
                    }
                };

                //delay
                new Handler().postDelayed(nextAction,2000 ); //delaying 1.5 seconds in UI





            }


        });


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private void init (){
        Log.d(TAG, "init: initializing");

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();

        mSearchText.setOnItemClickListener(mAutocompleteClickListener);

        mPlaceAutocompleteAdapter = new PlaceAutocompleteAdapter(this,
                Places.getGeoDataClient(this, null),
                LAT_LNG_BOUNDS,
                null);

        mSearchText.setAdapter(mPlaceAutocompleteAdapter);
        mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER){

                    //Execute method for searching
                    geoLocate();

                }
                return false;
            }
        });
        mGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked gps icon");
                getDeviceLocation();
            }
        });
        hideKeyboard();
    }

    private void geoLocate(){
        Log.d(TAG, "geoLocate: geoLocation");
        String searchString = mSearchText.getText().toString();
        Geocoder geocoder = new Geocoder(QueryActivity.this);
        List<Address> list = new ArrayList<>();
        try{
            list = geocoder.getFromLocationName(searchString, 1);
        }catch(IOException e){
            Log.e(TAG, "geoLocate: IOException: " + e.getMessage());

        }
        if (list.size() > 0){
            Address address = list.get(0);
            Log.d(TAG, "geoLocate: found a location" + address.toString());
            //Toast.makeText(this, address.toString(), Toast.LENGTH_SHORT).show();

            //This moves camera to address typed in search bar
            moveCamera(new LatLng(address.getLatitude(), address.getLongitude()),default_zoom, address.getAddressLine(0));
        }

    }

    private void getDeviceLocation(){
        Log.d(TAG, "getDeviceLocation: getting device location" );
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if(mLocationPermissionGranted){
                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful() && task.getResult() != null){
                            Log.d(TAG, "Found Location");
                            Location currentLocation = (Location) task.getResult();


                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                    default_zoom, "My Location");

                        }else{
                            Log.d(TAG, "getDeviceLocation failed");
                            Toast.makeText(QueryActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation: Security Exception: " + e.getMessage());
        }


    }


    private void moveCamera(LatLng latLng, float zoom, String title){
        Log.d(TAG, "moveCamera: Moving the camera to lat: " + latLng.latitude + ", lng: " + latLng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));

        /*if (!title.equals("My Location")){
            MarkerOptions options = new MarkerOptions().position(latLng).title(title);
            mMap.addMarker(options);
        }*/

        hideKeyboard();



    }





    private void initMap(){
        Log.d(TAG, "initMap: Initializing Map");
        SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(QueryActivity.this);
    }
    private void getLocationPermission(){
        Log.d(TAG,"getLocationPermission: Getting location permission");
        String[] permissions = {android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;
                initMap();
            }else {
                ActivityCompat.requestPermissions(this, permissions, locationPermissionRequestCode);

            }
        }else{
            ActivityCompat.requestPermissions(this, permissions, locationPermissionRequestCode);


        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionResult: called");
        //no need for the super
        mLocationPermissionGranted = false;

        switch(requestCode){
            case locationPermissionRequestCode:{
                if(grantResults.length > 0){
                    for(int i = 0; i<grantResults.length; i++){
                        if(grantResults[i]!= getPackageManager().PERMISSION_GRANTED){
                            mLocationPermissionGranted = false;
                            Log.d(TAG, "onRequestPermissiolnResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionResult: permission granted");
                    mLocationPermissionGranted= true;
                    //init our map
                    initMap();

                }
            }
        }
    }

    private void hideKeyboard(){
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /*
    ------------------------------------------------
     */

    private AdapterView.OnItemClickListener mAutocompleteClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            hideKeyboard();

            final AutocompletePrediction item = mPlaceAutocompleteAdapter.getItem(i);
            final String placeId =  item.getPlaceId();

            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi.getPlaceById(mGoogleApiClient, placeId);

            placeResult.setResultCallback(mUpdatePlaceDetailsCallback);


        }
    };

    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(@NonNull PlaceBuffer places) {
            if (!places.getStatus().isSuccess()){
                Log.d(TAG, "onResult: Place query did not comp;ete successfully" + places.getStatus().toString());
                places.release();
                return;
            }
            final Place place = places.get(0);

            try {
                mPlace = new placeInfo();
                mPlace.setName(place.getName().toString());
                mPlace.setAddress(place.getAddress().toString());
                mPlace.setAttributions(place.getAttributions().toString());
                mPlace.setId(place.getId());
                mPlace.setLatlng(place.getLatLng());
                mPlace.setRating(place.getRating());
                mPlace.setPhoneNumber(place.getPhoneNumber().toString());
                Log.d(TAG, "onResult: place details: " + mPlace.toString());
            }catch(NullPointerException e) {
                Log.e(TAG, "onResult: NullPointerException: " + e.getMessage());
            }
            moveCamera(new LatLng(place.getViewport().getCenter().latitude,
                    place.getViewport().getCenter().longitude), default_zoom, mPlace.getAddress()); //Couldnt get getName to work


        }
    };


}