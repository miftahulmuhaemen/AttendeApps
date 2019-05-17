package com.unlam.developerstudentclub.attendemapsnusa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.marcinorlowski.fonty.Fonty;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.unlam.developerstudentclub.attendemapsnusa.API.LoginResponse;
import com.unlam.developerstudentclub.attendemapsnusa.API.ApiGenerator;
import com.unlam.developerstudentclub.attendemapsnusa.API.ApiInterface;
import com.unlam.developerstudentclub.attendemapsnusa.Util.UserPreference;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.unlam.developerstudentclub.attendemapsnusa.Util.Util.EMPTY_FIELD;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_login)
    Button btn_login;

    @BindView(R.id.edt_username)
    MaterialEditText edt_username;

    @BindView(R.id.edt_password)
    MaterialEditText edt_password;

    @BindView(R.id.progressbar_login)
    ProgressBar progressbar;

    ApiInterface api = ApiGenerator.createService(ApiInterface.class);
    UserPreference userPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        userPreference = new UserPreference(this);

        Fonty.context(this)
                .normalTypeface("Domine-Regular.ttf")
                .boldTypeface("PatuaOne-Regular.ttf")
                .build();

        Fonty.setFonts(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = edt_password.getText().toString().trim();
                String username = edt_username.getText().toString().trim();
                boolean isEmpty = false;

                if (TextUtils.isEmpty(username)) {
                    isEmpty = true;
                    edt_username.setError(EMPTY_FIELD);
                }

                if (TextUtils.isEmpty(password)) {
                    isEmpty = true;
                    edt_password.setError(EMPTY_FIELD);
                }

                if (!isEmpty) {
                    progressbar.setVisibility(View.VISIBLE);

                    HashMap<String, RequestBody> map = new HashMap<>();
                    map.put("KarUsername", createPartFromString(username));
                    map.put("KarPassword", createPartFromString(password));

                    Call<LoginResponse> call = api.login(map);
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.body().getStatus()) {
                                progressbar.setVisibility(View.INVISIBLE);
                                userPreference.setPreference(response.body().getNama(), response.body().getId()); /*Sesuaikan dengan kiriman API*/
                                Intent intent = new Intent(LoginActivity.this, PresensiActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            progressbar.setVisibility(View.INVISIBLE);
                        }
                    });

                }

            }
        });
    }

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, descriptionString);
    }
}
