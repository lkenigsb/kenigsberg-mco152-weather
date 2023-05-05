package kenigsberg.weather;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


import java.io.IOException;

public class RunInfo {
    public static void main(String[] args) throws IOException {
        /*instantiate dagger component which knows about all of my classes
        * component is a part of dagger
        * It is an interface that I make
        * Component is the way get classes out of dagger
        * In component, need way for dagger to BUILD service
         */
        ForecastWeatherComponent component = DaggerForecastWeatherComponent
                .builder()
                .build();

        WeatherFrame frame = component.providesForecastWeatherFrame();
        frame.setVisible(true);

    }
}
