package com.sentisafe.testapp;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

    public void onSearch(View view){
        EditText location_tf = (EditText)findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        String markerTitle = null;
        List<Address> addressList = null;
        if(location != null || !location.equals("")){
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location,1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
            //final List<String> dataList = new ArrayList<String>();
            mMap.clear();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            /*DatabaseReference myRef = database.getReference("safe");

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    String Value= dataSnapshot.getValue(String.class);
                   Iterable<DataSnapshot> children=dataSnapshot.getChildren();
                    for(DataSnapshot child :children){
                        String value = child.getValue(String.class);

                    }
                    dataList.add(Value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });*/
           // myRef.child("safe").orderByChild("Place");
           // String locationName = myRef.

            if(address.getFeatureName().equals("Kondapur")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("Safe").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            }else if(address.getFeatureName().equals("Secunderabad")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("unsafe").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }else if(address.getFeatureName().equals("Kompally")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("unsafe").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }else if(address.getFeatureName().equals("Raidurgam")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("unsafe").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }else if(address.getFeatureName().equals("Charminar")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("unsafe").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }else if(address.getFeatureName().equals("Kukatpally")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("good").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            }else if(address.getFeatureName().equals("Balanagar")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("unsafe").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }else if(address.getFeatureName().equals("Gachibowli")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("good").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            }else if(address.getFeatureName().equals("Uppal")){
                mMap.addMarker(new MarkerOptions().position(latLng).title("unsafe").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }else {
                 mMap.addMarker(new MarkerOptions().position(latLng).title("Safe").
                  icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            }
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
           // mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
      //  LatLng sydney = new LatLng(-34, 151);
       // mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("Marker"));
       // mMap.setMyLocationEnabled(true);
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //mMap.clear();
    }
}
