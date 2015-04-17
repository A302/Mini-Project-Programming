package com.yourdomain.physicalsnakegame;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class GameActivity extends MenuActivity
        implements OnMapReadyCallback{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

 /*
        The code below implements the map fragment from the related xml file and makes google map appear on the screen.*/
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
/*
    The method "onMapReady" initiates when google map has succesfully loaded on to the screen.
    */
    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-33.867, 151.206); /* Create a point called "sydney" using longitude and latitudes */
        map.setMyLocationEnabled(true);/* Connects the devices GPS */
        /* the code below set up where on the map the view is and how much it should zoom when google maps starts */
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
        map.animateCamera(CameraUpdateFactory.zoomIn());
        map.animateCamera(CameraUpdateFactory.zoomTo(20), 2000, null);

/* Creates a marker taking position from the point "sydney" */
        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }

     /*  PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(57.055454, 9.905867))
                .add(new LatLng(58.055454, 9.905867))
                .add(new LatLng(58.055454, 10.905867))
                .add(new LatLng(57.055454, 10.905867))
                .add(new LatLng(57.055454, 9.905867));

        Polyline polyline = myMap.addPolyline(rectOptions);*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


