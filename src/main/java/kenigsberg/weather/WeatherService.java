package kenigsberg.weather;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface WeatherService {
    @GET("/data/2.5/weather?q=Staten%20Island&appid=bcb814bf7bcba6823c73eb6e9ebfdd9b&units=imperial")
    Observable<CurrentWeather> getCurrentWeather();

}
