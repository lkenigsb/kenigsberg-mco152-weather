package kenigsberg.weather;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RunInfo {
    public static void main(String[] args) throws IOException {

        //WeatherFrame earthquakeFrame = new WeatherFrame();
        //earthquakeFrame.setVisible(true);

        WeatherFrame currentWeatherDraw = new WeatherFrame();
        currentWeatherDraw.setVisible(true);

    }
}
