package kenigsberg.weather;

import com.google.gson.annotations.SerializedName;

public class Main {
    double temp;

    @SerializedName("feels_like")
    double feelsLike;

    @SerializedName("temp_min")
    double tempMin;

    @SerializedName("temp_max")
    double tempMax;

    int humidity;


}
