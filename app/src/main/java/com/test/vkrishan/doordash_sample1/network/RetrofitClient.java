package com.test.vkrishan.doordash_sample1.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.doordash.com";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){
            retrofit  = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
