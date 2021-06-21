package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;

public class RelativeVelocity {
    private String kilometersPerSecond;
    private String kilometersPerHour;
    private String milesPerHour;

    @JsonProperty("kilometers_per_second")
    public String getKilometersPerSecond() { return kilometersPerSecond; }
    @JsonProperty("kilometers_per_second")
    public void setKilometersPerSecond(String value) { this.kilometersPerSecond = value; }

    @JsonProperty("kilometers_per_hour")
    public String getKilometersPerHour() { return kilometersPerHour; }
    @JsonProperty("kilometers_per_hour")
    public void setKilometersPerHour(String value) { this.kilometersPerHour = value; }

    @JsonProperty("miles_per_hour")
    public String getMilesPerHour() { return milesPerHour; }
    @JsonProperty("miles_per_hour")
    public void setMilesPerHour(String value) { this.milesPerHour = value; }
}
