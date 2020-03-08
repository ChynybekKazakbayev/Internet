package com.geektech.internet.data.internet.internet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.geektech.internet.BuildConfig.BASE_URL;

public class RetrofitBuilder {

    private static  RetrofitService service;

    public static RetrofitService getService(){
        if (service == null) service = buildRetrofit();

        return service;
    }



    private static RetrofitService buildRetrofit(){
        return new  Retrofit.Builder()
                .baseUrl(BASE_URL).addCallAdapterFactory(G)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService.class);
    }

}
//http://api.openweathermap.org/data/2.5/weather?q={city%20name}&appid={your%20api%20key}


