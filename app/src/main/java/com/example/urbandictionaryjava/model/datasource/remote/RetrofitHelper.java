package com.example.urbandictionaryjava.model.datasource.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.urbandictionaryjava.model.datasource.remote.UrlConstants.BASE_URL;

public class RetrofitHelper {
    private Retrofit getRetrofitInstance(){
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public UrbanDictionaryApiService getUrbanDictionaryApiService(){
        return getRetrofitInstance().create(UrbanDictionaryApiService.class);
    }
}

