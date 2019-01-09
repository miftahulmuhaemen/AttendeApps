package com.unlam.developerstudentclub.attendemapsnusa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marcinorlowski.fonty.Fonty;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_login)
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Fonty
                .context(this)
                .normalTypeface("Domine-Regular.ttf")
                .boldTypeface("PatuaOne-Regular.ttf")
                .build();

        Fonty.setFonts(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,PresensiActivity.class);
                startActivity(intent);
            }
        });
    }
}
