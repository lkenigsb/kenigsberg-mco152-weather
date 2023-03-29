package kenigsberg.weather;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.atomic.AtomicReference;

class WeatherServiceTest {


    @Test
    void getCurrentWeather() {
        // given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();


        WeatherService service = retrofit.create(WeatherService.class);

        // when
        CurrentWeather currentWeather = service.getCurrentWeather().blockingFirst();


        // then
        Assertions.assertNotNull(currentWeather);
        Assertions.assertNotNull(currentWeather.weather[0].description);
        //Below test will fail when weather is cold
        Assertions.assertTrue(currentWeather.main.temp > 0);
        Assertions.assertEquals("Staten Island", currentWeather.name);
    }
}