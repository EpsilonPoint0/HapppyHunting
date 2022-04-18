package com.example.itsfiveoclocksomewhere;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsfiveoclocksomewhere.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.uber.sdk.android.core.UberButton;
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
    private AppDatabase db;
    private List<Special> specialList;
    private List<Special> specials;
    private List<Bar> bars;
    TextView textView;


    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        // These are both viewgroups containing an ImageView with id "badge" and two TextViews with id
        // "title" and "snippet".
        private Activity context;

        public CustomInfoWindowAdapter(Activity context) {
            this.context = context;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            View view = context.getLayoutInflater().inflate(R.layout.map_marker, null);

            TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
            TextView tvSubTitle = (TextView) view.findViewById(R.id.tv_subtitle);

            tvTitle.setText(marker.getTitle());
            tvSubTitle.setText(marker.getSnippet());

            return view;
        }
    }


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
        UberButton button = (UberButton) requestButton.getChildAt(0);
        button.setText(getString((R.string.Uber)));
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



        /*ApiConfig apiConfig = new ApiConfig.Builder()
                .setClientId("your_client_id")
                .setClientToken("your_client_token")
                .build();

        LyftButton lyftButton = (LyftButton) findViewById(R.id.lyft_button);
        lyftButton.setApiConfig(apiConfig);

        RideParams.Builder rideParamsBuilder = new RideParams.Builder()
                .setPickupLocation(37.7766048, -122.3943629)
                .setDropoffLocation(37.759234, -122.4135125);
        rideParamsBuilder.setRideTypeEnum(RideTypeEnum.STANDARD);

        lyftButton.setRideParams(rideParamsBuilder.build());
        lyftButton.load();*/

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "OurDB").allowMainThreadQueries().build();

        specials = DBMethods.populateSpecials(db.specialDao());
        bars = DBMethods.populateBar(db.barDao());

        Timber.d("Map activity onCreate");

        requestPermissions();

    }

    private void requestPermissions() {
        // below line is use to request
        // permission in the current activity.
        Dexter.withContext(this)
                // below line is use to request the number of
                // permissions which are required in our app.
                .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,
                        // below is the list of permissions
                        Manifest.permission.ACCESS_FINE_LOCATION
                        )
                // after adding permissions we are
                // calling an with listener method.
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        Toast.makeText(MapsActivity.this, getString(R.string.permissions), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {

                    }
                })
                .withErrorListener(new PermissionRequestErrorListener() {
            // this method is use to handle error
            // in runtime permissions
            @Override
            public void onError(DexterError error) {
                // we are displaying a toast message for error message.
                Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        })
                // below line is use to run the permissions
                // on same thread and to check the permissions
                .onSameThread().check();
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

    private LatLngBounds createBounds(){

        LatLng columbus = DBMethods.getLocationFromAddress(MapsActivity.this, "111 W Northwood Ave Columbus Ohio");
        List<Bar> barList = db.barDao().getAllBars();
        System.out.println(barList);
        specialList = db.specialDao().getAllSpecials();
        List<Marker> markers = new ArrayList<Marker>();
        for (int i = 0; i < barList.size(); i++) {
            String snippet = getString(R.string.special) + specialList.get(i).specialInfo + "\n"+getString(R.string.start) + specialList.get(i).startTime + "\n"+getString(R.string.end) + specialList.get(i).endTime;
            LatLng mark = DBMethods.getLocationFromAddress(MapsActivity.this, barList.get(i).address);
            //String snippet = getString(R.string.special) + specials.get(i).specialInfo + "\n"+getString(R.string.start) + specials.get(i).startTime + "\n"+getString(R.string.end) + specials.get(i).endTime;
            //LatLng mark = DBMethods.getLocationFromAddress(MapsActivity.this, barList.get(i).address);
            markers.add(mMap.addMarker(new MarkerOptions().position(mark).title(barList.get(i).name).snippet(snippet)));
        }
        markers.add(mMap.addMarker(new MarkerOptions().position(columbus).title("Marker in Columbus")));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : markers) {
            builder.include(marker.getPosition());

        }

        LatLngBounds bounds = builder.build();

        return bounds;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);


        // Add a marker in Sydney and move the camera
        //LatLng columbus = new LatLng(40.005095,-83.027703);

        /*LatLng columbus = DBMethods.getLocationFromAddress(MapsActivity.this, "111 W Northwood Ave Columbus Ohio");

        List<Bar> barList = db.barDao().getAllBars();
        System.out.println(barList);
        specialList = db.specialDao().getAllSpecials();
        List<Marker> markers = new ArrayList<Marker>();
        for (int i = 0; i < barList.size(); i++) {
            String snippet = getString(R.string.special) + specialList.get(i).specialInfo + "\n"+getString(R.string.start) + specialList.get(i).startTime + "\n"+getString(R.string.end) + specialList.get(i).endTime;
            LatLng mark = DBMethods.getLocationFromAddress(MapsActivity.this, barList.get(i).address);
            markers.add(mMap.addMarker(new MarkerOptions().position(mark).title(barList.get(i).name).snippet(snippet)));
        }
        markers.add(mMap.addMarker(new MarkerOptions().position(columbus).title("Marker in Columbus")));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : markers) {
            builder.include(marker.getPosition());

        }
        LatLngBounds bounds = builder.build();*/
        LatLngBounds bounds = createBounds();

        int padding = 0; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker m) {

                if(m.isInfoWindowShown()){
                    ((TextView) findViewById(R.id.textViewLink)).setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) findViewById(R.id.textViewLink)).setText(Html.fromHtml(getResources().getString(R.string.messagewithlink)));
                }
                System.out.println("marker clicked");
                return false;
            }

        });
        googleMap.animateCamera(cu);

        mMap.setMyLocationEnabled(true);
        //mMap.setOnMyLocationButtonClickListener(this);
        //mMap.setOnMyLocationClickListener(this);
        Timber.d("Map activity onStart");
    }
}