package com.example.playandroid.utils;

public class RetrofitManger {
    RetrofitManger Instance;

    private RetrofitManger() {
    }

    public RetrofitManger getInstance() {
        if (Instance == null) {
            synchronized (RetrofitManger.class) {
                if (Instance == null) {
                    Instance = new RetrofitManger();
                }
            }
        }
        return Instance;
    }
}
