package com.example.notify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class showUnsafeMap extends FragmentActivity implements OnMapReadyCallback{
    DatabaseReference mDatabase;
    GoogleMap map ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_unsafe_map);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //int position = (int)(marker.getTag());
                //Using position get Value from arraylist
                try {

                    //Intent intent=new Intent(showUnsafeMap.this,MarkerActivity.class);
                   // intent.putExtra("posotion",marker.getPosition());
                    //Toast.makeText(showUnsafeMap.this,marker.getTag().toString(),Toast.LENGTH_LONG).show();
                    startActivity(new Intent(showUnsafeMap.this,MarkerActivity.class)
                            .putExtra("latitude",marker.getTag().toString()));

                }catch (Exception e){
                    Toast.makeText(showUnsafeMap.this,""+ e, Toast.LENGTH_LONG).show();
                    //System.out.println(e);
                }
                return true;
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference("UnsafeAreas");
        mDatabase.addValueEventListener(new ValueEventListener() {

            final String table = "table";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int len;
                double lat,lon,radii;
                LatLng loc;
                String title;
                lat=lon=radii=0;
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    //lat=Double.parseDouble(dataSnapshot.child("UnsafeAreas").child(dataSnapshot1.getKey()).child("lat").getValue().toString());
                    Toast.makeText(showUnsafeMap.this, "" + dataSnapshot1.getKey(), Toast.LENGTH_LONG).show();
                    try {
                        ;//Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                    String uid = dataSnapshot1.getKey();
                    for (DataSnapshot dataSnapshot2 : dataSnapshot1.getChildren()) {
                        if (dataSnapshot2.getKey().equals("lat"))
                            lat = Double.parseDouble(dataSnapshot2.getValue().toString());
                        else if (dataSnapshot2.getKey().equals("lon"))
                            lon = Double.parseDouble(dataSnapshot2.getValue().toString());
                        else if (dataSnapshot2.getKey().equals("radius"))
                            radii = Double.parseDouble(dataSnapshot2.getValue().toString());
                    }
                        //lat=Double.parseDouble(dataSnapshot1.child(uid).child("lat").getValue().toString());
                        //Toast.makeText(showUnsafeMap.this,dataSnapshot1.child("Golconda").child("lat").getValue().toString()+" "+dataSnapshot.getKey(), Toast.LENGTH_LONG).show();
                        //lon=Double.parseDouble(dataSnapshot1.child(dataSnapshot1.getKey()).child("lon").getValue().toString());
                        title=dataSnapshot1.getKey();
                        loc = new LatLng(lat, lon);
                        map.addMarker(new MarkerOptions().position(loc).title(title));
                        map.addCircle(new CircleOptions().center(loc)
                                .radius(radii));
                        // map.moveCamera(CameraUpdateFactory.newLatLngZoom(loc,12));

                    }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                // ...
            }
        });
    }
}
