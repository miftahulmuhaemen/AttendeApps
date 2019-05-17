package com.unlam.developerstudentclub.attendemapsnusa.API;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface ApiInterface {

    @Multipart
    @POST("userlogin")
    Call<LoginResponse> login(
            @PartMap Map<String, RequestBody> partMap
    );

    @Multipart
    @POST("usercekin")
    Call<DefaultResponse> cekin(
            @PartMap Map<String, RequestBody> partMap,
            @Part MultipartBody.Part file
    );

    @Multipart
    @POST("usercekout")
    Call<DefaultResponse> cekout(
            @PartMap Map<String, RequestBody> partMap,
            @Part MultipartBody.Part file
    );

}
