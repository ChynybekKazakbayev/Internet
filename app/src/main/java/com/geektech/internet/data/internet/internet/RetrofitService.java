package com.geektech.internet.data.internet.internet;

import com.geektech.internet.pojo.CurrentWeather;
import com.geektech.internet.pojo.ForcastWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.geektech.internet.data.internet.internet.ApiEndpoinds.CURRENT_WEATHER;
import static com.geektech.internet.data.internet.internet.ApiEndpoinds.FORECAST_WEATHER;

public interface RetrofitService {

    @GET(CURRENT_WEATHER)
    Call<CurrentWeather> getCurrentWeather(
            @Query("g") String city,
            @Query("appId")String appId,
            @Query("units") String units);

   @GET(FORECAST_WEATHER)
    Call<ForcastWeather> getForcastWeather (
            @Query("q") String city,
            @Query("appId") String appId,
            @Query("units") String units);
  //  ?q=London,us&appid=b6907d289e10d714a6e88b30761fae22

}
