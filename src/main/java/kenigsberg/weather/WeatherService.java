package kenigsberg.weather;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("/data/2.5/weather?appid=bcb814bf7bcba6823c73eb6e9ebfdd9b&units=imperial")
    Observable<CurrentWeather> getCurrentWeather(@Query("q") String location);


    /**
     * HMWK: add another @GET - getCall() - for the 5-day forecast
     * https://api.openweathermap.org/data/2.5/forecast?q=Staten%20Island&appid=bcb814bf7bcba6823c73eb6e9ebfdd9b&units=imperial
     *
     * Taken From: https://openweathermap.org/forecast5#name5
     * list - 40 items, 5 days
     * dt - time
     */

    @GET("/data/2.5/forecast?appid=bcb814bf7bcba6823c73eb6e9ebfdd9b&units=imperial")
    Observable<FiveDayWeather> getFiveDayWeather(@Query("q") String location);
}
