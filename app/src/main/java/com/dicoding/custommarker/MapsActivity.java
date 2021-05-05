package com.dicoding.custommarker;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    LatLng Alfamidi = new LatLng(-0.9271938222817028, 119.89579607197885 );
    LatLng Home = new LatLng(-0.928199, 119.887758);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(Alfamidi).title("Marker Alfamidi")
                .snippet("Ini adalah Alfamidi").icon(BitmapFromVector(getApplicationContext(),
                        R.mipmap.alfamidi)));
        mMap.addMarker(new MarkerOptions().position(Home).title("Marker Rumah Saya")
                .snippet("Ini adalah Rumah Saya").icon(BitmapFromVector(getApplicationContext(),
                        R.mipmap.home)));
        mMap.addPolyline(new PolylineOptions().add(
                Home,
                new LatLng(-0.9283701230639537, 119.88775397109433),
                new LatLng(-0.9284199897788982, 119.88865767458918),
                new LatLng(-0.9278694612022239, 119.88868560361533),
                new LatLng(-0.9272690658045017, 119.88872550222398),
                new LatLng(-0.9272946893424607, 119.89005210405857),
                new LatLng(-0.9273445560712088, 119.89137075313539  ),
                new LatLng(-0.9273545294163427, 119.89207496364472),
                new LatLng(-0.927394422799817, 119.89274326534124),
                new LatLng(-0.9273804601153014, 119.89363100941101),
                new LatLng(-0.9274662308902667, 119.89436713878204),
                new LatLng(-0.9275021349343083, 119.89504142529485),
                new LatLng(-0.9275432760387102, 119.89555359457492),
                new LatLng(-0.9273728323878343, 119.89606459068176),
                new LatLng(-0.9271489011638101, 119.89595767506525),
                Alfamidi
                ).width(16)
                        .color(Color.BLACK)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Home, 14.5f));
    }
    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        // below line is use to generate a drawable.
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        // below line is use to set bounds to our vector drawable.
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());
        // below line is use to create a bitmap for our
        // drawable which we have added.
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        // below line is use to add bitmap in our canvas.
        Canvas canvas = new Canvas(bitmap);
        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas);
        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}