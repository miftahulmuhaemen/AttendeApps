package com.unlam.developerstudentclub.attendemapsnusa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marcinorlowski.fonty.Fonty;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.unlam.developerstudentclub.attendemapsnusa.API.ApiDefaultResponse;
import com.unlam.developerstudentclub.attendemapsnusa.API.ApiGenerator;
import com.unlam.developerstudentclub.attendemapsnusa.API.ApiInterface;
import com.unlam.developerstudentclub.attendemapsnusa.Util.UserPreference;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.unlam.developerstudentclub.attendemapsnusa.Util.Util.API_KEY;
import static com.unlam.developerstudentclub.attendemapsnusa.Util.Util.EMPTY_FIELD;
import static com.unlam.developerstudentclub.attendemapsnusa.Util.Util.INVALID_EMAIL;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_login)
    Button btn_login;

    @BindView(R.id.edt_email)
    MaterialEditText edt_email;

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

        userPreference =  new UserPreference(this);

        Fonty   .context(this)
                .normalTypeface("Domine-Regular.ttf")
                .boldTypeface("PatuaOne-Regular.ttf")
                .build();

        Fonty.setFonts(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = edt_password.getText().toString().trim();
                String email = edt_email.getText().toString().trim();
                boolean isEmpty = false;

                if(TextUtils.isEmpty(email)){
                    isEmpty = true;
                    edt_email.setError(EMPTY_FIELD);
                } else if(!isValidEmail(email)){
                    isEmpty = true;
                    edt_email.setError(INVALID_EMAIL);
                }

                if(TextUtils.isEmpty(password)){
                    isEmpty = true;
                    edt_password.setError(EMPTY_FIELD);
                }

                if(isEmpty){
                    progressbar.setVisibility(View.VISIBLE);


                    userPreference.setPreference("ASDAsd", 2133); /*Sesuaikan dengan kiriman API*/
                    Intent intent = new Intent(LoginActivity.this,PresensiActivity.class);
                    startActivity(intent);
                    finish();

//                    Call<ApiDefaultResponse> call = api.getLogin(API_KEY, email, password);
//                    call.enqueue(new Callback<ApiDefaultResponse>() {
//                        @Override
//                        public void onResponse(Call<ApiDefaultResponse> call, Response<ApiDefaultResponse> response) {
//                            if(response.isSuccessful()){
//                                userPreference.setPreference("", 0); /*Sesuaikan dengan kiriman API*/
//                                Intent intent = new Intent(LoginActivity.this,PresensiActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ApiDefaultResponse> call, Throwable t) {
//                            if (t instanceof IOException) {
//                                Toast.makeText(LoginActivity.this, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });


                }

            }
        });
    }

    private boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
