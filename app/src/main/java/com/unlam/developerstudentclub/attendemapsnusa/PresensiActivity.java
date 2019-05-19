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

    @BindView(R.id.btn_checkin)
    LinearLayout btn_checkin;
    @BindView(R.id.btn_checkout)
    LinearLayout btn_checkout;

    @BindView(R.id.tv_kodekaryawan)
    TextView tv_kodekaryawan;
    @BindView(R.id.tv_username)
    TextView tv_username;

    UserPreference userPreference;

    public static String IDENTIFIER_REQUEST = "checkinuot";
    public static int CHECK_IN = R.menu.menu_checkin;
    public static int CHECK_OUT = R.menu.menu_checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attende);
        ButterKnife.bind(this);

        userPreference =  new UserPreference(this);

        Fonty
                .context(this)
                .normalTypeface("Domine-Regular.ttf")
                .boldTypeface("PatuaOne-Regular.ttf")
                .build();

        Fonty.setFonts(this);

        PushDownAnim.setPushDownAnimTo(btn_checkin,btn_checkout)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PresensiActivity.this,MapsActivityCurrentPlace.class);
                        switch(v.getId()){
                            case R.id.btn_checkin :
                                intent.putExtra(IDENTIFIER_REQUEST,CHECK_IN);
                                startActivity(intent);
                                break;
                            case R.id.btn_checkout :
                                intent.putExtra(IDENTIFIER_REQUEST,CHECK_OUT);
                                startActivity(intent);
                                break;
                        }
                    }
                });
    }


}
