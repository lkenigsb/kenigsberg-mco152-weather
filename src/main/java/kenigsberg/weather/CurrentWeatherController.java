package kenigsberg.weather;

import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrentWeatherController {

    private OpenWeatherMapService service;
    private JLabel imageLabel;
    private JLabel degreeLabel;

    @Inject
    public CurrentWeatherController(OpenWeatherMapService service,
                                    @Named("imageLabel") JLabel imageLabel,
                                    @Named("degreesLabel") JLabel degreeLabel) {
        this.service = service;
        this.imageLabel = imageLabel;
        this.degreeLabel = degreeLabel;
    }

    public void updateWeather(String location) {
        service.getCurrentWeather(location)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(this::setCurrentWeather,
                        Throwable::printStackTrace);
    }

    public void setCurrentWeather(CurrentWeather currentWeather) throws MalformedURLException {
        degreeLabel.setText(String.valueOf(currentWeather.main.temp));
        String icon = currentWeather.weather[0].icon;
        String url="https://openweathermap.org/img/w/" + icon + ".png";
        imageLabel.setIcon(new ImageIcon(new URL(url)));
    }

}
