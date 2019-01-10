package com.unlam.developerstudentclub.attendemapsnusa.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.unlam.developerstudentclub.attendemapsnusa.Util.Util.BASE_URL;

public class ApiGenerator {

    private static Retrofit retrofit;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(interceptor);

        builder.client(httpClient.build());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

}
