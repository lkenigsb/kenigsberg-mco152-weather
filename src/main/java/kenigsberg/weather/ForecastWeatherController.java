package kenigsberg.weather;

/* NOTES ON CONTROLLER
 * Have model, view & controller
 * model - data aka fiveDayWeather
 * view - currentWeatherView = display the data
 * controller - connect the model to the view
 * This way all 3 of these things can be independently tested
 */

import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.inject.Inject;

public class ForecastWeatherController {
    private ForecastWeatherView view;
    private OpenWeatherMapService service;

    //@inject tells dagger this is how you create one of these things

    @Inject
    public ForecastWeatherController(
            ForecastWeatherView view,
            OpenWeatherMapService service
    ) {

        this.view = view;
        this.service = service;
    }

    public void updateWeather(String location) {
        service.getFiveDayWeather(location)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(
                        fiveDayWeather -> {
                            view.setForecast(fiveDayWeather);
                        },
                        Throwable::printStackTrace

                );
    }
}
