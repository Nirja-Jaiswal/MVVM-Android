package com.android.helpsetup.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {


    public static final String URL = "http://159.203.136.159:3009/";

    /*public static Retrofit getRetrofit() {
        if (retrofit == null)
            return retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        else
            return retrofit;
    }*/

    private static final OkHttpClient httpclient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS).build();

    private static final Gson gson = new GsonBuilder().setLenient().create();
    private static final Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL);

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpclient).
                addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit.create(serviceClass);
    }

    public static Retrofit getRetrofit(){
        return builder.client(httpclient).build();
    }

}
