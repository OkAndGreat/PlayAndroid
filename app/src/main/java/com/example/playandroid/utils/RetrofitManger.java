package com.example.playandroid.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.playandroid.utils.Constants.CONNECT_TIME_OUT;
import static com.example.playandroid.utils.Constants.PlayAndroid_URL;
import static com.example.playandroid.utils.Constants.Rest_URL;

public class RetrofitManger {
    private static RetrofitManger Instance;
    private Retrofit mRetrofit;
    private OkHttpClient OkHttpClient;
    private final HashMap<String,List<Cookie>> cookieStore = new HashMap<>();


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
        OkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(url.host(),cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(url.host());
                        return cookies!=null?cookies:new ArrayList<Cookie>();
                    }
                })
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(PlayAndroid_URL)
                //设置请求的client
                .client(OkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit;
    }

    public Retrofit createRestRetrofit() {
        OkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Rest_URL)
                //设置请求的client
                .client(OkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit;
    }
}
