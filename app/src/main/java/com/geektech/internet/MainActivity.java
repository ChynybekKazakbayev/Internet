package com.geektech.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.geektech.internet.data.internet.internet.RetrofitBuilder;
import com.geektech.internet.pojo.CurrentWeather;
import com.geektech.internet.pojo.ForcastWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.geektech.internet.BuildConfig.APP_ID;

public class MainActivity extends AppCompatActivity {

    private TextView tvCurrentWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        loadCurrentWeather();
        loadForecastWeather();
        
    }

    private void loadForecastWeather() {
        RetrofitBuilder.getService().getForcastWeather(
                "Bishkek",

                APP_ID,
                "metric")
                .enqueue(new Callback<ForcastWeather>() {
                    @Override
                    public void onResponse(Call<ForcastWeather> call, Response<ForcastWeather> response) {
                        Log.e("dwdk","dwkd;");
                    }

                    @Override
                    public void onFailure(Call<ForcastWeather> call, Throwable t) {
                        Log.e("dwdk","dwkd;");

                    }
                });
    }

    private void loadCurrentWeather(){
        RetrofitBuilder
                .getService()
                .getCurrentWeather(
                        "Bishkek",
                        //"b6907d289e10d714a6e88b30761fae22",
                        APP_ID,"metric")
                .enqueue(new Callback<CurrentWeather>() {
                    @Override
                    public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                        if (response.isSuccessful()&& response.body()!= null){
                            CurrentWeather weather = response.body();
                            tvCurrentWeather.setText(weather.getMain().getTemp().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentWeather> call, Throwable t) {

                    }
                });
    }

    private void setupViews(){
        tvCurrentWeather = findViewById(R.id.tvCurrentWeather);
    }
}
