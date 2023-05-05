package kenigsberg.weather;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;

//Have singleton to show that only have 1 of these things across service

@Singleton
public class ForecastWeatherView extends JComponent {

    @Inject
    public ForecastWeatherView()
    {

    }
    private FiveDayWeather fiveDayWeather;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int height = getHeight();
        g.translate(0, height);

        //if fiveDayWeather null, don't do anything
        if (fiveDayWeather == null) {
            return;
        }
        for (int i = 0; i < fiveDayWeather.list.length - 1; i++) {
            int temp = (int) fiveDayWeather.list[i].main.temp; //y

            int nextTemp = (int) fiveDayWeather.list[i + 1].main.temp;

            g.drawLine(i * 20, -temp * 5, (i + 1) * 20, -nextTemp * 5);

        }
    }

    public void setForecast(FiveDayWeather fiveDayWeather) {
        this.fiveDayWeather = fiveDayWeather;
        repaint();
    }

}

