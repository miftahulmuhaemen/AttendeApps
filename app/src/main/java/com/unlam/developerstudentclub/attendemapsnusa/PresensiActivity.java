package com.unlam.developerstudentclub.attendemapsnusa;

import android.Manifest;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.marcinorlowski.fonty.Fonty;
import com.thekhaeng.pushdownanim.PushDownAnim;
import com.unlam.developerstudentclub.attendemapsnusa.Util.UserPreference;

import java.io.Console;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;

public class PresensiActivity extends AppCompatActivity {

    static int RC_LOCATION_PERMISSION_CODE = 101;

    @BindView(R.id.btn_checkin)
    LinearLayout btn_checkin;
    @BindView(R.id.btn_checkout)
    LinearLayout btn_checkout;

    @BindView(R.id.adminmsg)
    TextView btn_adminmsg;
    @BindView(R.id.tv_kodekaryawan)
    TextView tv_kodekaryawan;
    @BindView(R.id.tv_username)
    TextView tv_username;

    UserPreference userPreference;

    public static String IDENTIFIER_REQUEST = "checkinuot";
    public static int CHECK_IN = R.id.option_checkin;
    public static int CHECK_OUT = R.id.option_checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attende);
        ButterKnife.bind(this);

        userPreference =  new UserPreference(this);

        tv_username.setText(userPreference.getNama());
        tv_kodekaryawan.setText(Integer.toString(userPreference.getCode()));

        Fonty
                .context(this)
                .normalTypeface("Domine-Regular.ttf")
                .boldTypeface("PatuaOne-Regular.ttf")
                .build();

        Fonty.setFonts(this);

        PushDownAnim.setPushDownAnimTo(btn_checkin,btn_checkout,btn_adminmsg)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PresensiActivity.this,MapsActivityCurrentPlace.class);
                        switch(v.getId()){
                            case R.id.btn_checkin :
                                intent.putExtra(IDENTIFIER_REQUEST,CHECK_IN);
                                startActivity(intent);
//                                locationPoint();
                                break;
                            case R.id.btn_checkout :
                                intent.putExtra(IDENTIFIER_REQUEST,CHECK_OUT);
                                startActivity(intent);
                                break;
                        }
                    }
                });

//        methodRequiresTwoPermission();
    }

//    private void methodRequiresTwoPermission() {
//        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
//        if (EasyPermissions.hasPermissions(this, perms)) {
//            lockmmenu.setVisibility(View.GONE);
//        } else {
//            EasyPermissions.requestPermissions(this,
//                    "Izin lokasi?",
//                    RC_LOCATION_PERMISSION_CODE, perms);
//        }
//    }

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
