package com.unlam.developerstudentclub.attendemapsnusa;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.io.Console;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;

public class PresensiActivity extends AppCompatActivity {

//    @BindView(R.id.btn_permission)
//    Button btn_permission;
//    @BindView(R.id.text_permission)
//    TextView text_permission;
//
//    static int RC_LOCATION_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attende);

        ButterKnife.bind(this);
//        btn_permission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                methodRequiresTwoPermission();
//            }
//        });
//        methodRequiresTwoPermission();
    }

//    private void methodRequiresTwoPermission() {
//        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
//        if (EasyPermissions.hasPermissions(this, perms)) {
//            btn_permission.setText("Check In");
//            text_permission.setText("Silahan Check in");
//            btn_permission.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    locationPoint();
//                }
//            });
//        } else {
//            EasyPermissions.requestPermissions(this,
//                    "Izin lokasi?",
//                    RC_LOCATION_PERMISSION_CODE, perms);
//        }
//    }
//
//    public void locationPoint() {
//
//        LocationRequest request = new LocationRequest();
//        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(this);
//        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
//
//        if (permission == PackageManager.PERMISSION_GRANTED) {
//            client.requestLocationUpdates(request, new LocationCallback() {
//
//                @Override
//                public void onLocationResult(LocationResult locationResult) {
//
//                    Location location = locationResult.getLastLocation();
//
//                    if (location != null) {
//                        Location company = new Location("");
//                        company.setLatitude(-3.4016452);
//                        company.setLongitude(115.9044867);
//                        Toast.makeText(PresensiActivity.this, Math.round(location.distanceTo(company)) + "meter", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//            }, null);
//        }
//    }

}
