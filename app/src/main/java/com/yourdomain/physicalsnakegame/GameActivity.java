package com.yourdomain.physicalsnakegame;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;


public class GameActivity extends MenuActivity

        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /*The code below implements the map fragment from the related xml file and makes google map appear on the screen.*/
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
         /* Disables the option to drag the map across the screen, as well as zoom, tilt and rotation. The user basically can't do any actions
        setAllGesturesEnabled is set to false */
        mapFragment.getMap().getUiSettings().setAllGesturesEnabled(false);
    }


    /*The method "onMapReady" initiates when google map has succesfully loaded on to the screen.dcdcdcdcd*/
    @Override
    public void onMapReady(GoogleMap map) {


        /*Tracks the phone's current location*/
        /* Connects the devices GPS */
        map.setMyLocationEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(false);

        /*Sets the camera to a specific location*/
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(57.055993, 9.903725), 19.7f));

        /* Polylines are useful for marking paths and routes on the map.
        added a polygon instead of a polyline - it is one cohesive figure appearing as a rectangle
         sadkljlkjdanwnkl*/
        map.addPolygon(new PolygonOptions()
        .add(new LatLng(57.055800, 9.903500))
        .add(new LatLng(57.055800, 9.903950))
        .add(new LatLng(57.056186, 9.903950))
        .add(new LatLng(57.056186, 9.903500)));


         map.addMarker(new MarkerOptions()
        .title("Point 1")
        .alpha(1f)
        .position(new LatLng(57.056022, 9.903823))
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.cheese)));

        map.addMarker(new MarkerOptions()
                         .alpha(0.01f)
                         .title("Point 2")
                         .position(new LatLng(57.056100, 9.903750)));


        map.addMarker(new MarkerOptions()
                         .title("Point 3")
                         .alpha(0.01f)
                         .position(new LatLng(57.055996, 9.903872)));
                map.addMarker(new MarkerOptions()
                         .title("Point 4")
                         .alpha(0.01f)
                         .position(new LatLng(57.055984, 9.903743)));
    }

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


