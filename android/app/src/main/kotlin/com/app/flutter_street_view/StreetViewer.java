package com.app.flutter_street_view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

import java.util.Objects;

public class StreetViewer extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.street_view_panorama_basic_demo);
        SupportStreetViewPanoramaFragment streetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);
        Objects.requireNonNull(streetViewPanoramaFragment).getStreetViewPanoramaAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        double lat = Double.parseDouble(Objects.requireNonNull(getIntent().getStringExtra("latitude")));
        double lng = Double.parseDouble(Objects.requireNonNull(getIntent().getStringExtra("longitude")));
        float heading = Float.parseFloat(Objects.requireNonNull(getIntent().getStringExtra("heading")));
        float pitch = Float.parseFloat(Objects.requireNonNull(getIntent().getStringExtra("pitch")));

        streetViewPanorama.setPanningGesturesEnabled(true);
        streetViewPanorama.setUserNavigationEnabled(true);
        streetViewPanorama.setZoomGesturesEnabled(true);
        streetViewPanorama.setStreetNamesEnabled(true);
        streetViewPanorama.setPosition(new LatLng(lat,lng));
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .tilt(pitch)
                .bearing(heading)
                .build();
        streetViewPanorama.animateTo(camera, 0);
    }
}