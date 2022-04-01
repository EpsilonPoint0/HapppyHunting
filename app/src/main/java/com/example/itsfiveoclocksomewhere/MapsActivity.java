package com.example.itsfiveoclocksomewhere;

import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.itsfiveoclocksomewhere.databinding.ActivityMapsBinding;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.android.rides.RideParameters;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.android.rides.RideRequestButtonCallback;
import com.uber.sdk.rides.client.SessionConfiguration;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;
import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.error.ApiError;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    public AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        RideParameters rideParams = new RideParameters.Builder()
                .setPickupLocation(37.775304, -122.417522, "Uber HQ", "1455 Market Street, San Francisco")
                .setDropoffLocation(37.795079, -122.4397805, "Embarcadero", "One Embarcadero Center, San Francisco") // Price estimate will only be provided if this is provided.
                .setProductId("a1111c8c-c720-46c3-8534-2fcdd730040d") // Optional. If not provided, the cheapest product will be used.
                .build();

        SessionConfiguration config = new SessionConfiguration.Builder()
                // mandatory
                .setClientId("BnSwQyE-8yfhamo56VmTNDVjPXNUVIPb")
                // required for enhanced button features
                .setServerToken("<TOKEN>")
                // required for implicit grant authentication
                .setRedirectUri("<REDIRECT_URI>")
                // optional: set sandbox as operating environment
                .setEnvironment(SessionConfiguration.Environment.SANDBOX)
                .build();
        UberSdk.initialize(config);
        RideRequestButton requestButton = findViewById(R.id.currentLoc);

        ServerTokenSession session = new ServerTokenSession(config);
        RideRequestButtonCallback callback = new RideRequestButtonCallback() {

            @Override
            public void onRideInformationLoaded() {

            }

            @Override
            public void onError(ApiError apiError) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        };

        requestButton.setRideParameters(rideParams);
        requestButton.setSession(session);
        requestButton.setCallback(callback);
        requestButton.loadRideInformation();

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "OurDB").allowMainThreadQueries().build();


        Timber.d("Map activity onCreate");
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return p1;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng columbus = new LatLng(40.005095,-83.027703);

        LatLng columbus = getLocationFromAddress(MapsActivity.this, "111 W Northwood Ave Columbus Ohio");

        List<Bar> barList = db.barDao().getAllBars();
        List<Marker> markers= new ArrayList<Marker>();
        for (int i = 0; i < barList.size(); i++) {
            LatLng mark = getLocationFromAddress(MapsActivity.this, barList.get(i).address);
            markers.add(mMap.addMarker(new MarkerOptions().position(mark).title(barList.get(i).name)));
        }
        markers.add(mMap.addMarker(new MarkerOptions().position(columbus).title("Marker in Columbus")));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : markers) {
            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();
        int padding = 0; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        googleMap.animateCamera(cu);
        Timber.d("Map activity onStart");
    }
}