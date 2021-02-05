package com.example.playandroid.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.playandroid.utils.Constants.CONNECT_TIME_OUT;
import static com.example.playandroid.utils.Constants.PlayAndroid_URL;
import static com.example.playandroid.utils.Constants.Rest_URL;

public class RetrofitManger {
    private static RetrofitManger Instance;
    private Retrofit mRetrofit;

    private RetrofitManger() {
    }

    public static RetrofitManger getInstance() {
        if (Instance == null) {
            synchronized (RetrofitManger.class) {
                if (Instance == null) {
                    Instance = new RetrofitManger();
                }
            }
        }
        return Instance;
    }

    public Retrofit createMainRetrofit() {
        //设置一下okHttp的参数
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(PlayAndroid_URL)//设置BaseUrl
                .client(okHttpClient)//设置请求的client
                .addConverterFactory(GsonConverterFactory.create())//设置转换器
                .build();
        return mRetrofit;
    }

    public Retrofit createRestRetrofit() {
        //设置一下okHttp的参数
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Rest_URL)//设置BaseUrl
                .client(okHttpClient)//设置请求的client
                .addConverterFactory(GsonConverterFactory.create())//设置转换器
                .build();
        return mRetrofit;
    }
}
