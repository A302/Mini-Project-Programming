package com.yourdomain.physicalsnakegame;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;


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
        map.setMyLocationEnabled(true);/* Connects the devices GPS */
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(57.055993, 9.903725), 20));
        // Polylines are useful for marking paths and routes on the map.
        map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(57.055800, 9.903500))
                        .add(new LatLng(57.055800, 9.903950))
                        .add(new LatLng(57.056186, 9.903950))
                        .add(new LatLng(57.056186, 9.903500))
                        .add(new LatLng(57.055800, 9.903500))
        );


    }
/* Creates a marker taking position from the point "sydney" */
        /*map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }*/



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


