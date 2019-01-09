package com.unlam.developerstudentclub.attendemapsnusa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marcinorlowski.fonty.Fonty;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Fonty
                .context(this)
                .normalTypeface("Domine-Regular.ttf")
                .boldTypeface("PatuaOne-Regular.ttf")
                .build();

        Fonty.setFonts(this);
    }
}
