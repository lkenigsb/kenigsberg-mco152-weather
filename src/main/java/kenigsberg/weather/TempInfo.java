package kenigsberg.weather;

import com.google.gson.annotations.SerializedName;

public class TempInfo {
    double temp;

    @SerializedName("feels_like")
    double feelsLike;
    int humidity;
}
