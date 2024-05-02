package com.cybilltek.technicalExam;

import static com.cybilltek.technicalExam.MainActivity.api;

import com.cybilltek.technicalExam.interfaces.ApiInterfaces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class RetrofitInstance {
    public static RetrofitInstance instance;
    ApiInterfaces apiInterfaces;

    RetrofitInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiInterfaces = retrofit.create(ApiInterfaces.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }
}
