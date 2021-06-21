package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;

public class EstimatedDiameter {
    private Feet kilometers;
    private Feet meters;
    private Feet miles;
    private Feet feet;

    @JsonProperty("kilometers")
    public Feet getKilometers() { return kilometers; }
    @JsonProperty("kilometers")
    public void setKilometers(Feet value) { this.kilometers = value; }

    @JsonProperty("meters")
    public Feet getMeters() { return meters; }
    @JsonProperty("meters")
    public void setMeters(Feet value) { this.meters = value; }

    @JsonProperty("miles")
    public Feet getMiles() { return miles; }
    @JsonProperty("miles")
    public void setMiles(Feet value) { this.miles = value; }

    @JsonProperty("feet")
    public Feet getFeet() { return feet; }
    @JsonProperty("feet")
    public void setFeet(Feet value) { this.feet = value; }
}
