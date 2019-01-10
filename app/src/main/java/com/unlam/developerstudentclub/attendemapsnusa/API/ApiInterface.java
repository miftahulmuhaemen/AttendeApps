package com.unlam.developerstudentclub.attendemapsnusa.API;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface ApiInterface {

    /*User API*/

    @GET("user/login")
    Call<ApiDefaultResponse> getLogin(
            @Query("key") String key,
            @Query("email") String email,
            @Query("password") String password
    );

    @Multipart
    @POST("user/checkin")
    Call<ApiDefaultResponse> checkIn(
            @PartMap Map<String, RequestBody> partMap
    );

    @Multipart
    @POST("user/checkout")
    Call<ApiDefaultResponse> checkOut(
            @PartMap Map<String, RequestBody> partMap
    );

    /**
     * Unused.
     */
//
//    @Multipart
//    @POST("user/updateProfil")
//    Call<ApiDefaultResponse> postGantiProfile(
//            @PartMap Map<String, RequestBody> partMap
//    );
//
//    @Multipart
//    @POST("user/updateIdentitas")
//    Call<ApiDefaultResponse> postGantiIdentitas(
//            @PartMap Map<String, RequestBody> partMap,
//            @Part MultipartBody.Part file
//    );


    /*Data API*/

//    @GET("permintaan/data")
//    Call<ApiResponseData<PerdataItem>> getPerdata(
//            @Query("key") String key,
//            @Query("id") int id
//    );
//
//    @GET("pengaduan/data")
//    Call<ApiResponseData<PengaduanItem>> getPengaduan(
//            @Query("key") String key,
//            @Query("id") int id
//    );

//    @Multipart
//    @POST("pengaduan/insert")
//    Call<ApiDefaultResponse> postPengaduan(
//            @PartMap Map<String, RequestBody> partMap,
//            @Part MultipartBody.Part file
//    );
//
//    @Multipart
//    @POST("permintaan/insert")
//    Call<ApiDefaultResponse> postPerdata(
//            @PartMap Map<String, RequestBody> partMap
//    );

}