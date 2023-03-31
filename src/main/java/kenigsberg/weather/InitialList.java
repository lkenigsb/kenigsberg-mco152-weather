package kenigsberg.weather;

import com.google.gson.annotations.SerializedName;

public class InitialList {
    long dt;

    Main main;

    FiveDayWeatherWeather[] weather;

    Clouds clouds;

    Wind wind;

    int visibility;

    @SerializedName("dt_txt")
    String dtText;
}
