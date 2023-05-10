package kenigsberg.weather;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ForecastWeatherControllerTest {

    static {
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    void updateWeather() {
        // given
        ForecastWeatherView view = mock();
        OpenWeatherMapService service = mock();
        ForecastWeatherController controller = new ForecastWeatherController(view, service);

        FiveDayWeather fiveDayWeather = mock();
        Observable<FiveDayWeather> observable = Observable.just(fiveDayWeather);
        doReturn(observable).when(service).getFiveDayWeather("New York");


        // when
        controller.updateWeather("New York");

        // then
        verify(service).getFiveDayWeather("New York");
        verify(view).setForecast(fiveDayWeather);
    }

}